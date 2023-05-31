package framework.pages;

import framework.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ispitkovskyi on 6/19/2016.
 */
public abstract class PageAbstract {
    protected WebDriver driver;

    protected PageAbstract(){
        driver = DriverFactory.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    protected void scrollToElement(WebElement element) throws InterruptedException {
        scrollToElement(element, null);
    }
    protected void scrollToElement(WebElement element, Integer pause) throws InterruptedException {
        if(pause == null)
            pause = 500;

        ((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.currentThread().sleep(pause);
    }

}
