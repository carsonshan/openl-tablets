package org.openl.rules.testmethod;

import org.openl.rules.context.IRulesRuntimeContext;
import org.openl.rules.table.InputArgumentsCloner;
import org.openl.rules.table.formatters.FormattersManager;
import org.openl.runtime.IRuntimeContext;
import org.openl.types.IOpenClass;
import org.openl.types.IOpenMethod;
import org.openl.types.IParameterDeclaration;
import org.openl.types.impl.DynamicObject;
import org.openl.util.Log;
import org.openl.util.formatters.IFormatter;
import org.openl.vm.IRuntimeEnv;

public class TestDescription {
    private ParameterWithValueDeclaration[] executionParams;
    private IOpenMethod testedMethod;
    private DynamicObject testObject;

    public TestDescription(IOpenMethod testedMethod, DynamicObject testObject) {
        this.testedMethod = testedMethod;
        this.testObject = testObject;
        executionParams = initExecutionParams();
    }

    public TestDescription(IOpenMethod testedMethod, Object[] arguments) {
        this(testedMethod, arguments, null, null);
    }

    public TestDescription(IOpenMethod testedMethod, Object[] arguments, Object expectedResult, String expectedError) {
        this(testedMethod, createTestObject(testedMethod, arguments, expectedResult, expectedError, null, null));
    }

    public TestDescription(IOpenMethod testedMethod,
            Object[] arguments,
            Object expectedResult,
            String expectedError,
            IRulesRuntimeContext context) {
        this(testedMethod, createTestObject(testedMethod, arguments, expectedResult, expectedError, context, null));
    }

    public TestDescription(IOpenMethod testedMethod,
            Object[] arguments,
            Object expectedResult,
            String expectedError,
            IRulesRuntimeContext context,
            String description) {
        this(testedMethod, createTestObject(testedMethod,
            arguments,
            expectedResult,
            expectedError,
            context,
            description));
    }

    public static DynamicObject createTestObject(IOpenMethod testedMethod,
            Object[] arguments,
            Object expectedResult,
            String expectedError,
            IRulesRuntimeContext context,
            String description) {
        //TODO should be created OpenClass like in TestSuiteMethod
        DynamicObject testObj = new DynamicObject();
        for (int i = 0; i < testedMethod.getSignature().getNumberOfParameters(); i++) {
            String paramName = testedMethod.getSignature().getParameterName(i);
            testObj.setFieldValue(paramName, arguments[i]);
        }
        if (description != null) {
            testObj.setFieldValue(TestMethodHelper.DESCRIPTION_NAME, context);
        }
        if (context != null) {
            testObj.setFieldValue(TestMethodHelper.CONTEXT_NAME, context);
        }
        if (expectedResult != null) {
            testObj.setFieldValue(TestMethodHelper.EXPECTED_RESULT_NAME, context);
        }
        if (expectedError != null) {
            testObj.setFieldValue(TestMethodHelper.EXPECTED_ERROR, context);
        }
        return testObj;
    }

    public IOpenMethod getTestedMethod() {
        return testedMethod;
    }

    public DynamicObject getTestObject() {
        return testObject;
    }

    public ParameterWithValueDeclaration[] getExecutionParams() {
        return executionParams;
    }
    
    public String[] getParametersNames() {
        String[] names = new String[executionParams.length];
        for (int i = 0; i < executionParams.length; i ++) {
            names[i] = executionParams[i].getName();
        }
        return names;
    }

    public Object[] getArguments() {
        InputArgumentsCloner cloner = new InputArgumentsCloner();

        Object[] args = new Object[executionParams.length];
        for (int i = 0; i < args.length; i++) {
            Object value = executionParams[i].getValue();
            try {
                args[i] = cloner.deepClone(value);
            } catch (RuntimeException e) {
                Log.error("Failed to clone an argument \"{0}\". Original argument will be used.", executionParams[i].getName());
                args[i] = value;
            }
        }
        return args;
    }

    protected ParameterWithValueDeclaration[] initExecutionParams() {
        ParameterWithValueDeclaration[] executionParams = new ParameterWithValueDeclaration[testedMethod.getSignature()
            .getNumberOfParameters()];
        for (int i = 0; i < executionParams.length; i++) {
            String paramName = testedMethod.getSignature().getParameterName(i);
            Object paramValue = testObject.getFieldValue(paramName);
            IOpenClass paramType = testedMethod.getSignature().getParameterType(i);
            executionParams[i] = new ParameterWithValueDeclaration(paramName, paramValue, paramType, IParameterDeclaration.IN);
        }
        return executionParams;
    }

    public TestUnit runTest(Object target, IRuntimeEnv env, long ntimes) {
        if (ntimes <= 0) {
            return runTest(target, env, 1);
        } else {
            Object res = null;
            Throwable exception = null;

            for (int j = 0; j < ntimes; j++) {
                try {
                    IRuntimeContext context = getRuntimeContext();

                    IRuntimeContext oldContext = env.getContext();
                    env.setContext(context);

                    res = testedMethod.invoke(target, getArguments(), env);

                    env.setContext(oldContext);
                } catch (Throwable t) {
                    Log.error("Testing " + this, t);
                    if (exception == null) {
                        exception = t;
                    }
                }
            }
            return exception == null ? new TestUnit(this, res, null) : new TestUnit(this, null, exception);
        }
    }

    public Object getArgumentValue(String paramName) {
        return testObject.getFieldValue(paramName);
    }

    public boolean hasDescription() {
        return testObject.containsField(TestMethodHelper.DESCRIPTION_NAME);
    }

    public String getDescription() {
        return (String) getArgumentValue(TestMethodHelper.DESCRIPTION_NAME);
    }

    public boolean isExpectedResultDefined() {
        return testObject.containsField(TestMethodHelper.EXPECTED_RESULT_NAME);
    }

    public Object getExpectedResult() {
        return getArgumentValue(TestMethodHelper.EXPECTED_RESULT_NAME);
    }

    public boolean isExpectedErrorDefined() {
        return testObject.containsField(TestMethodHelper.EXPECTED_ERROR);
    }

    public String getExpectedError() {
        return (String) getArgumentValue(TestMethodHelper.EXPECTED_ERROR);
    }

    public boolean isRuntimeContextDefined() {
        return testObject.containsField(TestMethodHelper.CONTEXT_NAME);
    }

    public IRulesRuntimeContext getRuntimeContext() {
        return (IRulesRuntimeContext) getArgumentValue(TestMethodHelper.CONTEXT_NAME);
    }

    @Override
    public String toString() {
        String description = getDescription();

        if (description == null) {
            if (testedMethod.getSignature().getNumberOfParameters() > 0) {
                String name = testedMethod.getSignature().getParameterName(0);
                Object value = testObject.getFieldValue(name);
                IFormatter formatter = FormattersManager.getFormatter(value);
                description = formatter.format(value);
            } else {
                description = "Run with no parameters";
            }
        }
        return description;
    }

}
