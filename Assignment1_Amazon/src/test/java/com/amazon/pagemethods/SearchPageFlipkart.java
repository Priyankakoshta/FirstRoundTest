package com.amazon.pagemethods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageFlipkart {

	@FindBy(xpath = "//div[@class=\"_1vC4OE _2rQ-NK\"]")
	WebElement text;

	public String getprice() {
		String price = text.getText();
		return price;

	}
}
