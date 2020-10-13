package pageobjects;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    //Locator
    private String _menuItem = "//ul[@id='menu']//li//a[normalize-space(.)='%s']";

    //Element
    private WebElement menuItem(String nameMenuItem){ return BrowserHelper.getWebDriver().findElement(By.xpath(String.format(_menuItem,nameMenuItem)));}

    public void clickMenuItem(String menuItemName){
        menuItem(menuItemName).click();
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

}
