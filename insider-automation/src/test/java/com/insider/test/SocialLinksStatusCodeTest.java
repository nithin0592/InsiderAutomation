package com.insider.test;

import com.insider.test.support.apps.page.HomePage;
import com.insider.test.support.library.AppHelperLibs;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;

import java.util.ArrayList;
import java.util.List;

/**
 * SocialLinks test:
 */

public class SocialLinksStatusCodeTest extends BaseTest {

    @Test(groups = {"SocialLinksStatusCode", "regression"})
    public void verifySocialLinks() throws IOException {


        HomePage homePage = new HomePage(webDriver);
        List<String> successStatusURLs = new ArrayList<>();
        List<String> errorStatusURLs = new ArrayList<>();
        boolean tracker = true;

        if (homePage.getSocialBar().getShareMoreIcon().isDisplayed() && homePage.getSocialBar().getShareMoreIcon().isEnabled()) {
            AppHelperLibs.getWebDriverWait(webDriver, 15).until(ExpectedConditions.elementToBeClickable(homePage.getSocialBar().getShareMoreIcon().getWrappedElement()));
            homePage.getSocialBar().getShareMoreIcon().click();

            for (int x = 0; x < homePage.getSocialBar().getSocialLinks().size(); x++) {
                String href = homePage.getSocialBar().getSocialLinks().get(x).getAttribute("href");
                if (href != "" || href != " ") {
                    URL url = new URL(href);
                    HttpURLConnection http = (HttpURLConnection) url.openConnection();
                    if (http.getResponseCode() == 200) {
                        successStatusURLs.add(href);
                    } else {
                        errorStatusURLs.add(href);
                        tracker = false;
                    }
                }
            }
            System.out.println("List of URLs with error:" + errorStatusURLs.toString());
            System.out.println("List of URLs with 200 status code:" + successStatusURLs.toString());

            softAssert.assertTrue(tracker);
            softAssert.assertAll();
        }
    }
}
