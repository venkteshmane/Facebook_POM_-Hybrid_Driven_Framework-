package com.facebook.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.DiscoverPage;
import com.facebook.qa.pages.GroupsPage;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LoginPage;

public class GroupsPageTest extends TestBase{
	LoginPage loginPage;
    HomePage homepage;
    GroupsPage groupsPage;
    DiscoverPage discoverPage;

    public GroupsPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
    	initilization();
        loginPage = new LoginPage();
        homepage = new HomePage();
        homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        groupsPage = homepage.clickOnGroupsLink();
        discoverPage = groupsPage.clickOnDiscover();
    }

    @Test(priority = 1)
    public void verifyDiscoverPageTitleTest() {
        String groupsPageTitle = groupsPage.verifyGroupsPageTitle();
        Assert.assertEquals(groupsPageTitle, "Groups | Facebook", "GroupsPage is not matched");
    }

    @Test(priority = 2)
    public void verifyClickOnWorkAndEduaction() {
        discoverPage = groupsPage.clickOnDiscover();

    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }


}
