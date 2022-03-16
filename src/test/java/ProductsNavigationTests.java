import Pages.HomePage;
import Pages.ProductsPage;
import Pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProductsNavigationTests extends MainClass {
    SearchResultsPage searchResultsPage;
    HomePage homePage;
    ProductsPage productsPage;
    String productTitle="Lenovo IdeaCentre 600 All-in-One PC";

    @BeforeMethod
    public void initializePageObjects() {
        homePage = new HomePage(driver);
        searchResultsPage=new SearchResultsPage(driver);
        productsPage=new ProductsPage(driver);
    }
    @Test
    public void switchUsedCurrency() {
        homePage.selectFromDropdown("Euro");
        homePage.checkThePricesCurrency("€");
    }
    @Test
    public void searchForAProduct() {
        homePage.searchForProduct(productTitle);
        searchResultsPage.checkTheProductExistsInSearchResults(productTitle);
    }
    @Test
    public void productsNavigation()  {
        String mainCategory="Computers";
        String subCategory="Desktops";
        homePage.selectProductsCategory(mainCategory,subCategory);
        homePage.checkDisplayedPageTitle(subCategory);
    }
    @Test
    public void filterProductsUsingColor()  {
        String mainCategory="Apparel";
        String subCategory="Shoes";
        String colorFilter="Grey";
        homePage.selectProductsCategory(mainCategory,subCategory);
        productsPage.filterProductsUsingColor(colorFilter);
    }
    @Test
    public void filterProductsUsingProductsTags()  {
        String tag="apparel";
        String mainCategory="Apparel";
        String subCategory="Shoes";
        String pageTitle=String.format("Products tagged with '%s'",tag);
        homePage.selectProductsCategory(mainCategory,subCategory);
        productsPage.selectProductsTag(tag);
        homePage.checkDisplayedPageTitle(pageTitle);
    }
    @Test
    public void addProductsToShoppingCart()  {
        String mainCategory="Computers";
        String subCategory="Desktops";
        String successMessage="The product has been added to your shopping cart";
        homePage.selectProductsCategory(mainCategory,subCategory);
        productsPage.addProductToShoppingCart(productTitle);
        productsPage.checkSuccessMessage(successMessage);
    }
    @Test
    public void addProductsToWishList()  {
        String mainCategory="Computers";
        String subCategory="Desktops";
        String successMessage="The product has been added to your wishlist";
        homePage.selectProductsCategory(mainCategory,subCategory);
        productsPage.addProductToTheWishlist(productTitle);
        productsPage.checkSuccessMessage(successMessage);
    }
    @Test
    public void addProductsToCompareList()  {
        String mainCategory="Computers";
        String subCategory="Desktops";
        String successMessage="The product has been added to your product comparison";
        homePage.selectProductsCategory(mainCategory,subCategory);
        productsPage.addProductToTheCompareList(productTitle);
        productsPage.checkSuccessMessage(successMessage);
    }
}
