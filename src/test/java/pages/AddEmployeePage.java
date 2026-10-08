package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddEmployeePage extends BasePage {

    public AddEmployeePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(xpath = "//button[@type='submit' and normalize-space()='Save']")
    private WebElement saveButton;

    @FindBy(css = ".oxd-toast-content-text")
    private WebElement successMessage;

    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOf(this.firstName));
        this.firstName.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOf(this.lastName));
        this.lastName.sendKeys(lastName);
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
        wait.until(ExpectedConditions.visibilityOf(successMessage));
    }

    public void assertEmployeeCreated(String expectedFirstName) {
        wait.until(ExpectedConditions.visibilityOf(firstName));
        Assert.assertEquals(expectedFirstName, firstName.getAttribute("value"));
    }
}
