package com.insider.test.support.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * The Class endpoints properties will have url endpoints
 */
@Component
@PropertySource(
        value = {"classpath:endpoints.properties"},
        ignoreResourceNotFound = true
)
public class EndpointProperties {

    private static Logger logger = Logger.getLogger(String.valueOf(EndpointProperties.class));

    /**
     * The url.
     */
    @Value("${APPLICATION_URL}")
    private String url;

    /**
     * The endpoint url.
     */
    @Value("${ENDPOINT_URL}")
    private String endpointUrl;


    /**
     * Gets the url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Gets the endpoint url.
     *
     * @return the endpointUrl
     */
    public String getEndpointUrl() {
        return endpointUrl;
    }

    @PostConstruct
    public void test() {
        logger.info("url = " + url);
        logger.info("url endpoint = " + endpointUrl);
    }

}
