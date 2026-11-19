package hooks;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

	@Before
	public void setup() throws IOException {
		
		System.out.println("=====Test Started====");
		loadConfig();
		launchBrowser();
	}
	
	@Before("@smoke")
	public void beforeSmoke() {
		
		System.out.println("Running Smoke Test");
	}
	
	@Before("@regression")
	public void beforeRegression() {
		
		System.out.println("Running Regression Test");	
	}
	
	@After
	public void tearDown(Scenario scenario) {
		
		if(scenario.isFailed()) {
			
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "scenario.getName()");
		}
		closeBrowser();
		System.out.println("=====Test Finished=====");
	}
}
