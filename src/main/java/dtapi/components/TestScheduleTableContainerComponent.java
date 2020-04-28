package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestScheduleTableContainerComponent {
    private WebElement testScheduleTableComponent;

    private By scheduleTestId = By.xpath(".//td[contains(@class,'cdk-column-id')]");
    private By group = By.xpath(".//td[contains(@class,'cdk-column-group')]");
    private By startDate = By.xpath(".//td[contains(@class,'cdk-column-start_date')]");
    private By startTime = By.xpath(".//td[contains(@class,'cdk-column-start_time')]");
    private By endDate = By.xpath(".//td[contains(@class,' cdk-column-end_date')]");
    private By endTime = By.xpath(".//td[contains(@class,' cdk-column-end_time')]");
    private By editScheduleTestIcon = By.xpath(".//td//mat-icon[contains(text(),'edit')]");
    private By deleteScheduleTestIcon = By.xpath(".//td//mat-icon[contains(text(),'delete')]");


    public TestScheduleTableContainerComponent(WebElement testScheduleTableComponent) {

        this.testScheduleTableComponent = testScheduleTableComponent;


    }


    public WebElement getScheduleTestId() {
        WebElement schedulesTestId = testScheduleTableComponent.findElement(scheduleTestId);
        return schedulesTestId;
    }

    public String getScheduleTestIdText() {
        return getScheduleTestId().getText();
    }


    public WebElement getGroup() {

        WebElement groups = testScheduleTableComponent.findElement(group);
        return groups;
    }

    public String getGroupText() {

        return getGroup().getText();
    }

    public WebElement getStartDate() {
        WebElement startsDate = testScheduleTableComponent.findElement(startDate);

        return startsDate;
    }

    public String getStartDateText() {
        return getStartDate().getText();
    }

    public WebElement getEndDate() {

        WebElement endsDate = testScheduleTableComponent.findElement(endDate);
        return endsDate;
    }

    public String getEndDateText() {
        return getEndDate().getText();
    }
    public WebElement getEndTime() {

        WebElement endsTime = testScheduleTableComponent.findElement(endTime);
        return endsTime;
    }

    public String getEndTimeText() {
        return getEndTime().getText();
    }


    public WebElement getStartTime() {

        WebElement startsTime = testScheduleTableComponent.findElement(startTime);
        return startsTime;
    }

    public String getStartTimeText() {
        return getStartTime().getText();
    }



    public WebElement getEditScheduleTestIcon() {

        WebElement editsScheduleTest = testScheduleTableComponent.findElement(editScheduleTestIcon);
        return editsScheduleTest;
    }

    public void clickEditScheduleTestIcon() {
        getEditScheduleTestIcon().click();
    }





    public WebElement getDeleteScheduleTestIcon() {
        WebElement deletesScheduleTestIcon = testScheduleTableComponent.findElement(deleteScheduleTestIcon);
        return deletesScheduleTestIcon;
    }

    public void clickDeleteScheduleTestIcon() {
        getDeleteScheduleTestIcon().click();
    }
}
