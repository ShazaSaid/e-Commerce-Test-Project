import Helpers.HelperFunctions;
import Models.User;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.Random;

public class MainClass {

   public  WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    User newUser;
    @BeforeMethod
    public void openApplication() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);

    }
    public void registerAnewUser() {
        Random R=new Random();
        newUser = new User();
        newUser.setFirstName("shaza");
        newUser.setLastName("saeed");
        newUser.setEmail("shazasaid"+R.nextInt(100)+"@gmail.com");
        newUser.setDayOfBirth("20");
        newUser.setMonthOfBirth("March");
        newUser.setYearOfBirth("1999");
        newUser.setPassword("123456789");
        homePage.goToRegistrationPage();
        registrationPage.registerNewUser(newUser);
        registrationPage.clickOnRegisterButton();
    }
    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}
