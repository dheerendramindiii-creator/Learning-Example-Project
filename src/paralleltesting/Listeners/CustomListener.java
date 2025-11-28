package paralleltesting.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {

    public void onStart(ITestContext arg) {

        System.out.println("Starts Test execution......"+arg.getName());
    }
    public void onFinish(ITestContext arg) {
        System.out.println("Finishes Test execution......"+arg.getName());
    }
    public void onTestStart(ITestResult arg0) {
        System.out.println("Starts Test execution......"+arg0.getName());
    }
    public void onTestSkipped(ITestResult result) {
        System.out.println("Skipped Test execution......"+result.getName());
    }
    public void onTestSuccess(ITestResult arg0) {
        System.out.println("Tests passed......"+arg0.getName());
    }
    public void onTestFailure(ITestResult arg0) {
        System.out.println("Tests failed......"+arg0.getName());
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

    }
}
