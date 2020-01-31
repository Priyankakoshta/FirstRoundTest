package com.tripadvisor.testscript;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tripadvisor.pagemethods.HomePage;
import com.tripadvisor.pagemethods.HotelPage;
import com.tripadvisor.pagemethods.SearchPage;
import com.tripadvisor.pagemethods.WriteaReviewPage;
import com.tripadvisor.util.BrowserFactory;
import com.tripadvisor.util.CommonUtil;

public class TestScript {

	WebDriver driver = null;
	String errorMsg = "", result = "fail";
	@BeforeTest
	public void setup() throws FileNotFoundException {
		
		
			String bn = CommonUtil.getPropertyValue("config", "browsername");
			String rm = CommonUtil.getPropertyValue("config", "runmode");
			String url = CommonUtil.getPropertyValue("config", "url");
			driver = BrowserFactory.getBrowser(bn, rm);
			BrowserFactory.OpenUrl(url);
	
	}
	
	@Test
	public void Onlinebooking() throws Throwable {
		
		try {
			HomePage hp = PageFactory.initElements(driver, HomePage.class);

			boolean value = hp.whereTo();
			if (value) {
				System.out.println("Where To is displayed");
			} else {
				try {
					hp.clickicon();
					hp.selectsearchbox();

					hp.searchbox();
				} catch (Exception e) {

				}
			}

			SearchPage search = PageFactory.initElements(driver, SearchPage.class);
			//HotelPage hop = search.clicktextlink();

			Set<String> allwindows = driver.getWindowHandles();
			String[] allw = allwindows.toArray(new String[3]);
			driver.switchTo().window(allw[1]);

			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));

			WebElement element = driver.findElement(By.xpath(".//div[contains(text(),'View Hotel')]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);

			//WriteaReviewPage rp = hop.clickreviewlink();

			Thread.sleep(2000);
			driver.switchTo().defaultContent();

			ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tab.get(2));

			hp.overAllReview();
			hp.titleOfYourReview();
			hp.yourReview();
			hp.sortOfTrip();
			hp.selectTravel();

			System.out.println("done");

			//rp.clickRatings();
			System.out.println(driver.getTitle());
			result = "pass";

			hp.serviceReview();
			hp.sleepQualityReview();
			hp.cleanlinessReview();
			hp.submitYourReviewCheckBox();
			hp.submitYourReviewButton();
			Thread.sleep(1000);
			driver.switchTo().frame("overlayRegFrame");
			hp.finalValidation();

		} catch (Throwable t) {
			errorMsg = t.getMessage();
			t.printStackTrace();
			CommonUtil.takeScreenshot(driver);
			throw t;
		} finally {
			System.out.println(result);
			if (!errorMsg.isEmpty())
				System.out.println(errorMsg);
		}

		
	}
	
	@AfterTest
	public void close() {
		
		driver.quit();
	}
	
	
}
