package com.insider.test.support.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by nmylarapu on 4/17/19.
 */
@Configuration
@ComponentScan(basePackages = { "com.insider.test" })

public class TestConfiguration {

        /**
         *  properties cnfig placeholder configurer.
         * @return the property sources placeholder configurer
         */
        @Bean
        public static PropertySourcesPlaceholderConfigurer corePropertiesConfigPlaceholderConfigurer() {
            PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
            p.setTrimValues(true);
            return p;
        }

    }

