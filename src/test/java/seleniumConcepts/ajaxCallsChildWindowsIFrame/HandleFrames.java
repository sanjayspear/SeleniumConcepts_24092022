 package seleniumConcepts.ajaxCallsChildWindowsIFrame;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import base.Util;

public class HandleFrames extends BaseClass {
	
	/* Frames : 
	 * 
	 *  1. Frames is a container which is independent of web page.
	 *  2. It is just hosted on top of any web site.
	 *  3. Before performing any action on frame we must switch to it.
	 *  4. We can switch to frame:
	 *      
	 *        - By Id
	 *        - By Index
	 *        - By WebElement
	 *        
	 *  Switch to frame method is the overloaded method since it allows you to switch using different arguments such as By Id, By Index,
	 *  and By WebElement.
	 * */
	
	//https://jqueryui.com/droppable/
	
	@BeforeMethod
	public void signin() throws InterruptedException {
		driver.get("https://jqueryui.com/droppable/");
		System.out.println("user has logged in");
	}
	
	@Test
	public void dragAndDropTest() {
		int frameCount = driver.findElements(By.tagName("iframe")).size();
		String locator = "//div[@id='draggable']";
		
		    Util.switchToFrame(frameCount, locator, driver);
		
			Actions a = new Actions(driver);
			WebElement draggable = driver.findElement(By.xpath(locator));
			WebElement droppable = driver.findElement(By.id("droppable"));
			
			a.dragAndDrop(draggable, droppable).build().perform();
			driver.switchTo().defaultContent();
		}

	
	
	@AfterMethod
	public void signout() throws InterruptedException {

		System.out.println("user has logged out");
		Thread.sleep(2000);
	}

}
