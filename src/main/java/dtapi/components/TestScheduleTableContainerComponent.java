package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestScheduleTableContainerComponent {
    private WebElement testScheduleTableComponent;

    private WebElement scheduleTestId;
    private WebElement group ;
    private WebElement startDate ;
    private WebElement startTime;
    private WebElement endDate;
    private WebElement endTime;
    private WebElement editScheduleTestIcon ;
    private WebElement deleteScheduleTestIcon ;


    public TestScheduleTableContainerComponent(WebElement testScheduleTableComponent) {

        this.testScheduleTableComponent = testScheduleTableComponent;
        initElements();

    }
    private void initElements(){
     scheduleTestId = testScheduleTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-id')]"));
     group = testScheduleTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-group')]"));
     startDate = testScheduleTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-start_date')]"));
     startTime = testScheduleTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-start_time')]"));
     endDate = testScheduleTableComponent.findElement(By.xpath(".//td[contains(@class,' cdk-column-end_date')]"));
     endTime = testScheduleTableComponent.findElement(By.xpath(".//td[contains(@class,' cdk-column-end_time')]"));
     editScheduleTestIcon = testScheduleTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'edit')]"));
     deleteScheduleTestIcon = testScheduleTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'delete')]"));


    }


    public WebElement getScheduleTestId() { ;
        return scheduleTestId;
    }

    public String getScheduleTestIdText() {
        return getScheduleTestId().getText();
    }


    public WebElement getGroup() {
        return group;
    }

    public String getGroupText() {
        return getGroup().getText();
    }

    public WebElement getStartDate() {
        return startDate;
    }

    public String getStartDateText() {
        return getStartDate().getText();
    }

    public WebElement getEndDate() {
        return endDate;
    }

    public String getEndDateText() {
        return getEndDate().getText();
    }
    public WebElement getEndTime() {
        return endTime;
    }

    public String getEndTimeText() {
        return getEndTime().getText();
    }


    public WebElement getStartTime() {
        return startTime;
    }

    public String getStartTimeText() {
        return getStartTime().getText();
    }

    public WebElement getEditScheduleTestIcon() {
        return  editScheduleTestIcon;
    }

    public void clickEditScheduleTestIcon() {
        getEditScheduleTestIcon().click();
    }


    public WebElement getDeleteScheduleTestIcon() {
        return deleteScheduleTestIcon;
    }
    public void clickDeleteScheduleTestIcon() {
        getDeleteScheduleTestIcon().click();
    }
}
