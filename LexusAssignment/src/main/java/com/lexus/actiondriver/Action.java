package com.lexus.actiondriver;

import com.lexus.base.BaseClass;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;

public class Action extends BaseClass  {

	public void navigateTo(String url){
		driver.navigate().to(url);
	}

	public void sendKeys(By by,String value){

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		WebElement element = driver.findElement(by);
		element.clear();
		element.sendKeys(value);

	}


	public void scrolltoElement(By by){
		WebElement element = driver.findElement(by);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void click (By by){
		WebElement element = driver.findElement(by);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public boolean isDisplayed (By by){
		WebElement element = driver.findElement(by);
		boolean visibility = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
			visibility = true;
		}catch(Exception ex)
		{
			visibility = false;
		}
		return visibility;

	}

	public String getCurrentUrl(){
		return driver.getCurrentUrl();
	}


}
