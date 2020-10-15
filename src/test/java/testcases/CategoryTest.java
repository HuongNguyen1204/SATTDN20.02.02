package testcases;

import helpers.BrowserHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.CategoryPage;
import pageobjects.LoginPage;
import utilities.Constants;
import utilities.Log;

public class CategoryTest extends BaseTest {
    LoginPage loginPage;
    CategoryPage categoryPage;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage();
        categoryPage = new CategoryPage();
    }

    @Test(testName = "TO_JOOMLA_CATEGORY_MANAGER_007",description = "User can browse Category help page")
    public void TO_JOOMLA_CATEGORY_MANAGER_007(){
        Log.startTestCase("TO_JOOMLA_CATEGORY_MANAGER_007 : User can browse Category help page");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        Log.info("[STEP-2] - Click content on menu nav bar)");
        categoryPage.clickMenuItem(Constants.CONTENT_MENU);

        Log.info("[STEP-3] - Click Articles item of content menu");
        categoryPage.clickMenuItem(Constants.CATEGORIES_ITEM);

        Log.info("[STEP-4] - Click Help button");
        categoryPage.clickHelpBtn();

        Log.info("[STEP-5] - Assert the help page is displays");
        Assert.assertTrue(BrowserHelper.isShowHelpBrowser(Constants.TITLE_HELP_BROWSER));
    }

    @Test(testName = "TO_JOOMLA_CATEGORY_MANAGER_014",description = "User can move may articles to another category")
    public void TO_JOOMLA_CATEGORY_MANAGER_014(){
        Log.startTestCase("TO_JOOMLA_CATEGORY_MANAGER_014 : User can move may articles to another category");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        Log.info("[STEP-2] - Click content on menu nav bar)");
        categoryPage.clickMenuItem(Constants.CONTENT_MENU);

        Log.info("[STEP-3] - Click Articles item of content menu");
        categoryPage.clickMenuItem(Constants.CATEGORIES_ITEM);

        Log.info("[STEP-4] - Get first title of categories");
        String firstTitle = categoryPage.getFirstTitle();

        Log.info("[STEP-5] - Ordering categories article");
        categoryPage.orderingCategory();

        Log.info("[STEP-6] - Assert the sorted title and the final title");
        Assert.assertEquals(firstTitle,categoryPage.getLastTitle(),"The item is not ordering");
    }
}
