package seleniumConcepts.miscellaneousTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class TooltipTest extends BaseClass {

	@BeforeMethod
	public void signin() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));

		username.sendKeys("Admin");
		Thread.sleep(1000);
		password.sendKeys("admin123");
		Thread.sleep(1000);
		loginBtn.click();
		Thread.sleep(1000);

		System.out.println("user has logged in");
	}

	@Test
	public void verifyTooltipTest() {
		
	}

	@AfterMethod
	public void signout() throws InterruptedException {

		System.out.println("user has logged out");
		Thread.sleep(2000);
	}

	/*
	 * Tooltip in Selenium
	 * 
	 * A Tooltip in Selenium is a text that appears when a mouse hovers over an
	 * object on a web page. The object can be a link, an image, a button, a text
	 * area, etc. The tooltip text often gives more information about the object on
	 * which the user hovers over the mouse cursor.
	 * 
	 * Tooltips were traditionally implemented as a ‘title’ attribute to an element.
	 * The value of this attribute was shown as a tooltip on mouse-hover. This is a
	 * static text giving information of the element with no styling.
	 * 
	 * Now, there are many plugins available for ‘tool tips’ implementation.
	 * Advanced tooltips with styling, rendering, images and links are being
	 * implemented using JavaScript/JQuery plugins or using CSS Tooltips.
	 * 
	 * For accessing or verifying the static tooltips which are implemented using
	 * the HTML “title” attribute, we can simply use the getAttribute(“title”)
	 * method of the WebElement. The returned value of this method (which is the
	 * tooltip text) is compared with an expected value for verification. For other
	 * forms of tooltip implementations, we will have to use the “Advanced User
	 * Interactions API” provided by the Web Driver to create the mouse hover effect
	 * and then retrieve the tooltip for the element.
	 * 
	 * ==> Tools tip also appears when you submit some form. ==> Delete / Add /
	 * Reset actions. ==> Mouse over actions etc.
	 * 
	 * ==> Tool tip is just like a toast message it comes and disappears within no
	 * time and you don't get enough time to inspect and locate tool tip. In that
	 * case you need to go to the developer tools and
	 */

}
