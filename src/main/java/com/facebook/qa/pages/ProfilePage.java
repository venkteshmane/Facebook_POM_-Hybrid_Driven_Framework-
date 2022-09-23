package com.facebook.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.facebook.qa.base.TestBase;

public class ProfilePage extends TestBase{
	@FindBy(xpath = "//span[contains(text(),'Er Venktesh Mane')]")
	WebElement profilePage;

	@FindBy(xpath = "//div[@aria-label='Update profile picture']")
	WebElement profilePhoto;

	@FindBy(xpath = "//span[contains(text(),'Upload Photo')]")
	WebElement photoUpload;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveButton;
}
