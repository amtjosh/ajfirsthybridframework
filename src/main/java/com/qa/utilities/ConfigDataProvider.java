package com.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConfigDataProvider {
	
	Properties prop;
	
	public ConfigDataProvider() {
	File src = new File("./Config/Config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			
			prop.load(fis);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to load config File" + e.getMessage());
		}
	}

	
	public String getConfigData(String KeytoSearch) {
		return prop.getProperty(KeytoSearch);
	}
	
	public String getBrowser() {
		return prop.getProperty("Browser");
	}
	
	public String getURL() {
		return prop.getProperty("qaURL");
		
	}
	
}
