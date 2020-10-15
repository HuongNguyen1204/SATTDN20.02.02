package testcases;

import pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.ArticlePage;
import utilities.Constants;
import utilities.Log;

public class ArticleTest extends BaseTest {
    LoginPage loginPage;
    ArticlePage articlePage;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage();
        articlePage = new ArticlePage();
    }

    @Test(testName = "TC_JOOMLA_ARTICLE_006", description = "User can check in an article")
    public void TC_JOOMLA_ARTICLE_006() {
        Log.startTestCase("TC_JOOMLA_ARTICLE_006 : User can check in an articles");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        Log.info("[STEP-2] - Click content on menu nav bar)");
        articlePage.clickMenuItem(Constants.CONTENT_MENU);

        Log.info("[STEP-3] - Click Articles item of content menu");
        articlePage.clickMenuItem(Constants.ARTICLES_MENU);

        Log.info("[STEP-4] - Click new Article button");
        articlePage.clickNewBtn();

        Log.info("[STEP-5] - Fill data to article form");
        articlePage.fillDataArticleForm(Constants.TITLE_ARTICLE, Constants.STATUS_PUBLISHED, Constants.CATEGORY_ARTICLE, Constants.CONTENT_AREA);

        Log.info("[STEP-6] - Click save button");
        articlePage.clickSaveAndCloseBtn();

        Log.info("[STEP-7] - Assert saved article success");
        Assert.assertEquals(articlePage.getSavedMessageSuccess(), Constants.SAVED_SUCCESS_MESS);

        Log.info("[STEP-8] - Check the Articles just posted displays");
        Assert.assertEquals(articlePage.getFirstTitle(), Constants.TITLE_ARTICLE);
    }

    @Test(testName = "TC_JOOMLA_ARTICLE_013", description = "TC_JOOMLA_ARTICLE_013")
    public void TC_JOOMLA_ARTICLE_013() {
        Log.startTestCase("TC_JOOMLA_ARTICLE_006 : User can check in an articles");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        Log.info("[STEP-2] - Click content on menu nav bar)");
        articlePage.clickMenuItem(Constants.CONTENT_MENU);

        Log.info("[STEP-3] - Click Articles item of content menu");
        articlePage.clickMenuItem(Constants.ARTICLES_MENU);

        Log.info("[STEP-4] - Click new Article button");
        articlePage.clickNewBtn();

        Log.info("[STEP-5] - Fill data to article form");
        articlePage.fillDataArticleForm(Constants.TITLE_ARTICLE, Constants.STATUS_PUBLISHED, Constants.CATEGORY_ARTICLE, Constants.CONTENT_AREA);

        Log.info("[STEP-6] - Insert image");
        articlePage.insertImage();

        Log.info("[STEP-7] - Click save button");
        articlePage.clickSaveAndCloseBtn();

        Log.info("[STEP-8] - Assert saved article success");
        Assert.assertEquals(articlePage.getSavedMessageSuccess(), Constants.SAVED_SUCCESS_MESS);

        Log.info("[STEP-9] - Check the Articles just posted displays");
        Assert.assertEquals(articlePage.getFirstTitle(), Constants.TITLE_ARTICLE);
    }
}
