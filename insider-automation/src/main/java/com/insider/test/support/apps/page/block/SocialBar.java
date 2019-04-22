package com.insider.test.support.apps.page.block;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

import java.util.List;

/**
 * Created by nithin mylarapu on 4/20/19.
 */
public class SocialBar extends HtmlElement {

    @FindBy(xpath = "//a[@title= 'Expand Share Options']")
    private Button shareMoreIcon;

    @FindBy(xpath = "//a[@title= 'Collapse Share Options']")
    private Button collapseShareIcon;

    @FindBy(xpath = "//a[contains(@class,'share-less d-none')]")
    private Button buttonClosed;

    @FindBy(xpath = "//a[contains(@class,'share-more d-none')]")
    private Button buttonExpanded;

    @FindBy(xpath = "//div[contains(@class, 'group-icons')]/a")
    private List<Link> socialLinks;

    public Button getShareMoreIcon() {
        return shareMoreIcon;
    }

    public Button getCollapseShareIcon() {
        return collapseShareIcon;
    }

    public Button getButtonClosed() {
        return buttonClosed;
    }

    public Button getButtonExpanded() {
        return buttonExpanded;
    }

    public List<Link> getSocialLinks() {
        return socialLinks;
    }
}
