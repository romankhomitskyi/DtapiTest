package dtapi.dtapiBase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WaitUtils {
    private By successSnackBar = By.xpath("//snack-bar-container[contains(class,snackbar-success)]");
    private WebDriverWait wait;
    private WebDriver driver;


    public WaitUtils(WebDriver driver, int seconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, seconds);
    }


    public void waitForAlertVisibility() {
        wait.until(ExpectedConditions.presenceOfElementLocated(successSnackBar));
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(successSnackBar)));
    }

    public void waitForElementToBeClickableByLocator(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));

    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public void scrollUntilElementVisible(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }
    public void javaClick(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", element);
    }

    public void visibilityOfElementByLocator(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 45);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void visibilityOfAllElements(List<WebElement> element) {
        WebDriverWait wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void visibilityOfAllElementsByLocator(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void presenceOfElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void invisibilityOfElementByLocator(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void invisibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void visibilityOfWebElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}
