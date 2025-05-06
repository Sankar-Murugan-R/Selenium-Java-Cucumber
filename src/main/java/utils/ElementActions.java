package utils;

import constants.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementActions {

    WebDriver driver;
    Select select;
    Actions action;
    WebDriverWait wait;
    private static final Logger log = LogManager.getLogger(ElementActions.class);

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
    }

    /**
     * This method will return the web element found using By locator.
     */
    public WebElement getElements(By locator) {
        elementWait(locator);
        return driver.findElement(locator);
    }

    /**
     * This method waits for the given WebElement to have the specified text.
     *
     * @param element WebElement to wait for the text to be present in.
     * @param text    Text to be present in the WebElement.
     */

    public void waitForElementToHaveText(WebElement element, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (Exception e) {
            log.error("Element " + element.toString() + "with " + text + " is not visible", e);
            throw e;
        }
    }

    /**
     * This method gives element wait using By Locator.
     *
     */
    public void elementWait(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * This method send values to the text field using By locator.
     *
     */
    public void doSendKeys(By locator, String value) {
        getElements(locator).sendKeys(value);
    }

    /**
     * This method clicks on the web element using By locator.
     *
     */
    public void doClick(By locator) {
        getElements(locator).click();
    }


    /**
     * This method hovers on the web element.
     *
     */
    public void moveToElement(WebElement element) {
        try {
            action = new Actions(driver);
            action.moveToElement(element).build().perform();
        } catch (Exception e) {
            log.error("Not able to hover the web element " + element.toString() + " passed", e);
            throw e;
        }
    }

    /**
     * This method performs click operation using web element.
     *
     */
    public void doClickByWebElement(WebElement element) {
        try {
            moveToElement(element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            TimeUtil.tooShortWait();
            element.click();
        } catch (Throwable e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * This method wait for the loading to complete.
     *
     */
    public void waitForLoaderToHide(WebElement loaderElement) {
        wait.until(ExpectedConditions.invisibilityOf(loaderElement));
    }

    /**
     * This method clears the text field.
     */
    public void clearField(WebElement element) {
        element.clear();
    }

    /**
     * This method sends value to the text field using web element.
     *
     */
    public void doSendKeysByWebElement(WebElement element, String value) {
        JavaScriptUtil.scrollIntoView(element, driver);
        clearField(element);
        element.sendKeys(value);
    }

    public void elementWaitByWebElement(WebElement element) {
            WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds((long)Constants.EXPLICIT_WAIT));
            wait.until(ExpectedConditions.visibilityOf(element));

    }
    public boolean presenceOfElement(WebElement element) {
        this.elementWaitByWebElement(element);
        JavaScriptUtil.scrollIntoView(element, this.driver);
        return element.isDisplayed();
    }

    /**
     * This method will return the web element.
     */
    public WebElement getElementsByWebelement(WebElement element) {
        elementWaitByWebElement(element);
        return driver.findElement((By) element);
    }

    /**
     * This method selects the value from dropdown using visible text.
     */
    public void doSelectFromDropDown(WebElement element, String value) {
        JavaScriptUtil.scrollIntoView(element, driver);
        getElementsByWebelement(element);
        select = new Select(element);
        select.selectByVisibleText(value);
    }
}
