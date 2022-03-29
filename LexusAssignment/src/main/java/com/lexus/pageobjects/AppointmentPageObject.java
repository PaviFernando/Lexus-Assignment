package com.lexus.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lexus.actiondriver.Action;
import com.lexus.base.BaseClass;

public class AppointmentPageObject extends BaseClass {
	
	Action action= new Action();
	

	By txtFname = By.id("input_first_name");
	By txtLname = By.id("input_last_name");
	By txtEmail = By.id("input_email_address");
	By txtPhone = By.id("input_phone_number");
	By txtTime = By.id("select_preferred_time");
	By txtDate = By.id("datepicker_preferred_date");
	By telSing = By.xpath("//div[@title='Singapore: +65']");
	By txtDate6 = By.xpath("//span[@aria-label='April 6, 2022']");
	By arrowCountry = By.xpath("//div[@class='iti__arrow']");
	By checkModel = By.id("select_preferred_models");
	By checkMarket = By.id("checkbox_marketing");
	By selectSales = By.xpath("//div[normalize-space()='Preferred sales consultant (optional)']");
	By selectPax = By.xpath("//div[normalize-space()='Number of pax']");
	By selectModel = By.xpath("//div[@data-type='select-multiple']//div[@class='choices__inner']");
	By selectOption = By.xpath("//div[@class='choices__item choices__item--selectable'][normalize-space()='Lexus Test Drive Concierge']");

	
	public void userNavigateToFormPage(String url){
		action.navigateTo(url);
	}
						
	public void enterFname(String fname){
		action.sendKeys(txtFname,fname);
	}

	public void enterLname(String lname){
		action.sendKeys(txtLname,lname);
	}

	public void enterEmail(String email){
		action.sendKeys(txtEmail,email);
	}

}
