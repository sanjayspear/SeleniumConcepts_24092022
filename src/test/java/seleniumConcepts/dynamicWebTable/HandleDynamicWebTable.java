package seleniumConcepts.dynamicWebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class HandleDynamicWebTable extends BaseClass {

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
		js.executeScript("window.scrollBy(0, 500)");

		Thread.sleep(3000);

		// Only web table scroll (Vertical scroll)
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000\r\n");

		Thread.sleep(3000);

		// Note: document.querySelector('.tableFixHead').scrollLeft=10000 ===> Vertical
		// Scroll

		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		String val = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim();
		
		int actualAmount = Integer.parseInt(val);

		int sum = 0;

		for (int i = 0; i < values.size(); i++) {

			String str = values.get(i).getText();
			sum = sum + Integer.parseInt(str);

		}
		
		int expectedAmount = sum;
		
		System.out.println("Actula Amount "+actualAmount+"  &  "+"Expected Amount "+expectedAmount);
		
		System.out.println("Sum of total amout collected "+sum);
		
		Assert.assertEquals(actualAmount, expectedAmount, "Test  Failed due to mismatch between actual and expected");
		

	}

	@AfterMethod
	public void signout() throws InterruptedException {

		System.out.println("user has logged out");
		Thread.sleep(2000);
	}

}
