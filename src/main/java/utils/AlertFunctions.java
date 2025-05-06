package utils;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertFunctions {
    WebDriver driver;
    WebDriverWait wait;

    public AlertFunctions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
    }

    public void waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void validateAlertMessage(String expectedMsg) {
        wait.until(ExpectedConditions.alertIsPresent());
        String actualMsg=driver.switchTo().alert().getText();
        Assert.assertEquals(actualMsg,expectedMsg);
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

}
