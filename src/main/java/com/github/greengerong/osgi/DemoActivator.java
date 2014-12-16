package com.github.greengerong.osgi;

import com.github.greengerong.app.AppModule;
import com.github.greengerong.named.NamedService;
import com.github.greengerong.order.OrderService;
import com.github.greengerong.runtime.RuntimeService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * ***************************************
 * *
 * Auth: green gerong                     *
 * Date: 2014                             *
 * blog: http://greengerong.github.io/    *
 * github: https://github.com/greengerong *
 * *
 * ****************************************
 */
public class DemoActivator implements BundleActivator {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoActivator.class);

    private Injector injector;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        LOGGER.info("enter demo activator.");
        injector = Guice.createInjector(new AppModule(bundleContext));
        final OrderService orderService = injector.getInstance(OrderService.class);
        orderService.add();
        final RuntimeService runtimeService = injector.getInstance(RuntimeService.class);
        runtimeService.call();
        final List<NamedService> namedServices = injector.getInstance(new Key<List<NamedService>>() {
        });
        for (int i = 0; i < namedServices.size(); i++) {
            namedServices.get(i).call();
        }
        LOGGER.info("success leave activator.");
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        injector = null;
        LOGGER.info("bundle removed.");
    }
}
