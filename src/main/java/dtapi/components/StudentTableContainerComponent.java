package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StudentTableContainerComponent {
    private WebElement studentTableComponent;

    private WebElement studentId;
    private WebElement gradeBookId ;
    private WebElement studentNSF ;
    private WebElement studentDataIcon ;
    private WebElement switchGroupIcon ;
    private WebElement editStudentIcon ;
    private WebElement deleteStudentIcon ;


    public StudentTableContainerComponent(WebElement studentTableComponent) {

        this.studentTableComponent = studentTableComponent;
        iniElements();

    }
    private void iniElements(){
     studentId = studentTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-numeration')]"));
     gradeBookId = studentTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-gradebookID')]"));
     studentNSF = studentTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-studentNSF')]"));
     studentDataIcon = studentTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'assignment_ind')]"));
     switchGroupIcon = studentTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'compare_arrows')]"));
     editStudentIcon = studentTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'edit')]"));
     deleteStudentIcon = studentTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'delete')]"));

    }


    public WebElement getStudentId() {
        return studentId;
    }

    public String getStudentIdText() {
        return getStudentId().getText();
    }


    public WebElement getGradeBookId() {
        return gradeBookId;
    }

    public String getGradeBookIdText() {
        return getGradeBookId().getText();
    }

    public WebElement getStudentNSF() {
        return studentNSF;
    }

    public String getStudentNSFText() {
        return getStudentNSF().getText();
    }

    public WebElement getEditStudentIcon() {

        return  editStudentIcon;
    }

    public void clickEditStudentIcon() {
        getEditStudentIcon().click();
    }

    public WebElement getStudentDataIcon() {
        return studentDataIcon;
    }

    public void clickStudentDataIcon() {
        getStudentDataIcon().click();
    }

    public WebElement getSwitchGroupIcon() {
        return switchGroupIcon;
    }

    public void clickSwitchGroupIcon() {
        getSwitchGroupIcon().click();
    }

    public WebElement getDeleteStudentIcon() {

        return deleteStudentIcon;
    }

    public void clickDeleteStudentIcon() {
        getDeleteStudentIcon().click();
    }
}
