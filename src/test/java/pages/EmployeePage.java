package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class EmployeePage extends BasePage {

    public EmployeePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[placeholder='Type for hints...']")
    private WebElement employeeName;

    @FindBy(css = ".orangehrm-left-space")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@role='cell']")
    private List<WebElement> employeeResults;

    @FindBy(xpath = "//span[text()='No Records Found']")
    private WebElement noRecordsFound;

    @FindBy(xpath = "//a[normalize-space()='Add Employee']")
    private WebElement addEmployee;


    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(css = "button[type='submit']")
    private WebElement saveButton;

    @FindBy(css = ".oxd-toast-content-text")
    private WebElement successMessage;

    public void enterEmployeeName(String employeeName) {
        wait.until(ExpectedConditions.visibilityOf(this.employeeName));
        this.employeeName.sendKeys(employeeName);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void assertEmployeeResult(String employeeName) {
        wait.until(ExpectedConditions.visibilityOfAllElements(employeeResults));
        boolean found = false;

        for (WebElement employee : employeeResults) {
            if (employee.getText().equals(employeeName)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
    }

    public void assertNoRecordsFound() {
        wait.until(ExpectedConditions.visibilityOf(noRecordsFound));
        Assert.assertTrue(noRecordsFound.isDisplayed());
    }

    public void clickAddEmployee() {
        wait.until(ExpectedConditions.elementToBeClickable(addEmployee));
        addEmployee.click();
    }

    public void clickEditButton(String employeeName) {
        WebElement editButton = driver.findElement(
                By.xpath("//div[@role='row'][.//div[normalize-space()='" + employeeName + "']]//button[.//i[contains(@class,'bi-pencil-fill')]]")
        );

        wait.until(ExpectedConditions.elementToBeClickable(editButton));
        editButton.click();
    }

    public void updateFirstName(String firstName) {
        wait.until(ExpectedConditions.elementToBeClickable(this.firstName));

        this.firstName.click();
        this.firstName.sendKeys(Keys.HOME);
        this.firstName.sendKeys(Keys.SHIFT, Keys.END);
        this.firstName.sendKeys(Keys.BACK_SPACE);
        this.firstName.sendKeys(firstName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        saveButton.click();
    }

    public void assertEmployeeUpdated() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        Assert.assertTrue(successMessage.isDisplayed());
    }


}

