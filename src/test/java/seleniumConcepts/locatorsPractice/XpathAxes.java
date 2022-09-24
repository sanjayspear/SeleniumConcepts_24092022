package seleniumConcepts.locatorsPractice;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import base.Util;

public class XpathAxes extends BaseClass {

	Logger log = Logger.getLogger(XpathAxes.class);

	@BeforeMethod
	public void signin() throws InterruptedException {
		log.info("Opened rediff.com web page");
		driver.get("https://money.rediff.com/gainers");
	}

	@Test
	public void xpathAxesTest() {
		log.info("Test Started ...");

		//  self::a  ==> Meaning Node itself: It represent same element
		// WebElement text = driver.findElement(By.xpath("//a[contains(text(), 'Kwality Pharmaceutic')]/self::a"));
		 //Util.explicitWait(driver, 20, text);
		//String text1 = text.getText();
		//String text2 = driver.findElement(By.xpath("//a[contains(text(), 'LGB Forge Ltd.')]/parent::td")).getText();
		//System.out.println("==================================================================================================");
		//log.info("Company name : "+text1);
		//log.info("Company name : "+text2);
		//System.out.println("==================================================================================================");
		
		WebElement company = driver.findElement(By.xpath("//a[contains(text(), 'LGB Forge Ltd.')]/ancestor::tr//td[1]"));
		WebElement group = driver.findElement(By.xpath("//a[contains(text(), 'LGB Forge Ltd.')]/ancestor::tr//td[2]"));
		WebElement prevCloseRs = driver.findElement(By.xpath("//a[contains(text(), 'LGB Forge Ltd.')]/ancestor::tr//td[3]"));
		WebElement currentPrice = driver.findElement(By.xpath("//a[contains(text(), 'LGB Forge Ltd.')]/ancestor::tr//td[4]"));
		WebElement changePercentage = driver.findElement(By.xpath("//a[contains(text(), 'LGB Forge Ltd.')]/ancestor::tr/child::td[5]"));
		
		List<WebElement> childs = driver.findElements(By.xpath("//a[contains(text(), 'LGB Forge Ltd.')]/ancestor::tr/child::td"));
		
		System.out.println("No. of child elements :: "+childs.size());
		System.out.println("==================================================================================================");

		log.info("Company :: "+company.getText());
		log.info("Group :: "+group.getText());
		log.info("Previous Close :: "+prevCloseRs.getText());
		log.info("Current Price :: "+currentPrice.getText());
		log.info("%Change :: "+changePercentage.getText());
		
		System.out.println("==================================================================================================");
		
		log.info("Test Completed ...");
	}

	@AfterMethod
	public void signout() throws InterruptedException {
		log.info("Logged out");
		Thread.sleep(2000);
	}

}
