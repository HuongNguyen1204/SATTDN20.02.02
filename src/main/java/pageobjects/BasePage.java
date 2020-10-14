package pageobjects;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Constants;

import static helpers.BrowserHelper.getWebDriver;
import static helpers.BrowserHelper.waitForElement;

public class BasePage {

    //Locator
    private By _newBtn = By.cssSelector("#toolbar button.button-new");
    private By _saveAndCloseBtn = By.cssSelector("#toolbar button.button-save");
    private By _savedSuccessMessage = By.cssSelector("div.alert-success div.alert-message");
    private By _searchToolBtn = By.xpath("//button[normalize-space()='Search Tools']");
    private By _statusSelect = By.id("filter_published_chzn");
    private By _trashBtn = By.cssSelector("#toolbar-trash button");
    private By _listLimit = By.id("list_limit_chzn");
    private By _allItem = By.cssSelector("#list_limit_chzn ul li:last-child");
    private By _editBtn = By.cssSelector("#toolbar-edit button");
    private String _menuItem = "//ul[@id='menu']//li//a[normalize-space(.)='%s']";
    private String _nameOption = "//div[@class='controls']//a[.='%s']";
    private String _subMenuItem = "//ul[@id='nav-empty']//a[normalize-space(.)='%s']";
    private String _typeStatus = "//div[@id='filter_published_chzn']//ul/li[.='%s']";
    private String _checkboxBtn = "//table//tbody//a[normalize-space()='%s']/../.. //preceding-sibling::td//input[@type='checkbox']";
    private String _titlePosted = "//tbody//td[@class='has-context']//a[normalize-space()='%s']";

    //Element
    private WebElement menuItem(String nameMenuItem) {
        return getWebDriver().findElement(By.xpath(String.format(_menuItem, nameMenuItem)));
    }

    private WebElement newBtn() {
        return getWebDriver().findElement(_newBtn);
    }

    private WebElement saveAndCloseBtn() {
        return getWebDriver().findElement(_saveAndCloseBtn);
    }

    private WebElement nameOption(String nameOption) {
        return getWebDriver().findElement(By.xpath(String.format(_nameOption, nameOption)));
    }

    private WebElement savedSuccessMessage() {
        return getWebDriver().findElement(_savedSuccessMessage);
    }

    private WebElement subMenuItem(String nameSubItem) {
        return getWebDriver().findElement(By.xpath(String.format(_subMenuItem, nameSubItem)));
    }

    private WebElement trashBtn() {
        return getWebDriver().findElement(_trashBtn);
    }

    private WebElement searchToolBtn() {
        return getWebDriver().findElement(_searchToolBtn);
    }

    private WebElement checkboxBtn(String nameTitle) {
        return getWebDriver().findElement(By.xpath(String.format(_checkboxBtn, nameTitle)));
    }

    private WebElement statusSelect() {
        return getWebDriver().findElement(_statusSelect);
    }

    private WebElement typeStatus(String nameType) {
        return getWebDriver().findElement(By.xpath(String.format(_typeStatus, nameType)));
    }

    private WebElement titlePosted(String name) {
        return getWebDriver().findElement(By.xpath(String.format(_titlePosted, name)));
    }

    private WebElement listLimitItem() {
        return getWebDriver().findElement(_listLimit);
    }

    private WebElement allItem() {
        return getWebDriver().findElement(_allItem);
    }

    private WebElement editBtn() { return getWebDriver().findElement(_editBtn); }

    //Method
    public void clickMenuItem(String menuItemName) {
        waitForElement(Constants.TIMES_WAIT_ELEMENTS, menuItem(menuItemName));
        menuItem(menuItemName).click();
    }

    public void clickNewBtn() {
        newBtn().click();
    }

    public void clickOptionName(String name) {
        nameOption(name).click();
    }

    public void clickSaveAndCloseBtn() {
        saveAndCloseBtn().click();
    }

    public void clickTrashBtn() {
        trashBtn().click();
    }

    public void clickEditBtn() { editBtn().click(); }

    public void clickCheckboxBtnByName(String name) {
        waitForElement(Constants.TIMES_WAIT_ELEMENTS, checkboxBtn(name));
        checkboxBtn(name).click();
    }

    public void clickSearchToolBtn() {
        searchToolBtn().click();
    }

    public void clickStatusSelect() {
        statusSelect().click();
    }

    /***
     * Get text of elements
     * @param element
     * @return
     */
    public String getText(WebElement element) {
        return element.getText().trim();
    }

    /***
     * Scroll to view an element and click
     * @param element
     */
    public void scrollToClick(WebElement element) {
        BrowserHelper.scrollToView(element);
        element.click();
    }

    /***
     * Get success message after saved success
     * @return
     */
    public String getSavedMessageSuccess() {
        return getText(savedSuccessMessage());
    }

    /***
     * Hover to menu dropdown
     * @param nameMenuItem
     */
    public void hoverMenuItemDrp(String nameMenuItem) {
        BrowserHelper.performToElemnt(menuItem(nameMenuItem));
    }

    /***
     * Click to sub menu of menu dropdown
     * @param name
     */
    public void clickSubMenuItem(String name) {
        subMenuItem(name).click();
    }

    /***
     * Deletem item by name title
     * @param nameItem
     */
    public void deleteItem(String nameItem) {
        clickCheckboxBtnByName(nameItem);
        clickTrashBtn();
    }

    /***
     * View item by status
     * @param nameStatus
     */
    public void viewItemByStatus(String nameStatus) {
        clickSearchToolBtn();
        clickStatusSelect();
        typeStatus(nameStatus).click();
    }

    /***
     * Check the title is displays
     * @param titlePosted
     * @return
     */
    public boolean doesShowTitle(String titlePosted) {
        return titlePosted(titlePosted).isDisplayed();
    }

    /***
     * View all item of table
     */
    public void showAllItem() {
        listLimitItem().click();
        allItem().click();
    }

    /***
     * Deletem item by name title
     * @param nameItem
     */
    public void editItem(String nameItem) {
        clickCheckboxBtnByName(nameItem);
        clickEditBtn();
    }
}
