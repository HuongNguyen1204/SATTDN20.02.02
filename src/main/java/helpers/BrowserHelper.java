package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Constants;
import utilities.Log;
import java.util.concurrent.TimeUnit;

public class BrowserHelper {
    private static WebDriver driver;

    public enum DriverType {CHROME, FIREFOX, MICROSOFT_EDGE}

    public static void navigateToUrl(String url) {
        driver.get(url);
    }

    public static void startBrowser(DriverType type) {
        switch (type) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                Log.info("------------------------------- OPEN CHROME DRIVER -------------------------------");
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                Log.info("------------------------------- OPEN FIREFOX DRIVER -------------------------------");
                driver = new FirefoxDriver();
                break;
            case MICROSOFT_EDGE:
                WebDriverManager.edgedriver().setup();
                Log.info("------------------------------- OPEN EDGE DRIVER ----------------------------------");
                driver = new EdgeDriver();
                break;
            default:
                Log.error("[startBrowser] No browser passed throw exception");
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.TIME_WAITS_DRIVER, TimeUnit.SECONDS);
    }

    public static void quitBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void scrollToView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void waitForElement(int seconds, WebElement element) {
        WebDriverWait wait = new WebDriverWait(BrowserHelper.getWebDriver(), seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public static void switchToIframe(WebElement element) {
        driver.switchTo().frame(element);
    }

    public static void performToElemnt(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public static void clickByJs(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void switchToWindow(String handels) {
         driver.switchTo().window(handels);
    }

    public static boolean isShowHelpBrowser(String title){
        for(String windowHandle  : getWebDriver().getWindowHandles())
            switchToWindow(windowHandle);
        return getWebDriver().getTitle().equalsIgnoreCase(title);
    }
}