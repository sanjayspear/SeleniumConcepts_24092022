package base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;

import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor arg2, Method arg3) {
		// TODO Auto-generated method stub

		annotation.setRetryAnalyzer(Retry.class);

	}

}
