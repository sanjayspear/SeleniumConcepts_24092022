package seleniumConcepts.exceptions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class ExceptionsDemo extends BaseClass {

	Logger log = Logger.getLogger(ExceptionsDemo.class);

	@BeforeMethod
	public void appLogin() throws InterruptedException {
		log.info("WebApp launch in progress");
		driver.get("https://learn.letskodeit.com/");
		log.info("WebApp launched successfully ");

		log.info("Clicked on Login");
		WebElement login = driver.findElement(By.xpath("//a[@class='navbar-link fedora-navbar-link']"));
		try {
			login.click();
		} catch (Exception e3) {
			log.error("Incorrect Locator for the password field button" + e3);
		}

		/*
		 * From the Base Class just comment out implicit and page load timeout you will
		 * get see the NoSuchElementException //Just update your locator wrongly then
		 * you get again NoSuchElementException
		 */
		log.info("Enter the user name");
		WebElement username = driver.findElement(By.xpath("//input[@name='email']"));
		try {
			username.sendKeys("rahul@gmail.com");
		} catch (Exception e2) {
			log.error("Incorrect Locator for the password field button" + e2);
		}

		log.info("Enter the password");
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		try {
			password.sendKeys("rahul@123");
		} catch (Exception e1) {
			log.error("Incorrect Locator for the password field button" + e1);
		}

		WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
		log.info("Clicked on submit button");
		try {
			submit.click();
		} catch (Exception e) {
			log.error("Incorrect Locator for submit button" + e);
		}
	}

	@Test
	public void noSuchElementExceptionTest() {
		log.info("Redirected to the practice cource page ...");
		driver.navigate().to("https://courses.letskodeit.com/practice");

		log.info("Search for Cource");
		WebElement searchForCource = driver.findElement(By.xpath("//input[@placeholder='Search Course']"));
		try {
			searchForCource.sendKeys("Java");
		} catch (Exception e) {
			log.info("no such element unable to locate element");
		}
	}
	
	@Test
	public void elementNotInteractable() {
		
	}

	@AfterMethod
	public void appLogout() {
		log.info("Trying to logout ...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			log.error("Logout Failed");
		}
		log.info("Logged out successful");
	}
}
