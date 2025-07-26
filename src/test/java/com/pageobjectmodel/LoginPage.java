package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.interfaceelements.LoginPageInterFaceElements;
import com.utility.ExcelUtility;
import com.utility.FileReaderManager;

public class LoginPage extends BaseClass implements LoginPageInterFaceElements {

	@FindBy(xpath = sign_xpath)
	private WebElement signin;
	
	@FindBy(xpath = username_xpath)
	private WebElement username;
	
	@FindBy(xpath = password_xpath)
	private WebElement password;
	
	@FindBy(xpath = login_xpath)
	private WebElement login;
	
	@FindBy(xpath = title_xpath)
	private WebElement title;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validLogin() throws IOException {
		//try {
			FileReaderManager data = new FileReaderManager();
			clickElement(signin,"clickable");
			explicitcitWait(username);
			passInput(username, data.getDataProperty("username"));
			passInput(password, data.getDataProperty("password"));
			clickElement(login, "clickable");
			explicitcitWait(title);
			//validation(title, ExcelUtility.getExcelData
			//("C:\\Selenium Practice\\MavenNaukri\\src\\test\\resources\\Excel.xlsx","Data"));
			//extenttest.log(Status.PASS, "Login Successful");
			
			
		//} catch (Exception e) {
			//extenttest.log(Status.FAIL, "Login Failed" + e.getMessage());
			//return false;
		//}
		//return true;
	}
}