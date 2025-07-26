package com.interfaceelements;

public interface EmploymentInterFaceElement {
	
	String emp_xpath = "//*[text()='Add employment']";
	String yearDrop_id = "exp-years-droopeFor";
	String expYear_xpath = "//a[contains(text(),' 2 Years ')]";
	String monthDrop_id = "exp-months-droopeFor";
	String expMonth_xpath = "(//a[contains(text(),' 2 Months ')])[1]";
	String companyDrop_id = "companySugg";
	String company_xpath = "//li[@data-id=\"223346\"]/div";
	//String company_xpath = "(//div[@id=\"sugDrp_designationSugg\"]//div[@tabindex=\"-1\"])[1]";
	String jobDrop_xpath = "//input[@placeholder='Type your designation']";
	String job_xpath = "//li[@data-id=\"14963\"]/div";
	//String job_xpath = "(//div[@id=\"sugDrp_designationSugg\"]//div[@tabindex=\"-1\"])[1]";
	String jyearDrop_id = "startedYearFor";
	String jyear_xpath = "//a[contains(text(),' 2022 ')]";
	String jmonthDrop_id = "startedMonthFor";
	String jmonth_xpath = "//a[contains(text(),' Jan ')]";
	String salary_xpath = "//input[@class='currency-input ']";
	String skillDrop_xpath = "//input[@placeholder='Add skills']";
	String skill_xpath = "//li[@data-id=\"26836\"]/div";
	String jobProfile_xpath = "//textarea[@placeholder='Type here...']";
	String notice_id = "noticePeriodFor";
	String noticeDays_xpath = "//a[contains(text(),' 15 Days or less ')]";
	String save_id = "submitEmployment";

}
