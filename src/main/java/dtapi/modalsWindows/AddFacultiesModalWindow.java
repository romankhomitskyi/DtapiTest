package dtapi.modalsWindows;

import dtapi.data.faculties.NewFaculties;
import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.FacultiesPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddFacultiesModalWindow extends BaseModalWindow {
    private By firstInput = By.xpath("//mat-dialog-container//input");
    private By textArea = By.xpath("//mat-dialog-container//textarea");
    private WaitUtils wait;

    public AddFacultiesModalWindow(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 20);
    }

    public InformModalWindow fillInvalidFacultiesDataAndAndSubmitForm(NewFaculties faculties) {
        String addSubjectPageWindow = driver.getWindowHandle();
        addNewFaculties(faculties);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new InformModalWindow(driver);
    }
    public AddFacultiesModalWindow fillInvalidFacultiesData(NewFaculties faculties) {

        fillInvalidData(faculties);
        return new AddFacultiesModalWindow(driver);
    }
    private void fillInvalidData(NewFaculties faculties) {
        fillAllFields(faculties);

    }

    public FacultiesPage fillAllFacultiesFieldsAndSubmitForm(NewFaculties faculties) {
        String addSubjectPageWindow = driver.getWindowHandle();
        addNewFaculties(faculties);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new FacultiesPage(driver);
    }

    private void addNewFaculties(NewFaculties faculties) {
        fillAllFields(faculties);
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

    private void setFacultiesNameField(NewFaculties faculties) {
        wait.visibilityOfElement(firstInput);
        wait.prevenseOfElement(firstInput);
        type(faculties.getFacultiesName(), firstInput);
    }

    private void fillFacultiesNameField(NewFaculties faculties) {
        clickFacultiesNameField();
        clearFacultiesTitleField();
        setFacultiesNameField(faculties);
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

    private void setFacultiesTextAreaField(NewFaculties faculties) {
        wait.visibilityOfElement(textArea);
        wait.prevenseOfElement(textArea);
        type(faculties.getFacultiesDesc(), textArea);
    }

    private void fillTextAreaField(NewFaculties faculties) {
        clickFacultiesTexAreaField();
        clearFacultiesTextAreaField();
        setFacultiesTextAreaField(faculties);
    }

    private void fillAllFields(NewFaculties faculties) {
        fillFacultiesNameField(faculties);
        fillTextAreaField(faculties);

    }
}
