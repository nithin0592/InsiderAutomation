package com.insider.test.support.apps.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

/**
 * Base page will have common page properties and base page extends in every page class
 * Created by nithin mylarapu on 4/20/19.
 */
public class BasePage {

    public BasePage(WebDriver webDriver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(webDriver)), this);
    }
}
