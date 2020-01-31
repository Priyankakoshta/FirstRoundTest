package com.amazon.pagemethods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageAmazon {

	@FindBy(xpath = "(//a[@class=\"a-size-base a-link-normal s-no-hover a-text-normal\"]/span/span[@aria-hidden=\"true\"]/span[2][contains(text(),\"47,900\")])[1]")

	WebElement text;

	public String getprice() {
		String price=text.getText();
		return price;
		
	}
}
