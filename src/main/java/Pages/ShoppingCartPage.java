package Pages;

import Helpers.WebUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    WebDriver driver;
    private static final By AGREE_TO_TERMS_CHECKBOX_LOCATOR=By.id("termsofservice");
    private static final By CHECKOUT_BUTTON_LOCATOR=By.id("checkout");
    public ShoppingCartPage(WebDriver driver){
        this.driver=driver;
    }
    public void setAgreeToTermsCheckbox(){
        WebUtilities.clickElementWithWait(driver,AGREE_TO_TERMS_CHECKBOX_LOCATOR);
    }
    public void proceedToCheckout(){
        WebUtilities.clickElementWithWait(driver,CHECKOUT_BUTTON_LOCATOR);
    }

}
