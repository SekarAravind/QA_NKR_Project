package com.listener;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.base.BaseClass;


public class ExtentReport_Test {

	public static ExtentTest extenttest;
	
	@BeforeSuite
	public void extentTestReportStartup() {
		BaseClass base = new BaseClass() {
			};
			base.extentReportStart(null);
	}
	
	@AfterSuite
	public void extentReportEnd() throws IOException {
		BaseClass base = new BaseClass() {
			};
			base.extentReportTearDown(null);
	}
	
}
