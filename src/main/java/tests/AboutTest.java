package tests;

import framework.pages.footer.PageFooter;
import framework.pages.about.PageAbout;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by ispitkovskyi on 6/19/2016.
 */
public class AboutTest {
    PageFooter elementFooter;

    @BeforeMethod
    public void setUp(){
        elementFooter = new PageFooter();
    }

    @Test
    public void openAbout() throws Exception {
        PageAbout about = elementFooter.clickAbout();
        Assert.assertTrue(about.isOpened(), "About box could not be opened");
    }

}
