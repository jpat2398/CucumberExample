package Util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TestEvaluate {

    public static void captureScreenshot(WebDriver driver, String testName) {
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

}
