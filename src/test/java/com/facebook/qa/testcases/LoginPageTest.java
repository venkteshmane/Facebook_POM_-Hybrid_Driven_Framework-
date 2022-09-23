package com.facebook.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LoginPage;
import com.facebook.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	String sheetName = "Signin";
	Logger log = Logger.getLogger(LoginPageTest.class);

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage = new LoginPage();

	}

	@Test(priority = 1)
	public void LoginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}

	@Test(priority = 2)
	public void facebookImageTest() {
		boolean flag = loginPage.validateFaceBookImage();
		Assert.assertTrue(flag);
	}

		// -------------------------- Data Driven --------------------------------//
	@DataProvider
	public Object[][] getLoginTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider = "getLoginTestData")
	public void multipleLoginTest(String userName, String password) throws InterruptedException {
		homePage = loginPage.loginMultipleAccounts(userName, password);
		Thread.sleep(3000);
		log.info("login successful with username: " + userName);
	}

	@Test(priority = 3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
