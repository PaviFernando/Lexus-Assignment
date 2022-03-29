package com.lexus.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import com.lexus.actiondriver.Action;

public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;

	
	//loadConfig method is to load the configuration
		@BeforeTest//(groups = { "Smoke", "Sanity", "Regression" })
		public void loadConfig() {
			//ExtentManager.setExtent();
			//DOMConfigurator.configure("log4j.xml");

			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(
						System.getProperty("user.dir") + "\\Configuration\\config.properties");
				prop.load(ip);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
		public void launchApp(String browserName) {
			// String browserName = prop.getProperty("browser");
			if (browserName.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if (browserName.equalsIgnoreCase("FireFox")) {
				driver=new FirefoxDriver();
				//WebDriverManager.firefoxdriver().setup();
				//driver.set(new FirefoxDriver());
			} else if (browserName.equalsIgnoreCase("IE")) {
				driver= new InternetExplorerDriver();
				//WebDriverManager.iedriver().setup();
				//driver.set(new InternetExplorerDriver());
			}
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();

		}

}
