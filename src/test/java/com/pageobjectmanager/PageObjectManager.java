package com.pageobjectmanager;

import com.pageobjectmodel.EmploymentPage;
import com.pageobjectmodel.SkillPage;
import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.ResumeHeadLinePage;
import com.pageobjectmodel.ViewProfile;
import com.utility.FileReaderManager;


public class PageObjectManager {

	private LoginPage loginPage;
	private FileReaderManager fileReader;
	private ViewProfile profile;
	private SkillPage addSkill;
	private EmploymentPage addEmployment;
	private ResumeHeadLinePage addResumeHeadLine;
	
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

	public SkillPage getAddSkill() {
		if(addSkill == null) {
			addSkill = new SkillPage();
		}
		return addSkill;
	}

	public EmploymentPage getAddEmployment() {
		if(addEmployment == null) {
			addEmployment = new EmploymentPage();
		}
		return addEmployment;
	}

	public ResumeHeadLinePage getAddResumeHeadLine() {
		if(addResumeHeadLine == null) {
			addResumeHeadLine = new ResumeHeadLinePage();
		}
		return addResumeHeadLine;
	}
}
	
	

	