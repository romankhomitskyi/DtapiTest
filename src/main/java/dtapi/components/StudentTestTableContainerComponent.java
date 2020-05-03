package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StudentTestTableContainerComponent {
    private WebElement studentTestTableComponent;

    private By subjectName = By.xpath(".//td[contains(@class,'cdk-column-subject')]");
    private By testName = By.xpath(".//td[contains(@class,'cdk-column-test')]");
    private By startTestIcon = By.xpath(".//td//mat-icon[contains(text(),' play_circle_outline ')]");



    public StudentTestTableContainerComponent(WebElement studentTestTableComponent) {

        this.studentTestTableComponent = studentTestTableComponent;


    }


    public WebElement getSubjectName() {
        WebElement subjectsName = studentTestTableComponent.findElement(subjectName);
        return subjectsName;
    }

    public String getSubjectNameText() {
        return getSubjectName().getText();
    }


    public WebElement getTestName() {


        WebElement testsName = studentTestTableComponent.findElement(testName);
        return testsName;
    }

    public String getTestNameText() {

        return getTestName().getText();
    }



    public WebElement getStartTestIcon() {

        WebElement startsTestIcon = studentTestTableComponent.findElement(startTestIcon);
        return  startsTestIcon;
    }

    public void clickStartTestIcon() {
        getStartTestIcon().click();
    }






}
