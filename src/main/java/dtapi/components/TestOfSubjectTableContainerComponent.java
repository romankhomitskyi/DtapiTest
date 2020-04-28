package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestOfSubjectTableContainerComponent {
    private By testId = By.xpath(".//td[contains(@class,'cdk-column-id')]");
    private By testName = By.xpath(".//td[contains(@class,'cdk-column-name')]");
    private By subjectName = By.xpath(".//td[contains(@class,'cdk-column-subject')]");
    private By countTask = By.xpath(".//td//mat-icon[contains(text(),'cdk-column-tasks')]");
    private By testParamIcon = By.xpath(".//td//mat-icon[contains(text(),'description')]");
    private By questionIcon = By.xpath(".//td//mat-icon[contains(text(),'list')]");
    private By editTestIcon = By.xpath(".//td//mat-icon[contains(text(),'edit')]");
    private By deleteTestIcon = By.xpath(".//td//mat-icon[contains(text(),'delete')]");
    private WebElement testOfSubjectTableComponent;

    public TestOfSubjectTableContainerComponent(WebElement testOfSubjectTableComponent) {

        this.testOfSubjectTableComponent = testOfSubjectTableComponent;

    }
    public WebElement getTestId() {
        WebElement testsId = testOfSubjectTableComponent.findElement(testId);
        return testsId;
    }

    public String getTestIdText() {
        return getTestId().getText();
    }


    public WebElement getTestOfSubjectName() {


        WebElement subjectsName = testOfSubjectTableComponent.findElement(subjectName);
        return subjectsName;
    }

    public String getTestOfSubjectNameText() {

        return getTestOfSubjectName().getText();
    }

    public WebElement getTestName() {
        WebElement testsName = testOfSubjectTableComponent.findElement(testName);

        return testsName;
    }

    public String getTestNameText() {
        return getTestName().getText();
    }

    public WebElement getCountTask() {
        WebElement countsTask = testOfSubjectTableComponent.findElement(countTask);

        return countsTask;
    }

    public String getCountTaskText() {
        return getCountTask().getText();
    }




    public WebElement getEditTestIcon() {

        WebElement editsTestIcon = testOfSubjectTableComponent.findElement(editTestIcon);
        return  editsTestIcon;
    }

    public void clickEditTestIcon() {
        getEditTestIcon().click();
    }

    public WebElement getTestParamIcon() {
        WebElement testsParamIcon = testOfSubjectTableComponent.findElement(testParamIcon);
        return testsParamIcon;
    }

    public void clickTestParamIcon() {
        getTestParamIcon().click();
    }

    public WebElement getQuestionIcon() {
        WebElement questionsIcon = testOfSubjectTableComponent.findElement(questionIcon);
        return questionsIcon;
    }

    public void clickQuestionIcon() {
        getQuestionIcon().click();
    }

    public WebElement getDeleteTestIcon() {
        WebElement deleteTestsIcon = testOfSubjectTableComponent.findElement(deleteTestIcon);
        return deleteTestsIcon;
    }

    public void clickDeleteTestIcon() {
        getDeleteTestIcon().click();
    }
}
