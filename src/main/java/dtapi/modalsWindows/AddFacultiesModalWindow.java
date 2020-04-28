package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.FacultiesPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddFacultiesModalWindow extends BaseModalWindow {
    private By firstInput = By.xpath("//mat-dialog-container//input");
    private By textArea = By.xpath("//mat-dialog-container//textarea");
    private WaitUtils wait;

    public AddFacultiesModalWindow(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 20);
    }


    public FacultiesPage fillAllFacultiesFieldsAndSubmitForm(String name, String desc) {
        String addSubjectPageWindow = driver.getWindowHandle();
        addNewFaculties(name, desc);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new FacultiesPage(driver, log);
    }

    private void addNewFaculties(String name, String desc) {
        fillAllFields(name, desc);
        clickSubmitButton();
    }

    private void clickFacultiesNameField() {
        wait.visibilityOfElement(firstInput);
        wait.prevenseOfElement(firstInput);
        click(firstInput);
    }

    private void clearFacultiesTitleField() {
        wait.visibilityOfElement(firstInput);
        wait.prevenseOfElement(firstInput);
        find(firstInput).clear();
    }

    private void setFacultiesNameField(String name) {
        wait.visibilityOfElement(firstInput);
        wait.prevenseOfElement(firstInput);
        type(name, firstInput);
    }

    private void fillFacultiesNameField(String name) {
        clickFacultiesNameField();
        clearFacultiesTitleField();
        setFacultiesNameField(name);
    }

    private void clickFacultiesTexAreaField() {
        wait.visibilityOfElement(textArea);
        wait.prevenseOfElement(textArea);
        click(textArea);
    }

    private void clearFacultiesTextAreaField() {
        wait.visibilityOfElement(textArea);
        wait.prevenseOfElement(textArea);
        find(textArea).clear();
    }

    private void setFacultiesTextAreaField(String desc) {
        wait.visibilityOfElement(textArea);
        wait.prevenseOfElement(textArea);
        type(desc, textArea);
    }

    private void fillTextAreaField(String desc) {
        clickFacultiesTexAreaField();
        clearFacultiesTextAreaField();
        setFacultiesTextAreaField(desc);
    }

    private void fillAllFields(String name, String desc) {
        fillFacultiesNameField(name);
        fillTextAreaField(desc);

    }
}
