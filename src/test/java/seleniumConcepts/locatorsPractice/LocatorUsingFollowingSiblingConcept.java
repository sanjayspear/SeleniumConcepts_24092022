package seleniumConcepts.locatorsPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class LocatorUsingFollowingSiblingConcept extends BaseClass {

	@BeforeMethod
	public void signin() throws InterruptedException {
		// driver.get("https://codepen.io/login");
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		System.out.println("user has logged in");
	}

	@Test
	public void followingSibLing() {
		WebElement ele1 = driver
				.findElement(By.xpath("//header//div//button[text()='Practice']/following-sibling::button[1]"));
		String LoginButtonText = ele1.getText();
		String LoginAuttonAttribute = ele1.getAttribute(LoginButtonText);
		System.out.println("Button Name: " + LoginButtonText);
		System.out.println("Attribute Name: " + LoginAuttonAttribute);

		WebElement ele2 = driver
				.findElement(By.xpath("//header//div//button[text()='Practice']/following-sibling::button[2]"));
		String SignUpButtonText = ele2.getText();
		String SignUpAuttonAttribute = ele2.getAttribute(SignUpButtonText);
		System.out.println("Button Name: " + SignUpButtonText);
		System.out.println("Attribute Name: " + SignUpAuttonAttribute);

		/*
		 * From the below example we traversing from child to parent
		 * 
		 * //header//div//button[text()='Practice']/following-sibling::button[1]/parent::div/parent::header
		 */
	}

	@AfterMethod
	public void signout() throws InterruptedException {
		System.out.println("user has logged out");
		Thread.sleep(2000);
	}

}
