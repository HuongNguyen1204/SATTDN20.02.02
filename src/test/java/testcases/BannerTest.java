package testcases;

import helpers.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.BannerPage;
import pageobjects.LoginPage;
import utilities.Constants;
import utilities.Log;

public class BannerTest extends BaseTest {
    LoginPage loginPage;
    BannerPage bannerPage;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage();
        bannerPage = new BannerPage();
    }

//    @Test(testName = "TC_JOOMLA_BANNERS_BANNERS_006", description = "User can send a banner to trash")
    public void TC_JOOMLA_BANNERS_BANNERS_006() {
        Log.startTestCase("TC_JOOMLA_BANNERS_BANNERS_006 : User can send a banner to trash");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        Log.info("[STEP-2] - Click content on menu nav bar)");
        bannerPage.clickMenuItem(Constants.COMPONENTS_MENU);

        Log.info("[STEP-3] - Hover Banner item of Components menu");
        bannerPage.hoverMenuItemDrp(Constants.BANNER_MENU);

        Log.info("[STEP-4] - Click Clients item of Banner item");
        bannerPage.clickSubMenuItem(Constants.CLIENTS_ITEMS);

        Log.info("[STEP-5] - Click new button");
        bannerPage.clickNewBtn();

        Log.info("[STEP-6] - Init data for new clients");
        String nameClientRandom = DataHelper.randomText();
        String nameContactRandom = DataHelper.randomText();
        String emailRandom = DataHelper.randomEmail();

        Log.info("[STEP-7] - Fill this data to contact form");
        bannerPage.fillDataToClientForm(nameClientRandom, nameContactRandom, emailRandom);

        Log.info("[STEP-8] - Click save and close button");
        bannerPage.clickSaveAndCloseBtn();

        Log.info("[STEP-9] - Assert saved clients success");
        Assert.assertEquals(bannerPage.getSavedMessageSuccess(), Constants.SAVE_CLIENTS_SUCCESS);

        Log.info("[STEP-10] - Click components menu");
        bannerPage.clickMenuItem(Constants.COMPONENTS_MENU);

        Log.info("[STEP-11] - Hover Banner item of Components menu");
        bannerPage.hoverMenuItemDrp(Constants.BANNER_MENU);

        Log.info("[STEP-12] - Click Categories item of Banner item");
        bannerPage.clickSubMenuItem(Constants.CATEGORIES_ITEM);

        Log.info("[STEP-13] - Click new Categories button");
        bannerPage.clickNewBtn();

        Log.info("[STEP-14] - Init data new categories and fill this to categories form");
        String categoriesRandom = DataHelper.randomText();
        bannerPage.fillDataToCategoriesForm(categoriesRandom);

        Log.info("[STEP-15] - Click save and close button");
        bannerPage.clickSaveAndCloseBtn();

        Log.info("[STEP-16] - Assert saved Categories success");
        Assert.assertEquals(bannerPage.getSavedMessageSuccess(), Constants.SAVE_CATEGORIES_SUCCESS);

        Log.info("[STEP-17] - Click components menu");
        bannerPage.clickMenuItem(Constants.COMPONENTS_MENU);

        Log.info("[STEP-18] - Hover Banner item of Components menu");
        bannerPage.hoverMenuItemDrp(Constants.BANNER_MENU);

        Log.info("[STEP-19] - Click Banners item of Banner item");
        bannerPage.clickSubMenuItem(Constants.BANNER_MENU);

        Log.info("[STEP-20] - Click new Banner button");
        bannerPage.clickNewBtn();

        Log.info("[STEP-21] - Init data for new banner form");
        String nameBanner = DataHelper.randomText();

        Log.info("[STEP-22] - Fill data to banner form");
        bannerPage.fillDataToBannerForm(nameBanner, categoriesRandom, nameClientRandom);

        Log.info("[STEP-23] - Click save and close button");
        bannerPage.clickSaveAndCloseBtn();

        Log.info("[STEP-24] - Assert saved Banner success");
        Assert.assertEquals(bannerPage.getSavedMessageSuccess(), Constants.SAVE_BANNER_SUCCESS);

        Log.info("[STEP-25] - Click to show all banner ");
        bannerPage.showAllItem();

        Log.info("[STEP-26] - Move the banner just posted to trash");
        bannerPage.deleteItem(nameBanner);

        Log.info("[STEP-27] - Assert trash Banner success");
        Assert.assertEquals(bannerPage.getSavedMessageSuccess(), Constants.TRASH_SUCCESS);

        Log.info("[STEP-28] - View item just trashed");
        bannerPage.viewItemByStatus(Constants.TRASHED_STATUS);

        Log.info("[STEP-29] - Check item just trashed is displays");
        Assert.assertTrue(bannerPage.doesShowTitle(nameBanner));
    }

//    @Test(testName = "TC_JOOMLA_BANNERS_BANNERS_013", description = "User can create a new banner by using 'Save as Copy' button")
    public void TC_JOOMLA_BANNERS_BANNERS_013() {
        Log.startTestCase("TC_JOOMLA_BANNERS_BANNERS_013 : User can create a new banner by using 'Save as Copy' button");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        Log.info("[STEP-2] - Click content on menu nav bar)");
        bannerPage.clickMenuItem(Constants.COMPONENTS_MENU);

        Log.info("[STEP-3] - Hover Banner item of Components menu");
        bannerPage.hoverMenuItemDrp(Constants.BANNER_MENU);

        Log.info("[STEP-4] - Click Clients item of Banner item");
        bannerPage.clickSubMenuItem(Constants.CLIENTS_ITEMS);

        Log.info("[STEP-5] - Click new button");
        bannerPage.clickNewBtn();

        Log.info("[STEP-6] - Init data for new clients");
        String nameClientRandom = DataHelper.randomText();
        String nameContactRandom = DataHelper.randomText();
        String emailRandom = DataHelper.randomEmail();

        Log.info("[STEP-7] - Fill this data to contact form");
        bannerPage.fillDataToClientForm(nameClientRandom, nameContactRandom, emailRandom);

        Log.info("[STEP-8] - Click save and close button");
        bannerPage.clickSaveAndCloseBtn();

        Log.info("[STEP-9] - Assert saved clients success");
        Assert.assertEquals(bannerPage.getSavedMessageSuccess(), Constants.SAVE_CLIENTS_SUCCESS);

        Log.info("[STEP-10] - Click components menu");
        bannerPage.clickMenuItem(Constants.COMPONENTS_MENU);

        Log.info("[STEP-11] - Hover Banner item of Components menu");
        bannerPage.hoverMenuItemDrp(Constants.BANNER_MENU);

        Log.info("[STEP-12] - Click Categories item of Banner item");
        bannerPage.clickSubMenuItem(Constants.CATEGORIES_ITEM);

        Log.info("[STEP-13] - Click new Categories button");
        bannerPage.clickNewBtn();

        Log.info("[STEP-14] - Init data new categories and fill this to categories form");
        String categoriesRandom = DataHelper.randomText();
        bannerPage.fillDataToCategoriesForm(categoriesRandom);

        Log.info("[STEP-15] - Click save and close button");
        bannerPage.clickSaveAndCloseBtn();

        Log.info("[STEP-16] - Assert saved Categories success");
        Assert.assertEquals(bannerPage.getSavedMessageSuccess(), Constants.SAVE_CATEGORIES_SUCCESS);

        Log.info("[STEP-17] - Click components menu");
        bannerPage.clickMenuItem(Constants.COMPONENTS_MENU);

        Log.info("[STEP-18] - Hover Banner item of Components menu");
        bannerPage.hoverMenuItemDrp(Constants.BANNER_MENU);

        Log.info("[STEP-19] - Click sub Banners item of Banner item");
        bannerPage.clickSubMenuItem(Constants.BANNER_MENU);

        Log.info("[STEP-20] - Click new Banner button");
        bannerPage.clickNewBtn();

        Log.info("[STEP-21] - Init data for new banner form");
        String nameBanner = DataHelper.randomText();

        Log.info("[STEP-22] - Fill data to banner form");
        bannerPage.fillDataToBannerForm(nameBanner, categoriesRandom, nameClientRandom);

        Log.info("[STEP-23] - Click save and close button");
        bannerPage.clickSaveAndCloseBtn();

        Log.info("[STEP-24] - Assert saved Banner success");
        Assert.assertEquals(bannerPage.getSavedMessageSuccess(), Constants.SAVE_BANNER_SUCCESS);

        Log.info("[STEP-25] - Click to show all banner ");
        bannerPage.showAllItem();

        Log.info("[STEP-26] - Check item banner just posted is displays");
        Assert.assertTrue(bannerPage.doesShowTitle(nameBanner));
    }

    @Test(testName = "TC_JOOMLA_BANNERS_CLIENTS_002", description = "User can edit a client")
    public void TC_JOOMLA_BANNERS_CLIENTS_002() {
        Log.startTestCase("TC_JOOMLA_BANNERS_CLIENTS_002 : User can edit a client");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        Log.info("[STEP-2] - Click content on menu nav bar)");
        bannerPage.clickMenuItem(Constants.COMPONENTS_MENU);

        Log.info("[STEP-3] - Hover Banner item of Components menu");
        bannerPage.hoverMenuItemDrp(Constants.BANNER_MENU);

        Log.info("[STEP-4] - Click Clients item of Banner item");
        bannerPage.clickSubMenuItem(Constants.CLIENTS_ITEMS);

        Log.info("[STEP-5] - Click new button");
        bannerPage.clickNewBtn();

        Log.info("[STEP-6] - Init data for new clients");
        String nameClientRandom = DataHelper.randomText();
        String nameContactRandom = DataHelper.randomText();
        String emailRandom = DataHelper.randomEmail();

        Log.info("[STEP-7] - Fill this data to contact form");
        bannerPage.fillDataToClientForm(nameClientRandom, nameContactRandom, emailRandom);

        Log.info("[STEP-8] - Click save and close button");
        bannerPage.clickSaveAndCloseBtn();

        Log.info("[STEP-9] - Assert saved clients success");
        Assert.assertEquals(bannerPage.getSavedMessageSuccess(), Constants.SAVE_CLIENTS_SUCCESS);

        Log.info("[STEP-10] - Click edit the client item just posted");
        bannerPage.editItem(nameClientRandom);

        Log.info("[STEP-11] - Init new data for edit clients");
        String editNameClient = DataHelper.randomText();
        String editNameContact = DataHelper.randomText();
        String editEmail = DataHelper.randomEmail();

        Log.info("[STEP-12] - Fill this data to contact form");
        bannerPage.fillDataToClientForm(editNameClient, editNameContact, editEmail);

        Log.info("[STEP-13] - Click save and close button");
        bannerPage.clickSaveAndCloseBtn();

        Log.info("[STEP-14] - Assert saved clients success");
        Assert.assertEquals(bannerPage.getSavedMessageSuccess(), Constants.SAVE_CLIENTS_SUCCESS);

        Log.info("[STEP-26] - Check item banner just posted is displays");
        Assert.assertTrue(bannerPage.doesShowTitle(editNameClient));
    }
}
