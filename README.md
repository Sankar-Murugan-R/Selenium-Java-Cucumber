# Selenium-Java-Cucumber 

Introduction: 
------------- 

This Automation Framework is created using Java with BDD Cucumber approach. Which can be used across different web based applications.
The framework contains lot of reusable components, so that they can directly used for another web application without spending any extra effort.
With this framework in place, whenever we need to automate a web based application, we would not need to start from scratch, but create the applications specific test scenarios by inherit the existing framework reusable properties.

**Assignment **

## Application Workflow – What This Project Tests
--------------------------------------------------

### 1. **Create an Account and Explore the Application**

#### User Actions Covered:
-------------------------

####  Sign Up
- User enters email ID and password to create a new account-Successful Sign Up with valid credentials.
- Failed Sign Up with an already registered email.
- Sign Up with blank email and  password combinations.
- Failed Sign Up with invalid email and password combinations.
#### Sign In
- User logs in using existing credentials.
- Sign In with blank email and  password combinations.
- Failed Sign In with invalid email and password combinations.

- ####  Submit Request To Onboard Nodes to Existing Blockchain
- Enter Node ID and Public IP for each node.
- Click "ADD NODE" for each node.
- Enter Wallet Address and select permission type.
- Click "ADD WALLET" for each wallet.
- Review and click **"SUBMIT"** to complete onboarding.

####  Submit Request To Create New Private Blockchain
- Enter Network Name and Wallet Address.
- Click **"NEXT"**.
- Add multiple Nodes with Node ID and Public IP.
- Click **"NEXT"** and review details.
- Click **"SUBMIT"** to complete creation.

- #### Sign Out
- Successful Sign Out using existing creadentials

>  **Note:**
> - **Node ID Format:** `NodeID-{number}`
> - **Wallet Address Format:** `0x{checksum valid hexadecimal}`
> - **IP Address Format:** `X.X.X.X` where 0 ≤ X ≤ 255

## Prerequisites & Setup
-------------------------

### Required:
- Java 11+
- Maven
- Git
- IDE (Eclipse, IntelliJ, or VS Code)

Prerequisites & Execution:
-------------------------
*	Clone the repository.
*	cd your-repo
*	Open command prompt and go to framework root directory.
* Install maven
*	To run feature file ....\.\framework_directory> `mvn clean verify"` in  terminal

  Regular run and reporting:
  --------------------------
*	The framework produce CucumberTestReport.json and CucumberTestReport.html report by default. It resides in the same `/target/cucumber-reports/ ` folder.
  
## Framework Reusable components

Following reusable components are available as part of the framework bundle.
*	[src/main/java/driverFactory] **basePage.java** - driver initialization methis is there . (launch url based on the given browser).
*	[src/main/java/utils] ** *.java** - Written selenium based reusable methods in this folder like - Webdriver , Alert , Javascript related functions

## Application specific components

*	[src/resource/config] **config.ts** - Keep the configuration variables.
*   [src/resource/features] **<featureName>.feature** - Create test steps in 'Gherkin' language
*   [src/typescript/appConstants] **AppConstants.ts** - The constants that are used for framework and application level are stored in this file
*   [src/typescript/hooks] **hooks.ts** - Minimize the test steps with repeated steps with @before and @after annotations.
    - BeforeAll - To invoke the playwright browsers.
    - Before - Launch browser with various parameter like 'Headless, browser & fullscreen' and enabling trace viewer , screen capturing and launches the application.
    - AfterStep - Capturing the steps status to show it in console
    - After - Quit the driver after Execution and Take screenshot and attache with report, if the test script is failed.
*	[src/typescript/pages] **<test>page.ts** - Write the page wise actions and the keep the corresponding locators.
*	[src/typescript/steps] **<test>PageSteps.ts** - Write the steps corresponding to the feature file and page wise..





