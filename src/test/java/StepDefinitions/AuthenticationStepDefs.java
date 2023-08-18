package StepDefinitions;

import Pages.*;
import Util.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AuthenticationStepDefs {

    WebDriver driver = DriverFactory.getDriver();

    private Homepage homePage = new Homepage(driver);
    private LoginPage loginPage = new LoginPage(driver);

    @Given("a user is on the homepage")
    public void aUserIsOnTheHomepage() {
        homePage.goTo();
        System.out.println("The user is on the Homepage");
    }

    @When("a user clicks on the loan application button")
    public void aUserClicksOnTheLoanApplicationButton() {
        homePage.clickLoanApplication();
        System.out.println("The user is now on the login page");
    }

    @And("a user enters {string} and {string} credentials")
    public void aUserEntersAndCredentials(String userName, String passWord) {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(passWord);
        System.out.println("The user has entered " + userName + " and " + passWord + " in their respective fields");
    }

    @And("a user clicks on the sign in button")
    public void aUserClicksOnTheSignInButton() {
        loginPage.clickSignIn();
        System.out.println("The user has clicked on the \"sign in\" button");
    }

    @Then("^a (admin|user) should be logged in$")
    public void aUserShouldBeLoggedIn(String adminOrUser) {
       Assert.assertTrue("The logged in footer does not contain " + adminOrUser, homePage.getLoggedInText().contains(adminOrUser));
        System.out.println("The user has been signed in");
    }

    @When("a user clicks on the login button")
    public void aUserClicksOnTheLoginButton() {
        homePage.clickLogInLogOut();
        System.out.println("The user is now on the Login page");
    }

    @Then("a log out message is displayed")
    public void aLogOutMessageIsDisplayed() {
        Assert.assertEquals("You have been logged out.", loginPage.getSignedOutHeader());
        System.out.println("The user has been signed out");
    }
}
