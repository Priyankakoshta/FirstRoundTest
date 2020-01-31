package com.amazon.pagemethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.util.WaitHelper;

public class HomePageFlipkart extends TestBaseFlipkart {

	public HomePageFlipkart(WebDriver driver) {
		super(driver);

	}
	WaitHelper wh;
	@FindBy(xpath = "//div[@class=\"col-12-12 _2tVp4j\"]/div/input[@name=\"q\"]")
	WebElement searchbox;

	@FindBy(xpath = "//div[@class=\"col-12-12 _2tVp4j\"]/button[@class=\"vh79eN\"]")
	WebElement clickbox;

	@FindBy(xpath = "button[@class='_2AkmmA _29YdH8']")
	WebElement alert;

	
	
	public void alertdismiss() throws AWTException, InterruptedException {
		//wh.implicitWait(5000);
		Thread.sleep(6000);
		//alert.click();
		
		  Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_ESCAPE);
		  robot.keyRelease(KeyEvent.VK_ESCAPE);
		 
	}

	public HomePageFlipkart SelectSearchbox1() {
		searchbox.sendKeys("iPhone XR 64GB yellow");
		return this;
	}

	public SearchPageFlipkart clicksearch1() {
		clickbox.click();
		return PageFactory.initElements(driver, SearchPageFlipkart.class);
	}

}
