package Pages;

import constants.AppConstants;
import io.cucumber.java.cs.Ale;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.AlertFunctions;
import utils.ConfigReader;
import utils.ElementActions;
import utils.RandomValueGenerator;


public class SignInPage {

    private WebDriver driver;
    ElementActions elementAction;
    AlertFunctions alert;
    ConfigReader prop = ConfigReader.getInstance();
    RandomValueGenerator randomValueGenerator = new RandomValueGenerator();

    @FindBy(how= How.XPATH, using = "//input[@type='text']")
    private WebElement emailAddressField;

    @FindBy(how= How.XPATH, using = "//label[text()='Password']/following-sibling::div//input")
    private WebElement passwordField;

    @FindBy(how= How.XPATH, using = "//label[text()='Confirm Password']/following::input[@type='password']")
    private WebElement confirmPasswordField;

    @FindBy(how= How.XPATH, using = "//label[text()='Password']/following-sibling::div/following-sibling::p")
    private WebElement passwordErrorMessage;

    @FindBy(how= How.XPATH, using = "//label[text()='Confirm Password']/following-sibling::div/following-sibling::p")
    private WebElement confirmPasswordErrorMessage;

    @FindBy(how= How.XPATH, using = "//button[text()='Sign Up']")
    private WebElement signUpBtn;

    @FindBy(how= How.XPATH, using = "//button[contains(text(), 'Click here to sign in')]")
    private WebElement clickHereToSignIn;

    @FindBy(how= How.XPATH, using = "//button[text()='Sign In']")
    private WebElement signInBtn;

    public WebElement getEmailAddressField() {
        return emailAddressField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public WebElement getSignUpBtn() {
        return signUpBtn;
    }

    public WebElement getPasswordErrorMessage() {
        return passwordErrorMessage;
    }

    public WebElement getConfirmPasswordErrorMessage() {
        return confirmPasswordErrorMessage;
    }

    public WebElement getClickHereToSignIn() {
        return clickHereToSignIn;
    }

    public WebElement getSignInBtn() {
        return signInBtn;
    }


    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementAction = new ElementActions(driver);
        alert = new AlertFunctions(driver);
    }

    public void enterEmailAddress(String userEmailAddress) {
      elementAction.doSendKeysByWebElement(getEmailAddressField(),userEmailAddress);
    }

    public void enterPassword(String userPassword) {
        elementAction.doSendKeysByWebElement(getPasswordField(),userPassword);
    }

    public void enterConfirmPassword(String userPassword) {
        elementAction.doSendKeysByWebElement(getConfirmPasswordField(),userPassword);
    }

    public void clickSignupBtn() {
        elementAction.doClickByWebElement(getSignUpBtn());
    }

    public void clickSignInBtn() {
        elementAction.doClickByWebElement(getSignInBtn());
    }

    public String generateUniqueEmail() {
        String emailUsername = prop.getProperty("Username");
        return emailUsername+randomValueGenerator.randomString(3)+randomValueGenerator.randomNumbers(2)+"@sample.com";
    }

    public void validateEmailExistAlert() {
        alert.waitForAlert();
        alert.validateAlertMessage(AppConstants.EMAIL_EXIST_ALERT_MESSAGE);
        alert.acceptAlert();
    }

    public void validateInvalidCredentialsAlert(String errorMessage) {
        alert.waitForAlert();
        alert.validateAlertMessage(errorMessage);
        alert.acceptAlert();
    }

    public void verifySignUpButtonIsDisabled() {
        Assert.assertFalse(getSignUpBtn().isEnabled());
    }

    public void verifySignInButtonIsDisabled() {
        Assert.assertFalse(getSignInBtn().isEnabled());
    }

    public void verifyErrorMessageByTestCase(String testCaseId, String expectedMessage) {
        String actualMessage = "";

        switch (testCaseId) {
            case "OCN_03":
            case "OCN_05":
            case "OCN_08":
                actualMessage = getPasswordErrorMessage().getText().trim();
                break;
            case "OCN_04":
            case "OCN_06":
                actualMessage = getConfirmPasswordErrorMessage().getText().trim();
                break;
            default:
                Assert.fail("Un Expected Testcase ID : " + testCaseId);
        }

        Assert.assertEquals(actualMessage, expectedMessage.trim(),
                "Error message does not match for test case: " + testCaseId);
    }

    public void clickHereToSignIn() {
        elementAction.doClickByWebElement(getClickHereToSignIn());
    }

    public void clickActionButton(String btnName) {
        elementAction.doClick(By.xpath("//button[text()='"+btnName+"']"));
    }

}
