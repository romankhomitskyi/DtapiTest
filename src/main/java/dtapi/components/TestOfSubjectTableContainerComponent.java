package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestOfSubjectTableContainerComponent {
    private WebElement testOfSubjectTableComponent;

    private WebElement testId;
    private WebElement testName;
    private WebElement subjectName;
    private WebElement countTask;
    private WebElement testParamIcon ;
    private WebElement questionIcon;
    private WebElement editTestIcon;
    private WebElement deleteTestIcon ;


    public TestOfSubjectTableContainerComponent(WebElement testOfSubjectTableComponent) {

        this.testOfSubjectTableComponent = testOfSubjectTableComponent;
        iniElements();
    }
    private void iniElements(){
    testId = testOfSubjectTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-id')]"));
    testName = testOfSubjectTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-name')]"));
    subjectName = testOfSubjectTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-subject')]"));
    countTask = testOfSubjectTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-tasks')]"));
    testParamIcon = testOfSubjectTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'description')]"));
    questionIcon = testOfSubjectTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'list')]"));
    editTestIcon = testOfSubjectTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'edit')]"));
    deleteTestIcon = testOfSubjectTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'delete')]"));

    }
    public WebElement getTestId() {
        return testId;
    }

    public String getTestIdText() {
        return getTestId().getText();
    }

    public WebElement getTestOfSubjectName() {
        return subjectName;
    }

    public String getTestOfSubjectNameText() {
        return getTestOfSubjectName().getText();
    }

    public WebElement getTestName() {
        return testName;
    }

    public String getTestNameText() {
        return getTestName().getText();
    }

    public WebElement getCountTask() {
        return countTask;
    }

    public String getCountTaskText() {
        return getCountTask().getText();
    }


    public WebElement getEditTestIcon() {
        return  editTestIcon;
    }

    public void clickEditTestIcon() {
        getEditTestIcon().click();
    }

    public WebElement getTestParamIcon() {
        return testParamIcon;
    }

    public void clickTestParamIcon() {
        getTestParamIcon().click();
    }

    public WebElement getQuestionIcon() {
        return questionIcon;
    }

    public void clickQuestionIcon() {
        getQuestionIcon().click();
    }

    public WebElement getDeleteTestIcon() {
        return deleteTestIcon;
    }

    public void clickDeleteTestIcon() {
        getDeleteTestIcon().click();
    }
}
