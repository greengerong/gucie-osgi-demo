package com.github.greengerong.price;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class PriceService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PriceService.class);

    public void getPrice() {
        LOGGER.info("price service called.");
    }
}
