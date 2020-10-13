package pageobjects;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static helpers.BrowserHelper.getWebDriver;

public class BasePage {

    //Locator
    private String _menuItem = "//ul[@id='menu']//li//a[normalize-space(.)='%s']";
    private By _newBtn = By.cssSelector("#toolbar button.button-new");
    private By _saveAndCloseBtn = By.cssSelector("#toolbar button.button-save");
    private String _nameOption = "//div[@class='controls']//a[.='%s']";
    private By _savedSuccessMessage = By.cssSelector("div.alert-success div.alert-message");

    //Element
    private WebElement menuItem(String nameMenuItem){ return getWebDriver().findElement(By.xpath(String.format(_menuItem,nameMenuItem)));}

    private WebElement newBtn() {
        return getWebDriver().findElement(_newBtn);
    }

    private WebElement saveAndCloseBtn() {
        return getWebDriver().findElement(_saveAndCloseBtn);
    }

    private WebElement nameOption(String nameOption) {
        return getWebDriver().findElement(By.xpath(String.format(_nameOption,nameOption)));
    }

    private WebElement savedSuccessMessage() {
        return getWebDriver().findElement(_savedSuccessMessage);
    }

    //Method
    public void clickMenuItem(String menuItemName){
        menuItem(menuItemName).click();
    }

    public void clickNewBtn() {
        newBtn().click();
    }

    public void clickOptionName(String name){
        nameOption(name).click();
    }

    public void clickSaveAndCloseBtn() {
        saveAndCloseBtn().click();
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

    public String getSavedMessageSuccess() {
        return getText(savedSuccessMessage());
    }
}
