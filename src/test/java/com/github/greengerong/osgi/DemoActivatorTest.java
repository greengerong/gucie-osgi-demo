package com.github.greengerong.osgi;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.osgi.framework.BundleContext;

@RunWith(MockitoJUnitRunner.class)
public class DemoActivatorTest {

    private DemoActivator demoActivator;
    @Mock
    private BundleContext bundleContext;

    @Before
    public void setUp() throws Exception {
        demoActivator = new DemoActivator();
    }

    @Test
    public void should_set_up_guice_success() throws Exception {
        demoActivator.start(bundleContext);
    }
}