package seleniumConcepts.javaStreamsLamdaExpression;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class FetchWebTablePriceUsingStream extends BaseClass {
	@BeforeMethod
	public void signin() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		System.out.println("user has logged in");
	}

	@Test
	public void webtablePriceFetchtest() {
		List<WebElement> vegListWebElements = driver.findElements(By.xpath("//tr/td[1]"));

		List<String> price = vegListWebElements.stream().filter(v -> v.getText().contains("Beans"))
				.map(v -> getPriceVeggies(v)).collect(Collectors.toList());
		
		System.out.println(price);

		 price.forEach(v -> System.out.println(v));
		
	}

	private static String getPriceVeggies(WebElement v) {
		String priceValue = v.findElement(By.xpath("following-sibling::td[1]")).getText();
		System.out.println(priceValue);
		return priceValue;
	}

	@AfterMethod
	public void signout() throws InterruptedException {
		System.out.println("User has logged out");
		Thread.sleep(2000);
	}
}
