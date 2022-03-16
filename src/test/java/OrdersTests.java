import Pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrdersTests extends MainClass{
    HomePage homePage;
    LoginPage loginPage;
    ProductsPage productsPage;
    ShoppingCartPage shoppingCartPage;
    BillingAddressPage billingAddressPage;
    String productTitle="Lenovo IdeaCentre 600 All-in-One PC";
    @BeforeMethod
    public void initializePageObjects() {
        homePage = new HomePage(driver);
        loginPage=new LoginPage(driver);
        productsPage=new ProductsPage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        shoppingCartPage=new ShoppingCartPage(driver);
        billingAddressPage=new BillingAddressPage(driver);
    }
    @Test
    public void orderAproduct() {
        registerAnewUser();
        homePage.logoutFromApplication();
        homePage.goToLoginPage();
        loginPage.checkLoginPageIsDisplayed();
        loginPage.enterEmail(newUser.getEmail());
        loginPage.enterPassword(newUser.getPassword());
        loginPage.clickLoginButton();
        String mainCategory = "Computers";
        String subCategory = "Desktops";
        homePage.selectProductsCategory(mainCategory, subCategory);
        productsPage.addProductToShoppingCart(productTitle);
        productsPage.closeSuccessMessage();
        productsPage.goToShoppingCart();
        shoppingCartPage.setAgreeToTermsCheckbox();
        shoppingCartPage.proceedToCheckout();
        billingAddressPage.selectBillingCountry("Egypt");
        billingAddressPage.enterBillingCity("cairo");
        billingAddressPage.enterBillingAddress("123 street at address");
        billingAddressPage.enterBillingZipCode("12345");
        billingAddressPage.enterBillingPhoneNumber("0123456844");
        billingAddressPage.clickOnContinueOrder();
        billingAddressPage.clickOnContinueShippingMethod();
        billingAddressPage.clickOnContinueOrder();
        billingAddressPage.clickOnContinuePayementInformation();
        billingAddressPage.clickOnConfirmOrder();
        billingAddressPage.checkOrderSucceeded();
    }

}
