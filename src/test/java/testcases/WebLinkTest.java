package testcases;

import helpers.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.BannerPage;
import pageobjects.LoginPage;
import pageobjects.WebLinkPage;
import utilities.Constants;
import utilities.Log;

public class WebLinkTest extends BaseTest {
    LoginPage loginPage;
    WebLinkPage webLinkPage;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage();
        webLinkPage = new WebLinkPage();
    }

    @Test(testName = "TO_JOOMLA_WEBLINKS_007", description = "User can move a web link to trash section")
    public void TO_JOOMLA_WEBLINKS_007() {
        Log.startTestCase("TO_JOOMLA_WEBLINKS_007 : User can move a web link to trash section");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        Log.info("[STEP-2] - Click content on menu nav bar)");
        webLinkPage.clickMenuItem(Constants.COMPONENTS_MENU);

        Log.info("[STEP-3] - Hover Banner item of Components menu");
        webLinkPage.clickMenuItem(Constants.WEBLINK_ITEM);

        Log.info("[STEP-4] - Click new button");
        webLinkPage.clickNewBtn();

        Log.info("[STEP-5] -Init new data for weblink form");
        String nameWebLinkRandom = DataHelper.randomText();
        String url = DataHelper.randomUrl();

        Log.info("[STEP-6] -Fill this data to weblink form");
        webLinkPage.fillDataToWebLinkForm(nameWebLinkRandom,url, Constants.STATUS_PUBLISHED);

        Log.info("[STEP-7] - Click save button");
        webLinkPage.clickSaveAndCloseBtn();

        Log.info("[STEP-8] - Assert weblink saved success");
        Assert.assertEquals(webLinkPage.getSavedMessageSuccess(), Constants.SAVE_WEBLINK_SUCCESS);

        Log.info("[STEP-9] - Click to show all weblink ");
        webLinkPage.viewItemByQuantity(Constants.ALL_QUANTITY);

        Log.info("[STEP-26] - Move the weblink just posted to trash");
        webLinkPage.deleteItem(nameWebLinkRandom);

        Log.info("[STEP-27] - Assert message trash weblink success");
        Assert.assertEquals(webLinkPage.getSavedMessageSuccess(), Constants.TRAHS_SUCCESS_WEBLINK);

        Log.info("[STEP-28] - View item just trashed");
        webLinkPage.viewItemByStatus(Constants.TRASHED_STATUS);

        Log.info("[STEP-29] - Check item just trashed is displays");
        Assert.assertTrue(webLinkPage.doesShowTitle(nameWebLinkRandom),"item just trashed is not displays");
    }

    @Test(testName = "TC_JOOMLA_WEBLINKS_014", description = "Verify user can change the order of weblinks using the Ordering column")
    public void TC_JOOMLA_WEBLINKS_014() {
        Log.startTestCase("TC_JOOMLA_WEBLINKS_014 : Verify user can change the order of weblinks using the Ordering column");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        Log.info("[STEP-2] - Click content on menu nav bar)");
        webLinkPage.clickMenuItem(Constants.COMPONENTS_MENU);

        Log.info("[STEP-3] - Hover Banner item of Components menu");
        webLinkPage.clickMenuItem(Constants.WEBLINK_ITEM);

        Log.info("[STEP-4] - Click new button");
        webLinkPage.clickNewBtn();

        Log.info("[STEP-5] -Init new data for weblink form");
        String nameWebLinkRandom1 = DataHelper.randomText();
        String url1 = DataHelper.randomUrl();

        Log.info("[STEP-6] -Fill this data to weblink form");
        webLinkPage.fillDataToWebLinkForm(nameWebLinkRandom1,url1, Constants.STATUS_PUBLISHED);

        Log.info("[STEP-7] - Click save button");
        webLinkPage.clickSaveAndCloseBtn();

        Log.info("[STEP-8] - Assert weblink saved success");
        Assert.assertEquals(webLinkPage.getSavedMessageSuccess(), Constants.SAVE_WEBLINK_SUCCESS);

        Log.info("[STEP-9] - Click content on menu nav bar)");
        webLinkPage.clickMenuItem(Constants.COMPONENTS_MENU);

        Log.info("[STEP-10] - Hover Banner item of Components menu");
        webLinkPage.clickMenuItem(Constants.WEBLINK_ITEM);

        Log.info("[STEP-11] - Click new button");
        webLinkPage.clickNewBtn();

        Log.info("[STEP-12] -Init the second new data for weblink form");
        String nameWebLinkRandom2 = DataHelper.randomText();
        String url2 = DataHelper.randomUrl();

        Log.info("[STEP-13] -Fill this data to weblink form");
        webLinkPage.fillDataToWebLinkForm(nameWebLinkRandom2,url2, Constants.STATUS_PUBLISHED);

        Log.info("[STEP-14] - Click save button");
        webLinkPage.clickSaveAndCloseBtn();

        Log.info("[STEP-15] - Assert weblink saved success");
        Assert.assertEquals(webLinkPage.getSavedMessageSuccess(), Constants.SAVE_WEBLINK_SUCCESS);

        webLinkPage.viewItemByQuantity(Constants.ALL_QUANTITY);
        Log.info("[STEP-16] - Get first title of categories");
        String firstTitle = webLinkPage.getFirstTitle();

        Log.info("[STEP-17] - Choose first weblink and click order button");
        webLinkPage.orderingWebLink();

        Log.info("[STEP-18] - Assert the sorted weblink ");
        Assert.assertFalse(webLinkPage.compareTitle(firstTitle),"The item is not ordering");
    }
}
