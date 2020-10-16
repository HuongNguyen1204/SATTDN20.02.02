package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static helpers.BrowserHelper.getWebDriver;

public class CategoryPage extends BasePage {

    // Locator
    private By _orderBtn = By.cssSelector("thead tr th span[class='icon-menu-2']");
    private By _firstTitle = By.cssSelector("tbody tr:first-child a[data-original-title=Edit]");
    private By _lastTitle = By.cssSelector("tbody tr:last-child a[data-original-title=Edit]");

    // Element
    private WebElement orderBtn() {
        return getWebDriver().findElement(_orderBtn);
    }

    private WebElement firstTitle() {
        return getWebDriver().findElement(_firstTitle);
    }

    private WebElement lastTitle() {
        return getWebDriver().findElement(_lastTitle);
    }

    //Method

    /***
     * Click first categories article and click to order icon
     */
    public void orderingCategory() {
        clickCheckboxBtnByName(getFirstTitle());
        orderBtn().click();
    }

    public String getFirstTitle() {
        return getText(firstTitle());
    }

    public String getLastTitle() {
        return getText(lastTitle());
    }

    public boolean compareCategory(String beforeTitle){
        return beforeTitle.equalsIgnoreCase(getFirstTitle());
    }
}
