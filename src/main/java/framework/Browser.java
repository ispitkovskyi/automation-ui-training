package framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by ispitkovskyi on 6/19/2016.
 */
public class Browser {
    WebDriver driver;

    @BeforeClass
    private void init(){
        driver = DriverFactory.getInstance().getDriver();
    }

    @Test
    @Parameters({"url"})
    public void goToUrl(@Optional String url){
        if(url == null)
            url = EnvironmentProperties.get().getServerUrl();
        driver.get(url);
    }

    @Test
    public void close() throws InterruptedException {
        Thread.currentThread().sleep(500);
        DriverFactory.getInstance().removeDriver();
    }
}
