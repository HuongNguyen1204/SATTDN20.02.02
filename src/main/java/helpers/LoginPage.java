package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.BasePage;

public class LoginPage extends BasePage {
    // Locator
    private By _inputUserName = By.id("mod-login-username");
    private By _inputPassword = By.id("mod-login-password");
    private By _loginBtn = By.cssSelector("button.login-button");

    // Element
    private WebElement inputUserName(){ return BrowserHelper.getWebDriver().findElement(_inputUserName); }

    private WebElement inputPassword(){ return BrowserHelper.getWebDriver().findElement(_inputPassword); }

    private WebElement loginBtn(){ return BrowserHelper.getWebDriver().findElement(_loginBtn); }

    public void clickLoginBtn(){ loginBtn().click(); }

    /***
     * Login with username and password
     * @param username
     * @param password
     */
    public void login(String username, String password){
        inputUserName().sendKeys(username);
        inputPassword().sendKeys(password);
        clickLoginBtn();
    }
}
