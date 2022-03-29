package com.lexus.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lexus.actiondriver.Action;
import com.lexus.base.BaseClass;

public class HomePageObject extends BaseClass{
	
	Action action = new Action();
	

	By logoLexus = By.xpath("//div[@class='nav__logo_wrp']//picture//a//*[name()='svg']");
	By imgRX = By.xpath("//section[@class='sec__cont sec__wrapper']//img[@alt='RX']");

	
	public HomePageObject() {
		PageFactory.initElements(driver, this);
	}

	
	public void clickOnImageRx() throws Throwable{
		Thread.sleep(3000);
		action.scrolltoElement(imgRX);
		Thread.sleep(3000);
		action.click(imgRX);
	}
	
	public boolean validateLogo() throws Throwable {
		return action.isDisplayed(logoLexus);
	}

	
	
}
