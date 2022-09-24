package base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	Logger log = Logger.getLogger(BaseClass.class);

	public WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		log.info("Initializing the ChromeDriver");
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		log.info("Maximixe the window");
		driver.manage().window().maximize();
		log.info("Implicit wait for max 10 SECONDS");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("Page Load Timeout for max 10 SECONDS");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		log.info("Delete All Cookies");
		driver.manage().deleteAllCookies();
		log.info("Static thread wait for 3 seconds");
		Thread.sleep(3000);
	}

	@AfterSuite
	public void end() {

		log.info("Close the browser");
		driver.close();
		log.info("Quit the browser");
		driver.quit();
	}

}
