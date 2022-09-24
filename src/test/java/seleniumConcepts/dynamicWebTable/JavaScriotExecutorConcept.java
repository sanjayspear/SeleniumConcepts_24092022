package seleniumConcepts.dynamicWebTable;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class JavaScriotExecutorConcept extends BaseClass {

	@BeforeMethod
	public void signin() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("user has logged in");
	}

	@Test
	public void dynamicWebTableTest() throws InterruptedException {
		// .tableFixHead td:nth-child(4)

		// Note: Go to your console and type window.scrollBy(0, 500) and validate whether it works or not
		// window.scrollBy(0, 500) ===> It scrolls complete current window and what coordinates to be added is 
		// just a trial and error that we can check through web console editor.
		
		//document.querySelector('AnyWebElement') ===> Is similar to selenium's find by locator
		
		//you can explore many options upon typing (window. ) and (document. ) through web console.

		// Full window scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");

		Thread.sleep(3000);

		// Only web table scroll (Vertical scroll)
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000\r\n");

		Thread.sleep(3000);
		
		//Note: document.querySelector('.tableFixHead').scrollLeft=10000 ===> Vertical Scroll
	}

	@AfterMethod
	public void signout() throws InterruptedException {

		System.out.println("user has logged out");
		Thread.sleep(2000);
	}

}
