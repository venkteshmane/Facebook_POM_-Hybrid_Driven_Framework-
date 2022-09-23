package com.facebook.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.BuyingPage;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.InboxPage;
import com.facebook.qa.pages.LoginPage;
import com.facebook.qa.pages.MarketplacePage;
import com.facebook.qa.pages.NotificationsPage;
import com.facebook.qa.pages.SellingPage;

public class MarketplacePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	MarketplacePage marketplacePage;
	NotificationsPage notificationPage;
	InboxPage inboxPage;
	BuyingPage buyingPage;
	SellingPage sellingPage;

	public MarketplacePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage = new LoginPage();
		homepage = new HomePage();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		marketplacePage = homepage.clickOnMarketplace();
	}

	@Test(priority = 1)
	public void verifyMarketplacePageTitleTest() {
		String marketplacePageTitle = marketplacePage.verifyMarketplacePageTitle();
		Assert.assertEquals(marketplacePageTitle, "Facebook", "MarketplacePage is not matched");
	}

	@Test(priority = 2)
	public void verifyClickOnNotification() {
		notificationPage = marketplacePage.clickOnNotifaction();

	}

	@Test(priority = 3)
	public void verifyClickOnInbox() {
		inboxPage = marketplacePage.clickOnInbox();

	}

	@Test(priority = 4)
	public void verifyClickOnBuying() {
		buyingPage = marketplacePage.clickOnBuying();

	}

	@Test(priority = 5)
	public void verifyClickOnSelling() {
		sellingPage = marketplacePage.clickOnSelling();

	}

	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
