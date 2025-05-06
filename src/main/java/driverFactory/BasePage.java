package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;



public class BasePage {
    public WebDriver driver;
    public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();
    private static final Logger log = LogManager.getLogger(BasePage.class);
    ChromeOptions chromeOptions = new ChromeOptions();
    FirefoxProfile profile = new FirefoxProfile();

    public WebDriver init_driver(String browser, String headless, String fullScreenMode) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            chromeOptions.addArguments("--disable-extensions");
            chromeOptions.addArguments("use-fake-ui-for-media-stream");
            chromeOptions.addArguments("window-size=1280,1024");

            if (headless.equalsIgnoreCase("yes")) {
                chromeOptions.addArguments("--headless=new");
            }

            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("media.navigator.permission.disabled", true);
            profile.setPreference("media.navigator.streams.fake", true);

            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setProfile(profile);

            if (headless.equalsIgnoreCase("yes")) {
                firefoxOptions.addArguments("--headless");
            }

            driver = new FirefoxDriver(firefoxOptions);
        } else {
            log.info(browser + " browser is not configured/supported");
            return null;
        }

        if (fullScreenMode.equalsIgnoreCase("no")) {
            driver.manage().window().maximize();
        }
        // Deletes all cookies before starting any session
        driver.manage().deleteAllCookies();
        //Sets page load timeout
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        // Stores the driver in a thread-safe container
        threadDriver.set(driver);
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return threadDriver.get();
    }
    }
