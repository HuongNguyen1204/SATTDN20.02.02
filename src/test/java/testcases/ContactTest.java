package testcases;

import org.testng.Assert;
import pageobjects.ContactPage;
import pageobjects.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Constants;
import utilities.Log;

public class ContactTest extends BaseTest{
    LoginPage loginPage;
    ContactPage contactPage;

    @BeforeMethod
    public void setupTest(){
        loginPage = new LoginPage();
        contactPage = new ContactPage();
    }

    @Test(testName = "TO_JOOMLA_CONTACTS_006",description = "Verify user can check in contact")
    public void TO_JOOMLA_CONTACTS_006(){
        Log.startTestCase("TO_JOOMLA_CONTACTS_006: Verify user can check in contact ");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME,Constants.VALID_PASSWORD );

        Log.info("[STEP-2] - Click content on menu nav bar)");
        contactPage.clickMenuItem(Constants.COMPONENTS_MENU);

        Log.info("[STEP-3] - Click Articles item of content menu");
        contactPage.clickMenuItem(Constants.CONTACT_MENU);

        Log.info("[STEP-4] - Click New icon");
        contactPage.clickNewBtn();

        Log.info("[STEP-5] - Fill data to contact form");
        contactPage.fillDataContactForm(Constants.TITLE_CONTACT,Constants.STATUS,Constants.CATEGORY_CONTACT);

        Log.info("[STEP-5] - Fill data to contact form");
        contactPage.clickSaveAndCloseBtn();

        Log.info("[STEP-6] - Assert saved article success");
        Assert.assertEquals(contactPage.getSavedMessageSuccess(),Constants.SAVE_CONTACT_SUCCESS);
    }
}
