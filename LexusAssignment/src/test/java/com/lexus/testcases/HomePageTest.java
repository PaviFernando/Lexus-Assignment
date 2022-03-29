package com.lexus.testcases;

import com.lexus.pageobjects.AppointmentPageObject;
import com.lexus.pageobjects.RXModelPageObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.lexus.base.BaseClass;
import com.lexus.pageobjects.HomePageObject;

public class HomePageTest extends BaseClass{
	
	HomePageObject homePageObject;
	RXModelPageObject rxModelPageObject;
	
	@BeforeMethod
	public void setup(){
		launchApp("chrome");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void validateLogo() throws Throwable {
		homePageObject = new HomePageObject();
		boolean result = homePageObject.validateLogo();
		Assert.assertTrue(result);
		homePageObject.clickOnImageRx();

		rxModelPageObject = new RXModelPageObject();
		Assert.assertEquals(rxModelPageObject.returnCurrentUrl(),"https://www.lexus.com.sg/en/models/rx.html","Validate RX Series Page");
		rxModelPageObject.navigateToGallery();
		Assert.assertTrue(rxModelPageObject.isVideoLoading());

	}
	@Test
	public void CheckFormFunctionality() throws Throwable {
		homePageObject = new HomePageObject();
		boolean result = homePageObject.validateLogo();
		Assert.assertTrue(result);
		homePageObject.clickOnImageRx();

		rxModelPageObject = new RXModelPageObject();
		Assert.assertEquals(rxModelPageObject.returnCurrentUrl(),"https://www.lexus.com.sg/en/models/rx.html","Validate RX Series Page");
		rxModelPageObject.navigateToBookATestDriverButtonAndClick();

	}

	@Test
	public void UserFillTheForm(){
		AppointmentPageObject appointmentPageObject = new AppointmentPageObject();
		appointmentPageObject.userNavigateToFormPage("https://www.lexus.com.sg/en/contact-us/book-a-test-drive.html?model=rx");
		appointmentPageObject.enterFname("CPL");
		appointmentPageObject.enterLname("Test");
		appointmentPageObject.enterEmail("qa@convertium.com");
	}
}
