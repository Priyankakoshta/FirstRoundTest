package com.tripadvisor.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonUtil {

	public static String getPropertyValue(String fn, String key) throws FileNotFoundException {

		try (FileInputStream fis = new FileInputStream("./Testdata/" + fn + ".properties")) {
			Properties p = new Properties();
			p.load(fis);
			return p.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return key;

	}

	

	public static void takeScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot tss = (TakesScreenshot) driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dest = new File("/.Screenshots/" +  ".png");
		FileUtils.copyFile(src, dest);

	}
	
	
}
