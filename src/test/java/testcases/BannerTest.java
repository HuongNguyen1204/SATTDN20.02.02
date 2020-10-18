package testcases;

import helpers.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.BannerCategoryPage;
import page.objects.BannerClientPage;
import page.objects.BannerPage;
import page.objects.LoginPage;
import utilities.Constants;
import utilities.Log;

public class BannerTest extends BaseTest {
    LoginPage loginPage;
    BannerPage bannerPage;
    BannerClientPage bannerClientPage;
    BannerCategoryPage bannerCategoryPage;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage();
        bannerPage = new BannerPage();
        bannerClientPage = new BannerClientPage();
        bannerCategoryPage = new BannerCategoryPage();
    }

    @Test(testName = "TC_JOOMLA_BANNERS_BANNERS_006", description = "User can send a banner to trash")
    public void TC_JOOMLA_BANNERS_BANNERS_006() {
        Log.startTestCase("TC_JOOMLA_BANNERS_BANNERS_006 : User can send a banner to trash");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        Log.info("[STEP-2] - Click content on menu nav bar)");
        bannerPage.clickMenuItem(Constants.COMPONENTS_MENU);

        Log.info("[STEP-3] - Click Banner item of Components menu");
        bannerPage.clickMenuItem(Constants.BANNER_MENU);

        Log.info("[STEP-4] - Click Clients item of Banner item");
        bannerClientPage.clickToSubMenu(Constants.CLIENTS_ITEMS);

        Log.info("[STEP-5] - Click new button");
        bannerPage.clickNewBtn();

        Log.info("[STEP-6] - Init data for new clients");
        String nameClientRandom = DataHelper.randomText();
        String nameContactRandom = DataHelper.randomText();
        String emailRandom = DataHelper.randomEmail();

        Log.info("[STEP-7] - Fill this data to contact form");
        bannerClientPage.enterClientForm(nameClientRandom, nameContactRandom, emailRandom);

        Log.info("[STEP-8] - Click save and close button");
        bannerPage.clickSaveAndCloseBtn();

        Log.info("[STEP-9] - Assert saved clients success");
        Assert.assertEquals(bannerPage.getSavedMessageSuccess(), Constants.SAVE_CLIENTS_SUCCESS);

        Log.info("[STEP-10] - Click components menu");
        bannerPage.clickMenuItem(Constants.COMPONENTS_MENU);

        Log.info("[STEP-11] - Click Banner item of Components menu");
        bannerPage.clickMenuItem(Constants.BANNER_MENU);

        Log.info("[STEP-12] - Click Categories item of Banner item");
        bannerPage.clickToSubMenu(Constants.CATEGORIES_ITEM);

        Log.info("[STEP-13] - Click new Categories button");
        bannerPage.clickNewBtn();

        Log.info("[STEP-14] - Init data new categories and fill this to categories form");
        String categoriesRandom = DataHelper.randomText();
        bannerCategoryPage.enterCategoriesForm(categoriesRandom);

        Log.info("[STEP-15] - Click save and close button");
        bannerPage.clickSaveAndCloseBtn();

        Log.info("[STEP-16] - Assert saved Categories success");
        Assert.assertEquals(bannerPage.getSavedMessageSuccess(), Constants.SAVE_CATEGORIES_SUCCESS, "Message saved categories does not match");

        Log.info("[STEP-17] - Click components menu");
        bannerPage.clickMenuItem(Constants.COMPONENTS_MENU);

        Log.info("[STEP-18] - Hover Banner item of Components menu");
        bannerPage.clickMenuItem(Constants.BANNER_MENU);

        Log.info("[STEP-19] - Click Banners item of Banner item");
        bannerPage.clickToSubMenu(Constants.BANNER_MENU);

        Log.info("[STEP-20] - Click new Banner button");
        bannerPage.clickNewBtn();

        Log.info("[STEP-21] - Init data for new banner form");
        String nameBanner = DataHelper.randomText();

        Log.info("[STEP-22] - Fill data to banner form");
        bannerPage.enterBannerForm(nameBanner, categoriesRandom);

        Log.info("[STEP-23] - Click to banner detail tabs");
        bannerPage.clickToBannerTab(Constants.BANNER_DETAIL_TABS);

        Log.info("[STEP-24] - Choose client for banner form");
        bannerPage.chooseClient(nameClientRandom);

        Log.info("[STEP-25] - Click save and close button");
        bannerPage.clickSaveAndCloseBtn();

        Log.info("[STEP-26] - Assert saved Banner success");
        Assert.assertEquals(bannerPage.getSavedMessageSuccess(), Constants.SAVE_BANNER_SUCCESS, "Message saved banner does not match");

        Log.info("[STEP-27] - Click to show all banner ");
        bannerPage.paging(Constants.ALL_QUANTITY);

        Log.info("[STEP-28] - Move the banner just posted to trash");
        bannerPage.deleteItem(nameBanner);

        Log.info("[STEP-29] - Assert message trash Banner success");
        Assert.assertEquals(bannerPage.getSavedMessageSuccess(), Constants.TRASH_SUCCESS);

        Log.info("[STEP-30] - View item just trashed");
        bannerPage.viewItemByStatus(Constants.TRASHED_STATUS);

        Log.info("[STEP-31] - Check item just trashed is displays");
        Assert.assertTrue(bannerPage.isDisplayTitle(nameBanner), "item just trashed is not displays");
    }

    @Test(testName = "TC_JOOMLA_BANNERS_BANNERS_013", description = "User can create a new banner by using 'Save as Copy' button")
    public void TC_JOOMLA_BANNERS_BANNERS_013() {
        Log.startTestCase("TC_JOOMLA_BANNERS_BANNERS_013 : User can create a new banner by using 'Save as Copy' button");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        Log.info("[STEP-2] - Click content on menu nav bar)");
        bannerPage.clickMenuItem(Constants.COMPONENTS_MENU);

        Log.info("[STEP-3] - Click Banner item of Components menu");
        bannerPage.clickMenuItem(Constants.BANNER_MENU);

        Log.info("[STEP-4] - Click Clients item of Banner item");
        bannerClientPage.clickToSubMenu(Constants.CLIENTS_ITEMS);

        Log.info("[STEP-5] - Click new button");
        bannerPage.clickNewBtn();

        Log.info("[STEP-6] - Init data for new clients");
        String nameClientRandom = DataHelper.randomText();
        String nameContactRandom = DataHelper.randomText();
        String emailRandom = DataHelper.randomEmail();

        Log.info("[STEP-7] - Fill this data to contact form");
        bannerClientPage.enterClientForm(nameClientRandom, nameContactRandom, emailRandom);

        Log.info("[STEP-8] - Click save and close button");
        bannerPage.clickSaveAndCloseBtn();

        Log.info("[STEP-9] - Assert saved clients success");
        Assert.assertEquals(bannerPage.getSavedMessageSuccess(), Constants.SAVE_CLIENTS_SUCCESS, "success message save client does not matched");

        Log.info("[STEP-10] - Click components menu");
        bannerPage.clickMenuItem(Constants.COMPONENTS_MENU);

        Log.info("[STEP-11] - Click Banner item of Components menu");
        bannerPage.clickMenuItem(Constants.BANNER_MENU);

        Log.info("[STEP-12] - Click Categories item of Banner item");
        bannerPage.clickToSubMenu(Constants.CATEGORIES_ITEM);

        Log.info("[STEP-13] - Click new Categories button");
        bannerPage.clickNewBtn();

        Log.info("[STEP-14] - Init data new categories and fill this to categories form");
        String categoriesRandom = DataHelper.randomText();
        bannerCategoryPage.enterCategoriesForm(categoriesRandom);

        Log.info("[STEP-15] - Click save and close button");
        bannerPage.clickSaveAndCloseBtn();

        Log.info("[STEP-16] - Assert saved Categories success");
        Assert.assertEquals(bannerPage.getSavedMessageSuccess(), Constants.SAVE_CATEGORIES_SUCCESS, "success message save categories does not matched");

        Log.info("[STEP-17] - Click components menu");
        bannerPage.clickMenuItem(Constants.COMPONENTS_MENU);

        Log.info("[STEP-18] - Hover Banner item of Components menu");
        bannerPage.clickMenuItem(Constants.BANNER_MENU);

        Log.info("[STEP-19] - Click sub Banners item of Banner item");
        bannerPage.clickToSubMenu(Constants.BANNER_MENU);

        Log.info("[STEP-20] - Click new Banner button");
        bannerPage.clickNewBtn();

        Log.info("[STEP-21] - Init data for new banner form");
        String nameBanner = DataHelper.randomText();

        Log.info("[STEP-22] - Fill data to banner form");
        bannerPage.enterBannerForm(nameBanner, categoriesRandom);

        Log.info("[STEP-23] - Click to banner detail tabs");
        bannerPage.clickToBannerTab(Constants.BANNER_DETAIL_TABS);

        Log.info("[STEP-24] - Choose client for banner form");
        bannerPage.chooseClient(nameClientRandom);

        Log.info("[STEP-24] - Click save button");
        bannerPage.clickToSaveBtn();

        Log.info("[STEP-25] - Assert the message after save");
        Assert.assertEquals(bannerPage.getSavedMessageSuccess(), Constants.SAVE_BANNER_SUCCESS, "success message save banner does not matched");

        Log.info("[STEP-26] - Click to detail tab");
        bannerPage.clickToBannerTab(Constants.DETAIL_TABS);

        Log.info("[STEP-27] - Init new data for banner form");
        String nameBannerEdit = DataHelper.randomText();

        Log.info("[STEP-28] - Fill this data to banner form");
        bannerPage.enterBannerForm(nameBannerEdit, categoriesRandom);

        Log.info("[STEP-29] - Click to save and close button");
        bannerPage.clickSaveAndCloseBtn();

        Log.info("[STEP-30] - Assert saved Banner success");
        Assert.assertEquals(bannerPage.getSavedMessageSuccess(), Constants.SAVE_BANNER_SUCCESS, "success message save banner does not matched");

        Log.info("[STEP-31] - Click to show all banner ");
        bannerPage.paging(Constants.ALL_QUANTITY);

        Log.info("[STEP-32] - Check item banner just posted without replace old banner");
        Assert.assertTrue(bannerPage.isDisplayTitle(nameBannerEdit), "The banner was edited is not displays");
        Assert.assertTrue(bannerPage.isDisplayTitle(nameBanner), "The old banner is replace by the new banner");
    }
}
