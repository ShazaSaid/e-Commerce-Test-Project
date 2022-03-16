package Pages;

import Helpers.WebUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchResultsPage {
    WebDriver driver;
    private static By SEARCH_RESULTS_LIST_LOCATOR;
    private static final By SEARCH_PAGE_TITLE = By.xpath("//*[@class='page-title']//*[contains(text(),'Search')]");

    public SearchResultsPage(WebDriver driver){
        this.driver=driver;
    }
public void checkTheProductExistsInSearchResults(String productTitle){
    SEARCH_RESULTS_LIST_LOCATOR=By.xpath(String.format("//*[@class='product-title']//a[contains(text(),'%s')]",productTitle));
    WebUtilities.waitForElementToBePresent(driver,SEARCH_PAGE_TITLE);
    Assert.assertTrue(WebUtilities.isPresent(driver,SEARCH_RESULTS_LIST_LOCATOR));

}
}
