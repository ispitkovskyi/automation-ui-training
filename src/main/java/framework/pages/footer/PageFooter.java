package framework.pages.footer;

import framework.pages.PageAbstract;
import framework.pages.about.AboutPageFactory;
import framework.pages.about.PageAbout;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ispitkovskyi on 6/19/2016.
 */
@FindBy(xpath = "//footer[contains(@class, 'footer')]")
public class PageFooter extends PageAbstract {

    @FindBy(xpath = ".//a[contains(@class, 'popup-link') and text()='About']")
    WebElement lnkAbout;

    public PageAbout clickAbout() throws InterruptedException {
        scrollToElement(lnkAbout);
        System.out.println("Click About link");
        lnkAbout.click();
        System.out.println("Return instance of About box");
        return AboutPageFactory.getInstance();
    }
}
