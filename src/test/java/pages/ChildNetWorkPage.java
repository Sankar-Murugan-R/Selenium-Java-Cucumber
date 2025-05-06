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

public class ChildNetWorkPage {
    private WebDriver driver;
    ElementActions elementAction;

    @FindBy(how= How.XPATH, using = "//*[text()='Launch OCN Child Network']")
    private WebElement launchOCNChileNet;

    @FindBy(how= How.XPATH, using = "//span[text()='Network Name']/preceding::input[@type='text']")
    private WebElement networkNameField;

    @FindBy(how= How.XPATH, using = "//span[text()='Network Name']/following::input[@type='text']")
    private WebElement walletAddressField;

    @FindBy(how= How.XPATH, using = "//button[contains(text(),'Add Node')] ")
    private WebElement addNodeBtn;

    @FindBy(how= How.XPATH, using = "//span[text()='Node ID']/preceding::input[@type='text']")
    private WebElement nodeIDField;

    @FindBy(how= How.XPATH, using = "//span[text()='Node ID']/following::input[@type='text']")
    private WebElement publicIPField;

    @FindBy(how= How.XPATH, using = "//*[text()='Submit']")
    private WebElement submitBtn;

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

    public WebElement getLaunchOCNChileNet() {
        return launchOCNChileNet;
    }

    public WebElement getNetworkNameField() {
        return networkNameField;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public ChildNetWorkPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementAction = new ElementActions(driver);
    }

    public void clickChildOCNNetworkBtn() {
        elementAction.doClickByWebElement(getLaunchOCNChileNet());
    }

    public void verifyNetworkNameFieldIsDisplayed() {
        Assert.assertTrue(elementAction.presenceOfElement(getNetworkNameField()));
    }

    public void validateChildNetworkLaunchPageUrl() {
        Assert.assertEquals(driver.getCurrentUrl(), AppConstants.CHILD_NETWORK_PAGE_URL);
    }

    public void enterNetworkName(String networkName) {
        elementAction.doSendKeysByWebElement(getNetworkNameField(),networkName);
    }

    public void enterWalletAddress(String walletAddress) {
        elementAction.doSendKeysByWebElement(getWalletAddressField(),walletAddress);
    }

    public void validateWalletAddress(String walletAddress) {
        By walletLocator = By.xpath("//*[text()='" + walletAddress + "']");
        WebElement walletElement = elementAction.getElements(walletLocator);
        Assert.assertTrue(elementAction.presenceOfElement(walletElement),
                "Wallet Address '" + walletAddress + "' is not displayed in the summary section");
    }

    public void validateNetworkName(String networkName) {
        By walletLocator = By.xpath("//*[text()='" + networkName + "']");
        WebElement walletElement = elementAction.getElements(walletLocator);
        Assert.assertTrue(elementAction.presenceOfElement(walletElement),
                "Network Name '" + networkName + "' is not displayed in the summary section");
    }


}
