package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
		
		initPageFactory(this);
	}
	
	@FindBy(id = "user-name")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "login-button")
	WebElement loginbtn;
	
	@FindBy(xpath = "//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]")
	WebElement errorMessage;
	
	public void enterUsername(String user) {
		
		username.sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		
		password.sendKeys(pass);
	}
	
	public void clickOnLoginBtn() {
		
		loginbtn.click();
	}
	
	public Boolean isErrorMessageDisplayed() {
		
		return errorMessage.isDisplayed();	
	}
}
