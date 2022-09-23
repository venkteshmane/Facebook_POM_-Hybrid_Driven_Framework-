package com.facebook.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - Object Repository:
	@FindBy(name = "email")
	@CacheLookup
	WebElement username;

	@FindBy(name = "pass")
	WebElement password;

	@FindBy(name="login")
	WebElement login;

	@FindBy(xpath = "//img[contains(@class, 'fb_logo _8ilh img')]")
	WebElement facebookLogo;

	//Initializing the page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateFaceBookImage() {
		return facebookLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		
		return new HomePage();
	}
	public HomePage loginMultipleAccounts(String un, String pass) {
		username.sendKeys(un);
        password.sendKeys(pass);
        login.submit();
        return new HomePage();
		
	}

}
