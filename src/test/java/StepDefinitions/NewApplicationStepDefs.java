package StepDefinitions;

import Pages.Homepage;
import Pages.LoanApplicationPage;
import Pages.LoginPage;
import Util.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class NewApplicationStepDefs {

    WebDriver driver = DriverFactory.getDriver();
    private LoanApplicationPage loanApplicationPage = new LoanApplicationPage(driver);
    private LoginPage loginPage = new LoginPage(driver);

    @And("a user enters user and password credentials")
    public void aUserEntersUserAndPasswordCredentials() {
        loginPage.enterUsername("user");
        loginPage.enterPassword("password");
        System.out.println("The user has entered user and password in their respective fields");
    }

    @When("a user fills out the loan application form")
    public void aUserFillsOutTheLoanApplicationForm(DataTable dataTable) {
        Map<String, String> userDetails = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> entry : userDetails.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        loanApplicationPage.enterAllFields("name", userDetails.get("fullname"));
        loanApplicationPage.enterAllFields("age", userDetails.get("age"));
        loanApplicationPage.enterAllFields("addressLine1", userDetails.get("addressline1"));
        loanApplicationPage.enterAllFields("addressLine2", userDetails.get("addressline2"));
        loanApplicationPage.enterAllFields("addressLine3", userDetails.get("addressline3"));
        loanApplicationPage.enterAllFields("addressLine4", userDetails.get("addressline4"));
        loanApplicationPage.enterAllFields("postCode", userDetails.get("postcode"));
        loanApplicationPage.enterAllFields("email", userDetails.get("email"));
        loanApplicationPage.enterAllFields("amount", userDetails.get("loanamount"));
        System.out.println("The user enters information into the fields");
    }

    @And("the user clicks submit")
    public void theUserClicksSubmit() {
        loanApplicationPage.clickSubmit();
        System.out.println("The user clicks submit");
    }

    @Then("the user has submitted the form")
    public void theUserHasSubmittedTheForm() {
        Assert.assertEquals("Result", loanApplicationPage.getResultHeader());
        System.out.println("The user has submitted the form");
    }
}
