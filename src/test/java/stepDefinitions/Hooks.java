package stepDefinitions;

import driverFactory.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.util.Properties;

public class Hooks {

    public static Properties prop;
    private WebDriver driver;
    private ConfigReader configReader = ConfigReader.getInstance();

    @Before(order = 0)
    public void getProperty() {
        configReader = ConfigReader.getInstance();
    }

    @Before(order = 1)
    public void launchBrowser() {
        String browserName = configReader.getProperty("browser");
        String headless = configReader.getProperty("headless");
        String fullScreenMode = configReader.getProperty("fullScreen");
        BasePage basepage = new BasePage();
        driver = basepage.init_driver(browserName, headless,fullScreenMode);
        driver.get(configReader.getProperty("qa_url"));
    }

    @After(order = 1)
    public void quitBrowser() {
        driver.quit();
    }

    @After(order = 0)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // take screenshot:
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }
}
