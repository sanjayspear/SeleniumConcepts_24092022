package seleniumConcepts.locatorsPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import base.Util;

//In the following example we are going to handle ElementClickInterceptedException

public class ElementNotInteractableExceptionConcept extends BaseClass {

	@BeforeMethod
	public void signin() throws InterruptedException {
		// driver.get("https://codepen.io/login");
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		System.out.println("user has logged in");
	}

	@Test(retryAnalyzer = base.Retry.class)
	public void codepenAppTest() throws InterruptedException {
		// Other xpath : //div[@class='forgot-pwd-container']
		// By By = org.openqa.selenium.By.linkText("Forgot your password?");

		WebElement forgotPasswordLink = driver.findElement(By.cssSelector("div.forgot-pwd-container [href]"));
		forgotPasswordLink.click();

		// You should make your script to wait to complete slider transition, to avoid
		// "ElementInterceptedException".

		// Why do we get 'ElementInterceptedException': ==> probably when application is
		// changing state from one view to another
		// then we get this exception. In that case we might need to wait until that
		// view get stable. We can handle through
		// ExplicitWait.
		Util.explicitWait(driver, 15, forgotPasswordLink);

		driver.findElement(By.cssSelector("button.go-to-login-btn"));

		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("john@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("5832274159");

		// button[class='reset-pwd-btn']
		driver.findElement(By.cssSelector("button[class*='reset-pwd']")).click(); // Usage of CSS Regular Expression

		//NOTE: Here we used replaceAll() method to remove special characters from the given string.
		String s1 = driver.findElement(By.xpath("//p[contains(text(), 'Please use temporary password ')]")).getText();
		String s2 = s1.replaceAll("['.]", "");
		String pwd = (s2.split(" "))[4].trim();
        
		//div[@class='forgot-pwd-btn-conainer']/button[1]  or //button[contains(@class, 'go-to-login-btn')]  ==> Both are valid xpath
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

		Thread.sleep(3000);
		
		WebElement logout = driver.findElement(By.xpath("//button[text()='Log Out']"));
		Util.explicitWait(driver, 20, logout);
		logout.click();
	}

	@AfterMethod
	public void signout() throws InterruptedException {
		System.out.println("user has logged out");
		Thread.sleep(2000);
	}

}
