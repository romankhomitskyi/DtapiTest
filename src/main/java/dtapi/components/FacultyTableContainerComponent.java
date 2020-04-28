package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FacultyTableContainerComponent {
    private WebElement facultyTableComponent;

    private By facultyId = By.xpath(".//td[contains(@class,'cdk-column-faculty_id')]");
    private By facultyName = By.xpath(".//td[contains(@class,'cdk-column-faculty_name')]");
    private By facultyDesc = By.xpath(".//td[contains(@class,'cdk-column-faculty_description')]");
    private By editFacultyIcon = By.xpath(".//td//mat-icon[contains(text(),'edit')]");
    private By deleteFacultyIcon = By.xpath(".//td//mat-icon[contains(text(),'delete')]");


    public FacultyTableContainerComponent(WebElement facultyTableComponent) {

        this.facultyTableComponent = facultyTableComponent;


    }


    public WebElement getFacultyId() {
        WebElement facultysId = facultyTableComponent.findElement(facultyId);
        return facultysId;
    }

    public String getFacultyIdText() {
        return getFacultyId().getText();
    }


    public WebElement getFacultyName() {


        WebElement facultysName = facultyTableComponent.findElement(facultyName);
        return facultysName;
    }

    public String getFacultyNameText() {

        return getFacultyName().getText();
    }

    public WebElement getFacultyDesc() {
        WebElement facultysDesc = facultyTableComponent.findElement(facultyDesc);

        return facultysDesc;
    }

    public String getFacultyDescText() {
        return getFacultyDesc().getText();
    }



    public WebElement getEditFacultyIcon() {
        WebElement editFacultysIcon = facultyTableComponent.findElement(editFacultyIcon);
        return editFacultysIcon;
    }

    public void clickFacultyEditIcon() {
        getEditFacultyIcon().click();
    }



    public WebElement getDeleteFacultyIcon() {
        WebElement deleteFacultysIcon = facultyTableComponent.findElement(deleteFacultyIcon);
        return  deleteFacultysIcon;
    }

    public void clickDeleteFacultyIcon() {
        getDeleteFacultyIcon().click();
    }
}
