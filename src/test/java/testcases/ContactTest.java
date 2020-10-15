package testcases;

import helpers.DataHelper;
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
    public void TC_JOOMLA_CONTACTS_006(){
        Log.startTestCase("TO_JOOMLA_CONTACTS_006: Verify user can check in contact ");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME,Constants.VALID_PASSWORD );

        Log.info("[STEP-2] - Click content on menu nav bar)");
        contactPage.clickMenuItem(Constants.COMPONENTS_MENU);

        Log.info("[STEP-3] - Click Contact item of components menu");
        contactPage.clickMenuItem(Constants.CONTACT_MENU);

        Log.info("[STEP-4] - Click New icon");
        contactPage.clickNewBtn();

        Log.info("[STEP-5] - Fill data to contact form");
        String titleRandom = DataHelper.randomText();
        contactPage.fillDataContactForm(titleRandom,Constants.STATUS,Constants.CATEGORY_CONTACT);

        Log.info("[STEP-6] - Click save and close button");
        contactPage.clickSaveAndCloseBtn();

        Log.info("[STEP-7] - Assert saved contact success");
        Assert.assertEquals(contactPage.getSavedMessageSuccess(),Constants.SAVE_CONTACT_SUCCESS);

        Log.info("[STEP-8] - Select to show all contact");
        contactPage.viewItemByQuantity(Constants.ALL_QUANTITY);

        Log.info("[STEP-9] - Assert the tile contact just saved");
        Assert.assertTrue(contactPage.doesShowTitle(titleRandom));
    }

    @Test(testName = "TC_JOOMLA_CONTACTS_013",description = "Verify user can add image to contact's information")
    public void TC_JOOMLA_CONTACTS_013(){
        Log.startTestCase("TC_JOOMLA_CONTACTS_013: Verify user can add image to contact's information");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME,Constants.VALID_PASSWORD );

        Log.info("[STEP-2] - Click content on menu nav bar)");
        contactPage.clickMenuItem(Constants.COMPONENTS_MENU);

        Log.info("[STEP-3] - Click Contact item of components menu");
        contactPage.clickMenuItem(Constants.CONTACT_MENU);

        Log.info("[STEP-4] - Click New icon");
        contactPage.clickNewBtn();

        Log.info("[STEP-5] - Fill data to contact form");
        String titleRandom = DataHelper.randomText();
        contactPage.fillDataContactForm(titleRandom,Constants.STATUS,Constants.CATEGORY_CONTACT);

        Log.info("[STEP-6] - Insert image to contact form");
        contactPage.insertImage();

        Log.info("[STEP-7] - Click save and close button");
        contactPage.clickSaveAndCloseBtn();

        Log.info("[STEP-8] - Assert saved contact success");
        Assert.assertEquals(contactPage.getSavedMessageSuccess(),Constants.SAVE_CONTACT_SUCCESS);

        Log.info("[STEP-9] - Select to show all contact");
        contactPage.viewItemByQuantity(Constants.ALL_QUANTITY);

        Log.info("[STEP-10] - Assert the tile contact just saved");
        Assert.assertTrue(contactPage.doesShowTitle(titleRandom));

    }
}
