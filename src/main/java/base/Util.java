package base;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {

	public static void switchToChildWindow(WebDriver driver, String parent, Set<String> child) {

		for (String childWindow : child) {
			if (!parent.equals(child)) {
				driver.switchTo().window(childWindow);
			}
		}
	}

	public static void explicitWait(WebDriver driver, int wait, WebElement ele) {
		WebDriverWait w = new WebDriverWait(driver, wait);
		w.until(ExpectedConditions.visibilityOf(ele));
	}

	public static int switchToFrame(int totalFrameCount, String locator, WebDriver driver) {
		for (int i = 0; i < totalFrameCount; i++) {
			driver.switchTo().frame(i);
			int count = driver.findElements(By.xpath(locator)).size();

			if (count > 0) {
				return count;
			} else {
				return 0;
			}
		}
		return 0;
	}

	public static void flash(WebElement element, WebDriver driver) {

		String bgcolor = element.getCssValue("background-color");

		for (int i = 0; i < 6; i++) {
			changeColor("#DE3163", element, driver);
			changeColor(bgcolor, element, driver);
		}
	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}

	}

	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("arguments[0].style.border='3px solid red'", element);

	}
	
	public static void takeScreenshot(WebDriver driver)  {
		File src = (File) ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest = new File("C:\\Users\\SANJAY YM\\eclipse-workspace\\SeleniumCocepts\\screenshots\\codepen.png");
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			System.out.println("Screenshot location not found");
		}
	}
	
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		String title = js.executeScript("return document.title;").toString();
		
		return title;

	}
	
	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("arguments[0].click()", element);
	}
	
	public static void scrollIntoViewAndClickByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;

		jse.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("alert('"+message+"')");
	}
	
	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("history.go(0)");
	}
	
	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public static void sendKeysByJS(WebElement element, WebDriver driver, String text) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].value = '" + text + "'", element);
	}

}
