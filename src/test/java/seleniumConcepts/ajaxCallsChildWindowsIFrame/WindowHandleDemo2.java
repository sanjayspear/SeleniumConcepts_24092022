package seleniumConcepts.ajaxCallsChildWindowsIFrame;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import base.Util;

public class WindowHandleDemo2 extends BaseClass {
	@BeforeMethod
	public void signin() throws InterruptedException {
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
		System.out.println("user has logged in");
	}

	@Test
	public void academyTest() throws InterruptedException {
		WebElement ele = driver.findElement(By.cssSelector("body > .blinkingText"));
		ele.click();

		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		
		Util.switchToChildWindow(driver, parent, child);

		ele = driver.findElement(By.xpath("//p[@class='im-para red']"));
		String text = ele.getText();

		System.out.println(text);

		String emailIdText = ele.getText().split("at")[1].trim().split("with")[0];

		System.out.println(emailIdText);

		driver.switchTo().window(parent);

		Thread.sleep(3000);

		driver.findElement(By.cssSelector("input#username")).sendKeys(emailIdText);

		Thread.sleep(3000);
	}

	@AfterMethod
	public void signout() throws InterruptedException {
		System.out.println("user has logged out");
		Thread.sleep(2000);
	}
}
