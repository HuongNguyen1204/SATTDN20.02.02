package pageobjects;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Constants;
import utilities.Log;

public class ArticlePage extends BasePage {

    // Locator
    private By _newArticleBtn = By.cssSelector("#toolbar button.button-new");
    private By _titleInput = By.id("jform_title");
    private By _articleTextArea = By.id("jform_articletext_ifr");
    private By _saveAndCloseBtn = By.cssSelector("#toolbar button.button-save");
    private By _savedSuccessMessage = By.cssSelector("div.alert-success div.alert-message");
    private By _imageTab = By.xpath("//div [@class='js-editor-tinymce'] //button[.='Image']");
    private By _statusSelect = By.id("jform_state_chzn");
    private By _categorySelect = By.id("jform_catid_chzn");
    private By _firstTile = By.cssSelector("tbody tr:first-child a[data-original-title=Edit]");
    private By _imageItem = By.xpath("//div[normalize-space(.)='powered_by...']//preceding-sibling::div");
    private By _insertBtn = By.cssSelector("button.button-save-selected");
    private By _imageModal = By.cssSelector("div.mce-container.mce-panel.mce-floatpanel.mce-window.mce-in");
    private By _imageIframe = By.id("imageframe");
    private String _nameOption = "//div[@class='controls']//a[.='%s']";

    // Element
    private WebElement newArticleBtn() {
        return BrowserHelper.getWebDriver().findElement(_newArticleBtn);
    }

    private WebElement titleInput() {
        return BrowserHelper.getWebDriver().findElement(_titleInput);
    }

    private WebElement statusSelect() { return BrowserHelper.getWebDriver().findElement(_statusSelect); }

    private WebElement categorySelect() { return BrowserHelper.getWebDriver().findElement(_categorySelect); }

    private WebElement firstTile() { return BrowserHelper.getWebDriver().findElement(_firstTile); }

    private WebElement nameOption(String nameOption) {
        return BrowserHelper.getWebDriver().findElement(By.xpath(String.format(_nameOption,nameOption)));
    }

    private WebElement articleTextArea() {
        return BrowserHelper.getWebDriver().findElement(_articleTextArea);
    }

    private WebElement saveAndCloseBtn() {
        return BrowserHelper.getWebDriver().findElement(_saveAndCloseBtn);
    }

    private WebElement savedSuccessMessage() {
        return BrowserHelper.getWebDriver().findElement(_savedSuccessMessage);
    }

    private WebElement imageTab() {
        return BrowserHelper.getWebDriver().findElement(_imageTab);
    }

    private WebElement imageItem() { return BrowserHelper.getWebDriver().findElement(_imageItem); }

    private WebElement insertButton() { return BrowserHelper.getWebDriver().findElement(_insertBtn); }

    private WebElement imageModal() { return BrowserHelper.getWebDriver().findElement(_imageModal); }

    private WebElement imageIframe() { return BrowserHelper.getWebDriver().findElement(_imageIframe); }

    // Method
    public void clickNewArticleBtn() {
        newArticleBtn().click();
    }

    public void clickSaveAndCloseBtn() {
        saveAndCloseBtn().click();
    }

    public void clickImageTab(){
        imageTab().click();
    }

    public void clickInsertButton() { insertButton().click(); }
    /***
     * fill data to article form and click save
     * @param title
     * @param status
     * @param category
     * @param text
     */
    public void fillDataArticleForm(String title, String status, String category, String text) {
        titleInput().sendKeys(title);
        statusSelect().click();
        nameOption(status).click();
        categorySelect().click();
        nameOption(category).click();
        articleTextArea().sendKeys(text);
    }

    public void insertImage() {
        Log.info(" + Click image button");
        clickImageTab();
        BrowserHelper.waitForElement(Constants.TIMES_WAIT_ELEMENTS,imageIframe());
        BrowserHelper.getWebDriver().switchTo().frame(imageIframe());
        Log.info(" + Choose image");
        BrowserHelper.waitForElement(Constants.TIMES_WAIT_ELEMENTS,imageItem());
        imageItem().click();
        Log.info(" + Click Insert button");
        clickInsertButton();
    }

    /***
     * Get success message after post new article
     * @return
     */
    public String getSavedMessageSuccess() {
        return getText(savedSuccessMessage());
    }

    public String getFirstTitle() {
        return getText(firstTile());
    }
}
