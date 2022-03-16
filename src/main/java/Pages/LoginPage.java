package Pages;
import Helpers.WebUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;
    private static final By EMAIL_LOCATOR = By.cssSelector(".email");
    private static final By PASSWORD_LOCATOR = By.cssSelector(".password");
    private static final By LOGIN_BUTTON_LOCATOR = By.cssSelector(".button-1.login-button");
    private static final By FORGOT_PASSWORD_LOCATOR = By.cssSelector(".forgot-password>a");
    private static final By RECOVER_PASSWORD_LOCATOR = By.name("send-email");
    private static final By LOGIN_PAGE_TITLE = By.cssSelector(".page-title");
    private static final By FAILED_LOGIN_MESSAGE_LOCATOR = By.cssSelector(".message-error.validation-summary-errors");
    private static final By RECOVERY_SUCCESS_MESSAGE_LOCATOR = By.cssSelector("#bar-notification .content");

    public LoginPage(WebDriver _driver) {
        this.driver = _driver;
    }

    public void enterEmail(String email) {
        WebUtilities.enterTextWithWait(driver, EMAIL_LOCATOR, email);
    }

    public void enterPassword(String password) {
        WebUtilities.enterTextWithWait(driver, PASSWORD_LOCATOR, password);
    }

    public void clickLoginButton() {
        WebUtilities.clickElementWithWait(driver, LOGIN_BUTTON_LOCATOR);
    }

    public void clickForgotPasswordLink() {
        WebUtilities.clickElementWithWait(driver, FORGOT_PASSWORD_LOCATOR);
    }

    public void checkLoginPageIsDisplayed() {
        Assert.assertEquals(WebUtilities.getElementTextWithWait(driver, LOGIN_PAGE_TITLE), "Welcome, Please Sign In!");
    }

    public void checkLoginUnSuccessfullErrorMessage() {
        Assert.assertEquals(WebUtilities.getElementTextWithWait(driver, FAILED_LOGIN_MESSAGE_LOCATOR),
                "Login was unsuccessful. Please correct the errors and try again.\n" +
                        "The credentials provided are incorrect");
    }

    public void clickOnRecoverPassword() {
        WebUtilities.clickElementWithWait(driver, RECOVER_PASSWORD_LOCATOR);
    }

    public void checkRecoveryConfirmationMessage() {
        Assert.assertEquals(WebUtilities.getElementTextWithWait(driver, RECOVERY_SUCCESS_MESSAGE_LOCATOR),
                "Email with instructions has been sent to you.");
    }

}
