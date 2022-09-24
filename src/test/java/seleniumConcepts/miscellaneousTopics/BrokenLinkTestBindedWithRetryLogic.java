package seleniumConcepts.miscellaneousTopics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

//Ex- @Test(retryAnalyzer = base.Retry.class)  ==> Use this line and bind your test case through retry logic and then your test will
// rerun if it fails  up to the maxRetryCount.

public class BrokenLinkTestBindedWithRetryLogic extends BaseClass {
	@BeforeMethod
	public void signin() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("user has logged in");
	}

	@Test(retryAnalyzer = base.Retry.class)
	public void brokenLinkValidation() throws Exception, IOException {
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		for(WebElement link : links) {
			String url = link.getAttribute("href");
			
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			
			int resCode = conn.getResponseCode();
			System.out.println(resCode);
			
			if(resCode > 400) {
				System.out.println("The link with the text "+link.getText()+" is broken with the status code "+resCode);
				Assert.assertTrue(false);  //Hard Assertion (Not recommended for the broken link validation)
			}
		}
	}

	@AfterMethod
	public void signout() throws InterruptedException {

		System.out.println("user has logged out");
		Thread.sleep(2000);
	}
}
