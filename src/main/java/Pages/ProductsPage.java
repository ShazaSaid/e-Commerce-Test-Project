package Pages;

import Helpers.WebUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage {
    WebDriver driver;
    private static final By SUCCESS_MESSAGE = By.cssSelector(".content");
    private static String PRODUCT_BUTTONS = "//*[text()='%s']/../..//*[@class='%s']";
    private static final By SHOPPING_CART_MENU_ITEM = By.className("ico-cart");
    private static final By GO_TO_CART_BUTTON = By.cssSelector(".button-1.cart-button");
private  static final By CLOSE_SUCCESS_MESSAGE_BUTTON=By.cssSelector(".close");
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void filterProductsUsingColor(String colorFilter) {
        By COLOR_FILTER_LOCATOR = By.xpath(String.format("//*[@class='item color-item']//*[text()=' %s ']", colorFilter));
        WebUtilities.clickElementWithWait(driver, COLOR_FILTER_LOCATOR);
    }

    public void selectProductsTag(String tag) {
        By PRODUCT_TAG_LOCATOR = By.xpath(String.format("//*[@class='tags']//*[text()='%s']", tag));
        WebUtilities.clickElementWithWait(driver, PRODUCT_TAG_LOCATOR);
    }

    public void addProductToShoppingCart(String productTitle) {
        By ADD_PRODUCT_TO_SHOPPING_CART_LOCATOR =
                By.xpath(String.format(PRODUCT_BUTTONS,
                        productTitle, "button-2 product-box-add-to-cart-button"));
        WebUtilities.clickElementWithWait(driver, ADD_PRODUCT_TO_SHOPPING_CART_LOCATOR);
    }

    public void checkSuccessMessage(String successMessage) {
        Assert.assertEquals(WebUtilities.getElementTextWithWait(driver, SUCCESS_MESSAGE),
                successMessage);
    }

    public void addProductToTheWishlist(String productTitle) {
        By ADD_PRODUCT_TO_WISH_LIST_LOCATOR =
                By.xpath(String.format(PRODUCT_BUTTONS,
                        productTitle, "button-2 add-to-wishlist-button"));
        WebUtilities.clickElementWithWait(driver, ADD_PRODUCT_TO_WISH_LIST_LOCATOR);

    }

    public void addProductToTheCompareList(String productTitle) {
        By ADD_PRODUCT_TO_COMPARE_LIST_LOCATOR =
                By.xpath(String.format(PRODUCT_BUTTONS,
                        productTitle, "button-2 add-to-compare-list-button"));
        WebUtilities.clickElementWithWait(driver, ADD_PRODUCT_TO_COMPARE_LIST_LOCATOR);
    }

    public void goToShoppingCart() {
        WebUtilities.hoverOverItemWithWait(driver, SHOPPING_CART_MENU_ITEM);
        WebUtilities.clickElementWithWait(driver, GO_TO_CART_BUTTON);
    }

    public void closeSuccessMessage(){
        WebUtilities.clickElementWithWait(driver,CLOSE_SUCCESS_MESSAGE_BUTTON);
    }
}
