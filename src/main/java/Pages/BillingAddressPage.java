package Pages;

import Helpers.WebUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BillingAddressPage {
    WebDriver driver;
    private static final By BILLING_COUNTRY_DROPDOWN_LOCATOR = By.id("BillingNewAddress_CountryId");
    private static final By BILLING_CITY_LOCATOR = By.id("BillingNewAddress_City");
    private static final By BILLING_ADDRESS_LOCATOR = By.id("BillingNewAddress_Address1");
    private static final By BILLING_ZIP_CODE_LOCATOR = By.id("BillingNewAddress_ZipPostalCode");
    private static final By BILLING_PHONE_NUMBER_LOCATOR = By.id("BillingNewAddress_PhoneNumber");
    private static final By CONTINUE_BUTTON_LOCATOR = By.name("save");
    private static final By CONTINUE_SHIPPING_METHOD_BUTTON = By.cssSelector(".button-1.shipping-method-next-step-button");
    private static final By CONTINUE_PAYEMENT_INFORMATION_BUTTON = By.cssSelector(".button-1.shipping-method-next-step-button");
    private static final By CONFIRM_ORDER_BUTTON = By.cssSelector(".button-1.confirm-order-next-step-button");
    private static final By ORDER_SUCCESS_MESSAGE_LOCATOR = By.cssSelector(".section.order-completed .title");

    public BillingAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectBillingCountry(String country) {
        WebUtilities.selectFromDropDown(driver, BILLING_COUNTRY_DROPDOWN_LOCATOR, country);
    }

    public void enterBillingCity(String city) {
        WebUtilities.enterTextWithWait(driver, BILLING_CITY_LOCATOR, city);
    }

    public void enterBillingAddress(String address) {
        WebUtilities.enterTextWithWait(driver, BILLING_ADDRESS_LOCATOR, address);
    }

    public void enterBillingZipCode(String zipCode) {
        WebUtilities.enterTextWithWait(driver, BILLING_ZIP_CODE_LOCATOR, zipCode);
    }

    public void enterBillingPhoneNumber(String phoneNumber) {
        WebUtilities.enterTextWithWait(driver, BILLING_PHONE_NUMBER_LOCATOR, phoneNumber);
    }

    public void clickOnContinueOrder() {
        WebUtilities.clickElementWithWait(driver, CONTINUE_BUTTON_LOCATOR);
    }

    public void clickOnContinueShippingMethod() {
        WebUtilities.clickElementWithWait(driver, CONTINUE_SHIPPING_METHOD_BUTTON);
    }

    public void clickOnContinuePayementInformation() {
        WebUtilities.clickElementWithWait(driver, CONTINUE_PAYEMENT_INFORMATION_BUTTON);
    }

    public void clickOnConfirmOrder() {
        WebUtilities.clickElementWithWait(driver, CONFIRM_ORDER_BUTTON);
    }

    public void checkOrderSucceeded() {
        String successMessage = "Your order has been successfully processed!";
        Assert.assertEquals(WebUtilities.getElementTextWithWait(driver, ORDER_SUCCESS_MESSAGE_LOCATOR),
                successMessage);
    }
}
