package org.openl.rules.runtime;

import java.lang.reflect.Method;
import java.util.Map;

import org.openl.rules.context.DefaultRulesRuntimeContext;
import org.openl.rules.context.IRulesRuntimeContext;
import org.openl.rules.context.IRulesRuntimeContextProvider;
import org.openl.types.IOpenMember;
import org.openl.vm.IRuntimeEnv;

public class RulesInvocationHandler extends OpenLRulesInvocationHandler implements IRulesRuntimeContextProvider {

    public RulesInvocationHandler(Object openlInstance,
            IRuntimeEnv openlEnv,
            Map<Method, IOpenMember> methodMap) {
        super(openlInstance, openlEnv, methodMap);
    }

    public RulesInvocationHandler(Object openlInstance,
            Map<Method, IOpenMember> methodMap) {

        super(openlInstance, methodMap);
    }

    public IRulesRuntimeContext getRuntimeContext() {
        
        IRulesRuntimeContext runtimeContext = (IRulesRuntimeContext) getRuntimeEnv().getContext();

        if (runtimeContext == null) {
            runtimeContext = new DefaultRulesRuntimeContext();
            getRuntimeEnv().setContext(runtimeContext);
        }

        return (IRulesRuntimeContext) runtimeContext;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getDeclaringClass() == IRulesRuntimeContextProvider.class) {
            Method declaredMethod = RulesInvocationHandler.class.getDeclaredMethod(method.getName(), new Class<?>[0]);
            return declaredMethod.invoke(this, args);
        }

        return super.invoke(proxy, method, args);
    }

}
