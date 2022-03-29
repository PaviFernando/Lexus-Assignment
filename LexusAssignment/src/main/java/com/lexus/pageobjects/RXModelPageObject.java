package com.lexus.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lexus.actiondriver.Action;
import com.lexus.base.BaseClass;

public class RXModelPageObject extends BaseClass{
	
	Action action= new Action();

	By logoGallery = By.xpath("//h2[normalize-space()='GALLERY']");
	By buttonVideo = By.xpath("//li[@aria-label='2 / 19']//picture[@class='slider__gallery_ar']");
	By buttonClose = By.xpath("//button[@aria-label='Close gallery']");
	By buttonAppointment = By.xpath("//span[normalize-space()='BOOK A TEST DRIVE']");


	public String returnCurrentUrl(){
		return action.getCurrentUrl();
	}

	public void navigateToGallery (){
		action.scrolltoElement(logoGallery);
	}

	public boolean isVideoLoading() throws InterruptedException {
		Thread.sleep(5000);
		return action.isDisplayed(buttonVideo);
	}

	public void navigateToBookATestDriverButtonAndClick() throws InterruptedException {
		action.scrolltoElement(buttonAppointment);
		Thread.sleep(3000);
		action.click(buttonAppointment);
	}
	
	

	
	
}
