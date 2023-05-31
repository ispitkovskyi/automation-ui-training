package framework.pages.about;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ispitkovskyi on 6/24/2016.
 */
public class PageAboutDetox extends PageAbout {

    @FindBy(xpath = "//h2[text()='About Pure Colon Detox']")
    WebElement aboutHeader;

    public boolean isOpened() throws InterruptedException {
        return isOpened(aboutHeader);
    }
}
