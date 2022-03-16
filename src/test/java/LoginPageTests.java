import Helpers.HelperFunctions;
import Models.User;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.Random;

public class LoginPageTests extends MainClass {
    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    @BeforeMethod
    public void initializePageObjects() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }
    @Test
    public void registerAnewUserTest() {
        registerAnewUser();
        registrationPage.checkRegistrationSucceeded();
        HelperFunctions.writeObjectToJsonFile(newUser);
    }
    @Test
    public void loginWithAValidUser() {
        registerAnewUser();
        homePage.logoutFromApplication();
        homePage.goToLoginPage();
        loginPage.checkLoginPageIsDisplayed();
        loginPage.enterEmail(newUser.getEmail());
        loginPage.enterPassword(newUser.getPassword());
        loginPage.clickLoginButton();
        homePage.checkTheUserWasLoggedToTheApp();
    }

    @Test
    public void loginWithInValidUser() {
        String invalidUserEmail="tests@testss.com";
        String invalidUserPassword="23232";
        homePage.goToLoginPage();
        loginPage.checkLoginPageIsDisplayed();
        loginPage.enterEmail(invalidUserEmail);
        loginPage.enterPassword(invalidUserPassword);
        loginPage.clickLoginButton();
        loginPage.checkLoginUnSuccessfullErrorMessage();
    }

    @Test
    public void resetPassword() {
        registerAnewUser();
        homePage.logoutFromApplication();
        homePage.goToLoginPage();
        loginPage.checkLoginPageIsDisplayed();
        loginPage.clickForgotPasswordLink();
        loginPage.enterEmail(newUser.getEmail());
        loginPage.clickOnRecoverPassword();
        loginPage.checkRecoveryConfirmationMessage();
    }
}
