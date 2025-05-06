package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class JavaScriptUtil {

    public static void clickElementByJS(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();", element);

    }

    /**
     * This method will return the title using JavaScript.
     */
    public static String getTitleByJS(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String title = js.executeScript("return document.title;").toString();
        return title;
    }

    /**
     * This method will return the page innerText using JavaScript.
     */
    public static String getPageInnerText(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        return js.executeScript("return document.documentElement.innerText;").toString();
    }

    /**
     * This method will scroll the page until the expected element is visible using
     * JavaScript.
     */
    public static void scrollIntoView(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * This method will scroll the page up using JavaScript.
     */
    public static void scrollUp(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("scroll(0,-400)");
    }

    /**
     * This method will scroll the page right using JavaScript.
     */
    public static void scrollRight(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("scroll(400,0)");
    }

    /**
     * This method will scroll the page down to specific range using JavaScript.
     */
    public static void scrollDown(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("scroll(0,400)");
    }

    /**
     * This method will pass the value to the element using id using JavaScript.
     */
    public static void sendKeysUsingJSWithId(WebDriver driver, String id, String value) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
    }

    /**
     * This method will pass the value to the element using name using JavaScript.
     */
    public static void sendKeysUsingJSWithName(WebDriver driver, String name, String value) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("document.getElementById('" + name + "').value='" + value + "'");
    }

    /**
     * This method will select the date using JavaScript.
     *
     */
    public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].setAttribute('value','" + dateVal + "');", element);
    }

    /**
     * This method will return the value data using JavaScript.
     */
    public static String getDataByJS(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String text = (String) js.executeScript("return arguments[0].value", element);
        return text;
    }

    /**
     * This method will open a new tab using JavaScript.
     */
    public static void openNewTab(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('');");
        Thread.sleep(100);
    }

}
