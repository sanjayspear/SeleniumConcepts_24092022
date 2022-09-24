package seleniumConcepts.log4j;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import base.Util;

public class JavaScriptExecutorDemo extends BaseClass {
	@BeforeMethod
	public void signin() throws InterruptedException {
		driver.get("https://codepen.io/tag/javascript");
		System.out.println("user has logged in");
		//Util.generateAlert(driver, "Currently you are on the [codepen.io] website");
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void flashingAnElementTest() throws InterruptedException {
		WebElement signUpButton = driver.findElement(By.xpath("//a[@data-test-id='signup-button']"));
		Util.flash(signUpButton, driver);
		//Thread.sleep(2000);
		System.out.println("[ELEMENT FLASH TEST SUCCESS]");
		//Util.generateAlert(driver, "Sign Up Button Flasshing");
	}

	@Test(priority = 2)
	public void drawBorderAroundElementTest() throws InterruptedException {
		WebElement signUpButton = driver.findElement(By.xpath("//a[@data-test-id='signup-button']"));
		Util.drawBorder(signUpButton, driver);
		Util.takeScreenshot(driver);
		//Thread.sleep(2000);
		System.out.println("[DRAW BORDER TEST SUCCESS]");
		//Util.generateAlert(driver, "Border drawn around Sign Up Button");
	}

	@Test(priority = 3)
	public void getTitleTest() throws InterruptedException {
		String title = Util.getTitleByJS(driver);
		//Thread.sleep(2000);
		System.out.println("[WEBSITE TITLE] :: " + title);
		System.out.println("[GET TITLE TEST SUCCESS]");
		//Util.generateAlert(driver, "Getting the title");
	}

	@Test(priority = 4)
	public void clickElementtTest() throws InterruptedException {
		WebElement LoginButton = driver.findElement(By.xpath("//a[text()='Log In']"));
		Util.flash(LoginButton, driver);
		Util.drawBorder(LoginButton, driver);
		Util.clickElementByJS(LoginButton, driver);
		
		/*
		 * WebElement username =
		 * driver.findElement(By.xpath("input#login-email-field")); Util.flash(username,
		 * driver); Util.sendKeysByJS(username, driver, "sanjay@gmail.com");
		 * System.out.println("ENTERED USER NAME");
		 * 
		 * WebElement password =
		 * driver.findElement(By.xpath("input#login-password-field"));
		 * Util.flash(password, driver); Util.sendKeysByJS(password, driver,
		 * "Ash#$%123"); System.out.println("ENTERED PASSWORD");
		 */
		Thread.sleep(2000);
		driver.navigate().back();
		System.out.println("[ELEMENT CLICK THROUGH JAVASCRIPT TEST SUCCESS]");
		//Util.generateAlert(driver, "Clicking on the login button");
	}
	
	@Test(priority = 5)
	public void refreshPageTest() {
		Util.refreshBrowserByJS(driver);
		System.out.println("[PAGE REFRESHED SUCCESSFULLY]");
	}
	
	@Test(priority=6)
	public void scrollDownPageTest() throws InterruptedException {
		WebElement nextBtn = driver.findElement(By.xpath("//button[@data-direction='next']"));
		Util.scrollIntoView(nextBtn, driver);
		Thread.sleep(3000);
		Util.flash(nextBtn, driver);
		Util.clickElementByJS(nextBtn, driver);
		System.out.println("[SCROLLED TILL {NEXT} BUTTON THEN CLICKED SUCCESSFULLY]");
		Thread.sleep(3000);
	}

	@AfterMethod
	public void signout() throws InterruptedException {

		System.out.println("user has logged out");
		Thread.sleep(2000);
		//Util.generateAlert(driver, "Logged out successfully");
	}
}
