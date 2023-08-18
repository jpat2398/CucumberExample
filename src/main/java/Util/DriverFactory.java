package Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    static {
        WebDriverManager.chromedriver().setup();
    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            setDriver();
        }
        return driver;
    }

    private static void setDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(/*"start-maximized", "incognito", "headless"*/);
        driver = new ChromeDriver(options);
    }

    public static void closeDriver() {
        driver.close();
        driver = null;
    }
}
