package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SubjectTableContainerComponent {
    private WebElement subjectTableComponent;

    private WebElement subjectId;
    private WebElement subjectName;
    private WebElement subjectDesc;
    private WebElement subjectTestIcon;
    private WebElement scheduleIcon;
    private WebElement editSubjectIcon;
    private WebElement deleteSubjectIcon;

    public SubjectTableContainerComponent(WebElement subjectTableComponent) {

        this.subjectTableComponent = subjectTableComponent;
        initElements();
    }

    private void initElements() {

        subjectName = subjectTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-subject_name')]"));
        subjectDesc = subjectTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-subject_description')]"));
        subjectTestIcon  = subjectTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'assignment_turned_in')]"));
        scheduleIcon  = subjectTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'date_range')]"));
        editSubjectIcon =subjectTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'edit')]"));
        deleteSubjectIcon= subjectTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'delete')]"));
    }

    public WebElement getSubjectId() {
        return subjectId;
    }

    public String getSubjectIdText() {
        return getSubjectId().getText();
    }


    public WebElement getSubjectName() {
        return subjectName;
    }

    public String getSubjectNameText() {

        return getSubjectName().getText();
    }

    public WebElement getSubjectDesc() {
        return subjectDesc;
    }

    public String getSubjectDescText() {
        return getSubjectDesc().getText();
    }


    public WebElement getEditSubjectIcon() {
        return  editSubjectIcon;
    }

    public void clickEditSubjectIcon() {
        getEditSubjectIcon().click();
    }

    public WebElement getSubjectTestIcon() {
        return subjectTestIcon;
    }

    public void clickSubjectTestIcon() {
        getSubjectTestIcon().click();
    }

    public WebElement getScheduleIcon() {
        return scheduleIcon;
    }

    public void clickScheduleIcon() {
        getScheduleIcon().click();
    }

    public WebElement getDeleteSubjectIcon() {
        return deleteSubjectIcon;
    }

    public void clickDeleteSubjectIcon() {
        getDeleteSubjectIcon().click();
    }
}
