package com.insider.test;

import com.insider.test.support.apps.page.HomePage;
import com.insider.test.support.library.AppHelperLibs;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

/**
 * ShareBarTest test:
 */

public class ShareBarTest extends BaseTest {

    @Test(groups = {"ShareBar", "regression"})
    public void verifyButtonExpands() {

        HomePage homePage = new HomePage(webDriver);
        boolean buttonShrink = false;
        boolean buttonExpands = false;

        if (homePage.getSocialBar().getShareMoreIcon().isDisplayed() && homePage.getSocialBar().getShareMoreIcon().isEnabled()) {

            homePage.getSocialBar().getShareMoreIcon().click();
            if (homePage.getSocialBar().getCollapseShareIcon().isDisplayed() && homePage.getSocialBar().getCollapseShareIcon().isEnabled()) {

                AppHelperLibs.getWebDriverWait(webDriver, 15).until(ExpectedConditions.elementToBeClickable(homePage.getSocialBar().getCollapseShareIcon().getWrappedElement()));
                buttonExpands = homePage.getSocialBar().getButtonExpanded().isEnabled();
            }
        }

        if (buttonExpands) {
            AppHelperLibs.getEnabledHiddenElement(webDriver, homePage.getSocialBar().getButtonExpanded().getWrappedElement());
            buttonShrink = homePage.getSocialBar().getShareMoreIcon().isEnabled();
        } else {
            buttonShrink = false;
        }

        if (buttonShrink == true && buttonExpands == true) {
            softAssert.assertEquals(buttonShrink, buttonExpands, "button not expands share bar when it is clicked");
        } else {
            softAssert.assertFalse(true);
        }
        softAssert.assertAll();

    }

}
