package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class AnswerComponent {

    private WebElement answerLayout;

    private By answerInput = By.xpath(".//input[@formcontrolname='answer_text']");
    private By deleteAnswerButton = By.xpath(".//span[contains(text(),'Видалити відповідь')]/parent::button");
    private By rightAnswerCheckBox = By.xpath(".//label[@class='mat-checkbox-layout']");


    public AnswerComponent(WebElement answerLayout) {
        this.answerLayout = answerLayout;


    }

    public WebElement getAnswerLayout() {
        return answerLayout;
    }

    private void clickAnswerInput() {
        getAnswerInput().click();
    }

    private void clearAnswerInput() {
        getAnswerInput().clear();
    }

    private void setAnswerInput(String answers) {
        getAnswerInput().sendKeys(answers);
    }

    public void fillAnswerField(String answer) {
        clickAnswerInput();
        clearAnswerInput();
        setAnswerInput(answer);

    }


    public WebElement getAnswerInput() {
        WebElement answerInputs = answerLayout.findElement(answerInput);
        return answerInputs;
    }

    public WebElement getAnswerDeleteButton() {
        WebElement answerInputs = answerLayout.findElement(deleteAnswerButton);
        return answerInputs;
    }

    public void clickDeleteButtons() {
        getAnswerDeleteButton().click();
    }


    public WebElement getCheckBox() {
        WebElement chexbox = answerLayout.findElement(rightAnswerCheckBox);
        return chexbox;
    }


}

