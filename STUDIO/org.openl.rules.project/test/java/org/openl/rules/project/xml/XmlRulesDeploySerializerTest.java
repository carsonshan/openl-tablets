package org.openl.rules.project.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.openl.rules.project.model.RulesDeploy;
import org.openl.rules.project.model.RulesDeploy.PublisherType;

public class XmlRulesDeploySerializerTest {
    
    @Test
    public void testReadRulesDeploy() throws Exception{
        FileInputStream fis = new FileInputStream(new File("test/resources/rules-deploy/rules-deploy.xml"));
        XmlRulesDeploySerializer serializer = new XmlRulesDeploySerializer();
        RulesDeploy rulesDeploy = serializer.deserialize(fis);
        
        assertNotNull(rulesDeploy);
        assertEquals("rulesDeployName", rulesDeploy.getServiceName());
        assertEquals(Boolean.FALSE, rulesDeploy.isProvideRuntimeContext());
        assertEquals(Boolean.TRUE, rulesDeploy.isUseRuleServiceRuntimeContext());
        assertEquals(Boolean.TRUE, rulesDeploy.isProvideVariations());
        assertEquals(String.class.getCanonicalName(), rulesDeploy.getServiceClass());
        assertEquals(String.class.getCanonicalName(), rulesDeploy.getInterceptingTemplateClassName());
        assertNotNull(rulesDeploy.getPublishers());
        assertEquals(1, rulesDeploy.getPublishers().length);
        assertEquals(RulesDeploy.PublisherType.RESTFUL, rulesDeploy.getPublishers()[0]);
        assertEquals("someURL", rulesDeploy.getUrl());
    }
    
    @Test
    public void testWriteRulesDeploy(){
        RulesDeploy rulesDeploy = new RulesDeploy();
        rulesDeploy.setServiceName("rulesDeployName");
        rulesDeploy.setProvideRuntimeContext(false);
        rulesDeploy.setProvideVariations(true);
        rulesDeploy.setUseRuleServiceRuntimeContext(true);
        rulesDeploy.setInterceptingTemplateClassName(String.class.getCanonicalName());
        rulesDeploy.setServiceClass(String.class.getCanonicalName());
        rulesDeploy.setUrl("someURL");
        rulesDeploy.setPublishers(new RulesDeploy.PublisherType[]{PublisherType.WEBSERVICE});
        Map<String, Object> configuration = new HashMap<String, Object>();
        configuration.put("key", "value");
        rulesDeploy.setConfiguration(configuration);
        XmlRulesDeploySerializer serializer = new XmlRulesDeploySerializer();
        String value = serializer.serialize(rulesDeploy);
        String expectedValue = "<rules-deploy>" + "\n" +
                                "  <isProvideRuntimeContext>false</isProvideRuntimeContext>"+ "\n" +
                                "  <isProvideVariations>true</isProvideVariations>"+ "\n" +
                                "  <useRuleServiceRuntimeContext>true</useRuleServiceRuntimeContext>"+ "\n" +
                                "  <serviceName>rulesDeployName</serviceName>"+ "\n" +
                                "  <publishers>"+ "\n" +
                                "    <publisher>WEBSERVICE</publisher>" + "\n" + 
                                "  </publishers>"+ "\n" +
                                "  <interceptingTemplateClassName>java.lang.String</interceptingTemplateClassName>"+ "\n" +
                                "  <serviceClass>java.lang.String</serviceClass>"+ "\n" +
                                "  <url>someURL</url>"+ "\n" +
                                "  <configuration>"+ "\n" +
                                "    <entry>"+ "\n" +
                                "      <string>key</string>"+ "\n" +
                                "      <string>value</string>"+ "\n" +
                                "    </entry>"+ "\n" +
                                "  </configuration>" + "\n" +
                                "</rules-deploy>";
        assertEquals(expectedValue, value);
    }
}