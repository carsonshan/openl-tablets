package org.openl.rules.ruleservice.publish.cache.dispatcher;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DispatchedData {
    Class<? extends ModuleDispatcherForData> dispatcher() ; 
}