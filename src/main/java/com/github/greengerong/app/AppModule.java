package com.github.greengerong.app;

import com.github.greengerong.item.ItemService;
import com.github.greengerong.item.ItemServiceImpl;
import com.github.greengerong.named.NamedService;
import com.github.greengerong.named.NamedServiceImpl1;
import com.github.greengerong.named.NamedServiceImpl2;
import com.github.greengerong.order.OrderService;
import com.github.greengerong.order.OrderServiceImpl;
import com.github.greengerong.price.PriceService;
import com.github.greengerong.runtime.RuntimeService;
import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.google.inject.Scopes.SINGLETON;

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
public class AppModule extends AbstractModule {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppModule.class);
    private final BundleContext bundleContext;

    public AppModule(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
        LOGGER.info(String.format("enter app module with: %s", bundleContext));
    }

    @Override
    public void configure() {
        final Binder binder = binder();
        //TODO: bind interface
        binder.bind(ItemService.class).to(ItemServiceImpl.class).in(SINGLETON);
        binder.bind(OrderService.class).to(OrderServiceImpl.class).in(SINGLETON);
        //TODO: bind self class(without interface or base class)
        binder.bind(PriceService.class).in(Scopes.SINGLETON);


        //TODO: bind instance not class.
        binder.bind(RuntimeService.class).toInstance(new RuntimeService());

        //TODO: bind named instance;
        binder.bind(NamedService.class).annotatedWith(Names.named("impl1")).to(NamedServiceImpl1.class);
        binder.bind(NamedService.class).annotatedWith(Names.named("impl2")).to(NamedServiceImpl2.class);
    }

    @Provides
    public List<NamedService> getAllItemServices(@Named("impl1") NamedService nameService1,
                                                 @Named("impl2") NamedService nameService2) {
        final ArrayList<NamedService> list = new ArrayList<NamedService>();
        list.add(nameService1);
        list.add(nameService2);
        return list;
    }
}
