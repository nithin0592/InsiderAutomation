package com.insider.test.support.library;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

/**
 * Consist of app specific functions.
 */
public class AppHelperLibs {

    private static String subWindowHandler(WebDriver driver){
        String subWindowHandler = null;
        Set<String> windowHandles;
        Iterator<String> iter;

        windowHandles = driver.getWindowHandles();
        iter = windowHandles.iterator();
        while(iter.hasNext()) {
            subWindowHandler = iter.next();
        }

        return subWindowHandler;
    }

    public static String getSubWindowHandler(WebDriver driver){
        return subWindowHandler(driver);
    }

    private static void enabledHiddenElement(WebDriver driver, WebElement webElement)   {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", webElement);
    }

    public static void getEnabledHiddenElement(WebDriver driver, WebElement webElement){
        enabledHiddenElement(driver, webElement);
    }

    private static WebDriverWait webDriverWait(WebDriver driver, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        return wait;
    }

    public static WebDriverWait getWebDriverWait(WebDriver driver, int seconds){
        return webDriverWait(driver, seconds);
    }
}
