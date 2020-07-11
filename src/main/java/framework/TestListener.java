package framework;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.util.Set;

public class TestListener implements ITestListener {

    @Override
    public void onFinish(ITestContext context) {
        Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
        for (ITestResult temp : failedTests) {
            ITestNGMethod method = temp.getMethod();
            if (context.getFailedTests().getResults(method).size() > 1) {
                failedTests.remove(temp);
            } else {
                if (context.getPassedTests().getResults(method).size() > 0) {
                    failedTests.remove(temp);
                }
            }
        }
        System.out.println("TEST RUN STARTED AT: " + context.getStartDate() + ", AND ENDED AT: " + context.getEndDate());
    }

    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("PASSED: " + result.getTestClass().getName() + " ==> " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("FAILED: " + result.getTestClass().getName() + " ==> " + result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIPPED: " + result.getTestClass().getName() + " ==> " + result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }
}
