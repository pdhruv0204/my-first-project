package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

import org.openqa.selenium.By;
import org.testng.Assert;

import base.BaseClass;

public class LoginSteps extends BaseClass {
	
	LoginPage lp = new LoginPage();
	
	@Given("User is on Login Page")
	public void User_is_on_Login_Page() {
		
	}
	
	@When("User enters valid username and password")
	public void User_enters_valid_username_and_password() throws InterruptedException {
		
		lp.enterUsername(prop.getProperty("username"));
		lp.enterPassword(prop.getProperty("password"));
		Thread.sleep(2000);
		lp.clickOnLoginBtn();
		Thread.sleep(2000);
	}
	
	@Then("User should logged in successfully")
	public void User_should_logged_in_successfully() {
		
		Boolean isLogoVisible = driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
		Assert.assertTrue(isLogoVisible, "Login Failed - Logo not visible");
	}
	
	@When("User enters invalid username and password")
	public void User_enters_invalid_username_and_password() throws InterruptedException {
		
		lp.enterUsername("incorrect_username");
		lp.enterPassword("incorrect_password");
		Thread.sleep(2000);
		lp.clickOnLoginBtn();
		Thread.sleep(2000);
		System.out.println("Enter Valid Credentials");
	}
	
	@Then("Error message should be displayed")
	public void Error_message_should_be_displayed() {
		
		Boolean isErrorMessageVisible = lp.isErrorMessageDisplayed();
		Assert.assertTrue(isErrorMessageVisible, "Error Message is not displayed");
		System.out.println("Error Message displayed successfully");
	}
}