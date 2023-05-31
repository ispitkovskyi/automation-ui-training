package framework.pages.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by IgorS on 7/1/2016.
 */
public class PageMainContactGarcinia extends PageMainContact {

    //TODO: Assume locators for elements on form are different, while you need to execute "fill" method for similar (but not identical) form in different applications
    @FindBy(xpath = "//div[@class='field name-firstname']//input")
    WebElement firstNameFld;

    @FindBy(xpath = "//div[@class='field name-lastname']//input")
    WebElement lastNameFld;

    @FindBy(xpath = "//div[@class='field field-email']//input")
    WebElement emailFld;

    @FindBy(xpath = "//div[@class='field field-telephone']//input")
    WebElement phoneFld;

    @FindBy(xpath = "//div[@class='field field-street-address']//input")
    WebElement streetFld;

    @FindBy(xpath = "//div[@class='field field-city']//input")
    WebElement cityFld;

    @FindBy(xpath = "//div[@class='field field-zip']//input")
    WebElement zipFld;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement orderBtn;

    public PageMainContactGarcinia(){
        countrySelect = new Select(driver.findElement(By.xpath("//div[@class='field field-country']//select[@id='country']")));
        //This force selenium PageFactory to initialize proxy objects of WebElements, using locators specified in @FindBy annotations
        super.firstNameFld = firstNameFld;
        super.lastNameFld = lastNameFld;
        super.emailFld = emailFld;
        super.phoneFld = phoneFld;
        super.cityFld = cityFld;
        super.streetFld = streetFld;
        super.zipFld = zipFld;
        super.orderBtn = orderBtn;

    }

    public PageMainContact fill() throws InterruptedException{
        super.fill();

        return this;
    }
}
