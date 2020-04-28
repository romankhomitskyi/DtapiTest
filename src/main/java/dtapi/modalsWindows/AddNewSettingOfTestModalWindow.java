package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.SettingsTestPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddNewSettingOfTestModalWindow  extends BaseModalWindow{
    private By listBox = By.xpath("//div[contains(@class,'mat-primary')]");
    private By countOfTask = By.xpath("//input[@placeholder = 'Кількість завдань']");
    private By countOfGrades = By.xpath("//input[@placeholder = 'Кількість балів']");
    private By lvlDropDown = By.xpath("//mat-select[contains(@class,'mat-select') and contains(@name,'level')]");
    private By cancelAddingNewSettingsButton = By.xpath("//span[contains(text(),'Відмінити')]/parent::button");
    private By addNewSettingsButton = By.xpath("//span[contains(text(),'Відмінити')]/parent::button/following-sibling::button");
    private WaitUtils wait;
    public AddNewSettingOfTestModalWindow(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 10);
    }
    private void clickСountOfTaskField() {
        wait.visibilityOfElement(countOfTask);
        wait.prevenseOfElement(countOfTask);
        click(countOfTask);
    }

    private void clearСountOfTaskField() {
        wait.visibilityOfElement(countOfTask);
        wait.prevenseOfElement(countOfTask);
        find(countOfTask).clear();
    }

    private void setСountOfTaskField(String countOfTasks) {
        wait.visibilityOfElement(countOfTask);
        wait.prevenseOfElement(countOfTask);
        type(countOfTasks, countOfTask);
    }

    private void fillCountOfTaskField(String countOfTasks) {
        clickСountOfTaskField();
        clearСountOfTaskField();
        setСountOfTaskField(countOfTasks);
    }
    private void clickCountOfGradesField() {
        wait.visibilityOfElement(countOfGrades);
        wait.prevenseOfElement(countOfGrades);
        click(countOfGrades);
    }

    private void clearCountOfGradesField() {
        wait.visibilityOfElement(countOfGrades);
        wait.prevenseOfElement(countOfGrades);
        find(countOfGrades).clear();
    }

    private void setCountOfGradesField(String countsOfGrades) {
        wait.visibilityOfElement(countOfGrades);
        wait.prevenseOfElement(countOfGrades);
        type(countsOfGrades, countOfGrades);
    }

    private void fillCountOfGradesField(String countsOfGrades) {
        clickСountOfTaskField();
        clearСountOfTaskField();
        setСountOfTaskField(countsOfGrades);
    }
    private void clickLvlDropDown() {
        wait.visibilityOfElement(lvlDropDown);
        wait.prevenseOfElement(lvlDropDown);
        wait.waitForElementClickability(lvlDropDown);
        click(lvlDropDown);
        wait.prevenseOfElement(listBox);
        wait.visibilityOfAllElements2(listBox);

    }
    private void clickLvlOptions(String lvl) {
        wait.visibilityOfElement2(driver.findElement(By.xpath("//mat-option/span")));
        wait.prevenseOfElement(By.xpath("//mat-option/span"));
        List<WebElement> dropDown = driver.findElements(By.xpath("//mat-option/span"));
        for (WebElement options : dropDown) {
            if (options.getText().equals(lvl)) {
                wait.waitForElementClickability2(options);
                options.click();
                wait.invisibilityOfEmelement2(options);
                break;
            }
        }

    }
    private void setLvlDropDownOption(String lvl) {
        clickLvlDropDown();
        clickLvlOptions(lvl);

    }
    private void fillAllSettingsOfTest(String lvl, String countOfTask, String countOfGrades) {
        setLvlDropDownOption(lvl);
        setСountOfTaskField(countOfTask);
        setCountOfGradesField(countOfGrades);


    }
    private void clickAddSettingsButton() {
        wait.visibilityOfElement(addNewSettingsButton);
        wait.prevenseOfElement(addNewSettingsButton);
        driver.findElement(addNewSettingsButton).click();
    }

    private void addNewSettings(String lvl, String countOfTask, String countOfGrades) {
        fillAllSettingsOfTest(lvl,countOfTask,countOfGrades);
        clickAddSettingsButton();
    }

    public SettingsTestPage fillAllSettingsAndSubmitForm(String lvl, String countOfTask, String countOfGrades) {
        String addSubjectPageWindow = driver.getWindowHandle();
        addNewSettings(lvl,countOfTask,countOfGrades);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                wait.invisibilityOfEmelement2(getSubmitButton());
                driver.switchTo().window(windowHandle);


            }
        }

        return new SettingsTestPage(driver, log);
    }
}
