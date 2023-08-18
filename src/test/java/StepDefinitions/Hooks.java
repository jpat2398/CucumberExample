package StepDefinitions;

import Util.DriverFactory;
import Util.TestEvaluate;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks{

    WebDriver driver = DriverFactory.getDriver();

    @Before
    public void before(){
        System.out.println("This is before");
    }

    @After(order=1)
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Test has failed!");
            TestEvaluate.captureScreenshot(driver, scenario.getName());
        }
    }

    @After(order=0)
    public void after(){
        System.out.println("This is after(0)");
        DriverFactory.closeDriver();
    }
}
