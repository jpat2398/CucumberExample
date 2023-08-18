package StepDefinitions;

import Util.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class FailedTestWatcher implements MethodRule {

    WebDriver driver = DriverFactory.getDriver();

    @Override
    public Statement apply(Statement statement, FrameworkMethod frameworkMethod, Object o) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    statement.evaluate();
                } catch (Throwable throwable) {
                    System.out.println("Test failed, custom failed response message");
                    captureScreenshot(driver, frameworkMethod.getName());
                    throw throwable;
                }
            }

            public void captureScreenshot(WebDriver driver, String testName) {
                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                String targetFilePath = (System.getProperty("user.dir") + "\\target\\screenshots\\failed_test-" + testName + ".png");

                File targetFile = new File(targetFilePath);

                try {
                    FileUtils.copyFile(srcFile, targetFile);
                    System.out.println("Screenshot saved to: " + targetFilePath);
                } catch (IOException screenshotException) {
                    System.out.println("Could not take screenshot for test");
                    screenshotException.printStackTrace();
                }
            }
        };
    }
}
