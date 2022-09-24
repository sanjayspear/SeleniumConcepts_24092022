package seleniumConcepts.miscellaneousTopics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import base.Util;

public class ValidateIfUIElementsEnabledOrDisabledUsingAttributes extends BaseClass {

	@BeforeMethod
	public void loginToSpiceJetApp() {
		driver.get("https://www.spicejet.com/");
	}

	@Test
	public void validateElementEnabledOrDisabled() throws InterruptedException {
		WebElement radio = driver.findElement(By.xpath("(//div[contains(@class, 'css-1dbjc4n r-zso239')])[2]"));

		Thread.sleep(3000);

		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert Not Present");
		}

		Util.explicitWait(driver, 20, radio);

		radio.click();

		WebElement returnDate = driver.findElement(By.xpath("//div[text()='Return Date']"));

		String attributeValue = returnDate.getAttribute("style");

		if (attributeValue.contains("1")) {
			System.out.println("Date field is enabled");
			Assert.assertTrue(true);
		} else {
			System.out.println("Date field is disabled");
			Assert.assertTrue(false);
		}

	}

	@AfterMethod
	public void logout() {

	}
}
