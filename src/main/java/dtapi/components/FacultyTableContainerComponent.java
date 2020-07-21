package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FacultyTableContainerComponent {
    private WebElement facultyTableComponent;

    private WebElement facultyId;
    private WebElement facultyName;
    private WebElement facultyDesc ;
    private WebElement editFacultyIcon ;
    private WebElement deleteFacultyIcon ;


    public FacultyTableContainerComponent(WebElement facultyTableComponent) {

        this.facultyTableComponent = facultyTableComponent;
        initElements();

    }
    private void initElements(){
        facultyId = facultyTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-faculty_id')]"));
        facultyName = facultyTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-faculty_name')]"));
        facultyDesc = facultyTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-faculty_description')]"));
        editFacultyIcon =facultyTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'edit')]"));
        deleteFacultyIcon =facultyTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'delete')]"));

    }

    public WebElement getFacultyId() {
        return facultyId;
    }

    public String getFacultyIdText() {
        return getFacultyId().getText();
    }


    public WebElement getFacultyName() {
        return facultyName;
    }

    public String getFacultyNameText() {
        return getFacultyName().getText();
    }

    public WebElement getFacultyDesc() {
        return facultyDesc;
    }

    public String getFacultyDescText() {
        return getFacultyDesc().getText();
    }


    public WebElement getEditFacultyIcon() {
        return editFacultyIcon;
    }

    public void clickFacultyEditIcon() {
        getEditFacultyIcon().click();
    }



    public WebElement getDeleteFacultyIcon() {
        return  deleteFacultyIcon;
    }

    public void clickDeleteFacultyIcon() {
        getDeleteFacultyIcon().click();
    }
}
