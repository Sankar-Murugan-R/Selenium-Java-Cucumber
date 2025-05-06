package stepDefinitions;

import Pages.ChildNetWorkPage;
import Pages.NodeOnboardingPage;
import constants.AppConstants;
import driverFactory.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ChildNetworkSteps {
    WebDriver driver;
    ChildNetWorkPage childNetworkPage;
    @Given("the user is on the Child Launch Network page")
    public void the_user_is_on_the_child_launch_network_page() {
        driver = BasePage.getDriver();
        childNetworkPage = new ChildNetWorkPage(driver);
        childNetworkPage.clickChildOCNNetworkBtn();
        childNetworkPage.validateChildNetworkLaunchPageUrl();
        childNetworkPage.verifyNetworkNameFieldIsDisplayed();
    }

    @When("the user enters network name {string}")
    public void the_user_enters_network_name(String network) {
     childNetworkPage.enterNetworkName(network);
    }

    @When("the user enters wallet address {string}")
    public void the_user_enters_wallet_address(String wallet) {
        childNetworkPage.enterWalletAddress(wallet);
    }

    @Then("the user should see the summary of entered network, wallet")
    public void the_user_should_see_the_summary_of_entered_network_wallet() {
        childNetworkPage.validateNetworkName(AppConstants.NETWORK_NAME);
        childNetworkPage.validateWalletAddress(AppConstants.WALLET_ADDRESS);
    }

   }
