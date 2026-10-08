package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".oxd-topbar-header-breadcrumb-module")
    private WebElement dashboard;

    @FindBy(css = "a[href='/web/index.php/pim/viewPimModule']")
    private WebElement pim;

    public void assertDashboardDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(dashboard));
        Assert.assertTrue(dashboard.isDisplayed());
    }

    public void clickPIM() {
        wait.until(ExpectedConditions.elementToBeClickable(pim));
        pim.click();
    }
}
