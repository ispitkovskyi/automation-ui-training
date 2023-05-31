package framework.pages.about;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ispitkovskyi on 6/24/2016.
 */
public class PageAboutGarcinia extends PageAbout {

    @FindBy(xpath = "//h2[text()='About Us']")
    WebElement aboutHeader;

    public boolean isOpened() throws InterruptedException {
        return isOpened(aboutHeader);
    }
}
