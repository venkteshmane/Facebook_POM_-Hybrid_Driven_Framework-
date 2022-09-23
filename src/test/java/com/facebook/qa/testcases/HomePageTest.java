package com.facebook.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.FindFriends;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LoginPage;
import com.facebook.qa.pages.GroupsPage;
import com.facebook.qa.pages.MessengerPage;
import com.facebook.qa.pages.NotificationsPage;
import com.facebook.qa.pages.ProfilePage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	FindFriends findFriends;
	GroupsPage groupspage;
	MessengerPage messenger;
	NotificationsPage notifications;

	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage = new LoginPage();
		profilePage = new ProfilePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("************Login the Application**********************");
		System.out.println("Welcome to Facebook Home Page");
	}

	@Test(priority = 1)
	public void HomePageTitleTest() throws InterruptedException {
		System.out.println("Opening Home Page");
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Facebook – log in or sign up");
		Thread.sleep(2000);
		System.out.println("Title Verified Successfully.....");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}

	@Test(priority = 3)
	public void verifyClickOnFriends() throws InterruptedException {

		findFriends = homePage.clickOnFriends();
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void verifyHomePage() throws InterruptedException {

		homePage = homePage.click_home();
		Thread.sleep(3000);
	}

	@Test(priority = 5)
	public void verifygroupsLinkTest() {
		groupspage = homePage.clickOnGroupsLink();
	}
	

	@Test(priority = 6)
	public void verifyMessengerLinkTest() {
		messenger = homePage.clickOnMessengerLink();
	}

	@Test(priority = 7)
	public void verifyNotificationsLinkTest() {
		notifications = homePage.clickOnNotificationsLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
