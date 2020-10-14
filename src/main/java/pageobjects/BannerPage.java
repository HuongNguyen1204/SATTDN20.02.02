package pageobjects;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static helpers.BrowserHelper.getWebDriver;

public class BannerPage extends BasePage {

    // Locator
    private By _nameInput = By.id("jform_name");
    private By _contactName = By.id("jform_contact");
    private By _contactEmail = By.id("jform_email");
    private By _categoriesTitle = By.id("jform_title");
    private By _categoriesSelect = By.id("jform_catid_chzn");
    private By _clientSelect = By.id("jform_cid_chzn");
    private By _statusSelect = By.id("jform_state_chzn");
    private By _bannerDetail = By.xpath("//ul[@id='myTabTabs']//a[.='Banner Details']");
    private String _itemTypeCategories = "//div[@id='jform_catid_chzn']//ul//li[.='%s']";
    private String _itemClient = "//div[@id='jform_cid_chzn']//ul//li[.='%s']";
    private String _typeStatusSelect =  "//div[@id='jform_state_chzn']//ul//li[.='%s']";


    // Element
    private WebElement nameInput() {
        return getWebDriver().findElement(_nameInput);
    }

    private WebElement contactName() {
        return getWebDriver().findElement(_contactName);
    }

    private WebElement contactEmail() {
        return getWebDriver().findElement(_contactEmail);
    }

    private WebElement categoriesTile() {
        return getWebDriver().findElement(_categoriesTitle);
    }

    private WebElement categoriesSelect() {
        return getWebDriver().findElement(_categoriesSelect);
    }

    private WebElement bannerDetail() {
        return getWebDriver().findElement(_bannerDetail);
    }

    private WebElement clientSelect() {
        return getWebDriver().findElement(_clientSelect);
    }

    private WebElement itemTypeCategories(String name) {
        return getWebDriver().findElement(By.xpath(String.format(_itemTypeCategories, name)));
    }

    private WebElement itemClientsName(String name) {
        return getWebDriver().findElement(By.xpath(String.format(_itemClient, name)));
    }

    private WebElement statusSelect() {
        return getWebDriver().findElement(_statusSelect);
    }

    private WebElement typeStatusSelect(String name) { return getWebDriver().findElement(By.xpath(String.format(_typeStatusSelect,name))); }

    // Method

    /***
     * Fill data to clients form
     * @param textClientName
     * @param textContactName
     * @param textContactEmail
     */
    public void fillDataToClientForm(String textClientName, String textContactName, String textContactEmail) {
        nameInput().sendKeys(textClientName);
        contactName().sendKeys(textContactName);
        contactEmail().sendKeys(textContactEmail);
    }

    /***
     * Fill name categories
     * @param nameTitle
     */
    public void fillDataToCategoriesForm(String nameTitle) {
        categoriesTile().sendKeys(nameTitle);
    }

    public void clickBannerDetail() {
        bannerDetail().click();
    }

    /***
     * Choose type categories by name
     * @param name
     */
    public void chooseTypeCategories(String name) {
        categoriesSelect().click();
        scrollToClick(itemTypeCategories(name));
    }

    /***
     * Choose client by name
     * @param clientName
     */
    public void chooseClient(String clientName) {
        clientSelect().click();
        scrollToClick(itemClientsName(clientName));
    }

    /***
     * Fill name, type categories, clients to banner form
     * @param nameBanner
     * @param typeNameCategorie
     * @param nameClient
     */
    public void fillDataToBannerForm(String nameBanner, String typeNameCategorie, String nameClient) {
        nameInput().sendKeys(nameBanner);
        chooseTypeCategories(typeNameCategorie);
        clickBannerDetail();
        chooseClient(nameClient);
    }

    public void chooseStatus(String nameStatus){
        statusSelect().click();
        typeStatusSelect(nameStatus).click();
    }
}
