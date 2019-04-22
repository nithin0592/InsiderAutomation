package com.insider.test;

import com.insider.test.support.config.EndpointProperties;
import com.insider.test.support.config.GlobalConfigProperties;
import com.insider.test.support.library.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

/**
 * Base test class which should be inherited by all test classes. It contains Web Driver instance which is accessible
 * for all tests and configuration stuff.
 */

public class BaseTest extends ConfigurationTest {

    public static final int DEFAULT_IMPLICITLY_WAIT = 3;
    public static final int DEFAULT_PAGE_LOAD_TIME = 10;
    protected WebDriver webDriver;

    protected SoftAssert softAssert = new SoftAssert();

    @Autowired
    protected GlobalConfigProperties globalConfigProperties;

    @Autowired
    protected EndpointProperties endpointProperties;

    @BeforeSuite(alwaysRun = true)
    public void initialize() {
        System.out.println("starting test suite..");
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("stopping test suite..");
    }

    @BeforeClass(alwaysRun = true)
    public void startSelenium() throws Exception {
        System.out.println("starting selenium..");
        openSite();
        //applicationLogin();
    }

    @AfterClass(alwaysRun = true)
    public void stopSelenium() {
        System.out.println("stopping selenium..");
        try {
            webDriver.quit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void openSite() throws Exception {
        System.out.println("launching and going to aut..");
        setBrowserDriverSystemProperty();
        //Todo navigating to base URL here and concatenate end url in test level
        try {
            String url = endpointProperties.getUrl()+ endpointProperties.getEndpointUrl();
            webDriver.get(url);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error, unable to naivgate to url. Please ensure url is correct");
        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(DEFAULT_PAGE_LOAD_TIME, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICITLY_WAIT, TimeUnit.SECONDS);
    }


    private void setBrowserDriverSystemProperty() throws Exception {

      String browser = globalConfigProperties.getBrowser();

        //Check if parameter passed from TestNG is 'firefox'
        if (browser.equalsIgnoreCase("firefox")) {
            //create firefox instance
            if (Utilities.isWindows()) {
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

            } else {
                System.setProperty("webdriver.gecko.driver", "geckodriver");
            }
            //create Firefox instance
            webDriver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("chrome")) {
            //set path to chromedriver
            if (Utilities.isWindows()) {
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

            } else {
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            }
            //create chrome instance
            webDriver = new ChromeDriver();
        }
        //Check if parameter passed as 'Edge'
        else if (browser.equalsIgnoreCase("Edge")) {
            //set path to Edge
            if (Utilities.isWindows()) {
                System.setProperty("webdriver.edge.driver", "MicrosoftWebDriver.exe");
            }
            //create Edge instance
            webDriver = new EdgeDriver();
        } else {
            System.out.println("browser parameter is not matching with required browser, Please try with ");
        }

    }

        public void applicationLogin(){
        System.out.println("User is able to login!!");
    }

}
