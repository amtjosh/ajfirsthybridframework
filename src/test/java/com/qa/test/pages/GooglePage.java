package com.qa.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qa.utilities.Helper;

public class GooglePage {
	
	public WebDriver driver;
	
	private final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
	
	@FindBy(xpath="//input[@name='q']")
	WebElement test;
	

	
	public GooglePage(WebDriver driver)
	{
		this.driver=driver;
	}

	
	public void GoogleSearch(String searchText) throws InterruptedException
	{
		System.out.println("Test Method Called");
		//WebElement test =driver.findElement(By.xpath("//input[@name='q']"));
		Thread.sleep(5000);
		test.sendKeys(searchText);
		test.submit();
		Thread.sleep(5000);
		List<WebElement> WebElement = driver.findElements(By.xpath("//a[@href]"));
		Helper.movetoObject(driver, "window.scrollBy(0,1000)");
		Thread.sleep(5000);
		boolean linkpresent=driver.findElement(By.xpath("//h3[@class=\"LC20lb DKV0Md\"]")).isDisplayed();
		System.out.println(linkpresent);
		System.out.println(WebElement.size());
	}
	
	
}
