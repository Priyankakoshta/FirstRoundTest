package com.tripadvisor.pagemethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelPage extends TestBase {

	public HotelPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = ".//a[contains(text(),'Write a review')]")
	public static WebElement writeAReview;
	
	
	public WriteaReviewPage clickreviewlink() {
		writeAReview.click();
		
		return PageFactory.initElements(driver, WriteaReviewPage.class);
	}

	
}
