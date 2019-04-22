package com.insider.test;

import com.insider.test.support.apps.page.HomePage;
import com.insider.test.support.library.AppHelperLibs;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * SocialLinks test:
 */

//Todo need to validate copy link and email links
public class SocialLinksTest extends BaseTest {

    @Test(groups = {"SocialLinks", "regression"})
    public void verifySocialLinks() {

        HomePage homePage = new HomePage(webDriver);
        String parentWinHandle = webDriver.getWindowHandle();
        List<String> expectedPageTitlesList = new ArrayList<>();
        List<String> actualPageTitlesList = new ArrayList<>();

        //Todo need to log into social accounts and validate actual business pages
        expectedPageTitlesList.add("facebook");
        expectedPageTitlesList.add("post a tweet on twitter");
        expectedPageTitlesList.add("linkedin");
        expectedPageTitlesList.add("flipboard");

        if (homePage.getSocialBar().getShareMoreIcon().isDisplayed() && homePage.getSocialBar().getShareMoreIcon().isEnabled()) {

            AppHelperLibs.getWebDriverWait(webDriver, 15).until(ExpectedConditions.elementToBeClickable(homePage.getSocialBar().getShareMoreIcon().getWrappedElement()));

            homePage.getSocialBar().getShareMoreIcon().click();

            for (int x = 0; x < homePage.getSocialBar().getSocialLinks().size(); x++) {

                String linkedText = homePage.getSocialBar().getSocialLinks().get(x).getAttribute("title").toLowerCase();
                if (!linkedText.contains("copy link") && !linkedText.contains("email")) {
                    homePage.getSocialBar().getSocialLinks().get(x).click();
                    webDriver.switchTo().window(AppHelperLibs.getSubWindowHandler(webDriver));
                    webDriver.manage().timeouts().pageLoadTimeout(DEFAULT_PAGE_LOAD_TIME, TimeUnit.SECONDS);
                    actualPageTitlesList.add(webDriver.getTitle().toLowerCase());
                    webDriver.close();
                    webDriver.switchTo().window(parentWinHandle);
                }
            }

            System.out.println("expected social links:" + expectedPageTitlesList);
            System.out.println("actual social links:" + actualPageTitlesList);
            softAssert.assertTrue(expectedPageTitlesList.containsAll(actualPageTitlesList));
            softAssert.assertAll();
        }

    }
}
