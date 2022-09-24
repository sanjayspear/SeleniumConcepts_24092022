package seleniumConcepts.miscellaneousTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

/*Selenium by default cannot handle hidden elements and throws ElementNotVisibleException while working with them. 
Javascript Executor is used to handle hidden elements on the page. Selenium runs the Javascript commands w
ith the executeScript method. The commands to be run are passed as arguments to the method.*/

//In Interview: Where did you used java script executor to find hidden element:

    //1. In our framework selenium click actions are defined as generic methods and each method verifies if element is hidden or not using
    // the isDisplayed() method. If not displayed then go to else block and pesform click action using the javascript executor.

public class HiddenElementTest extends BaseClass {
	@BeforeMethod
	public void signin() throws InterruptedException {
		driver.get("https://learn.letskodeit.com/p/practice");
		System.out.println("user has logged in");
	}

	@Test
	public void validateHiddenElement() {
		// identify element and click
		driver.findElement(By.id("hide-textbox")).click();
		// Javascript executor class with executeScript method
		JavascriptExecutor j = (JavascriptExecutor) driver;
		// identify element and set value
		j.executeScript("document.getElementById('displayed-text').value='Selenium';");
		String s = (String) j.executeScript("return document.getElementById('displayed-text').value");
		System.out.print("Value entered in hidden field: " + s);

	}

	@AfterMethod
	public void signout() throws InterruptedException {
		System.out.println("user has logged out");
		Thread.sleep(2000);
	}
}
