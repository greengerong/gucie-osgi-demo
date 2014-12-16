package com.github.greengerong.order;

import com.github.greengerong.item.ItemService;
import com.github.greengerong.price.PriceService;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

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
public class OrderServiceImpl implements OrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);
    private ItemService itemService;
    private PriceService priceService;

    @Inject
    public OrderServiceImpl(ItemService itemService, PriceService priceService) {
        this.itemService = itemService;
        this.priceService = priceService;
    }

    @Override
    public void add() {
        LOGGER.info("order service called.");
        itemService.get();
        priceService.getPrice();
    }


    public ItemService getItemService() {
        return itemService;
    }

    public PriceService getPriceService() {
        return priceService;
    }
}
