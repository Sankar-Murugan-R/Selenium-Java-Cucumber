package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features", glue = {"stepDefinitions"},
        tags = "@Child-Network or @Node-Onboard or @Login",

        plugin = {"pretty", "json:target/cucumber-reports/CucumberTestReport.json", "html:target/cucumber-html-report",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"},
        // display the console output in proper readable format
        monochrome = true,
        // to check whether the mapping is proper between the feature file and step
        dryRun = false
)

public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
