package Pages;

import Helpers.WebUtilities;
import Models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage {
    WebDriver driver;
    private static final By FIRST_NAME_LOCATOR = By.id("FirstName");
    private static final By LAST_NAME_LOCATOR = By.id("LastName");
    private static final By EMAIL_LOCATOR = By.id("Email");
    private static final By DAY_OF_BIRTH_LOCATOR = By.name("DateOfBirthDay");
    private static final By MONTH_OF_BIRTH_LOCATOR = By.name("DateOfBirthMonth");
    private static final By YEAR_OF_BIRTH_LOCATOR = By.name("DateOfBirthYear");
    private static final By PASSWORD_LOCATOR = By.id("Password");
    private static final By CONFIRM_PASSWORD_LOCATOR = By.id("ConfirmPassword");
    private static final By REGISTER_BUTTON_LOCATOR = By.id("register-button");
    private static final By REGISTRATION_SUCCESS_MESSAGE_LOCATOR = By.cssSelector(".result");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerNewUser(User user) {
        enterFirstName(user.getFirstName());
        enterLastName(user.getLastName());
        enterEmail(user.getEmail());
        enterDateOfBirth(user.getDayOfBirth(), user.getMonthOfBirth(), user.getYearOfBirth());
        enterPassword(user.getPassword());
    }

    public void enterFirstName(String firstName) {
        WebUtilities.enterTextWithWait(driver, FIRST_NAME_LOCATOR, firstName);
    }

    public void enterLastName(String lastName) {
        WebUtilities.enterTextWithWait(driver, LAST_NAME_LOCATOR, lastName);
    }

    public void enterEmail(String email) {
        WebUtilities.enterTextWithWait(driver, EMAIL_LOCATOR, email);
    }

    public void enterDateOfBirth(String day, String month, String year) {
        WebUtilities.selectFromDropDown(driver, DAY_OF_BIRTH_LOCATOR, day);
        WebUtilities.selectFromDropDown(driver, MONTH_OF_BIRTH_LOCATOR, month);
        WebUtilities.selectFromDropDown(driver, YEAR_OF_BIRTH_LOCATOR, year);
    }

    public void enterPassword(String password) {
        WebUtilities.enterTextWithWait(driver, PASSWORD_LOCATOR, password);
        WebUtilities.enterTextWithWait(driver, CONFIRM_PASSWORD_LOCATOR, password);
    }

    public void clickOnRegisterButton() {
        WebUtilities.clickElementWithWait(driver, REGISTER_BUTTON_LOCATOR);
    }

    public void checkRegistrationSucceeded() {
        Assert.assertEquals( WebUtilities.getElementTextWithWait(driver,REGISTRATION_SUCCESS_MESSAGE_LOCATOR),
                "Your registration completed");
    }
}
