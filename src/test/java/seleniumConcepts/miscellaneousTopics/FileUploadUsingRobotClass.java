package seleniumConcepts.miscellaneousTopics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class FileUploadUsingRobotClass extends BaseClass {

	@BeforeMethod
	public void signin() throws InterruptedException {
		driver.get("https://www.monsterindia.com/seeker/registration?");
		//JavascriptExecutor j = (JavascriptExecutor)driver;
	    //j.executeScript("scroll(0,500)");
		System.out.println("user has logged in");
	}
	
	@Test
	public void FileUploadTest() throws AWTException, InterruptedException {
		// file path passed as parameter to StringSelection
	      StringSelection s = new StringSelection("C:\\Users\\SANJAY YM\\OneDrive\\Desktop\\upload.txt");
	      
	      Thread.sleep(3000);
	      // Clipboard copy
	      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
	      //identify element and click
	      driver.findElement(By.xpath("//*[text()='Choose file']")).click();
	      // Robot object creation
	      Robot r = new Robot();
	      //pressing enter
	      r.keyPress(KeyEvent.VK_ENTER);
	      //releasing enter
	      r.keyRelease(KeyEvent.VK_ENTER);
	      //pressing ctrl+v
	      r.keyPress(KeyEvent.VK_CONTROL);
	      r.keyPress(KeyEvent.VK_V);
	      //releasing ctrl+v
	      r.keyRelease(KeyEvent.VK_CONTROL);
	      r.keyRelease(KeyEvent.VK_V);
	    //pressing enter
	      r.keyPress(KeyEvent.VK_ENTER);
	      //releasing enter
	      r.keyRelease(KeyEvent.VK_ENTER);
	}

	@AfterMethod
	public void signout() throws InterruptedException {
		System.out.println("user has logged out");
		Thread.sleep(2000);
	}

}
