package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GroupTableContainerComponent {
    private WebElement groupTableComponent;

    private WebElement groupId ;
    private WebElement groupCode ;
    private WebElement groupSpecility;
    private WebElement groupFaculty ;
    private WebElement studentInGroupIcon;
    private WebElement groupTestResultsIcon ;
    private WebElement editGroupIcon ;
    private WebElement deleteGroupIcon;


    public GroupTableContainerComponent(WebElement groupTableComponent) {

        this.groupTableComponent = groupTableComponent;
        initElements();

    }
    private void initElements(){
        groupId = groupTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-group_id')]"));
        groupCode =groupTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-group_name')]"));
        groupSpecility =groupTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-speciality')]"));
        groupFaculty =groupTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-faculty')]"));
        studentInGroupIcon =groupTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'supervisor_account')]"));
        groupTestResultsIcon =groupTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'score')]"));
        editGroupIcon =groupTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'edit')]"));
         deleteGroupIcon =groupTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'delete')]"));
    }

    public WebElement getGroupId() {
        return groupId;
    }

    public String getGroupIdText() {
        return getGroupId().getText();
    }


    public WebElement getGroupCode() {
        return groupCode;
    }

    public String getGroupCodeText() {

        return getGroupCode().getText();
    }

    public WebElement getGroupSpecility() {
        return groupSpecility;
    }

    public String getGroupSpecilityText() {
        return getGroupSpecility().getText();
    }

    public WebElement getGroupFaculty() {

        return groupFaculty;
    }

    public String getGroupFacultyText() {
        return getGroupFaculty().getText();
    }


    public WebElement getEditGroupIcon() {

        return editGroupIcon;
    }

    public void clickEditGroupIcon() {
        getEditGroupIcon().click();
    }

    public WebElement getStudentInGroupIcon() {
        return studentInGroupIcon;
    }

    public void clickStudentInGroupIcon() {
        getStudentInGroupIcon().click();
    }

    public WebElement getGroupTestResultsIcon() {

        return groupTestResultsIcon;
    }

    public void clickGroupTestResultsIcon() {
        getGroupTestResultsIcon().click();
    }

    public WebElement getDeleteGroupIcon() {
        return deleteGroupIcon;
    }

    public void clickDeleteGroupIcon() {
        getDeleteGroupIcon().click();
    }


}
