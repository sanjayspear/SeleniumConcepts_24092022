package seleniumConcepts.miscellaneousTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class getAttributeTest extends BaseClass {

	@BeforeMethod
	public void signin() throws InterruptedException {
		driver.get("https://phptravels.com/demo/");
		System.out.println("user has logged in");
	}
	
	@Test
	public void verifyGetAttributeTest() {
		WebElement img = driver.findElement(By.xpath("//img[@class='center-block img-responsive']"));
		String imgSrc = img.getAttribute("src");
		
		//Fetching the image source
		System.out.println("The image source is : "+imgSrc);
		
		//Fetching the placeholder value
		
		WebElement name = driver.findElement(By.name("first_name"));
		String expectedPlaceholde = "First Nam";
		
		String actualPlaceholder = name.getAttribute("placeholder");
		
		Assert.assertEquals(actualPlaceholder, expectedPlaceholde);
	}
	
	
	@AfterMethod
	public void signout() throws InterruptedException {

		System.out.println("user has logged out");
		Thread.sleep(2000);
	}
	
	/*Q. What is getAttribute() ?
	 * 
	 * The getAttribute() method helps to get the value of any attribute of a web
	 * element, which is returned as a String. If an attribute has a Boolean value,
	 * the method returns either True or null. Also, if there is no attribute, the
	 * method will return null.
	 * 
	 * Q. When to Use getAttribute()?
	 * 
       Consider a scenario where you need to verify the placeholder text on an input field or maybe the image source or even the field’s 
       dimensions. This is where the getAttribute() method comes to the rescue. You just have to find the web element that contains the 
       attribute and use the getAttribute() method to find its value.
	 */
}
