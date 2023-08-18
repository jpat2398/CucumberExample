package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoanApplicationPage extends BasePage{

    public LoanApplicationPage(WebDriver driver) {
        super(driver);
    }

    private static final By SUBMIT_BUTTON = By.cssSelector("button[type='submit']");

    private static final By RESULT_HEADER = By.cssSelector("h1");

    public void clickSubmit() {waitAndClick(SUBMIT_BUTTON);}

    public String getResultHeader() {return getElementText(RESULT_HEADER);}

    public void enterAllFields(String key, String input){
        WebElement textField = driver.findElement(By.id(key));
        textField.clear();
        textField.sendKeys(input);
    }
}
