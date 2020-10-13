package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static helpers.BrowserHelper.getWebDriver;

public class ContactPage extends BasePage {

    //Locator
    private By _contactTile = By.id("jform_name");
    private By _statusSelect = By.id("jform_published_chzn");
    private By _categorySelect = By.id("jform_catid_chzn");

    //Element
    private WebElement contactTile() { return getWebDriver().findElement(_contactTile); }

    private WebElement statusSelect() { return getWebDriver().findElement(_statusSelect); }

    private WebElement categorySelect() { return getWebDriver().findElement(_categorySelect); }

    //Method 
    
    public void fillDataContactForm(String title,String status, String category){
        contactTile().sendKeys(title);
        statusSelect().click();
        clickOptionName(status);
        categorySelect().click();
        clickOptionName(category);
    }

}
