package dtapi.modalsWindows;

import dtapi.data.speciality.NewSpeciality;
import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.BasePageObject;
import dtapi.pages.SpecialityPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewSpecialityModalWindow extends BasePageObject {
    private By submitButton = By.xpath("//span[contains(text(),'Підтвердити')]/parent::button");
    private By cancelButton = By.xpath("//span[contains(text(),'Скасувати')]/parent::button");
    private By codeSpeciality = By.xpath("//input[@placeholder='Код спеціальності']");
    private By nameOfSpeciality = By.xpath("//input[@placeholder='Назва спеціальності']");
    private By error = By.xpath("//mat-error");
    private WaitUtils wait;

    public AddNewSpecialityModalWindow(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 5);
    }



    public SpecialityPage fillAllSpecialityFieldsAndSubmitForm(String code, String name) {
        String addSubjectPageWindow = driver.getWindowHandle();
        addNewSpeciality(code, name);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                wait.invisibilityOfElementByLocator(submitButton);
                driver.switchTo().window(windowHandle);
            }
        }

        return new SpecialityPage(driver);
    }

    private void clickSpecialityCodeField() {
        wait.visibilityOfElementByLocator(codeSpeciality);
        wait.presenceOfElement(codeSpeciality);
        click(codeSpeciality);
    }

    private void clearSpecialityCodeField() {
        wait.visibilityOfElementByLocator(codeSpeciality);
        wait.presenceOfElement(codeSpeciality);
        find(codeSpeciality).clear();
    }

    private void setSpecialityCodeField(String code) {
        wait.visibilityOfElementByLocator(codeSpeciality);
        wait.presenceOfElement(codeSpeciality);
        type(code, codeSpeciality);
    }

    private void fillSpecialityCodeField(String code) {
        clickSpecialityCodeField();
        clearSpecialityCodeField();
        setSpecialityCodeField(code);
    }

    private void clickNameOfSpecialityField() {
        wait.visibilityOfElementByLocator(nameOfSpeciality);
        wait.presenceOfElement(nameOfSpeciality);
        click(nameOfSpeciality);
    }

    private void clearNameOfSpecialityField() {
        wait.visibilityOfElementByLocator(nameOfSpeciality);
        wait.presenceOfElement(nameOfSpeciality);
        find(nameOfSpeciality).clear();
    }

    private void setNameOfSpecialityField(String name) {
        wait.visibilityOfElementByLocator(nameOfSpeciality);
        wait.presenceOfElement(nameOfSpeciality);
        type(name, nameOfSpeciality);
    }

    private void fillNameOfSpecialityField(String desc) {
        clickNameOfSpecialityField();
        clearNameOfSpecialityField();
        setNameOfSpecialityField(desc);
    }

    private void fillAllSpecialityFields(String code, String name) {
        fillSpecialityCodeField(code);
        fillNameOfSpecialityField(name);

    }

    private void addNewSpeciality(String code, String name) {
        fillAllSpecialityFields(code, name);
        clickSubmitButton();
    }

    private void clickSubmitButton() {

        wait.presenceOfElement(submitButton);
        wait.visibilityOfElementByLocator(submitButton);
        click(submitButton);
    }

    private void clickCancelButton() {
        click(cancelButton);

    }
    public boolean isErrorDisplayed() {

        wait.presenceOfElement(error);
        wait.visibilityOfElementByLocator(error);
        WebElement result = driver.findElement(error);
        wait.scrollUntilElementVisible(result);
        return result.isDisplayed();
    }
    public AddNewSpecialityModalWindow fillInvalidSpecialityData(NewSpeciality speciality) {
        fillInvalidData(speciality);
        return new AddNewSpecialityModalWindow(driver);
    }

    private void fillInvalidData(NewSpeciality specialityCodeField) {
        fillAllFields( specialityCodeField);

    }

    private void fillAllFields(NewSpeciality specialityCodeField) {
        fillInvalidSpecialityCodeField(specialityCodeField);
        fillInvalidSpecialityNameField(specialityCodeField);

    }
    private void setInvalidSpecialityCodeField(NewSpeciality specialityCodeField) {
        wait.visibilityOfElementByLocator(codeSpeciality);
        wait.presenceOfElement(codeSpeciality);
        type(specialityCodeField.getCodeSpeciality(),codeSpeciality);
    }

    private void fillInvalidSpecialityCodeField(NewSpeciality specialityCodeField) {
        clickSpecialityCodeField();
        clearSpecialityCodeField();
        setInvalidSpecialityCodeField(specialityCodeField);
    }
    private void fillInvalidSpecialityNameField(NewSpeciality specialityCodeField) {
        clickNameOfSpecialityField();
        clearNameOfSpecialityField();
        setInvalidSpecialityNameField(specialityCodeField);
    }
    private void setInvalidSpecialityNameField(NewSpeciality specialityCodeField) {
        wait.visibilityOfElementByLocator(nameOfSpeciality);
        wait.presenceOfElement(nameOfSpeciality);
        type(specialityCodeField.getCodeSpeciality(),nameOfSpeciality);
    }

}
