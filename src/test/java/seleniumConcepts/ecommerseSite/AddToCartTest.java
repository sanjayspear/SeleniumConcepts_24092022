package seleniumConcepts.ecommerseSite;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class AddToCartTest extends BaseClass {
	@BeforeMethod
	public void signin() throws InterruptedException {

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		System.out.println("Application launched and logged in successfully");
	}

	@Test()
	public void codepenAppTest() throws InterruptedException {

		int count = 0;

		String[] shopList = { "Cucumber", "Beans", "Mushroom" };

		int len = shopList.length;

		List<String> expectedProd = Arrays.asList(shopList);

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			String actualProduct = products.get(i).getText().split("-")[0].trim();

			if (expectedProd.contains(actualProduct)) {

				count++;

				System.out.println("Expected: " + expectedProd + " Actual: " + actualProduct);

				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				Thread.sleep(2000);

				if (count == len) {
					break;
				}

			}
		}
	}

	@AfterMethod
	public void signout() throws InterruptedException {

		System.out.println("User has logged out successfully");
	}
}
