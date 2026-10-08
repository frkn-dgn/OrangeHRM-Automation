package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.Hooks;

public class LoginStep {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Given("user is on the OrangeHRM login page")
    public void userOrangeHRMLoginPage() {
        Hooks.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(Hooks.driver);
    }

    @When("user enters username {string}")
    public void userEntersUsername(String username) {
        loginPage.enterUsername(username);
    }

    @And("user enters password {string}")
    public void userEntersPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("user clicks the login button")
    public void userClicksTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("user should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        dashboardPage = new DashboardPage(Hooks.driver);
        dashboardPage.assertDashboardDisplayed();
    }

    @When("user enters valid username")
    public void userEntersValidUsername() {
        loginPage.enterUsername("Admin");
    }
    @And("user enters invalid password")
    public void userEntersInvalidPassword() {
        loginPage.enterPassword("13213");
    }
    @Then("login error message should be displayed")
    public void loginErrorMessageShouldBeDisplayed() {
    loginPage.assertLoginErrorMessage();
    }
    @Then("required field messages should be displayed")
    public void requiredFieldMessagesShouldBeDisplayed() {
    loginPage.assertRequiredFieldMessages();
    }
}