package base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int maxRetryCount = 6;

	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {
			retryCount++;
			return true;
		}
		return false;
	}
	
	//Note: Now go to any test cases and bind this retry mechanism
	
    //Ex- @Test(retryAnalyzer = base.Retry.class)  ==> Use this line and bind your test case through retry logic and then your test will
	// rerun if it fails  up to the maxRetryCount.
	
	//If threre are 500 test cases then we have to do it for all and it is not the good approach.
	
	//Instead create one RetryLister class and then implement 'IAnnotationTransformer' and Call this listener in our testNG annotation
	//afeter Suite Tag and Before TestTag and call this listener as below and if 300 test cases are failed then add those test cases 
	// in the testng suite as below:
	
	
	//   <?xml version="1.0" encoding="UTF-8"?>
	//   <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
	//   <suite name="Suite">
	
	//      <listeners>
	//           <listener class-name="base.RetryListener"></listener>
	//       </listeners>
	
	//       <test thread-count="5" name="Test">
	//           <classes>
	//                <class name="seleniumConcepts.miscellaneousTopics.TestNGListenerDemoForRetryOnTestFailure"/>
	 //          </classes>
	 //      </test> <!-- Test -->
	
	
	//    </suite> <!-- Suite -->

}
