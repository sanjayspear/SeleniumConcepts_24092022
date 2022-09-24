package seleniumConcepts.ajaxCallsChildWindowsIFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class AutoSuggestiveDropDown extends BaseClass {
	@BeforeMethod
	public void signin() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("user has logged in");
	}

	@Test
	public void AutoSuggestiveDropDownTest() throws InterruptedException {
		// Note: We use build().perform() because we can perform composite actions.
		WebElement ele = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		ele.sendKeys("ind");
		
		Thread.sleep(2000);
		
		ele.sendKeys(Keys.DOWN);
		
		Thread.sleep(1000);
		
		ele.sendKeys(Keys.DOWN);
		
		Thread.sleep(1000);
		
		
		String expectedCountry = "Indonesia";
		String Actualcountry = ele.getAttribute("value");
		
		System.out.println("Country "+Actualcountry);
		
		Assert.assertEquals(Actualcountry, expectedCountry, "[Test Failed] :: [THERE IS A MISMATCH BETWEEN COUNTRY]");
		
		

	}

	@AfterMethod
	public void signout() throws InterruptedException {

		System.out.println("user has logged out");
		Thread.sleep(2000);
	}
}
