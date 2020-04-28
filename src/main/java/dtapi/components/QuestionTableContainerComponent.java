package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class QuestionTableContainerComponent {
    private WebElement questionTableComponent;

    private By questionId = By.xpath(".//td[contains(@class,'cdk-column-number')]");
    private By questionText = By.xpath(".//td[contains(@class,'cdk-column-question_text')]");
    private By questionType = By.xpath(".//td[contains(@class,'cdk-column-type')]");
    private By questionLvl = By.xpath(".//td[contains(@class,'cdk-column-level')]");
    private By editQuestionIcon = By.xpath(".//td//mat-icon[contains(text(),'settings_applications')]");
    private By deleteQuestionIcon = By.xpath(".//td//mat-icon[contains(text(),'delete')]");


    public QuestionTableContainerComponent(WebElement questionTableComponent) {

        this.questionTableComponent = questionTableComponent;


    }


    public WebElement getQuestionId() {
        WebElement questionsId = questionTableComponent.findElement(questionId);
        return questionsId;
    }

    public String getQuestionIdText() {
        return getQuestionId().getText();
    }


    public WebElement getQuestionText() {


        WebElement questionsText = questionTableComponent.findElement(questionText);
        return questionsText;
    }

    public String getQuestionTextText() {

        return getQuestionText().getText();
    }

    public WebElement getQuestionType() {
        WebElement questionsType = questionTableComponent.findElement(questionType);

        return questionsType;
    }

    public String getQuestionTypeText() {
        return getQuestionType().getText();
    }


    public WebElement getQuestionLvl() {
        WebElement questionsLvl = questionTableComponent.findElement(questionLvl);

        return questionsLvl;
    }

    public String getQuestionLvlText() {
        return getQuestionLvl().getText();
    }



    public WebElement getEditQuestionIcon() {
        WebElement editQuestionsIcon = questionTableComponent.findElement(editQuestionIcon);
        return editQuestionsIcon;
    }

    public void clickEditQuestionIcon() {
        getEditQuestionIcon().click();
    }



    public WebElement getDeleteQuestionIcon() {
        WebElement deleteQuestionsIcon = questionTableComponent.findElement(deleteQuestionIcon);
        return  deleteQuestionsIcon;
    }

    public void clickDeleteQuestionIcon() {
        getDeleteQuestionIcon().click();
    }
}
