package com.qa.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	WebDriver driver;
	
	public static WebDriver StrartApplication(WebDriver driver, String browsername , String url) 
	{
		if (browsername.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\dev\\software\\chromedriver_win32 (8)\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		System.out.println("db.mybrowser: Started ");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get(url);
		
		return driver;
	}

	
	public static void quitbrowser(WebDriver driver)
	{
		driver.quit();
	}
	
}
