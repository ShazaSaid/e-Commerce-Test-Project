package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public  class WebUtilities {

    static WebDriverWait wait;
    static Duration duration = Duration.ofSeconds(30);

    public static void openURL(WebDriver driver, String URL) {
        driver.get(URL);
    }

    public static void clickElementWithWait(WebDriver driver, By elementLocator) {
        wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        driver.findElement(elementLocator).click();
    }

    public static String getElementTextWithWait(WebDriver driver, By elementLocator) {
        wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
        return driver.findElement(elementLocator).getText();
    }

    public static void enterTextWithWait(WebDriver driver, By elementLocator, String text) {
        wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
        driver.findElement(elementLocator).sendKeys(text);
    }

    public static boolean isPresent(WebDriver driver, By elementLocator) {
        try {
            WebElement element = driver.findElement(elementLocator);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean isDisplayed(WebDriver driver, By elementLocator) {
        try {
            WebElement element = driver.findElement(elementLocator);
            return element.isDisplayed();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void waitForElementToBePresent(WebDriver driver, By elementLocator) {
        wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
    }

    public static void selectFromDropDown(WebDriver driver, By dropdownElementLocator, String selection) {
        Select dropdown = new Select(driver.findElement(dropdownElementLocator));
        dropdown.selectByVisibleText(selection);

    }

    public static void hoverOverItemWithWait(WebDriver driver, By elementLocator) {
        waitForElementToBePresent(driver,elementLocator);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(elementLocator)).build().perform();
    }
}
