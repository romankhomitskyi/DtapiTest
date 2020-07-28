package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.TestPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddTestModalWindow extends BaseModalWindow {
    private By testNameInput = By.xpath("//span[contains(text(),'Назва тесту')]/ancestor::div/input");
    private By taskCountInput = By.xpath("//mat-label[contains(text(),'Кількість завдань')]/ancestor::div/input");
    private By timeInput = By.xpath("//mat-label[contains(text(),'Час')]/ancestor::div/input");
    private By numberOfAttemptsInput = By.xpath("//mat-label[contains(text(),'Кількість спроб')]/ancestor::div/input");
    private By cancelCreateTestButton = By.xpath("//span[contains(text(),'Відмінити')]/parent::button");
    private By addTestButton = By.xpath("//span[contains(text(),'Відмінити')]/parent::button/following-sibling::button");
    private By radioButtos = By.xpath("//label[@class='mat-radio-label']");
    private WaitUtils wait;

    public AddTestModalWindow(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver,10);
    }

    private void clickTestNameField() {
        wait.visibilityOfElementByLocator(testNameInput);
        wait.presenceOfElement(testNameInput);
        find(testNameInput).click();
    }

    private void clearTestNameField() {
        wait.visibilityOfElementByLocator(testNameInput);
        wait.presenceOfElement(testNameInput);
        find(testNameInput).clear();
    }

    private void setTestNameField(String testName) {
        wait.visibilityOfElementByLocator(testNameInput);
        wait.presenceOfElement(testNameInput);
        type(testName, testNameInput);
    }

    private void fillTestNameField(String testName) {
        clickTestNameField();
        clearTestNameField();
        setTestNameField(testName);
    }

    private void clickTaskCountField() {
        wait.visibilityOfElementByLocator(taskCountInput);
        wait.presenceOfElement(taskCountInput);
        find(taskCountInput).click();
    }

    private void clearTaskCountField() {
        wait.visibilityOfElementByLocator(taskCountInput);
        wait.presenceOfElement(taskCountInput);
        find(taskCountInput).clear();
    }

    private void setTaskCountField(int taskCount) {
        wait.visibilityOfElementByLocator(taskCountInput);
        wait.presenceOfElement(taskCountInput);
        find(taskCountInput).sendKeys(String.valueOf(taskCount));
    }

    private void fillTaskCountField(int taskCount) {
        clickTaskCountField();
        clearTaskCountField();
        setTaskCountField(taskCount);
    }

    private void clickTimeField() {
        wait.visibilityOfElementByLocator(timeInput);
        wait.presenceOfElement(timeInput);
        find(timeInput).click();
    }

    private void clearTimeField() {
        wait.visibilityOfElementByLocator(timeInput);
        wait.presenceOfElement(timeInput);
        find(timeInput).clear();
    }

    private void setTimeField(int timeCount) {
        wait.visibilityOfElementByLocator(timeInput);
        wait.presenceOfElement(timeInput);
        find(timeInput).sendKeys(String.valueOf(timeCount));
    }

    private void fillTimeField(int timeCount) {
        clickTimeField();
        clearTimeField();
        setTimeField(timeCount);
    }

    private void clickNumberOfAttemptsField() {
        wait.visibilityOfElementByLocator(numberOfAttemptsInput);
        wait.presenceOfElement(numberOfAttemptsInput);
        find(numberOfAttemptsInput).click();
    }

    private void clearNumberOfAttemptsField() {
        wait.visibilityOfElementByLocator(numberOfAttemptsInput);
        wait.presenceOfElement(numberOfAttemptsInput);
        find(numberOfAttemptsInput).clear();
    }

    private void setNumberOfAttemptsField(int numberOfAttempts) {
        wait.visibilityOfElementByLocator(numberOfAttemptsInput);
        wait.presenceOfElement(numberOfAttemptsInput);
        find(numberOfAttemptsInput).sendKeys(String.valueOf(numberOfAttempts));
    }

    private void fillNumberOfAttemptsField(int numberOfAttempts) {
        clickNumberOfAttemptsField();
        clearNumberOfAttemptsField();
        setNumberOfAttemptsField(numberOfAttempts);
    }

    private void selectOnRadioButton() {
        wait.visibilityOfElementByLocator(radioButtos);
        wait.presenceOfElement(radioButtos);
        List<WebElement> radiobuttons = driver.findElements(radioButtos);
        if (!radiobuttons.get(0).isSelected()) {
            radiobuttons.get(0).click();
        }

    }

    private void selectOffRadioButton() {
        wait.visibilityOfElementByLocator(radioButtos);
        wait.presenceOfElement(radioButtos);
        List<WebElement> radiobuttons = findAll(radioButtos);
        for (WebElement radiobutton : radiobuttons) {
            if (!radiobutton.isSelected()) {
                radiobuttons.get(1).click();
            }
        }
    }

    private void clickAddTestButton() {
        wait.visibilityOfElementByLocator(addTestButton);
        wait.presenceOfElement(addTestButton);
        driver.findElement(addTestButton).click();
    }

    private void clickCancelCreateTestButton() {
        driver.findElement(cancelCreateTestButton).click();
    }

    private void fillAllTestFields(String testName, int taskCount, int timeCount, int numberOfAttempts) {
        fillTestNameField(testName);
        fillTaskCountField(taskCount);
        fillTimeField(timeCount);
        fillNumberOfAttemptsField(numberOfAttempts);
        selectOnRadioButton();

    }

    private void addNewTest(String testName, int taskCount, int timeCount, int numberOfAttempts) {
        fillAllTestFields(testName, taskCount, timeCount, numberOfAttempts);
        clickAddTestButton();
    }

    public TestPage fillAllTestFieldsAndSubmitForm(String testName, int taskCount, int timeCount, int numberOfAttempts) {
        String addSubjectPageWindow = driver.getWindowHandle();
        addNewTest(testName, taskCount, timeCount, numberOfAttempts);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        wait.waitForAlertVisibility();
        return new TestPage(driver);
    }
}
