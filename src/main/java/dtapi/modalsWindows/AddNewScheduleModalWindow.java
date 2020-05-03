package dtapi.modalsWindows;

import dtapi.data.schedule.NewSchedule;
import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.DatePicker;
import dtapi.pages.ScheduleTestingPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddNewScheduleModalWindow extends BaseModalWindow {
    private By listBox = By.xpath("//div[contains(@class,'mat-primary')]");
    private By groupDropDown = By.xpath("//mat-select[@formcontrolname='group_id']");
    private By startTimeField = By.xpath("//input[@formcontrolname='start_time']");
    private By endTimeField = By.xpath("//input[@formcontrolname='end_time']");
    private By startDateInput = By.xpath("//input[@placeholder='Виберіть початкову дату']");
    private By endDateInput = By.xpath("//input[@placeholder='Виберіть кінцеву дату']");
    private WaitUtils wait;

    @FindBy(xpath = "//input[@formcontrolname='start_time']/parent::*/parent::*/parent::*/parent::*/preceding-sibling::*//button")
    private WebElement startDateField;
    @FindBy(xpath = "//input[@formcontrolname='end_time']/parent::*/parent::*/parent::*/parent::*/preceding-sibling::*//button")
    private WebElement endDateField;

    @FindBy(xpath = "//mat-calendar")
    private DatePicker datePicker;

    private void clickStartDateInput() {
        wait.waitForElementClickability(startDateInput);
        wait.visibilityOfElement(startDateInput);
        wait.prevenseOfElement(startDateInput);
        click(startDateInput);
    }

    private void clearStartDateInput() {
        wait.visibilityOfElement(startDateInput);
        wait.prevenseOfElement(startDateInput);
        find(startDateInput).clear();
    }

    private void setStartDateInput(String startsDateInput) {
        wait.visibilityOfElement(startDateInput);
        wait.prevenseOfElement(startDateInput);
        type(startsDateInput, startDateInput);
    }
    private void fillStartDateInput(String startsDateInput) {
        clickStartDateInput() ;
        clearStartDateInput();
        setStartDateInput(startsDateInput);
    }
    private void clickEndDateInput() {
        wait.visibilityOfElement(endDateInput);
        wait.prevenseOfElement(endDateInput);
        click(endDateInput);
    }

    private void clearEndDateInput() {
        wait.visibilityOfElement(endDateInput);
        wait.prevenseOfElement(endDateInput);
        find(endDateInput).clear();
    }

    private void setEndDateInput(String endsDateInput) {
        wait.visibilityOfElement(endDateInput);
        wait.prevenseOfElement(endDateInput);
        type(endsDateInput, endDateInput);
    }
    private void fillEndDateInput(String endsDateInput) {
        clickEndDateInput() ;
        clearEndDateInput();
        setEndDateInput(endsDateInput);
    }


    private void clickStartTimeField() {
        wait.visibilityOfElement(startTimeField);
        wait.prevenseOfElement(startTimeField);
        click(startTimeField);
    }

    private void clearStartTimeField() {
        wait.visibilityOfElement(startTimeField);
        wait.prevenseOfElement(startTimeField);
        find(startTimeField).clear();
    }

    private void setStartTimeField(String startsTimeField) {
        wait.visibilityOfElement(startTimeField);
        wait.prevenseOfElement(startTimeField);
        type(startsTimeField, startTimeField);
    }

    private void fillStartTimeField(String startsTimeField) {
        clickStartTimeField();
        clearStartTimeField();
        setStartTimeField( startsTimeField);
    }
    private void clickEndTimeField() {
        wait.visibilityOfElement(endTimeField);
        wait.prevenseOfElement(endTimeField);
        click(endTimeField);
    }

    private void clearEndTimeField() {
        wait.visibilityOfElement(endTimeField);
        wait.prevenseOfElement(endTimeField);
        find(endTimeField).clear();
    }

    private void setEndTimeField(String endsTimeField) {
        wait.visibilityOfElement(endTimeField);
        wait.prevenseOfElement(endTimeField);
        type(endsTimeField, endTimeField);
    }

    private void fillEndTimeField(String endsTimeField) {
        clickEndTimeField();
        clearEndTimeField();
        setEndTimeField( endsTimeField);
    }
    private void clickGroupDropDown() {
        wait.visibilityOfElement2(driver.findElement(groupDropDown));
        wait.prevenseOfElement(groupDropDown);
        wait.waitForElementClickability(groupDropDown);
        click(groupDropDown);
        wait.prevenseOfElement(By.xpath("//mat-option/span"));
    }


    private void clickGroupOptions(String group) {

        wait.prevenseOfElement(By.xpath("//mat-option/span"));
        List<WebElement> dropDown = driver.findElements(By.xpath("//mat-option/span"));
        for (WebElement options : dropDown) {
            if (options.getText().equals(group)) {
                wait.waitForElementClickability2(options);
                options.click();
                wait.invisibilityOfEmelement2(options);
                break;
            }

        }

    }

    private void setGroupDropDownOption(String group) {
        clickGroupDropDown();
        clickGroupOptions(group);

    }
    public AddNewScheduleModalWindow(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
        wait = new WaitUtils(driver,10);
        datePicker = new DatePicker(driver);
    }
    private DatePicker getStartDateFieldDatePicker() {
        startDateField.click();
        return datePicker;
    }
    private DatePicker getEndDateFieldDatePicker() {
        endDateField.click();
        return datePicker;
    }
    private void setStartDate(String date){
        getStartDateFieldDatePicker()
                .setDate(date);
    }
    private void setEndDate(String date){
        getEndDateFieldDatePicker()
                .setDate(date);
    }
    private void fillAllScheduleFields(String group,String startDate,String endDate,String startTime,String endTime) {
        setGroupDropDownOption(group);
        fillStartDateInput(startDate);
        fillEndDateInput(endDate);
        fillStartTimeField(startTime);
        fillEndTimeField(endTime);

    }

    private void addNewSchedule(String group,String startDate,String endDate,String startTime,String endTime) {
        fillAllScheduleFields(group, startDate,endDate,startTime,endTime);
        clickSubmitButton();
    }

    public ScheduleTestingPage fillAllScheduleFieldsAndSubmitForm(String group, String startDate, String endDate, String startTime, String endTime) {
        String addSubjectPageWindow = driver.getWindowHandle();
        addNewSchedule(group, startDate,endDate,startTime,endTime);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                wait.invisibilityOfEmelement2(getSubmitButton());
                driver.switchTo().window(windowHandle);


            }
        }

        return new ScheduleTestingPage(driver, log);
    }
    public AddNewScheduleModalWindow fillInvalidScheduleData(String group,NewSchedule schedule) {
        fillInvalidData(group,schedule);
        return new AddNewScheduleModalWindow(driver,log);
    }

    private void fillInvalidData(String group,NewSchedule schedule) {
        fillAllFields(group,schedule);

    }

    private void fillAllFields(String group,NewSchedule schedule) {
        setGroupDropDownOption(group);
        fillInvalidStartDateField(schedule);
        fillInvalidEndDateField(schedule);
        fillInvalidStartTimeField(schedule);
        fillInvalidEndTimeField(schedule);


    }

    private void setInvalidEndDateField(NewSchedule schedule) {
        wait.visibilityOfElement(endDateInput);
        wait.prevenseOfElement(endDateInput);
        type(schedule.getEndDate(),endDateInput);
    }

    private void fillInvalidEndDateField(NewSchedule schedule) {
        clickEndDateInput();

        driver.findElement(endDateInput).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        setInvalidEndDateField(schedule);
    }
    private void setInvalidStartDateField(NewSchedule schedule) {
        wait.visibilityOfElement(startDateInput);
        wait.prevenseOfElement(startDateInput);
        type(schedule.getStartDate(),startDateInput);
    }

    private void fillInvalidStartDateField(NewSchedule schedule) {
       clickStartDateInput();
       driver.findElement(startDateInput).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
       setInvalidStartDateField(schedule);
    }
    private void setInvalidStartTimeField(NewSchedule schedule) {
        wait.visibilityOfElement(startTimeField);
        wait.prevenseOfElement(startTimeField);
        type(schedule.getStartTime(),startTimeField);
    }

    private void fillInvalidStartTimeField(NewSchedule schedule) {
        clickStartTimeField();
        clearStartTimeField();
        setInvalidStartTimeField(schedule);
    }
    private void fillInvalidEndTimeField(NewSchedule schedule) {
        clickEndTimeField();
        clearEndTimeField();
        setInvalidEndTimeField(schedule);
    }
    private void setInvalidEndTimeField(NewSchedule schedule) {
        wait.visibilityOfElement(endTimeField);
        wait.prevenseOfElement(endTimeField);
        type(schedule.getEndTime(),endTimeField);
    }

}
