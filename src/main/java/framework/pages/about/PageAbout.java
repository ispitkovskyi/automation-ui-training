package framework.pages.about;

import framework.pages.PageAbstract;
import org.openqa.selenium.WebElement;

/**
 * Created by ispitkovskyi on 6/19/2016.
 */
public class PageAbout extends PageAbstract {

    public boolean isOpened(WebElement element) throws InterruptedException {
        System.out.println("Scroll to element");
        scrollToElement(element);
        System.out.println("Sleep after scroll");
        Thread.currentThread().sleep(500);
        System.out.println("Check if element is displayed");
        return element.isDisplayed();
    }

    public boolean isOpened() throws Exception {
        throw new Exception("isOpened() method is not supported in the super-class PageAbout");
    }
}
