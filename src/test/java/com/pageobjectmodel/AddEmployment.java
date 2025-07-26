package com.pageobjectmodel;

import java.io.IOException;

import org.asynchttpclient.webdav.WebDavCompletionHandlerBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.interfaceelements.EmploymentInterFaceElement;
import com.utility.FileReaderManager;

public class AddEmployment extends BaseClass implements EmploymentInterFaceElement {
	
	@FindBy(xpath = emp_xpath)
	private WebElement emp;
	
	@FindBy(id = yearDrop_id)
	private WebElement yearDrop;
	
	@FindBy(xpath = expYear_xpath)
	private WebElement expYear;
	
	@FindBy(id = monthDrop_id)
	private WebElement monthDrop;
	
	@FindBy(xpath = expMonth_xpath)
	private WebElement expMonth;
	
	@FindBy(id = companyDrop_id)
	private WebElement companyDrop;
	
	@FindBy (xpath = company_xpath)
	private WebElement company;
	
	@FindBy(xpath = jobDrop_xpath)
	private WebElement jobDrop;
	
	@FindBy(xpath = job_xpath)
	private WebElement job;
	
	@FindBy(id = jyearDrop_id)
	private WebElement jyearDrop;
	
	@FindBy(xpath = jyear_xpath)
	private WebElement jyear;
	
	@FindBy(id = jmonthDrop_id)
	private WebElement jmonthDrop;
	
	@FindBy(xpath = jmonth_xpath)
	private WebElement jmonth;
	
	@FindBy(xpath = salary_xpath)
	private WebElement salary;
	
	@FindBy(xpath = skillDrop_xpath)
	private WebElement skillDrop;
	
	@FindBy(xpath = skill_xpath)
	private WebElement skill;
	
	@FindBy(xpath = jobProfile_xpath)
	private WebElement jobProfile;
	
	@FindBy(id = notice_id)
	private WebElement notice;
	
	@FindBy(xpath = noticeDays_xpath)
	private WebElement noticeDays;
	
	@FindBy(id = save_id)
	private WebElement save;
	
	public AddEmployment() {
		PageFactory.initElements(driver, this);
	}
	
	public void addEmploymentPage() throws IOException {
		FileReaderManager data = new FileReaderManager();		
		jsScrollElement(emp);
		explicitcitWait(emp);
		clickElement(emp, "clickable");		
		explicitcitWait(yearDrop);
		javaScriptClick(yearDrop);
		javaScriptClick(expYear);
		javaScriptClick(monthDrop);
		javaScriptClick(expMonth);
		passInput(companyDrop, data.getDataProperty("company"));
		explicitcitWait(company);
		javaScriptClick(company);
		jsScrollElement(jobDrop);
		explicitcitWait(jobDrop);
		passInput(jobDrop, data.getDataProperty("job"));
		explicitcitWait(job);
		javaScriptClick(job);
		javaScriptClick(jyearDrop);
		javaScriptClick(jyear);
		javaScriptClick(jmonthDrop);
		javaScriptClick(jmonth);		
		passInput(salary, data.getDataProperty("salary"));
		passInput(skillDrop, data.getDataProperty("skill1"));
		javaScriptClick(skill);
		passInput(jobProfile, data.getDataProperty("profile"));
		//clickElement(notice, "clickable");
		//clickElement(noticeDays, "clickable");
		//clickElement(save, "clickable");
		
	}

}
