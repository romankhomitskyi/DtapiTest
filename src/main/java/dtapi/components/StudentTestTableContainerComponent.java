package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StudentTestTableContainerComponent {
    private WebElement studentTestTableComponent;

    private WebElement subjectName;
    private WebElement testName;
    private WebElement startTestIcon ;



    public StudentTestTableContainerComponent(WebElement studentTestTableComponent) {

        this.studentTestTableComponent = studentTestTableComponent;
        initElements();


    }
    private void initElements(){
    subjectName = studentTestTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-subject')]"));
    testName = studentTestTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-test')]"));
    startTestIcon = studentTestTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),' play_circle_outline ')]"));
    }


    public WebElement getSubjectName() {
        return subjectName;
    }

    public String getSubjectNameText() {
        return getSubjectName().getText();
    }


    public WebElement getTestName() {
        return testName;
    }

    public String getTestNameText() {

        return getTestName().getText();
    }



    public WebElement getStartTestIcon() {

        return  startTestIcon;
    }

    public void clickStartTestIcon() {
        getStartTestIcon().click();
    }


}
