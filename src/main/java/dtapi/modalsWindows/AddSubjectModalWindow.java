package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.SubjectPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddSubjectModalWindow extends BaseModalWindow {
    private By firstInput = By.xpath("//mat-dialog-container//input");
    private By textArea = By.xpath("//mat-dialog-container//textarea");
    private WaitUtils wait;


    public AddSubjectModalWindow(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver,10);
    }

    public SubjectPage fillAllSubjectFieldsAndSubmitForm(String name, String desc) {
        String addSubjectPageWindow = driver.getWindowHandle();
        addNewSubject(name, desc);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new SubjectPage(driver, log);
    }

    private void addNewSubject(String name, String desc) {
        fillAllFields(name, desc);
        clickSubmitButton();
    }

    private void clickSubjectNameField() {
        wait.visibilityOfElement(firstInput);
        wait.prevenseOfElement(firstInput);
        find(firstInput).click();
    }

    private void clearSubjectTitleField() {
        wait.visibilityOfElement(firstInput);
        wait.prevenseOfElement(firstInput);
        find(firstInput).clear();
    }

    private void setSujectNameField(String name) {
        wait.visibilityOfElement(firstInput);
        wait.prevenseOfElement(firstInput);
        type(name, firstInput);
    }

    private void fillSubjectNameField(String name) {
        clickSubjectNameField();
        clearSubjectTitleField();
        setSujectNameField(name);
    }

    private void clickSubjectTexAreaField() {
        wait.visibilityOfElement(textArea);
        wait.prevenseOfElement(textArea);
        find(textArea).click();
    }

    private void clearSubjectTextAreaField() {
        wait.visibilityOfElement(textArea);
        wait.prevenseOfElement(textArea);
        find(textArea).clear();
    }

    private void setSubjectTextAreaField(String desc) {
        wait.visibilityOfElement(textArea);
        wait.prevenseOfElement(textArea);
        type(desc, textArea);
    }

    private void fillTextAreaField(String desc) {
        clickSubjectTexAreaField();
        clearSubjectTextAreaField();
        setSubjectTextAreaField(desc);
    }

    private void fillAllFields(String name, String desc) {
        fillSubjectNameField(name);
        fillTextAreaField(desc);

    }
}
