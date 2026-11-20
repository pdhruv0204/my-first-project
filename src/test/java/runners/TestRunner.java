package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
			features = "src/test/resources/features",
			glue = {"stepdefinitions", "hooks"},
			plugin = {
					"pretty",
					"html:target/cucumber-report.html",
			        "json:target/cucumber-report.json", // Jenkins Cucumber plugin reads this
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
			},
			monochrome = true,
			tags = "@regression or @smoke"
			
		)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	
}
