package stepDefinitions;

import Pages.HomePage;
import Pages.SignInPage;
import driverFactory.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import utils.ConfigReader;

public class SignInSteps {

    static WebDriver driver;
    SignInPage signInPage;
    HomePage homePage;
    ConfigReader prop = ConfigReader.getInstance();
    private static final Logger log = LogManager.getLogger(SignInSteps.class);

    @Given("the user is on the Sign Up page")
    public void the_user_is_on_the_sign_up_page() {
        driver = BasePage.getDriver();
        signInPage = new SignInPage(driver);
    }

    @When("the user enters a valid email address")
    public void the_user_enters_a_valid_email_address() {
        signInPage = new SignInPage(driver);
        signInPage.enterEmailAddress(signInPage.generateUniqueEmail());
    }

    @When("the user enters a valid password")
    public void the_user_enters_a_valid_password() {
        signInPage.enterPassword(prop.getProperty("Password"));
    }

    @When("the user enters a valid confirm password")
    public void the_user_enters_a_valid_confirm_password() {
        signInPage.enterConfirmPassword(prop.getProperty("Password"));
    }

    @When("the user submits the Sign Up form")
    public void the_user_submits_the_sign_up_form() {
        signInPage.clickSignupBtn();
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        homePage = new HomePage(driver);
        homePage.validateGetStartedBtn();
        homePage.validateHomepageUrl();
    }

    @When("the user enters an already registered email address")
    public void the_user_enters_an_already_registered_email_address() {
        signInPage = new SignInPage(driver);
        signInPage.enterEmailAddress(prop.getProperty("Existing_EmailAddress"));
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        signInPage.validateEmailExistAlert();
    }

    @When("the user enters email {string}")
    public void the_user_enters_email(String email) {
        signInPage.enterEmailAddress(email);
    }

    @When("the user enters password {string}")
    public void the_user_enters_password(String password) {
        signInPage.enterPassword(password);
    }

    @When("the user re-enters the password as {string} in the confirm password field")
    public void the_user_reenters_confirm_password(String confirmPassword) {
        signInPage.enterConfirmPassword(confirmPassword);
    }

    @Then("for {string}, {string} should be displayed")
    public void for_should_be_displayed(String testCaseId, String expectedMessage) {
        signInPage.verifyErrorMessageByTestCase(testCaseId,expectedMessage);
    }

    @Then("the Sign Up button should be disabled")
    public void the_Sign_Up_button_should_be_disabled() {
        signInPage.verifySignUpButtonIsDisabled();
    }

    @Given("the user is on the Sign In page")
    public void the_user_is_on_the_sign_in_page() {
        driver = BasePage.getDriver();
        signInPage = new SignInPage(driver);
        signInPage.clickHereToSignIn();
    }
    @When("the user submits the Sign In form")
    public void the_user_submits_the_sign_in_form() {
        signInPage.clickSignInBtn();
    }

    @Given("the user is signed in")
    public void the_user_is_signed_in() {
        driver = BasePage.getDriver();
        signInPage = new SignInPage(driver);
        signInPage.clickHereToSignIn();
        signInPage.enterEmailAddress(prop.getProperty("Existing_EmailAddress"));
        signInPage.enterPassword(prop.getProperty("Password"));
        signInPage.clickSignInBtn();
        homePage = new HomePage(driver);
        homePage.validateGetStartedBtn();
        homePage.validateHomepageUrl();
    }

    @When("the user clicks {string} button")
    public void the_user_clicks_button(String buttonName) {
        signInPage = new SignInPage(driver);
        signInPage.clickActionButton(buttonName);
    }

    @Then("the user should be redirected to the Sign In page")
    public void the_user_should_be_redirected_to_the_sign_in_page() {
        homePage.validateGetStartedBtn();
    }

    @Then("the Sign In button should be disabled")
    public void the_Sign_In_button_should_be_disabled() {
        signInPage.verifySignInButtonIsDisabled();
    }
    @Then("for {string}, {string} alert should be displayed")
    public void for_alert_should_be_displayed(String testCaseId, String expectedMessage) {
        signInPage.validateInvalidCredentialsAlert(expectedMessage);
    }
}
