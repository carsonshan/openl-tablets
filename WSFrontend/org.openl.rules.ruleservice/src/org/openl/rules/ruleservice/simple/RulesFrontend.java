package org.openl.rules.ruleservice.simple;

import java.util.Collection;

import org.openl.rules.ruleservice.core.OpenLService;

/**
 * The instance of this interface is not thread safe.
 * 
 * @author Marat Kamalov
 * 
 */
public interface RulesFrontend { 
    /**
     * This method is designed for extending service functionality. Modify returned OpenLService object, can be result of system failure.
     * Please, don't modify returned OpenLService object.
     * 
     * @param serviceName service name
     * @return found service
     */
    OpenLService findServiceByName(String serviceName);

    /**
     * Executes method with specified parameters.
     * 
     * @param serviceName Name of deployed service
     * @param ruleName Technical name of the rule to execute
     * @param inputParamsTypes Types of method input parameters to discover
     *            method
     * @param params Parameters for method execution
     * @return Result of execution
     */
    Object execute(String serviceName, String ruleName, Class<?>[] inputParamsTypes, Object[] params)
            throws MethodInvocationException;

    /**
     * Executes method with specified parameters. Method discovery is done based
     * on parameters types.
     * 
     * @param serviceName Name of deployed service
     * @param ruleName Technical name of the rule to execute
     * @param params Parameters for method execution
     * @return Result of execution
     */
    Object execute(String serviceName, String ruleName, Object... params) throws MethodInvocationException;

    /**
     * Gets values defined in rules.
     * 
     * @param serviceName Name of deployed service
     * @param fieldName Technical name of the rule to execute
     * @return Data stored in field
     */
    Object getValue(String serviceName, String fieldName) throws MethodInvocationException;
    
    /**
     * Gets service names.
     */
    Collection<String> getServiceNames();

    /**
     * Registers service to use it in calculations.
     * 
     * @param service Service to register.
     *
     */
    void registerService(OpenLService service);

    /**
     * Unregister service.
     * 
     * @param serviceName Service to unregister
     */
    void unregisterService(String serviceName);
    
    /**
     * Return proxy object for defined service.
     * @param serviceName service name
     * @param proxyInterface interface for proxy
     * @return Proxy object for service
     */
    <T> T buildServiceProxy(String serviceName, Class<T> proxyInterface);

    /**
     * Return proxy object for defined service.
     * @param serviceName service name
     * @param proxyInterface interface for proxy
     * @param classLoader classloader
     * @return Proxy object for service
     */
    <T> T buildServiceProxy(String serviceName, Class<T> proxyInterface, ClassLoader classLoader);
}
