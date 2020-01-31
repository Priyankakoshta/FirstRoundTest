package com.amazon.testscript;


import java.util.ArrayList;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.amazon.pagemethods.HomePageAmazon;
import com.amazon.pagemethods.HomePageFlipkart;
import com.amazon.pagemethods.SearchPageAmazon;
import com.amazon.pagemethods.SearchPageFlipkart;
import com.amazon.util.BrowserFactory;
import com.amazon.util.CommonUtil;

public class TestScript {

	@Test
	public void Compareprice() throws Throwable {
		WebDriver driver = null;
		String errorMsg = "", result = "fail";
		try {
			String bn = CommonUtil.getPropertyValue("config", "browsername");
			String rm = CommonUtil.getPropertyValue("config", "runmode");
			String url = CommonUtil.getPropertyValue("config", "url1");
			driver = BrowserFactory.getBrowser(bn, rm);
			BrowserFactory.OpenUrl(url);
			HomePageAmazon hp = PageFactory.initElements(driver, HomePageAmazon.class);
			hp.SelectSearchbox();
			SearchPageAmazon search = hp.clicksearch();
			String amazonprice = search.getprice();

			String url2 = CommonUtil.getPropertyValue("config", "url2");
			BrowserFactory.navigateUrl(url2);
			HomePageFlipkart hf = PageFactory.initElements(driver, HomePageFlipkart.class);
			hf.alertdismiss();
			hf.SelectSearchbox1();
			SearchPageFlipkart sf = hf.clicksearch1();
			String flipkartprice = sf.getprice();

			List<String> sortedprice = new ArrayList<>();
			sortedprice.add(flipkartprice);
			sortedprice.add(amazonprice);
			Collections.sort(sortedprice);
			Iterator<String> iter = sortedprice.iterator();
			Object firstvalue = iter.next();
			System.out.println("Lowest price of iPhone XR 64GB yellow between Amazon and flipkart is: " + firstvalue);
			result = "pass";

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
		BrowserFactory.closeBrowser();
	}
}
