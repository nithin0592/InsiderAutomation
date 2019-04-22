package com.insider.test.support.apps.page;


import com.insider.test.support.apps.page.block.SocialBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Class representing home page, home page contains multiple blocks like SocialBar etc..
 */
public class HomePage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'group-icons')]")
    private SocialBar socialBar;

    public SocialBar getSocialBar() {
        return socialBar;
    }

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }


}
