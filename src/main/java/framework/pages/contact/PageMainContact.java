package framework.pages.contact;

import framework.pages.PageAbstract;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by IgorS on 7/1/2016.
 */
public class PageMainContact extends PageAbstract{
    String country, firstName, lastName, email, phone, street, city, zip;
    protected Select countrySelect;
    protected WebElement firstNameFld, lastNameFld,emailFld, phoneFld, streetFld, cityFld, zipFld;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement orderBtn;

    public PageMainContact(){
        country = System.getProperty("order.country");
        firstName = System.getProperty("order.firstName");
        lastName = System.getProperty("order.lastName");
        email = System.getProperty("order.email");
        phone = System.getProperty("order.phone");
        street = System.getProperty("order.street");
        city = System.getProperty("order.city");
        zip = System.getProperty("order.zip");
    }

    public PageMainContact fill() throws InterruptedException{
        countrySelect.selectByVisibleText(country);
        firstNameFld.sendKeys(firstName);
        lastNameFld.sendKeys(lastName);
        emailFld.sendKeys(email);
        phoneFld.sendKeys(phone);
        streetFld.sendKeys(street);
        cityFld.sendKeys(city);
        zipFld.sendKeys(zip);

        scrollToElement(orderBtn);

        return null;
    }
}
