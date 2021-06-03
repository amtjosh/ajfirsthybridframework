package com.qa.test.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.test.base.BaseClass;
import com.qa.test.pages.GooglePage;
import com.qa.utilities.ExcelDataProvider;
import com.qa.utilities.Helper;

public class GooglePageTest extends BaseClass{

	GooglePage google;
	
	@Test
	public void SearchTest() throws InterruptedException
	{
		
		logger=report.createTest("Google Test");
		logger.info("Starting123 Test");
		google= PageFactory.initElements(driver, GooglePage.class);
		//GooglePage google = new GooglePage(driver);
		System.out.println("In Test Method");
		google.GoogleSearch(excel.getStringData(0, 0, 0));
		logger.pass("Google Search Is Working");
		Helper.captureScreenshot(driver);
		
	}
}
