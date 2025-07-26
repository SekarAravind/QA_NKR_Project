package com.pageobjectmodel;

import java.awt.print.PageFormat;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.interfaceelements.KeySkillsPageInterFaceElement;
import com.utility.FileReaderManager;

public class AddSkill extends BaseClass implements KeySkillsPageInterFaceElement {

	@FindBy(xpath = skill_xpath)
	private WebElement skill;
	
	@FindBy(id = addSkill_id)
	private WebElement addSkill;
	
	@FindBy(id = save_id)
	private WebElement save;
	
	public AddSkill() {
	PageFactory.initElements(driver, this);
	}
	
	public void addSkillPage() throws IOException {
		
		FileReaderManager data = new FileReaderManager();
		explicitcitWait(skill);
		clickElement(skill, "clickable");
		explicitcitWait(addSkill);
		passInput(addSkill, data.getDataProperty("skill"));
		clickElement(save, "Clickable");
				
	}
}
