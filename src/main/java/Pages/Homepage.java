package Pages;

import Util.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage extends BasePage {

    public Homepage(WebDriver driver) {
        super(driver);
    }

    private static String URL = "http://13.40.132.213:8080/";

    public void goTo() {DriverFactory.getDriver().get(URL);}

    private static final By LOAN_APPLICATION_BUTTON = By.cssSelector("a[href=\"/application\"]");
    private static final By USER_FOOTER = By.xpath("//footer/span");
    private static final By LOG_IN_LOG_OUT = By.cssSelector("a[href='/logout']");

    public void clickLoanApplication() {waitAndClick(LOAN_APPLICATION_BUTTON);}
    public String getLoggedInText() {return getElementText(USER_FOOTER);}
    public void clickLogInLogOut() {waitAndClick(LOG_IN_LOG_OUT);}

}
