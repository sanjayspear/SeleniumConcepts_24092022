package seleniumConcepts.javaStreamsLamdaExpression;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class WebtableSortingUsingStream extends BaseClass {
	@BeforeMethod
	public void signin() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		System.out.println("user has logged in");
		System.out.println("List validation for sorted list test is ==> started");
	}

	@Test
	public void webtableSortingTest() {
		// Click and Sort Veg/fruit column from the VegTable

		driver.findElement(By.xpath("//span[text()='Veg/fruit name']")).click();

		// get all the web elements of vegetables

		List<WebElement> ele = driver.findElements(By.xpath("//tr/td[1]"));

		List<String> originalList = ele.stream().map(s -> s.getText()).collect(Collectors.toList());

		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		if (originalList.equals(sortedList) == true) {
			System.out.println("List is sorted properly ==> test passed");
			Assert.assertTrue(true);
		} else {
			System.out.println("List is not sorted properly ==> test failed");
			Assert.assertTrue(false);
		}

	}

	@AfterMethod
	public void signout() throws InterruptedException {
		System.out.println("List validation for sorted list test is ==> completed");
		System.out.println("user has logged out");
		Thread.sleep(2000);
	}
}
