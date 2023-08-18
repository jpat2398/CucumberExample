package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By USERNAME_FIELD = By.id("username");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By SIGN_IN_BUTTON = By.xpath("//input[@value='Sign In']");
    private static final By SIGNED_OUT_HEADER = By.cssSelector("div[class=\"alert alert-info\"]");
    private static final By SIGN_IN_HEADER = By.xpath("//fieldset/h1");

    public void enterUsername(String userName) {findAndType(USERNAME_FIELD, userName);}
    public void enterPassword(String password) {findAndType(PASSWORD_FIELD, password);}
    public void clickSignIn() {waitAndClick(SIGN_IN_BUTTON);}
    public String getSignedOutHeader() {return getElementText(SIGNED_OUT_HEADER);}
    public String getSignInHeader() {return getElementText(SIGN_IN_HEADER);}
}
