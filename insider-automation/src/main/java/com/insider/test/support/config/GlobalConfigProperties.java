package com.insider.test.support.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * The Class GlobalConfigProperties.
 */
@Component
@PropertySource(
        value = {"classpath:globalconfig.properties"},
        ignoreResourceNotFound = true
)
public class GlobalConfigProperties {

    private static Logger logger = Logger.getLogger(String.valueOf(GlobalConfigProperties.class));

    /**
     * The browser.
     */
    @Value("${BROWSER}")
    private String browser;

    /**
     * Gets the browser.
     *
     * @return the browser
     */
    public String getBrowser() {
        return browser;
    }

    @PostConstruct
    public void test() {

        logger.info("browser = " + browser);
    }
}
