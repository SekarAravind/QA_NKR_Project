package com.runner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.listener.ExtentReport_Test;
import com.pageobjectmanager.PageObjectManager;

public class NaukriRunner extends BaseClass {
	
	@BeforeClass
	public void propertySetup() throws IOException {
	launchBrowser(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("browser"));
	launchUrl(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("url"), "getUrl");
	}
	
	@Test (priority = 1)
	public void validLoginPage() throws IOException {		
		PageObjectManager.getPageObjectManager().getloginPage().validLogin();
		//ExtentReport_Test.extenttest=extentReports.createTest("NAUKRI APPLICATION TESTING" + " : " + Thread
		//.currentThread().getStackTrace()[1].getMethodName().toString()).info("VALID LOGIN TEST");
		
		//Assert.assertTrue(PageObjectManager.getPageObjectManager().getloginPage()
		//.validLogin(ExtentReport_Test.extenttest));				
	}
	

	@Test (priority = 2)
	public void profilePage() throws InterruptedException {
		PageObjectManager.getPageObjectManager().getProfile().profile();		
	}
	
	@Ignore
	@Test (priority = 3)
	public void addSkillPage() throws IOException {
		PageObjectManager.getPageObjectManager().getAddSkill().addSkillPage();
	}
	
	@Test(priority = 4)
	public void addEducationPage() throws IOException {
		PageObjectManager.getPageObjectManager().getAddEmployment().addEmploymentPage();
	}
	
	//@AfterClass
	//public void browserClose() {
		//closeBrowser("close");
	//}
}
