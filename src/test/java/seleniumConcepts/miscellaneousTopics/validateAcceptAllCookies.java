package seleniumConcepts.miscellaneousTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import InterviewDemo.SeleniumDemo;
import base.BaseClass;
import base.Util;

public class validateAcceptAllCookies extends BaseClass {
	Logger log = Logger.getLogger(SeleniumDemo.class);

	@BeforeMethod
	public void loginToApp() {
		log.info("Looged In ...");
		driver.get("https://test.io/coverage/website-testing");
	}

	@Test(priority = 1)
	public void validateAcceptAllCookiesTest() throws InterruptedException {

		WebElement acceptAllButton = driver.findElement(By.xpath("//button[text()='Accept All']"));

		Util.explicitWait(driver, 10, acceptAllButton);

		Util.flash(acceptAllButton, driver);

		Util.scrollIntoViewAndClickByJS(acceptAllButton, driver);

	}

	@Test(priority = 2)
	public void flashTest() throws InterruptedException {

		WebElement qaExpertButton = driver.findElement(By.xpath("//a[text()='TALK TO QA EXPERTS']"));

		Util.explicitWait(driver, 10, qaExpertButton);

		Util.flash(qaExpertButton, driver);
	}

	@BeforeMethod
	public void loginOut() {
		log.info("Logged Out");
	}
}
