package framework;

/**
 * Created by ispitkovskyi on 6/19/2016.
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
    private static WebDriver driver;
    //Do not allow to initialize this class from outside
    private DriverFactory() { }

    private static DriverFactory instance;

    public static DriverFactory getInstance() {
        if(instance == null){
            instance = new DriverFactory();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if(driver == null) {
            String browserType = EnvironmentProperties.get().browser.toLowerCase();
            System.out.println("Using browser: " + browserType);
            switch (browserType) {
                case "chrome":
                    driver = createChromeDriver();
                    break;
                case "firefox":
                    driver = createFirefoxDriver();
                    break;
                case "ie":
                    driver = createIEDriver();
                    break;
                default:
                    throw new RuntimeException("Unknown WebDriver browser: " + browserType);
            }
        }
        return driver;
    }

    //Following "remove()" method is needed to avoid ERROR org.openqa.selenium.remote.SessionNotFoundException: The FirefoxDriver cannot be used after quit() was called.
    public void removeDriver() {
        driver.quit();
    }

    private WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setEnableNativeEvents(true);

        profile.setPreference("browser.download.manager.showWhenStarting", false);
        //profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/json");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "");
        profile.setPreference("browser.download.manager.showAlertOnComplete", false);
        profile.setPreference("browser.download.panel.shown", false);
        profile.setPreference("browser.download.useToolkitUI", true);
        profile.setPreference("dom.disable_window_flip", false);

        WebDriver webDriver = new FirefoxDriver(profile);
        webDriver.manage().window().maximize();
        return webDriver;
    }

    private WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        return webDriver;
    }

    private WebDriver createIEDriver() {
        System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");

        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability("ie.ensureCleanSession", true);
        capabilities.setCapability("enablePersistentHover", false);
        capabilities.setCapability("requireWindowFocus", true);
        capabilities.setCapability("unexpectedAlertBehaviour", "accept");

        WebDriver webDriver = new InternetExplorerDriver(capabilities);
        webDriver.manage().window().maximize();
        return webDriver;
    }

}
