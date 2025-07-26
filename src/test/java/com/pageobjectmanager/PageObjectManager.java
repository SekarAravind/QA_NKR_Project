package com.pageobjectmanager;

import com.pageobjectmodel.AddEmployment;
import com.pageobjectmodel.AddSkill;
import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.ViewProfile;
import com.utility.FileReaderManager;


public class PageObjectManager {

	private LoginPage loginPage;
	private FileReaderManager fileReader;
	private ViewProfile profile;
	private AddSkill addSkill;
	private AddEmployment addEmployment;
	
	private static PageObjectManager pageObjectManager;
	
	

	public static PageObjectManager getPageObjectManager() {
		if(pageObjectManager == null) {
			pageObjectManager = new PageObjectManager();
		}
		return pageObjectManager;
	}
	
	public LoginPage getloginPage() {
		if(loginPage == null) {
			loginPage = new LoginPage();
		}
		return loginPage;
	}
	public FileReaderManager getFileReader() {
		if(fileReader == null) {
			fileReader = new FileReaderManager();
		}
	
		return fileReader;
	}
	public ViewProfile getProfile() {
		if(profile == null) {
			profile =new ViewProfile();
		}
		return profile;
	}

	public AddSkill getAddSkill() {
		if(addSkill == null) {
			addSkill = new AddSkill();
		}
		return addSkill;
	}

	public AddEmployment getAddEmployment() {
		if(addEmployment == null) {
			addEmployment = new AddEmployment();
		}
		return addEmployment;
	}
	
	
	
}
	
	

	