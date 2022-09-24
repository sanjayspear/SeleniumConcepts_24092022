package seleniumConcepts.miscellaneousTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import base.Util;

public class ValidateSuccessfulLoginTrroughAssertion extends BaseClass {

	@BeforeMethod
	public void signin() throws InterruptedException {

		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		WebElement forgotPasswordLink = driver.findElement(By.cssSelector("div.forgot-pwd-container [href]"));
		forgotPasswordLink.click();

		Util.explicitWait(driver, 15, forgotPasswordLink);

		driver.findElement(By.cssSelector("button.go-to-login-btn"));

		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("john@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("5832274159");

		driver.findElement(By.cssSelector("button[class*='reset-pwd']")).click();

		String s1 = driver.findElement(By.xpath("//p[contains(text(), 'Please use temporary password ')]")).getText();
		String s2 = s1.replaceAll("['.]", "");
		String pwd = (s2.split(" "))[4].trim();
		
		/*
		 * //Note: You can also split without using replaceAll() method:
		 * 
		 * String s2 = s1.split("'")[1].split("'")[0];
		 * 
		 * System.out.println(s2);
		 */

		WebElement GoToLoginWindow = driver.findElement(By.xpath("//button[contains(@class, 'go-to-login-btn')]"));
		GoToLoginWindow.click(); // Regular Expression

		WebElement userName = driver.findElement(By.cssSelector("input#inputUsername"));
		Util.explicitWait(driver, 20, userName);
		userName.sendKeys("rahul");

		WebElement password = driver.findElement(By.cssSelector("input[type*='pass']"));
		Util.explicitWait(driver, 20, password);
		password.sendKeys(pwd);

		WebElement SignButton = driver.findElement(By.xpath("//button[@class='submit signInBtn']"));
		Util.explicitWait(driver, 20, SignButton);

		SignButton.click();
		System.out.println("user has logged in");
	}

	@Test()
	public void codepenAppTest() throws InterruptedException {

		WebElement successfulLoginMessage = driver
				.findElement(By.xpath("//p[text()='You are successfully logged in.']"));
		Util.explicitWait(driver, 20, successfulLoginMessage);
		String successfulLogin = successfulLoginMessage.getText();
		System.out.println(successfulLogin);
		
		Assert.assertEquals(successfulLogin, "You are successfully logged in.", "Test Failed ");

	}

	@AfterMethod
	public void signout() throws InterruptedException {
		WebElement logout = driver.findElement(By.xpath("//button[text()='Log Out']"));
		Util.explicitWait(driver, 20, logout);
		Thread.sleep(2000);
		logout.click();
		System.out.println("User has logged out successfully");
	}

}
