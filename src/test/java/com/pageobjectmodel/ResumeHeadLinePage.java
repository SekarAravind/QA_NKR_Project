package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.interfaceelements.ResumeHeadLineInterfaceElements;
import com.utility.FileReaderManager;

public class ResumeHeadLinePage extends BaseClass implements ResumeHeadLineInterfaceElements {
	
	@FindBy (xpath = resumeHeadline_xpath)
	private WebElement resumeHeadLine;
	
	@FindBy (id = headLine_id)
	private WebElement headLine;
	
	@FindBy(xpath = save_xpath)
	private WebElement save;
	
	public ResumeHeadLinePage() {
		PageFactory.initElements(driver, this);
	}

	public void addResumeHeadLinePage() throws IOException{		
		FileReaderManager data = new FileReaderManager();
		explicitcitWait(resumeHeadLine);
		javaScriptClick(resumeHeadLine);
		passInput(headLine, data.getDataProperty("Headline"));
		//javaScriptClick(save);
	}
		
		
}
