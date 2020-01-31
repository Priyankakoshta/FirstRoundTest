package com.amazon.pagemethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageAmazon extends TestBaseAmazon {

	public HomePageAmazon(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//div[@class=\"nav-search-field \"]/input[@name=\"field-keywords\"]")
	WebElement searchbox;

	public HomePageAmazon SelectSearchbox() {
		searchbox.sendKeys("iPhone XR 64GB yellow");
		return this;
	}

	@FindBy(xpath = "//div[@class=\"nav-search-submit nav-sprite\"]/input[@type=\"submit\"]")
	WebElement clickbox;

	public SearchPageAmazon clicksearch() {
		clickbox.click();
		return PageFactory.initElements(driver, SearchPageAmazon.class);
	}

}
