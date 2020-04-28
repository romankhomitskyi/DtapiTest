package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StudentTableContainerComponent {
    private WebElement studentTableComponent;

    private By studentId = By.xpath(".//td[contains(@class,'cdk-column-numeration')]");
    private By gradeBookId = By.xpath(".//td[contains(@class,'cdk-column-gradebookID')]");
    private By studentNSF = By.xpath(".//td[contains(@class,'cdk-column-studentNSF')]");
    private By studentDataIcon = By.xpath(".//td//mat-icon[contains(text(),'assignment_ind')]");
    private By switchGroupIcon = By.xpath(".//td//mat-icon[contains(text(),'compare_arrows')]");
    private By editStudentIcon = By.xpath(".//td//mat-icon[contains(text(),'edit')]");
    private By deleteStudentIcon = By.xpath(".//td//mat-icon[contains(text(),'delete')]");


    public StudentTableContainerComponent(WebElement studentTableComponent) {

        this.studentTableComponent = studentTableComponent;


    }


    public WebElement getStudentId() {
        WebElement studentsId = studentTableComponent.findElement(studentId);
        return studentsId;
    }

    public String getStudentIdText() {
        return getStudentId().getText();
    }


    public WebElement getGradeBookId() {


        WebElement gradeBooksId = studentTableComponent.findElement(gradeBookId);
        return gradeBooksId;
    }

    public String getGradeBookIdText() {

        return getGradeBookId().getText();
    }

    public WebElement getStudentNSF() {
        WebElement studentsNSF = studentTableComponent.findElement(studentNSF);

        return studentsNSF;
    }

    public String getStudentNSFText() {
        return getStudentNSF().getText();
    }




    public WebElement getEditStudentIcon() {

        WebElement editsStudentIcon = studentTableComponent.findElement(editStudentIcon);
        return  editsStudentIcon;
    }

    public void clickEditStudentIcon() {
        getEditStudentIcon().click();
    }

    public WebElement getStudentDataIcon() {
        WebElement studentsDataIcon = studentTableComponent.findElement(studentDataIcon);
        return studentsDataIcon;
    }

    public void clickStudentDataIcon() {
        getStudentDataIcon().click();
    }

    public WebElement getSwitchGroupIcon() {
        WebElement switchGroupsIcon = studentTableComponent.findElement(switchGroupIcon);
        return switchGroupsIcon;
    }

    public void clickSwitchGroupIcon() {
        getSwitchGroupIcon().click();
    }

    public WebElement getDeleteStudentIcon() {
        WebElement deleteStudentsIcon = studentTableComponent.findElement(deleteStudentIcon);
        return deleteStudentsIcon;
    }

    public void clickDeleteStudentIcon() {
        getDeleteStudentIcon().click();
    }
}
