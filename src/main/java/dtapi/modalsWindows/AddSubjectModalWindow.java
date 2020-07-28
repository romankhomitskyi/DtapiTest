package dtapi.modalsWindows;

import dtapi.data.subject.NewSubject;
import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.SubjectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddSubjectModalWindow extends BaseModalWindow {
    private By firstInput = By.xpath("//mat-dialog-container//input");
    private By textArea = By.xpath("//mat-dialog-container//textarea");
    private By snackBar= By.xpath("//snack-bar-container[contains(class,snackbar-success)]");
    private WaitUtils wait;


    public AddSubjectModalWindow(WebDriver driver) {
        super(driver);
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
    
        new WaitUtils(driver, 10).waitForAlertVisibility();
        return new SubjectPage(driver);
    }

    private void addNewSubject(String name, String desc) {
        fillAllFields(name, desc);
        clickSubmitButton();
    }

    private void clickSubjectNameField() {
        wait.visibilityOfElementByLocator(firstInput);
        wait.presenceOfElement(firstInput);
        find(firstInput).click();
    }

    private void clearSubjectTitleField() {
        wait.visibilityOfElementByLocator(firstInput);
        wait.presenceOfElement(firstInput);
        find(firstInput).clear();
    }

    private void setSujectNameField(String name) {
        wait.visibilityOfElementByLocator(firstInput);
        wait.presenceOfElement(firstInput);
        type(name, firstInput);
    }

    private void fillSubjectNameField(String name) {
        clickSubjectNameField();
        clearSubjectTitleField();
        setSujectNameField(name);
    }

    private void clickSubjectTexAreaField() {
        wait.visibilityOfElementByLocator(textArea);
        wait.presenceOfElement(textArea);
        find(textArea).click();
    }

    private void clearSubjectTextAreaField() {
        wait.visibilityOfElementByLocator(textArea);
        wait.presenceOfElement(textArea);
        find(textArea).clear();
    }

    private void setSubjectTextAreaField(String desc) {
        wait.visibilityOfElementByLocator(textArea);
        wait.presenceOfElement(textArea);
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
    public AddSubjectModalWindow fillInvalidSubjectData(NewSubject subject) {
        fillInvalidData(subject);
        return new AddSubjectModalWindow(driver);
    }
    public InformModalWindow fillInvalidSubjectDataAndClickSubmitButton(NewSubject subject) {
        String addSubjectPageWindow = driver.getWindowHandle();
        fillInvalidData(subject);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {

                driver.switchTo().window(windowHandle);


            }
        }
        return new InformModalWindow(driver);
    }
    private void fillInvalidData(NewSubject subject) {
        fillAllFields( subject);
        clickSubmitButton();

    }

    private void fillAllFields(NewSubject subject) {
        fillInvalidSubjectNameField(subject);
        fillInvalidSubjectDescField(subject);

    }
    private void setInvalidSubjectNameField(NewSubject subject) {
        wait.visibilityOfElementByLocator(firstInput);
        wait.presenceOfElement(firstInput);
        type(subject.getSubjectName(),firstInput);
    }

    private void fillInvalidSubjectNameField(NewSubject subject) {
        clickSubjectNameField();
        clearSubjectTitleField();
        setInvalidSubjectNameField(subject);
    }
    private void setInvalidSubjectDescField(NewSubject subject) {
        wait.visibilityOfElementByLocator(textArea);
        wait.presenceOfElement(textArea);
        type(subject.getSubjectDesc(),textArea);
    }

    private void fillInvalidSubjectDescField(NewSubject subject) {
        clickSubjectTexAreaField();
        clearSubjectTextAreaField();
        setInvalidSubjectDescField(subject);
    }
}
