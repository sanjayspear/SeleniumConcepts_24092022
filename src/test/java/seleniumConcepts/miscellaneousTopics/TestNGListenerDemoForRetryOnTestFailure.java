package seleniumConcepts.miscellaneousTopics;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class TestNGListenerDemoForRetryOnTestFailure extends BaseClass {

	@Test(retryAnalyzer = base.Retry.class)
	public void LaunchApp() {
		driver.get("https://ebay.com");
		Assert.assertTrue(false);
	}

}
