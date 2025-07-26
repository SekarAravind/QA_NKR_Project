package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.interfaceelements.ViewProfileInterFaceElement;

public class ViewProfile extends BaseClass implements ViewProfileInterFaceElement {
		
	@FindBy(xpath = profile_xpath)
	private WebElement profile;
	
	@FindBy(xpath = viewProfile_xpath)
	private WebElement viewProfile;
	
	public ViewProfile() {
		PageFactory.initElements(driver, this);
	}
	
	public void profile() throws InterruptedException {
		
		clickElement(profile, "clickable");
		explicitcitWait(viewProfile);
		clickElement(viewProfile, "clickable");
		
	}
	
	

}
