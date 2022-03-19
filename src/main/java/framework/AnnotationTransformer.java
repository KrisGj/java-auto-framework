package framework;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Allows for the configuration and modification of TestNG annotations during runtime.
 */
public class AnnotationTransformer implements IAnnotationTransformer {

    /**
     * Invokes transform method for each test during a test run, adding a retry for each failed test.
     */
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}