package com.qa.test.base;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.qa.utilities.BrowserFactory;
import com.qa.utilities.ConfigDataProvider;
import com.qa.utilities.ExcelDataProvider;
import com.qa.utilities.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		 excel=new ExcelDataProvider();
		 config= new ConfigDataProvider();
		 System.out.println("My Extent Report");		
		 //ExtentSparkReporter extent =new ExtentSparkReporter("C:\\dev\\workspace\\Education\\MyFrameWork\\Reports\\TestReport1.html");
		 //ExtentSparkReporter extent =new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/TestReport.html");
		 //System.out.println(extent.getReport().toString());
		  ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/TestReport.html"));
		 report = new ExtentReports();
		  report.attachReporter(extent);
	}
	
	@BeforeClass
	public void setup()
	{
		
		driver=BrowserFactory.StrartApplication(driver, config.getBrowser() , config.getURL()) ;
		/*
		 * System.setProperty(
		 * "webdriver.chrome.driver","C:\\dev\\software\\chromedriver_win32 (8)\\chromedriver.exe"
		 * );
		 * 
		 * driver =new ChromeDriver(); System.out.println("db.mybrowser: Started ");
		 * driver.manage().window().maximize(); driver.manage().deleteAllCookies();
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 * driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		 * 
		 * 
		 * driver.get(config.getURL());
		 */
	}
	
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.captureScreenshot(driver);
		}
		report.flush();
		
	}

	@AfterClass
	public void teardown()
	{
		BrowserFactory.quitbrowser(driver);
	}
}
