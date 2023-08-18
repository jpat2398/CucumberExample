package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }
    public void waitAndClick(By selector) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selector));
        element.click();
    }
    public void selectDropdown(By selector, String dropdownVisibleText) {
        Select select = new Select(driver.findElement(selector));
        select.selectByVisibleText(dropdownVisibleText);
    }
    public String getElementText(By selector) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        return element.getText();
    }
    public void findAndType(By selector, String input) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selector));
        element.sendKeys(input);
    }
}
