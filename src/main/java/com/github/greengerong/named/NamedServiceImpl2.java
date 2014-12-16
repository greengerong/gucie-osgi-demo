package com.github.greengerong.named;

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
public class NamedServiceImpl2 implements NamedService {
    private static final Logger LOGGER = LoggerFactory.getLogger(NamedServiceImpl2.class);

    @Override
    public void call() {
        LOGGER.info("named service 2 called.");
    }
}
