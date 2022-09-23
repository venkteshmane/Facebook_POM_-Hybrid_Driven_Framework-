package com.facebook.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.FindFriends;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LoginPage;

public class FindFriendsTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	FindFriends findFriends;

	public FindFriendsTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage = new LoginPage();
		findFriends = new FindFriends();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		findFriends.clickFindFriends();

	}

	@Test(priority = 1)
	public void verifyFindFriendsTitleTest() {
		String findFriendsTitle = findFriends.verifyFindFriendsTitle();
		Assert.assertEquals(findFriendsTitle, "Facebook", "Home Page is Incorrect");
	}

	@Test(priority = 2)
	public void verifyFriendRequestLink() {
		findFriends.clickFindFriends();
	}

	@Test(priority = 3)
	public void verifySuggestionsLink() {
		findFriends.clickonSuggestions();
	}

	@Test(priority = 4)
	public void verifyBirthdaysLink() {
		findFriends.clickonBithdays();
	}

	@Test(priority = 5)
	public void add_friend() throws InterruptedException {
		findFriends.clickAddFriend();
		log.info("Click on Add Friend....");
		Thread.sleep(3000);
	}

	@Test(priority = 6)
	public void confirm_friend() throws InterruptedException {
		findFriends.clickOnConfirmFriend();
		log.info("Click on Confirm Friend....");
		Thread.sleep(3000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("Closing Browser....");
	}

}
