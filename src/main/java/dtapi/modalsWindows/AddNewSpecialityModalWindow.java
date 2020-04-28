package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.BasePageObject;
import dtapi.pages.SpecialityPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewSpecialityModalWindow extends BasePageObject {
    private By submitButton = By.xpath("//span[contains(text(),'Підтвердити')]/parent::button");
    private By cancelButton = By.xpath("//span[contains(text(),'Скасувати')]/parent::button");
    private By codeSpeciality = By.xpath("//input[@placeholder='Код спеціальності']");
    private By nameOfSpeciality = By.xpath("//input[@placeholder='Назва спеціальності']");
    private WaitUtils wait;

    public AddNewSpecialityModalWindow(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 5);
    }

    public SpecialityPage fillAllSpecialityFieldsAndSubmitForm(int code, String name) {
        String addSubjectPageWindow = driver.getWindowHandle();
        addNewSpeciality(code, name);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                wait.invisibilityOfEmelement(submitButton);
                driver.switchTo().window(windowHandle);
            }
        }

        return new SpecialityPage(driver, log);
    }

    private void clickSpecialityCodeField() {
        wait.visibilityOfElement(codeSpeciality);
        wait.prevenseOfElement(codeSpeciality);
        click(codeSpeciality);
    }

    private void clearSpecialityCodeField() {
        wait.visibilityOfElement(codeSpeciality);
        wait.prevenseOfElement(codeSpeciality);
        find(codeSpeciality).clear();
    }

    private void setSpecialityCodeField(int code) {
        wait.visibilityOfElement(codeSpeciality);
        wait.prevenseOfElement(codeSpeciality);
        typeInt(code, codeSpeciality);
    }

    private void fillSpecialityCodeField(int code) {
        clickSpecialityCodeField();
        clearSpecialityCodeField();
        setSpecialityCodeField(code);
    }

    private void clickNameOfSpecialityField() {
        wait.visibilityOfElement(nameOfSpeciality);
        wait.prevenseOfElement(nameOfSpeciality);
        click(nameOfSpeciality);
    }

    private void clearNameOfSpecialityField() {
        wait.visibilityOfElement(nameOfSpeciality);
        wait.prevenseOfElement(nameOfSpeciality);
        find(nameOfSpeciality).clear();
    }

    private void setNameOfSpecialityField(String name) {
        wait.visibilityOfElement(nameOfSpeciality);
        wait.prevenseOfElement(nameOfSpeciality);
        type(name, nameOfSpeciality);
    }

    private void fillNameOfSpecialityField(String desc) {
        clickNameOfSpecialityField();
        clearNameOfSpecialityField();
        setNameOfSpecialityField(desc);
    }

    private void fillAllSpecialityFields(int code, String name) {
        fillSpecialityCodeField(code);
        fillNameOfSpecialityField(name);

    }

    private void addNewSpeciality(int code, String name) {
        fillAllSpecialityFields(code, name);
        clickSubmitButton();
    }

    private void clickSubmitButton() {

        wait.prevenseOfElement(submitButton);
        wait.visibilityOfElement(submitButton);
        click(submitButton);
    }

    private void clickCancelButton() {
        click(cancelButton);

    }

}
