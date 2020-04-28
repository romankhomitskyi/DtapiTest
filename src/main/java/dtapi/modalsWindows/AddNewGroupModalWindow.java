package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.GroupPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddNewGroupModalWindow extends BaseModalWindow {
    private By groupId = By.xpath("//input[@placeholder = 'Шифр групи']");
    private By listBox = By.xpath("//div[contains(@class,'mat-primary')]");
    private By specialityDropDown = By.xpath("//mat-select[contains(@class,'mat-select') and contains(@placeholder,'Виберіть спеціальність')]");
    private By facultyDropDown = By.xpath("//mat-select[contains(@class,'mat-select') and contains(@placeholder,'Виберіть факультет/інститут')]");

    private WaitUtils wait;


    public AddNewGroupModalWindow(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 10);
    }


    private void clickGroupIdField() {
        wait.visibilityOfElement(groupId);
        wait.prevenseOfElement(groupId);
        click(groupId);
    }

    private void clearGroupIdField() {
        wait.visibilityOfElement(groupId);
        wait.prevenseOfElement(groupId);
        find(groupId).clear();
    }

    private void setGroupIdField(String groupText) {
        wait.visibilityOfElement(groupId);
        wait.prevenseOfElement(groupId);
        type(groupText, groupId);
    }

    private void fillGroupIdField(String groupText) {
        clickGroupIdField();
        clearGroupIdField();
        setGroupIdField(groupText);
    }

    private void clickSpecialityDropDown() {
        wait.visibilityOfElement2(driver.findElement(specialityDropDown));
        wait.prevenseOfElement(specialityDropDown);
        wait.waitForElementClickability(specialityDropDown);
        click(specialityDropDown);
        wait.prevenseOfElement(By.xpath("//mat-option/span"));
    }

    /*private void clickSpecialityOptions(String specialityName){
        wait.visibilityOfElement(By.xpath(String.format(specialityDropDownOption,specialityName)));
        driver.findElement(By.xpath(String.format(specialityDropDownOption,specialityName))).click();
    }*/
    private void clickSpecialityOptions(String specialityName) {

        wait.prevenseOfElement(By.xpath("//mat-option/span"));
        List<WebElement> dropDown = driver.findElements(By.xpath("//mat-option/span"));
        for (WebElement options : dropDown) {
            if (options.getText().equals(specialityName)) {
                wait.waitForElementClickability2(options);
                options.click();
                wait.invisibilityOfEmelement2(options);
                break;
            }
        }

    }

    private void setSpecialityDropDownOption(String specialityName) {
        clickSpecialityDropDown();
        clickSpecialityOptions(specialityName);

    }

    private void clickFacultyDropDown() {
        wait.prevenseOfElement(facultyDropDown);
        wait.visibilityOfElement(facultyDropDown);
        wait.waitForElementClickability(facultyDropDown);
        click(facultyDropDown);
        wait.visibilityOfElement2(driver.findElement(listBox));
        wait.prevenseOfElement(listBox);

    }

    /*private void clickFacultyOptions(String facultyName){
        wait.visibilityOfElement(By.xpath(String.format(facultyDropDownOption,facultyName)));
        driver.findElement(By.xpath(String.format(facultyDropDownOption,facultyName))).click();
    }*/
    private void clickFacultyOptions(String facultyName) {
        wait.visibilityOfElement2(driver.findElement(By.xpath("//mat-option/span")));
        wait.waitForElementClickability2(driver.findElement(By.xpath("//mat-option/span")));

        List<WebElement> dropDown = driver.findElements(By.xpath("//mat-option/span"));
        for (WebElement options : dropDown) {
            if (options.getText().equals(facultyName)) {
                options.click();
                wait.invisibilityOfEmelement2(options);// click the desired option
                break;
            }
        }

    }

    private void setFacultyDropDownOption(String facultyName) {
        clickFacultyDropDown();
        clickFacultyOptions(facultyName);

    }

    private void fillAllGroupFields(String groupText, String specialityName, String facultyName) {
        fillGroupIdField(groupText);
        setSpecialityDropDownOption(specialityName);
        setFacultyDropDownOption(facultyName);


    }

    private void addNewGroup(String groupText, String specialityName, String facultyName) {
        fillAllGroupFields(groupText, specialityName, facultyName);
        clickSubmitButton();
    }

    public GroupPage fillAllGroupFieldsAndSubmitForm(String groupText, String specialityName, String facultyName) {
        String addSubjectPageWindow = driver.getWindowHandle();
        addNewGroup(groupText, specialityName, facultyName);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                wait.invisibilityOfEmelement2(getSubmitButton());
                driver.switchTo().window(windowHandle);


            }
        }

        return new GroupPage(driver, log);
    }
}
