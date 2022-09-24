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
import org.testng.asserts.SoftAssert;

import base.BaseClass;

/*Broken Link Info:
 *  
 *  Step-1: To get all the urls tied up to the links using selenium.
 *  Step-2: We need to use java methods to get the status code of the URL.
 *  Step-3: If status code is > 400 then url is not working.
 *  
 *  NOTE: 200 status code indicates URL is working
 *  
 *  //a[href*='soapui']
 *  
 *  NOTE: It's always good to use soft assertion while you validate broken links.
 *  
 *      because, if in cause you are validating around 100 links 10th link is broken and during this case if you would have used hard assertion
 *      then, remaining 90 links will be ignored and we cannot proceed further for the broken link validation for the rest of the links.
 *      So, we should use SOFT ASSERTION instead of HARD ASSERTION.
 *      
 *      SOFT ASSERTION: If assertion fails soft assertion will not stop the test execution. Instead it simply store all the failure log and then
 *                      report at last once the test is completed.
 *                      
 *                 a.assertAll(); ==> once the test execution is completed if any test is failed then ultimately this line fail that script.
 *  
 * */

public class SoftAssertionTest extends BaseClass {
	@BeforeMethod
	public void signin() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("user has logged in");
	}

	@Test
	public void brokenLinkValidation() throws Exception, IOException {
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

		SoftAssert a = new SoftAssert();

		for (WebElement link : links) {
			String url = link.getAttribute("href");

			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();

			int resCode = conn.getResponseCode();
			System.out.println(resCode);

			a.assertTrue(resCode < 400,
					"The link with the text " + link.getText() + " is broken with the status code " + resCode);

		}
		// once the test execution is completed if any test is failed then ultimately
		// this line fail that script

		a.assertAll();
	}

	@AfterMethod
	public void signout() throws InterruptedException {

		System.out.println("user has logged out");
		Thread.sleep(2000);
	}
}
