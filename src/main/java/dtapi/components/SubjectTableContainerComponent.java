package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SubjectTableContainerComponent {
    private By subjectId = By.xpath(".//td[contains(@class,'cdk-column-subject_id')]");
    private By subjectName = By.xpath(".//td[contains(@class,'cdk-column-subject_name')]");
    private By subjectDesc = By.xpath(".//td[contains(@class,'cdk-column-subject_description')]");
    private By subjectTestIcon = By.xpath(".//td//mat-icon[contains(text(),'assignment_turned_in')]");
    private By scheduleIcon = By.xpath(".//td//mat-icon[contains(text(),'date_range')]");
    private By editSubjectIcon = By.xpath(".//td//mat-icon[contains(text(),'edit')]");
    private By deleteSubjectIcon = By.xpath(".//td//mat-icon[contains(text(),'delete')]");
    private WebElement subjectTableComponent;

    public SubjectTableContainerComponent(WebElement subjectTableComponent) {

        this.subjectTableComponent = subjectTableComponent;

    }
    public WebElement getSubjectId() {
        WebElement subjectsId = subjectTableComponent.findElement(subjectId);
        return subjectsId;
    }

    public String getSubjectIdText() {
        return getSubjectId().getText();
    }


    public WebElement getSubjectName() {


        WebElement subjectsName = subjectTableComponent.findElement(subjectName);
        return subjectsName;
    }

    public String getSubjectNameText() {

        return getSubjectName().getText();
    }

    public WebElement getSubjectDesc() {
        WebElement subjectsDesc = subjectTableComponent.findElement(subjectDesc);

        return subjectsDesc;
    }

    public String getSubjectDescText() {
        return getSubjectDesc().getText();
    }




    public WebElement getEditSubjectIcon() {

        WebElement editsSubjectIcon = subjectTableComponent.findElement(editSubjectIcon);
        return  editsSubjectIcon;
    }

    public void clickEditSubjectIcon() {
        getEditSubjectIcon().click();
    }

    public WebElement getSubjectTestIcon() {
        WebElement subjectsTestIcon = subjectTableComponent.findElement(subjectTestIcon);
        return subjectsTestIcon;
    }

    public void clickSubjectTestIcon() {
        getSubjectTestIcon().click();
    }

    public WebElement getScheduleIcon() {
        WebElement schedulesIcon = subjectTableComponent.findElement(scheduleIcon);
        return schedulesIcon;
    }

    public void clickScheduleIcon() {
        getScheduleIcon().click();
    }

    public WebElement getDeleteSubjectIcon() {
        WebElement deleteSubjectsIcon = subjectTableComponent.findElement(deleteSubjectIcon);
        return deleteSubjectsIcon;
    }

    public void clickDeleteSubjectIcon() {
        getDeleteSubjectIcon().click();
    }
}
