package com.tripadvisor.pagemethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends TestBase {

	public HomePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "(.//input[contains(@title, 'Search')])[2]")
	public static WebElement searchicon;

	@FindBy(xpath = "(.//button[contains(@title,'Search')])[2]")
	public static WebElement clickbutton;

	@FindBy(xpath = "(.//input[contains(@title,'Search')])[2]")
	public static WebElement searchbox;

	@FindBy(xpath = "(.//input[contains(@title,'Search')])[2]/following-sibling::div/a[1]")
	public static WebElement clickOnFirstResult;

	@FindBy(xpath = ".//a[contains(text(),'Write a review')]")
	public static WebElement writeAReview;

	@FindBy(xpath = ".//div[contains(text(),'Where to?')]")
	public static WebElement whereTo;

	@FindBy(xpath = "(.//span[contains(text(), 'Search')])[1]")
	public static WebElement searchBoxNearBySignUp;

	@FindBy(xpath = ".//input[contains(@name,'ReviewTitle')]")
	public static WebElement titleOfYourReview;

	@FindBy(xpath = ".//textarea[contains(@name,'ReviewText')]")
	public static WebElement yourReview;

	@FindBy(xpath = ".//div[contains(text(),'Family')]")
	public static WebElement sortOfTrip;

	@FindBy(xpath = ".//select[contains(@id,'trip_date_month_year')]")
	public static WebElement selectTravel;
	
	@FindBy(xpath = "(.//input[contains(@id,'noFraud')])[2]")
	public static WebElement submitYourReviewCheckBox;
	
	@FindBy(xpath = ".//span[contains(text(),'Submit your review ')]")
	public static WebElement submitYourReviewButton;

	public boolean whereTo() {
		boolean value = false;
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			if (wait.until(
					ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[contains(text(),'Where to?')]"))))
					.isDisplayed()) {
				value = true;
				searchBoxNearBySignUp.click();
				driver.findElement(By.xpath(".//input[contains(@id,'mainSearch')]")).sendKeys("Club Mahindra");
				driver.findElement(By.xpath(".//div[contains(text(),'Search')]")).click();
			}
		} catch (Exception e) {
			value = false;
		}
		return value;
	}

	public HomePage clickicon() {
		searchicon.click();
		return this;
	}

	public HomePage selectsearchbox() {
		searchbox.sendKeys("Club Mahindra");
		return this;
	}

	public HomePage searchbox() {
		clickbutton.click();
		return this;

	}

	public SearchPage clicksearchbox() {
		clickbutton.click();
		return PageFactory.initElements(driver, SearchPage.class);

	}

	public HomePage clickOnFirstResult() {
		clickOnFirstResult.click();
		return this;

	}

	public HomePage clickOnWriteAReview() {
		writeAReview.click();
		return this;

	}

	public void overAllReview() throws AWTException, InterruptedException {

		Point point = driver.findElement(By.xpath(".//span[contains(@id,'bubble_rating')]")).getLocation();
	

		Robot robot = new Robot();
		Thread.sleep(500);
		robot.mouseMove(point.getX() + 3, point.getY() + 124);
		Thread.sleep(500);
		robot.mouseMove(point.getX() + 43, point.getY() + 124);
		Thread.sleep(500);
		robot.mouseMove(point.getX() + 83, point.getY() + 124);
		Thread.sleep(500);
		robot.mouseMove(point.getX() + 123, point.getY() + 124);
		Thread.sleep(500);
		robot.mouseMove(point.getX() + 153, point.getY() + 124);
		Thread.sleep(500);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(500);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(500);

	}

	public HomePage titleOfYourReview() {
		titleOfYourReview.sendKeys("Priyanka's Review");
		return this;

	}

	public HomePage yourReview() {
		yourReview.sendKeys("We had come to Club Mahindra madekari Coorg For our 31st anniversary celebrations And the team in Particular Mr Joshi and Mr Goorang and Chef Sameer made our celebrations memorable for the years left Mr Joshi in particular sang song which made occasion memorable we shall play it every year Cake baked for the occasion was excellent. Violin played was melodious Wishing Team at Club Mahindra all the best and looking forward to celebrating our all anniversary with Club Mahindra If we can add many more stars we shall do so");
		return this;

	}

	public HomePage sortOfTrip() {
		sortOfTrip.click();
		return this;

	}

	public HomePage selectTravel() {

		Select select = new Select(selectTravel);
		select.selectByVisibleText("January 2020");
		return this;

	}

	public void serviceReview() throws AWTException, InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath(".//div[contains(text(),'Hotel Ratings')]")));

		Thread.sleep(500);
		Point point = driver.findElement(By.xpath("(.//span[contains(@id,'bubbles')])[1]")).getLocation();

		Robot robot = new Robot();
		Thread.sleep(500);
		robot.mouseMove(point.getX() +3, point.getY() -1335);
		Thread.sleep(500);
		robot.mouseMove(point.getX() + 40, point.getY() -1335);
		Thread.sleep(500);
		robot.mouseMove(point.getX() + 70, point.getY() -1335);
		Thread.sleep(500);
		robot.mouseMove(point.getX() + 95, point.getY() -1335);
		Thread.sleep(500);
		robot.mouseMove(point.getX() + 115, point.getY() -1335);
		Thread.sleep(500);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(500);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(500);

	}

	public void sleepQualityReview() throws AWTException, InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath(".//div[contains(text(),'Hotel Ratings')]")));

		Thread.sleep(500);
		Point point = driver.findElement(By.xpath("(.//span[contains(@id,'bubbles')])[2]")).getLocation();
		

		Robot robot = new Robot();
		Thread.sleep(500);
		robot.mouseMove(point.getX() +3, point.getY() -1335);
		Thread.sleep(500);
		robot.mouseMove(point.getX() + 40, point.getY() -1335);
		Thread.sleep(500);
		robot.mouseMove(point.getX() + 70, point.getY() -1335);
		Thread.sleep(500);
		robot.mouseMove(point.getX() + 95, point.getY() -1335);
		Thread.sleep(500);
		robot.mouseMove(point.getX() + 115, point.getY() -1335);
		Thread.sleep(500);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(500);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(500);

	}

	public void cleanlinessReview() throws AWTException, InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath(".//div[contains(text(),'Hotel Ratings')]")));

		Thread.sleep(500);
		Point point = driver.findElement(By.xpath("(.//span[contains(@id,'bubbles')])[3]")).getLocation();


		Robot robot = new Robot();
		Thread.sleep(500);
		robot.mouseMove(point.getX() +3, point.getY() -1335);
		Thread.sleep(500);
		robot.mouseMove(point.getX() + 40, point.getY() -1335);
		Thread.sleep(500);
		robot.mouseMove(point.getX() + 70, point.getY() -1335);
		Thread.sleep(500);
		robot.mouseMove(point.getX() + 95, point.getY() -1335);
		Thread.sleep(500);
		robot.mouseMove(point.getX() + 115, point.getY() -1335);
		Thread.sleep(500);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(500);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(500);
	

	}
	
	public HomePage submitYourReviewCheckBox() {
		submitYourReviewCheckBox.click();
		return this;

	}

	public HomePage submitYourReviewButton() {
		submitYourReviewButton.click();
		return this;

	}
	
	public boolean finalValidation() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		boolean value =wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//img[contains(@class,'regHeaderImage')]"))))
				.isDisplayed();
		System.out.println("Popup displayed");
		return value;

	}

	
}
