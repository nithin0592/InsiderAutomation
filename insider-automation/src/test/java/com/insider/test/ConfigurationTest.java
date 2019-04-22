package com.insider.test;

import com.insider.test.support.library.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * initialize spring Context Configuration
 * Created by nmylarapu on 4/18/2019.
 */
@ContextConfiguration(classes = {TestConfiguration.class})
public class ConfigurationTest extends AbstractTestNGSpringContextTests {


}
