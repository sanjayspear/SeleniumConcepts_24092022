package seleniumConcepts.miscellaneousTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class ColorCodeVerification extends BaseClass {

	@BeforeMethod
	public void signin() throws InterruptedException {
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
		System.out.println("user has logged in");
	}
	
	@Test
	public void verifyButtonColorTest() {
		String expectedColorCode = "#1d8ea0";
		
		String col = driver.findElement(By.xpath("//input[@id='signInBtn']")).getCssValue("background-color");
		String actualColorCode = Color.fromString(col).asHex();
		          
		org.testng.Assert.assertEquals(actualColorCode, expectedColorCode, "Test Failed");	
	}
	
	
	@AfterMethod
	public void signout() throws InterruptedException {

		System.out.println("user has logged out");
		Thread.sleep(2000);
	}
	
}
