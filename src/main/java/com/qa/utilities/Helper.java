package com.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public static void captureScreenshot(WebDriver driver) 
	{
		File scrFile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(scrFile, new File("./Screenshots/"+getCurrentDateTime()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to Capture the Screenshot" + e.getMessage());
		}
	}

	
	public static String getCurrentDateTime()
	{
		DateFormat dformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentDate = new Date();
		
		return dformat.format(currentDate);
	}
	
	
	public static void movetoObject(WebDriver driver, String script) 
	{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(script);
	}
	
}
