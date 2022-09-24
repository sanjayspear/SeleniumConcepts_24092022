package seleniumConcepts.miscellaneousTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import base.Util;

public class TraverseForwardAndBackward extends BaseClass {
	@BeforeMethod
	public void signin() throws InterruptedException {

		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		System.out.println("Launced Rahul Shetty academy website");
		
		Thread.sleep(2000);

		driver.navigate().to("https://www.google.com");
		
		System.out.println("Navigated to the google website");
		
		Thread.sleep(2000);
		
		driver.navigate().back();
		
		System.out.println("Traversed back to to the Rahul Shetty academy website");
		
		Thread.sleep(2000);
	}

	@Test()
	public void codepenAppTest() throws InterruptedException {

		System.out.println("Application tested successfully");
	}

	@AfterMethod
	public void signout() throws InterruptedException {
		
		System.out.println("User has logged out successfully");
	}

}
