package dtapi.pages;

import dtapi.components.AnswerComponent;
import dtapi.data.question.NewQuestion;
import dtapi.dtapiBase.WaitUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddQuestionPage extends BasePageObject {
    private final String ANSWER_COMPONENT_XPATH = "//mat-form-field/parent::div";
    private List<AnswerComponent> answerComponents;
    private WaitUtils wait;
    private By questionField = By.xpath("//textarea");
    private By addAnswer = By.xpath("//span[contains(text(),'Додати відповідь')]/parent::button");
    private By createAnswer = By.xpath("//button[@type='submit']");

    public AddQuestionPage(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 10);
    }


    public List<AnswerComponent> getAnswerComponent() {
        answerComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.xpath(ANSWER_COMPONENT_XPATH))) {
            answerComponents.add(new AnswerComponent(current));
        }
        return answerComponents;
    }

    public void clickAnswerComponentDeleteButtons() {
        for (AnswerComponent current : getAnswerComponent()) {
            current.clickDeleteButtons();
        }

    }

    public void clickCheckBox(int i) {
        getListCheckBoxes().get(i).click();


    }

    public List<WebElement> getAllCheckBoxes() {
        List<WebElement> checkBoxes = new ArrayList<>();
        for (AnswerComponent current : getAnswerComponent()) {
            checkBoxes.add(current.getCheckBox());
        }
        return checkBoxes;
    }

    public List<WebElement> getListCheckBoxes() {
        return getAllCheckBoxes();
    }

    public List<WebElement> getAnswerComponentDeleteButtons() {
        List<WebElement> deleteButtons = new ArrayList<>();
        for (AnswerComponent current : getAnswerComponent()) {
            deleteButtons.add(current.getAnswerDeleteButton());
        }
        return deleteButtons;
    }

    public List<WebElement> getAnswerComponentDeleteButtonsCount() {
        return getAnswerComponentDeleteButtons();
    }

    private List<WebElement> getInputs() {
        List<WebElement> inputs = new ArrayList<>();
        for (AnswerComponent field : getAnswerComponent()) {
            inputs.add(field.getAnswerInput());
        }
        return inputs;
    }

    public int getAllInputsCount() {
        return getInputs().size();
    }

    public List<WebElement> getAllInputs() {
        return getInputs();
    }

    /*private List<String> getAnswersForInput(NewQuestion answers) {
        List<String> strings = new ArrayList<>();
        for (String field  : answers.getAnswers()) {
            strings.add(field);
        }
        return strings;
    }*/
    /*public List<String> getAllStrings(NewQuestion answers) {
        return getAnswersForInput(answers);
    }*/


    /*public void setAnswerFields(NewQuestion answer) {
        for (int i =0; i< getAnswerComponent().size(); i++) {
                getAnswerComponent().get(i).fillAnswerField(answer.getAnswers().get(i));
            }
    }*/
    /*public void setAnswerFields(NewQuestion answer) {
        for (int i =0; i< getAnswerComponent().size(); i++) {

            getAnswerComponent().get(i).fillAnswerField(answer.getAnswers().get(i));
        }
    }*/
    public void setAnswerFields(NewQuestion answer) {
        int i = 0;
        for (Map.Entry<String, Boolean> item : answer.getAnswers().entrySet()) {
            getAnswerComponent().get(i).fillAnswerField(item.getKey());
            if (item.getValue()) {
                clickCheckBox(i);
            }
            i++;

        }
    }


    private void clickQuestionField() {
        driver.findElement(questionField).click();
    }

    private void clearQuestionField() {
        driver.findElement(questionField).clear();
    }

    private void setQuestionField(NewQuestion question) {
        wait.scrollUntilElementVisible(driver.findElement(questionField));
        driver.findElement(questionField).sendKeys(question.getQuestionName());
    }

    private void fillQuestionField(NewQuestion question) {
        clickQuestionField();
        clearQuestionField();
        setQuestionField(question);
    }

    public QuestionPage fillAllQuestion(NewQuestion question) {
        fillQuestionField(question);
        setAnswerFields(question);
        clickCreateQustionButton();
        return new QuestionPage(driver, log);
    }

    public AddQuestionPage clickAddAnswerButton() {
        driver.findElement(addAnswer).click();
        return new AddQuestionPage(driver, log);
    }

    public void clickCreateQustionButton() {
        wait.scrollUntilElementVisible(driver.findElement(createAnswer));
        driver.findElement(createAnswer).click();

    }


}




