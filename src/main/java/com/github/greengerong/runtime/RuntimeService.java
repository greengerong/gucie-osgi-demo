package com.github.greengerong.runtime;

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
public class RuntimeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RuntimeService.class);

    public void call() {
        LOGGER.info("runtime service called.");
    }
}
