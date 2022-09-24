package seleniumConcepts.dynamicWebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class DynamicTableAssignment extends BaseClass {
	
	@BeforeMethod
	public void signin() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("user has logged in");
	}

	@Test
	public void dynamicWebTableTest() throws InterruptedException {
		// .tableFixHead td:nth-child(4)

		// Note: Go to your console and type window.scrollBy(0, 500 and validate

		// Full window scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 600)");

		Thread.sleep(3000);

		int numRows = driver.findElements(By.xpath("//table[@name='courses']//tr")).size();
		int numCol = driver.findElements(By.xpath("//table[@name='courses']//th")).size();

		System.out.println("Number of rows " + numRows);
		System.out.println("Number of cols " + numCol);

		List<WebElement> ele = driver.findElements(By.xpath("(//table[@name='courses']//tr)[3]//td"));
		int cellSize = ele.size();

		for (int i = 0; i < cellSize; i++) {
             String str = ele.get(i).getText();
             System.out.println(str);
		}

		System.out.println("Cell Size " + cellSize);

	}

	@AfterMethod
	public void signout() throws InterruptedException {

		System.out.println("user has logged out");
		Thread.sleep(2000);
	}
}
