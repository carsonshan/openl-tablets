package org.openl.rules.runtime;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openl.rules.context.IRulesRuntimeContextProvider;
import org.openl.runtime.EngineFactory;
import org.openl.runtime.EngineFactoryDefinition;
import org.openl.runtime.OpenLInvocationHandler;
import org.openl.types.IOpenMember;
import org.openl.vm.IRuntimeEnv;

/**
 * 
 * Class RuleEngineFactory creates wrappers around OpenL
 * classes with openl name "org.openl.xls".
 * 
 */
public class RuleEngineFactory<T> extends EngineFactory<T> {

    public static final String RULE_OPENL_NAME = "org.openl.xls";
    
    /**
     *
     * @param factoryDef Engine factory definition {@link EngineFactoryDefinition}.
     * @param engineInterface User interface of rule.
     */
    public RuleEngineFactory(EngineFactoryDefinition factoryDef, Class<T> engineInterface) {
        super(RULE_OPENL_NAME, factoryDef, engineInterface);
    }
    
    /**
     *
     * @param file Rule file
     * @param engineInterface User interface of rule
     */
    public RuleEngineFactory(File file, Class<T> engineInterface) {
        super(RULE_OPENL_NAME, file, engineInterface);
    }
    
    /**
     *
     * @param sourceFile A path name of rule file string
     * @param engineInterface User interface of a rule
     */
    public RuleEngineFactory(String sourceFile, Class<T> engineInterface) {
        super(RULE_OPENL_NAME, sourceFile, engineInterface);
    }
    
    /**
     *
     * @param userHome Current path of Openl userHome
     * @param sourceFile A pathname of rule file string
     * @param engineInterface User interface of a rule
     */
    public RuleEngineFactory(String userHome, String sourceFile, Class<T> engineInterface) {
        super(RULE_OPENL_NAME, userHome, sourceFile, engineInterface);
    }
    
    /**
     *
     * @param url Url to rule file
     * @param engineInterface User interface of a rule
     */
    public RuleEngineFactory(URL url, Class<T> engineInterface) {
        super(RULE_OPENL_NAME, url, engineInterface);
    }

    @Override
    protected Class<?>[] makeInstanceInterfaces() {
        
        List<Class<?>> interfaces = new ArrayList<Class<?>>();
        interfaces.addAll(Arrays.asList(super.makeInstanceInterfaces()));
        interfaces.add(IRulesRuntimeContextProvider.class);
        
        return interfaces.toArray(new Class<?>[interfaces.size()]);
    }

    @Override
    protected OpenLInvocationHandler<T> makeInvocationHandler(Object openlInstance,
            IRuntimeEnv env,
            Map<Method, IOpenMember> methodMap) {

        return new RulesInvocationHandler<T>(openlInstance, this, env, methodMap);
    }
    
}
