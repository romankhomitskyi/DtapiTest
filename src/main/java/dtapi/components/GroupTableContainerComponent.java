package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GroupTableContainerComponent {
    private WebElement groupTableComponent;

    private By groupId = By.xpath(".//td[contains(@class,'cdk-column-group_id')]");
    private By groupCode = By.xpath(".//td[contains(@class,'cdk-column-group_name')]");
    private By groupSpecility = By.xpath(".//td[contains(@class,'cdk-column-speciality')]");
    private By groupFaculty = By.xpath(".//td[contains(@class,'cdk-column-faculty')]");
    private By studentInGroupIcon = By.xpath(".//td//mat-icon[contains(text(),'supervisor_account')]");
    private By groupTestResultsIcon = By.xpath(".//td//mat-icon[contains(text(),'score')]");
    private By editGroupIcon = By.xpath(".//td//mat-icon[contains(text(),'edit')]");
    private By deleteGroupIcon = By.xpath(".//td//mat-icon[contains(text(),'delete')]");


    public GroupTableContainerComponent(WebElement groupTableComponent) {

        this.groupTableComponent = groupTableComponent;


    }


    public WebElement getGroupId() {
        WebElement groupsId = groupTableComponent.findElement(groupId);
        return groupsId;
    }

    public String getGroupIdText() {
        return getGroupId().getText();
    }


    public WebElement getGroupCode() {


        WebElement groupsCode = groupTableComponent.findElement(groupCode);
        return groupsCode;
    }

    public String getGroupCodeText() {

        return getGroupCode().getText();
    }

    public WebElement getGroupSpecility() {
        WebElement groupsSpecility = groupTableComponent.findElement(groupSpecility);

        return groupsSpecility;
    }

    public String getGroupSpecilityText() {
        return getGroupSpecility().getText();
    }

    public WebElement getGroupFaculty() {

        WebElement groupsFaculty = groupTableComponent.findElement(groupFaculty);
        return groupsFaculty;
    }

    public String getGroupFacultyText() {
        return getGroupFaculty().getText();
    }


    public WebElement getEditGroupIcon() {

        WebElement editsGroupIcon = groupTableComponent.findElement(editGroupIcon);
        return editsGroupIcon;
    }

    public void clickEditGroupIcon() {
        getEditGroupIcon().click();
    }

    public WebElement getStudentInGroupIcon() {
        WebElement studentsInGroupIcon = groupTableComponent.findElement(studentInGroupIcon);
        return studentsInGroupIcon;
    }

    public void clickStudentInGroupIcon() {
        getStudentInGroupIcon().click();
    }

    public WebElement getGroupTestResultsIcon() {
        WebElement groupsTestResultsIcon = groupTableComponent.findElement(groupTestResultsIcon);
        return groupsTestResultsIcon;
    }

    public void clickGroupTestResultsIcon() {
        getGroupTestResultsIcon().click();
    }

    public WebElement getDeleteGroupIcon() {
        WebElement deleteGroupsIcon = groupTableComponent.findElement(deleteGroupIcon);
        return deleteGroupsIcon;
    }

    public void clickDeleteGroupIcon() {
        getDeleteGroupIcon().click();
    }


}
