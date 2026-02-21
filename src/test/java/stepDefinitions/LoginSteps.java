package stepDefinitions;

import helper.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;

import java.io.FileNotFoundException;

public class LoginSteps {
    private LoginPage loginPage;
    private TestContext testContext;

    public LoginSteps(TestContext testContext) throws FileNotFoundException {
        this.testContext = testContext;
        loginPage = new LoginPage(testContext.getDriverFactory().getDriver());
    }

    @Given("I am on the login page")
    public void loginPage() {
        loginPage.getUrl("https://automationexercise.com/");
    }

    @When("I login with {string} and {string}")
    public void loginWithCredentials(String userName, String password) {
        loginPage.clickLoginLink();
        loginPage.enterEmail(userName);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }
    @Then("I validate logged in user text as {string}")
    public void validateLogin(String userValue) {
        String loggedUserTxt = loginPage.getLoggedUserTxt();
        System.out.println("loggedUserTxt :"+loggedUserTxt);

        //Storing the value in Scenario Context
        testContext.getScenarioContext().setContext("userText",loggedUserTxt);
        //Retrieving the value from Scenario Context
        Assertions.assertEquals(userValue,testContext.getScenarioContext().getContext("userText"));
    }
    @Then("I validate login error message as {string}")
    public void validateLoginErrorMsg(String errorMessage) {
        String loginErrorMsgTxt = loginPage.getLoginErrorMsgTxt();
        System.out.println("loginErrorMsgTxt :"+loginErrorMsgTxt);

        //Storing the value in Scenario Context
        testContext.getScenarioContext().setContext("loginErrorMsg",loginErrorMsgTxt);
        //Retrieving the value from Scenario Context
        Assertions.assertEquals(errorMessage,testContext.getScenarioContext().getContext("loginErrorMsg"));
    }
    @Given("I click logout from login page")
    public void logoutPage() {
        loginPage.clickLogoutLink();
    }

}
