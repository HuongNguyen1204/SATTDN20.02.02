package testcases;

import helpers.DataHelper;
import page.objects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.ArticlePage;
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

        Log.info("[STEP-5] - Init data random for article form");
        String titleArticle = DataHelper.randomText();
        String titleContent = DataHelper.randomText();

        Log.info("[STEP-6] - Fill this data to article form");
        articlePage.enterArticleForm(titleArticle, Constants.STATUS_PUBLISHED, Constants.CATEGORY_ARTICLE, titleContent);

        Log.info("[STEP-7] - Click save button");
        articlePage.clickSaveAndCloseBtn();

        Log.info("[STEP-8] - Assert saved article success");
        Assert.assertEquals(articlePage.getSavedMessageSuccess(), Constants.SAVED_SUCCESS_MESS, "Save  sucess message does not matched");

        Log.info("[STEP-9] - Check the Articles just posted displays");
        Assert.assertEquals(articlePage.getFirstTitle(), titleArticle, "The client just posted not display");
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

        Log.info("[STEP-5] - Init data random for article form");
        String titleArticle = DataHelper.randomText();
        String titleContent = DataHelper.randomText();

        Log.info("[STEP-6] - Fill this data to article form");
        articlePage.enterArticleForm(titleArticle, Constants.STATUS_PUBLISHED, Constants.CATEGORY_ARTICLE, titleContent);

        Log.info("[STEP-7] - Click to image button ");
        articlePage.clickImageTab();

        Log.info("[STEP-8] - Insert image");
        articlePage.insertImage();

        Log.info("[STEP-9] - Click save button");
        articlePage.clickSaveAndCloseBtn();

        Log.info("[STEP-10] - Assert saved article success");
        Assert.assertEquals(articlePage.getSavedMessageSuccess(), Constants.SAVED_SUCCESS_MESS, "Save  sucess message does not matched");

        Log.info("[STEP-11] - Check the Articles just posted displays");
        Assert.assertEquals(articlePage.getFirstTitle(), titleArticle, "The article just posted is not display");
    }
}
