package seleniumConcepts.dynamicWebTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTableSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		//scrolling

		JavascriptExecutor js =(JavascriptExecutor)driver;

		js.executeScript("window.scrollBy(0,570)");

		//rowSize

		List<WebElement> row = driver.findElements(By.cssSelector("table[id='product']:nth-child(2) tr "));

		int rowCount = row.size();

		System.out.println("The number of rows in the table is "+rowCount);

		//columnSize

		List<WebElement> column= driver.findElements(By.cssSelector("table[id='product']:nth-child(2) tr th"));

		int columnSize=column.size();

		System.out.println("The number of columns in  the table is "+columnSize);

		//courseDetails

		String content = driver.findElement(By.cssSelector("table[id='product']:nth-child(2) tr:nth-child(3)")).getText();
		
		System.out.println("The second course details are "+content);
		
		driver.close();
		driver.quit();

	}

}
