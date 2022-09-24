package seleniumConcepts.throughJSExecutor;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import base.BaseClass;
import base.Util;

public class Log4jDemo extends BaseClass {
	
	Logger log = Logger.getLogger(Log4jDemo.class);
	
	@BeforeMethod
	public void signin() throws InterruptedException {
		log.info("Launch the codepenApp");
		
		driver.get("https://codepen.io/tag/javascript");

        log.info("user has logged in");
        
		//Util.generateAlert(driver, "Currently you are on the [codepen.io] website");
        
        log.info("Static thread wait for 2 seconds");
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void flashingAnElementTest() throws InterruptedException {
		log.info("ELEMENT FLASH TEST STARTED");
		WebElement signUpButton = driver.findElement(By.xpath("//a[@data-test-id='signup-button']"));
		Util.flash(signUpButton, driver);
		//Thread.sleep(2000);
		log.info("[ELEMENT FLASH TEST END]");
		//Util.generateAlert(driver, "Sign Up Button Flasshing");
	}

	@Test(priority = 2)
	public void drawBorderAroundElementTest() throws InterruptedException {
		log.info("[DRAW BORDER TEST around SignIn Button STARTED]");
		WebElement signUpButton = driver.findElement(By.xpath("//a[@data-test-id='signup-button']"));
		Util.drawBorder(signUpButton, driver);
		log.info("[SignIn Button Screenshot STARTED]");
		Util.takeScreenshot(driver);
		log.info("[SignIn Button Screenshot END]");
		//Thread.sleep(2000);
		log.info("[DRAW BORDER TEST around SignIn Button END]");
		//Util.generateAlert(driver, "Border drawn around Sign Up Button");
	}

	@Test(priority = 3)
	public void getTitleTest() throws InterruptedException {
		String title = Util.getTitleByJS(driver);
		//Thread.sleep(2000);
		
		log.info("[WEBSITE TITLE] :: " + title);
		System.out.println();
		log.info("[GET TITLE TEST SUCCESS]");
		//Util.generateAlert(driver, "Getting the title");
	}

	@Test(priority = 4)
	public void clickElementtTest() throws InterruptedException {
		WebElement LoginButton = driver.findElement(By.xpath("//a[text()='Log In']"));
		Util.flash(LoginButton, driver);
		log.info("[DRAW BRODER AROUND LOGIN BUTTON STARTED]");
		Util.drawBorder(LoginButton, driver);
		log.info("[DRAW BRODER AROUND LOGIN BUTTON END]");
		log.info("[CLICLLOGIN BUTTON]");
		Util.clickElementByJS(LoginButton, driver);
		log.info("[LOGIN BUTTON CLICKED");
		
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
		log.info("Static thread wait for 2 seconds");
		Thread.sleep(2000);
		log.info("ABOUT TO NAVIGATE TO THE PREVIOUS PAGE");
		driver.navigate().back();
		log.info("[NAVIGATED BACK SUCCESSFULLY]");
		//Util.generateAlert(driver, "Clicking on the login button");
	}
	
	@Test(priority = 5)
	public void refreshPageTest() {
		log.info("[PAGE REFRESH STARTED]");
		Util.refreshBrowserByJS(driver);
		log.info("[PAGE REFRESH DONE]");
	}
	
	@Test(priority=6)
	public void scrollDownPageTest() throws InterruptedException {
		log.info("[SCROLLED TILL {NEXT} BUTTON TEST STARTED");
		WebElement nextBtn = driver.findElement(By.xpath("//button[@data-direction='next']"));
		Util.scrollIntoView(nextBtn, driver);
		log.info("Static thread wait for 3 seconds");
		Thread.sleep(3000);
		Util.flash(nextBtn, driver);
		Util.clickElementByJS(nextBtn, driver);
		log.info("[SCROLLED TILL {NEXT} BUTTON THEN CLICKED SUCCESSFULLY]");
		log.info("Static thread wait for 3 seconds");
		Thread.sleep(3000);
	}

	@AfterMethod
	public void signout() throws InterruptedException {

		log.info("user has log out Inprogress");
		log.info("Static thread wait for 3 seconds");
		Thread.sleep(2000);
		log.info("user has logged out Successfully");
		//Util.generateAlert(driver, "Logged out successfully");
	}
}
