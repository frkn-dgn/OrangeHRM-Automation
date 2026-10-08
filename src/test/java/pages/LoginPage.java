package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(css = ".orangehrm-login-button")
    private WebElement loginButton;

    @FindBy(css = ".oxd-alert-content--error .oxd-alert-content-text")
    private WebElement loginErrorMessage;

    @FindBy(css = ".oxd-input-field-error-message")
    private List<WebElement> requiredMessages;

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(this.username));
        this.username.sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(this.password));
        this.password.sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public void assertLoginErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(loginErrorMessage));
        Assert.assertTrue(loginErrorMessage.isDisplayed());
    }
    public void assertRequiredFieldMessages() {
        wait.until(ExpectedConditions.visibilityOfAllElements(requiredMessages));
        Assert.assertEquals(2, requiredMessages.size());
    }
}