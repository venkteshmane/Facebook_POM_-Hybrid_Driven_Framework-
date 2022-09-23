package com.facebook.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.qa.base.TestBase;

public class GroupsPage extends TestBase{
	 @FindBy(xpath = "//span[contains(text(),'Groups')]")
	    WebElement groups;
	 
	 @FindBy(xpath = "//span[contains(text(),'Discover')]")
	    WebElement discover;

	    public GroupsPage() {
	        PageFactory.initElements(driver, this);
	    }

	    public String verifyGroupsPageTitle() {
	        try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        return driver.getTitle();
	    }
	    public GroupsPage clickOnGroups() {
	    	groups.click();
	        return new GroupsPage();
	    }


	    public DiscoverPage clickOnDiscover() {
	        discover.click();
	        return new DiscoverPage();
	    }

}
