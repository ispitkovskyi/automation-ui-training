package tests;

import framework.pages.contact.ContactPageFactory;
import framework.pages.contact.PageMainContact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by IgorS on 6/30/2016.
 */
public class ContactTest {
    PageMainContact pageMainContact;

    @BeforeMethod
    public void setUp() throws Exception {
        pageMainContact = ContactPageFactory.getInstance();
    }

    @Test
    public void fillContactData() throws Exception {
        pageMainContact.fill();
    }

}
