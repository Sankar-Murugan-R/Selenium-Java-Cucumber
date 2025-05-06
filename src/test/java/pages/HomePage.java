package pages;

import constants.AppConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ElementActions;

public class HomePage {

    private WebDriver driver;
    ElementActions elementAction;

    @FindBy(how= How.XPATH, using = "//button[text()='Get Started']")
    private WebElement getStartedButton;

    @FindBy(how= How.XPATH, using = "//input[@aria-invalid='true' and @type='password']")
    private WebElement passwordField;

    @FindBy(how= How.XPATH, using = "//label[text()='Confirm Password']/following::input[@type='password']")
    private WebElement confirmPasswordField;

    @FindBy(how= How.XPATH, using = "//button[text()='Sign Up']")
    private WebElement signUpBtn;

    public WebElement getGetStartedButton() {
        return getStartedButton;
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementAction = new ElementActions(driver);
    }

    public void validateGetStartedBtn() {
        Assert.assertTrue(elementAction.presenceOfElement(getStartedButton), "Get Started Button is not displayed in Home page");
    }

    public void validateHomepageUrl() {
        Assert.assertEquals(driver.getCurrentUrl(),AppConstants.OCN_PORTAL_HOME_PAGE_URL);
    }

}
