package stepDefinitions;

import Pages.HomePage;
import Pages.NodeOnboardingPage;
import driverFactory.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.Map;


public class NodeOnBoardSteps {
    static WebDriver driver;
    NodeOnboardingPage nodeOnBoardPage;


    @Given("the user is on the Node Onboarding page")
    public void the_user_is_on_the_node_onboarding_page() {
        driver = BasePage.getDriver();
        nodeOnBoardPage = new NodeOnboardingPage(driver);
        nodeOnBoardPage.clickOnBoardOCNBtn();
        nodeOnBoardPage.validateNodeOnboardPageUrl();
        nodeOnBoardPage.verifyNodeIDFieldIsDisplayed();
    }

    @When("the user adds the following nodes:")
    public void the_user_adds_the_following_nodes(DataTable dataTable) {
        driver = BasePage.getDriver();
        nodeOnBoardPage = new NodeOnboardingPage(driver);
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String nodeId = row.get("node_id");
            String publicIp = row.get("public_ip");
            nodeOnBoardPage.addNodes(nodeId, publicIp);
    }}

    @When("the user adds the following wallets:")
    public void the_user_adds_the_following_wallets(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String walletAddress = row.get("wallet_address");
            String permission = row.get("permission");
            nodeOnBoardPage.addWallets(walletAddress, permission);
        }
    }

    @Then("the user should see the following nodes in the summary:")
    public void the_user_should_see_the_following_nodes_in_the_summary(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String nodeId = row.get("node_id");
            nodeOnBoardPage.validateNodeId(nodeId);
        }
    }
    @Then("the user should see the following wallet addresses in the summary:")
    public void the_user_should_see_the_following_wallet_addresses_in_the_summary(DataTable dataTable) {
            List<Map<String, String>> WalletRows = dataTable.asMaps(String.class, String.class);
            for (Map<String, String> row : WalletRows) {
                String walletAddress = row.get("wallet_address");
                nodeOnBoardPage.validateWalletAddress(walletAddress);
            }}
}
