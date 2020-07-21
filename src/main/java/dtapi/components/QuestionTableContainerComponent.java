package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class QuestionTableContainerComponent {
    private WebElement questionTableComponent;

    private WebElement questionId ;
    private WebElement questionText ;
    private WebElement questionType ;
    private WebElement questionLvl ;
    private WebElement editQuestionIcon ;
    private WebElement deleteQuestionIcon;


    public QuestionTableContainerComponent(WebElement questionTableComponent) {

        this.questionTableComponent = questionTableComponent;
        initElements();

    }
    private void initElements(){
        questionId = questionTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-number')]"));
        questionText = questionTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-question_text')]"));
        questionType = questionTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-type')]"));
        questionLvl = questionTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-level')]"));
        editQuestionIcon = questionTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'settings_applications')]"));
        deleteQuestionIcon = questionTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'delete')]"));

    }

    public WebElement getQuestionId() {
        return questionId;
    }

    public String getQuestionIdText() {
        return getQuestionId().getText();
    }


    public WebElement getQuestionText() {
        return questionText;
    }

    public String getQuestionTextText() {

        return getQuestionText().getText();
    }

    public WebElement getQuestionType() {
        return questionType;
    }

    public String getQuestionTypeText() {
        return getQuestionType().getText();
    }


    public WebElement getQuestionLvl() {
        return questionLvl;
    }

    public String getQuestionLvlText() {
        return getQuestionLvl().getText();
    }



    public WebElement getEditQuestionIcon() {
        return editQuestionIcon;
    }

    public void clickEditQuestionIcon() {
        getEditQuestionIcon().click();
    }



    public WebElement getDeleteQuestionIcon() {
        return  deleteQuestionIcon;
    }

    public void clickDeleteQuestionIcon() {
        getDeleteQuestionIcon().click();
    }
}
