package seleniumConcepts.ajaxCallsChildWindowsIFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class CompositeActionDemo extends BaseClass {
	@BeforeMethod
	public void signin() throws InterruptedException {
		driver.get("https://www.amazon.com/");
		System.out.println("user has logged in");
	}

	@Test
	public void amazonTest() throws InterruptedException {
		// Note: We use build().perform() because we can perform composite actions.

		Actions a = new Actions(driver);

		WebElement ele = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

		a.moveToElement(ele).click().keyDown(Keys.SHIFT).sendKeys("Honey").doubleClick().build().perform();

	}

	@AfterMethod
	public void signout() throws InterruptedException {

		System.out.println("user has logged out");
		Thread.sleep(2000);
	}
}
