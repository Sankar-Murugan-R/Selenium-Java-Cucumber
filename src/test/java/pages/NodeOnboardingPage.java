package pages;

import constants.AppConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ElementActions;

public class NodeOnboardingPage {
    private WebDriver driver;
    ElementActions elementAction;

    @FindBy(how= How.XPATH, using = "//*[text()='Onboard OCN Node']")
    private WebElement onBoardOCNNode;

    @FindBy(how= How.XPATH, using = "//span[text()='Node ID']/preceding::input[@type='text']")
    private WebElement nodeIDField;

    @FindBy(how= How.XPATH, using = "//span[text()='Node ID']/following::input[@type='text']")
    private WebElement publicIPField;

    @FindBy(how= How.XPATH, using = "//button[contains(text(),'Add Node')] ")
    private WebElement addNodeBtn;

    @FindBy(how= How.ID_OR_NAME, using = "outlined-basic")
    private WebElement walletAddressField;

    @FindBy(how= How.XPATH, using = "//button[contains(text(),'Add Wallet')] ")
    private WebElement addWalletBtn;

    @FindBy(how= How.XPATH, using = "//*[text()='Submit']")
    private WebElement submitBtn;

    @FindBy(how= How.ID, using = "node-type-select")
    private WebElement nodeTypeSelect;

    public WebElement getOnBoardOCNNode() {
        return onBoardOCNNode;
    }

    public WebElement getNodeIDField() {
        return nodeIDField;
    }

    public WebElement getPublicIPField() {
        return publicIPField;
    }

    public WebElement getAddNodeBtn() {
        return addNodeBtn;
    }

    public WebElement getWalletAddressField() {
        return walletAddressField;
    }

    public WebElement getAddWalletBtn() {
        return addWalletBtn;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public WebElement getNodeTypeSelect() {
        return nodeTypeSelect;
    }

    public NodeOnboardingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementAction = new ElementActions(driver);
    }

    public void clickOnBoardOCNBtn() {
        elementAction.doClickByWebElement(getOnBoardOCNNode());
    }

    public void verifyNodeIDFieldIsDisplayed() {
        Assert.assertTrue(elementAction.presenceOfElement(getNodeIDField()));
    }

    public void validateNodeOnboardPageUrl() {
        Assert.assertEquals(driver.getCurrentUrl(), AppConstants.NODE_ONBOARD_PAGE_URL);
    }

    public void enterNodeID(String nodeId) {
        elementAction.doSendKeysByWebElement(getNodeIDField(),nodeId);
    }

    public void enterPublicIP(String publicIP) {
        elementAction.doSendKeysByWebElement(getPublicIPField(),publicIP);
    }

    public void clickAddNodeBtn() {
        elementAction.doClickByWebElement(getAddNodeBtn());
    }

    public void addNodes(String nodeId,String publicIP) {
        enterNodeID(nodeId);
        enterPublicIP(publicIP);
        clickAddNodeBtn();
    }

    public void validateNodeId(String nodeId) {
        By nodeLocator = By.xpath("//*[@title='" + nodeId + "']");
        WebElement nodeElement = elementAction.getElements(nodeLocator);
        Assert.assertTrue(elementAction.presenceOfElement(nodeElement),
                "Node ID '" + nodeId + "' is not displayed in the summary section");
    }

    public void validateWalletAddress(String walletAddress) {
        By walletLocator = By.xpath("//*[@title='" + walletAddress + "']");
        WebElement walletElement = elementAction.getElements(walletLocator);
        Assert.assertTrue(elementAction.presenceOfElement(walletElement),
                "Wallet Address '" + walletAddress + "' is not displayed in the summary section");
    }

    public void addWallets(String walletAddress,String permission) {
        enterWalletAddress(walletAddress);
        selectWalletPermission(permission);
        clickAddWalletBtn();
    }

    public void clickAddWalletBtn() {
        elementAction.doClickByWebElement(getAddWalletBtn());
    }

    public void enterWalletAddress(String walletAddress) {
        elementAction.doSendKeysByWebElement(getWalletAddressField(),walletAddress);
    }

    public void selectWalletPermission(String nodeType) {
        elementAction.doClickByWebElement(getNodeTypeSelect());
        elementAction.doClick(By.xpath("//li[text()='"+nodeType+"']"));
    }
}
