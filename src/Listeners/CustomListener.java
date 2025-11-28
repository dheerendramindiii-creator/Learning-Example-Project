package Listeners;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;


public class CustomListener implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        System.out.println("For starting-----------Start test");
    }
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("For Finishing ----------Finish test");
    }
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Starting Method");
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Skipping Method");
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Method successful");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = extractDriver(result.getInstance());

        if (driver != null) {
            try {
                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Files.createDirectories(Path.of("screenshots"));
                Path dest = Path.of("screenshots", result.getName() + ".png");
                Files.copy(srcFile.toPath(), dest, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("📸 Screenshot saved for failed test: " + result.getName());
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("⚠️ No WebDriver found for test: " + result.getName());
        }
    }

    private WebDriver extractDriver(Object testInstance) {
        try {

            return (WebDriver) testInstance.getClass().getDeclaredField("driver").get(testInstance);
        } catch (Exception ignored) {
            return null;
        }
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test failed but within test result");
    }
}
