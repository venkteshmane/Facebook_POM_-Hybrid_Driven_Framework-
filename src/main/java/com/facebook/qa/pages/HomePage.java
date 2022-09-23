package com.facebook.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Er Venktesh Mane')]")
	WebElement userNameLable;

	@FindBy(xpath = "//span[contains(text(), 'Groups')]")
	WebElement groupsLink;

	@FindBy(xpath = "//span[contains(text(),'Marketplace')]")
	WebElement marketplace;

	@FindBy(xpath = "//div[contains(@aria-label,'Menu')]")
	WebElement Link;

	@FindBy(xpath = "//div[contains(@aria-label,'Messenger')]")
	WebElement messengerLink;

	@FindBy(xpath = "//a[contains(@aria-label,'Notifications')]")
	WebElement notificationsLink;

	@FindBy(xpath = "//span[contains(text(),'Friends')]")
	WebElement friends;

	@FindBy(xpath = "//a[@aria-label='Home']")
	WebElement home;

	// Initializing the page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyCorrectUserName() {
		return userNameLable.isDisplayed();
	}

	public HomePage click_home() {
		home.click();
		return new HomePage();
	}

	public GroupsPage clickOnGroupsLink() {
		groupsLink.click();
		return new GroupsPage();
	}

	public MessengerPage clickOnMessengerLink() {
		messengerLink.click();
		return new MessengerPage();
	}

	public NotificationsPage clickOnNotificationsLink() {
		notificationsLink.click();
		return new NotificationsPage();
	}

	public MarketplacePage clickOnMarketplace() {
		marketplace.click();
		return new MarketplacePage();
	}

	public FindFriends clickOnFriends() {
		friends.click();
		return new FindFriends();
	}

}
