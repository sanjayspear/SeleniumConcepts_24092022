package seleniumConcepts.ajaxCallsChildWindowsIFrame;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class WindowHandleDemo extends BaseClass {

	@BeforeMethod
	public void signin() throws InterruptedException {
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
		System.out.println("user has logged in");
	}

	@Test
	public void academyTest() throws InterruptedException {
		WebElement ele = driver.findElement(By.cssSelector("body > .blinkingText"));
		Thread.sleep(3000);
		ele.click();
		Thread.sleep(3000);

		/*
		 * Note: Though you clicked open the new window, still you driver pointing to
		 * the parent window. It won't switch automatically to the child window. We must
		 * switch explicitly.
		 * 
		 * Note: We get NoSuchElement Exception, If you try to perform action on child
		 * window without switching it.
		 */

		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		
		for (String childWindow : child) {
			if (!parent.equals(child)) {
				driver.switchTo().window(childWindow);
			}
		}

		ele = driver.findElement(By.xpath("//p[@class='im-para red']"));
		String text = ele.getText();

		/*
		 * Note: Here we got complete paragraph but we want only email address out of
		 * it. So we need use some java's split string concept to fetch only the part of the text out of
		 * the paragraph.
		 * 
		 * Copy that partial text and switch back to your parent window and paste it.
		 */

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
