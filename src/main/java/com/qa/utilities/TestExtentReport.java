package com.qa.utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class TestExtentReport {

	public static void main(String[] args) {
		//ExtentSparkReporter extent =new ExtentSparkReporter("TestReport1.html");
		//ExtentSparkReporter extent =new ExtentSparkReporter("C:\\dev\\workspace\\Education\\MyFrameWork\\TestReport1.html");
		 //ExtentSparkReporter extent =new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/TestReport.html");
		 //System.out.println(extent.getReport().toString());
		  ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/TestReport.html"));
		ExtentReports report = new ExtentReports();
		 report.attachReporter(extent);
		System.out.println("Test case starting");
		 
		 ExtentTest logger =report.createTest("My Test", "sample");
		 logger.log(Status.INFO, "Test");
			
	}

}
