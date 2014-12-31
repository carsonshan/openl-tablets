package org.openl.rules.ruleservice.loader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openl.rules.common.CommonVersion;
import org.openl.rules.common.impl.CommonVersionImpl;
import org.openl.rules.project.abstraction.Deployment;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.openl.rules.ruleservice.Constants.DEPLOYMENT_NAME;
import static org.openl.rules.ruleservice.Constants.VERSION;

public class JcrDataSourceTest {

    private JcrDataSource dataSource;

    @Before
    public void setDataSource() throws Exception {
        dataSource = new JcrDataSource();
    }

    @After
    public void releaseDataSource() throws Exception {
        dataSource.destroy();
    }

    @Test
    public void testJcrDataSource() {
        assertNotNull(dataSource);
    }

    @Test
    public void testGetDeployments() {
        Collection<Deployment> deployments = dataSource.getDeployments();
        assertTrue(deployments.size() > 0);
    }

    @Test
    public void testGetDeployment() {
        CommonVersion commonVersion = new CommonVersionImpl(VERSION);
        Deployment deployment = dataSource.getDeployment(DEPLOYMENT_NAME, commonVersion);
        assertNotNull(deployment);
        assertEquals(DEPLOYMENT_NAME, deployment.getDeploymentName());
        assertEquals(VERSION, deployment.getCommonVersion().getVersionName());
    }

    @Test
    public void testAddListener() {
        assertEquals(0, dataSource.listeners.size());
        DataSourceListener dataSourceListener = new DataSourceListener() {
            public void onDeploymentAdded() {
            }
        };
        dataSource.addListener(dataSourceListener);
        assertEquals(1, dataSource.listeners.size());
    }

    @Test
    public void testRemoveListener() {
        assertEquals(0, dataSource.listeners.size());
        DataSourceListener dataSourceListener = new DataSourceListener() {
            public void onDeploymentAdded() {
            }
        };
        dataSource.addListener(dataSourceListener);
        assertEquals(1, dataSource.listeners.size());
        dataSource.removeListener(dataSourceListener);
        assertEquals(0, dataSource.listeners.size());
    }
}