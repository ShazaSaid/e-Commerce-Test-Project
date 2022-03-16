package Pages;

import Helpers.WebUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage {
    WebDriver driver;

    private static final By USER_LOGIN_LOCATOR = By.cssSelector(".ico-login");
    private static final By USER_REGISTRATION_LOCATOR = By.cssSelector(".ico-register");
    private static final By SEARCH_FIELD_LOCATOR = By.cssSelector(".search-box-text.ui-autocomplete-input");
    private static final By SEARCH_BUTTON_LOCATOR = By.cssSelector(".button-1.search-box-button");
    private static final By CURRENCY_DROPDOWN_LOCATOR = By.cssSelector("#customerCurrency");
    private static final By FIRST_ACTUAL_PRICE_LOCATOR = By.xpath("(//*[@class='price actual-price'])[1]");
    private static final By LOGOUT_LOCATOR = By.cssSelector(".ico-logout");
    private static final By PAGE_TITLE_LOCATOR = By.cssSelector(".page-title");
    private static final By LOGOUT_BUTTON_LOCATOR = By.cssSelector(".ico-logout");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLoginPage() {
        WebUtilities.clickElementWithWait(driver, USER_LOGIN_LOCATOR);
    }

    public void goToRegistrationPage() {
        WebUtilities.clickElementWithWait(driver, USER_REGISTRATION_LOCATOR);
    }

    public void searchForProduct(String productTitle) {
        WebUtilities.enterTextWithWait(driver, SEARCH_FIELD_LOCATOR, productTitle);
        WebUtilities.clickElementWithWait(driver, SEARCH_BUTTON_LOCATOR);
    }

    public void selectFromDropdown(String currency) {
        Select currencyDropDown = new Select(driver.findElement(CURRENCY_DROPDOWN_LOCATOR));
        currencyDropDown.selectByVisibleText(currency);
    }

    public void checkThePricesCurrency(String expectedCurrency) {
        Assert.assertEquals(WebUtilities.getElementTextWithWait(driver, FIRST_ACTUAL_PRICE_LOCATOR).substring(0, 1), expectedCurrency);

    }

    public void checkTheUserWasLoggedToTheApp() {
        Assert.assertTrue(WebUtilities.isPresent(driver, LOGOUT_LOCATOR));
    }

    public void selectProductsCategory(String Category, String subCategory) {
        By TOP_NAVIGATION_ITEMS =
                By.xpath(String.format("//*[@class='top-menu notmobile']//*[contains(text(),'%s')]/..", Category));
        WebUtilities.hoverOverItemWithWait(driver, TOP_NAVIGATION_ITEMS);
        By SUB_CATEGORY_LOCATOR = By.xpath(String.format("//*[@class='sublist first-level']//*[contains(text(),'%s')]", subCategory));
        WebUtilities.clickElementWithWait(driver, SUB_CATEGORY_LOCATOR);
    }

    public void checkDisplayedPageTitle(String pageTitle) {
        Assert.assertEquals(WebUtilities.getElementTextWithWait(driver, PAGE_TITLE_LOCATOR), pageTitle);
    }

    public void logoutFromApplication() {
        WebUtilities.clickElementWithWait(driver, LOGOUT_BUTTON_LOCATOR);
    }
}
