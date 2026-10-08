package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.EmployeePage;
import utilities.Hooks;

public class EmployeeStep {
    private EmployeePage employeePage;
    private DashboardPage dashboardPage;
    private AddEmployeePage addEmployeePage;

    @And("user clicks the PIM menu")
    public void clickPIMMenu() {
        dashboardPage = new DashboardPage(Hooks.driver);
        dashboardPage.clickPIM();
    }

    @And("user enters employee name {string}")
    public void userEntersEmployeeName(String name) {
        employeePage = new EmployeePage(Hooks.driver);
        employeePage.enterEmployeeName(name);
    }

    @And("user clicks the search button")
    public void userClicksTheSearchButton() {
        employeePage = new EmployeePage(Hooks.driver);
        employeePage.clickSearchButton();
    }

    @Then("employee {string} should be displayed in the search results")
    public void employeeShouldBeDisplayedInTheSearchResults(String employeeName) {
       employeePage.assertEmployeeResult(employeeName);
    }

    @Then("no records found message should be displayed")
    public void noRecordsFoundMessageShouldBeDisplayed() {
     employeePage.assertNoRecordsFound();
    }

    @And("user clicks the Add Employee menu")
    public void userClicksTheAddEmployeeMenu() {
        employeePage = new EmployeePage(Hooks.driver);
        employeePage.clickAddEmployee();
    }

    @And("user enters first name {string}")
    public void userEntersFirstName(String firstName) {
        addEmployeePage = new AddEmployeePage(Hooks.driver);
        addEmployeePage.enterFirstName(firstName);
    }
    @And("user enters last name {string}")
    public void userEntersLastName(String lastName) {
        addEmployeePage.enterLastName(lastName);
    }
    @And("user clicks the save button")
    public void userClicksTheSaveButton() {
        addEmployeePage.clickSave();

    }

    @Then("employee should be created successfully with first name {string}")
    public void employeeShouldBeCreatedSuccessfully(String firstName) {
        addEmployeePage.assertEmployeeCreated(firstName);
    }

    @And("user clicks the edit button for {string}")
    public void userClicksTheEditButtonFor(String employeeName) {
        employeePage.clickEditButton(employeeName);
    }
    @And("user updates first name to {string}")
    public void userUpdatesFirstNameTo(String firstName) {
        employeePage.updateFirstName(firstName);
    }
    @And("user clicks the edit save button")
    public void userClicksTheEditSaveButton() {
        employeePage.clickSave();
    }
    @Then("employee should be updated successfully")
    public void employeeShouldBeUpdatedSuccessfully() {
        employeePage.assertEmployeeUpdated();
    }
}
