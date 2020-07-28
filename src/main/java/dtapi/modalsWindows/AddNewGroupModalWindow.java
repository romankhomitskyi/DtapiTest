package dtapi.modalsWindows;

import dtapi.data.group.NewGroup;
import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.GroupPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AddNewGroupModalWindow extends BaseModalWindow {
    private By groupId = By.xpath("//input[@placeholder = 'Шифр групи']");
    private By listBox = By.xpath("//div[contains(@class,'mat-primary')]");
    private By specialityDropDown = By.xpath("//mat-select[contains(@class,'mat-select') and contains(@placeholder,'Виберіть спеціальність')]");
    private By facultyDropDown = By.xpath("//mat-select[contains(@class,'mat-select') and contains(@placeholder,'Виберіть факультет/інститут')]");

    private WaitUtils wait;


    public AddNewGroupModalWindow(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 15);
    }
    public AddNewGroupModalWindow fillInvalidGroupData(NewGroup group) {
        fillInvalidData(group);
        return new AddNewGroupModalWindow(driver);
    }
    public InformModalWindow fillInvalidGroupDataAndClickSubmitButton(String groudId,String gpoupSpeciality,String groupFaculty) {
        String addSubjectPageWindow = driver.getWindowHandle();
        addNewGroup(groudId, gpoupSpeciality, groupFaculty);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                wait.invisibilityOfElement(getSubmitButton());
                driver.switchTo().window(windowHandle);


            }
        }
        return new InformModalWindow(driver);
    }
    private void fillInvalidData(NewGroup group) {
        fillAllFields( group);

    }

    private void fillAllFields(NewGroup group) {
        fillInvalidGroupIdField(group);
        clickSpecialityDropDown();
        Actions actions = new Actions(driver);
        actions.moveToElement( driver.findElement(groupId)).click().build().perform();
        clickFacultyDropDown();
        actions.moveToElement(driver.findElement(groupId)).click().build().perform();
    }
    private void setInvalidGroupIdField(NewGroup group) {
        wait.visibilityOfElementByLocator(groupId);
        wait.presenceOfElement(groupId);
        type(group.getGroupId(), groupId);
    }

    private void fillInvalidGroupIdField(NewGroup group) {
        clickGroupIdField();
        clearGroupIdField();
        setInvalidGroupIdField(group);
    }



    private void clickGroupIdField() {
        wait.visibilityOfElementByLocator(groupId);
        wait.presenceOfElement(groupId);
        click(groupId);
    }

    private void clearGroupIdField() {
        wait.visibilityOfElementByLocator(groupId);
        wait.presenceOfElement(groupId);
        find(groupId).clear();
    }

    private void setGroupIdField(String newGroup) {
        wait.visibilityOfElementByLocator(groupId);
        wait.presenceOfElement(groupId);
        type(newGroup, groupId);
    }

    private void fillGroupIdField(String groupText) {
        clickGroupIdField();
        clearGroupIdField();
        setGroupIdField(groupText);
    }

    private void clickSpecialityDropDown() {
        wait.visibilityOfWebElement(driver.findElement(specialityDropDown));
        wait.presenceOfElement(specialityDropDown);
        wait.waitForElementToBeClickableByLocator(specialityDropDown);
        click(specialityDropDown);
        wait.visibilityOfAllElementsByLocator(By.xpath("//mat-option/span"));
    }


    private void clickSpecialityOptions(String specialityName) {

        List<WebElement> dropDown = driver.findElements(By.xpath("//mat-option/span"));
        for (WebElement options : dropDown) {
            if (options.getText().equals(specialityName)) {
                wait.waitForElementToBeClickable(options);
                options.click();
                wait.invisibilityOfElement(options);
                break;
            }
        }

    }

    private void setSpecialityDropDownOption(String specialityName) {
        clickSpecialityDropDown();
        clickSpecialityOptions(specialityName);

    }

    private void clickFacultyDropDown() {

        wait.waitForElementToBeClickableByLocator(facultyDropDown);
        driver.findElement(facultyDropDown).click();
        wait.visibilityOfAllElementsByLocator(By.xpath("//mat-option/span"));

    }

    /*private void clickFacultyOptions(String facultyName){
        wait.visibilityOfElement(By.xpath(String.format(facultyDropDownOption,facultyName)));
        driver.findElement(By.xpath(String.format(facultyDropDownOption,facultyName))).click();
    }*/
    private void clickFacultyOptions(String facultyName) {

        List<WebElement> dropDown = driver.findElements(By.xpath("//mat-option/span"));
        for (WebElement options : dropDown) {
            if (options.getText().equals(facultyName)) {
                wait.waitForElementToBeClickable(options);
                options.click();
                wait.invisibilityOfElement(options);// click the desired option
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
                wait.invisibilityOfElement(getSubmitButton());
                driver.switchTo().window(windowHandle);


            }
        }

        return new GroupPage(driver);
    }
}
