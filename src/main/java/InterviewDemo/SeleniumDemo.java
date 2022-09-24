package InterviewDemo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import base.BaseClass;

public class SeleniumDemo extends BaseClass {
	Logger log = Logger.getLogger(SeleniumDemo.class);
	

	@BeforeMethod
	public void loginToApp() {

	}

	@Test()
	public void validateAcceptAllCookiesTest(){
	  
	}

	@AfterMethod
	public void loginOut() {
		
	}
}
