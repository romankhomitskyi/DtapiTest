package dtapi.pages;

import dtapi.components.QuestionTableContainer;
import dtapi.components.QuestionTableContainerComponent;
import dtapi.data.question.NewQuestion;
import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.Paginator;
import dtapi.modalsWindows.DeleteQuestionModalWindow;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class QuestionPage extends Paginator {
    public QuestionPage(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver,10);
        initElements();
    }
    private WaitUtils wait;
    private QuestionTableContainer questionTableContainer;
    private By addQuestion = By.xpath("//span[contains(text(),'Додати питання')]/parent::a");

    private void initElements() {

        questionTableContainer = new QuestionTableContainer(driver, log);
    }
    public QuestionTableContainer getQuestionTableContainer() {
        return questionTableContainer;
    }

    /*public AddQuestionPage clickAddQuesButton() {
        wait.prevenseOfElement(addQuestion);
        wait.visibilityOfElement(addQuestion);
        driver.findElement(addQuestion).click();
        return new AddQuestionPage(driver, log);
    }*/
    public AddQuestionPage clickAddQuesButton() {
        wait.prevenseOfElement(addQuestion);
        wait.visibilityOfElement(addQuestion);
        driver.findElement(addQuestion).click();
        return new AddQuestionPage(driver, log);
    }
    /*public QuestionPage fillAllQuestion(NewQuestion question) {
        fillQuestionField(question);
        setAnswerFields(question);
        clickCreateQustionButton();
        return new QuestionPage(driver, log);
    }*/
    public QuestionPage addQuestionWithAnswers(List<NewQuestion> questions) {

        int i = 0;
        QuestionPage questionPage = getQuestionWithAnswers(questions.get(0));

        while (i != questions.size()) {
            questionPage = questionPage. getQuestionWithAnswers(questions.get(i));
            i++;
        }

        return new QuestionPage(driver,log);
    }

    public QuestionPage getQuestionWithAnswers(NewQuestion question) {
        clickAddQuesButton()
                .clickAddAnswerButton()
                .clickAddAnswerButton()
                .clickAddAnswerButton()
                .clickAddAnswerButton()
                .fillAllQuestion(question);
        return new QuestionPage(driver,log);
    }

    public AddQuestionPage navigateToEditQuestionPage(String questionText) {
        getQuestionTableContainer()
                .getQuestionComponentByQuestionText(questionText)
                .clickEditQuestionIcon();


        return new AddQuestionPage(driver, log);
    }
    public DeleteQuestionModalWindow switchToDeleteQuestionModalWindow(String questionText) {
        String shoppingCartWindow = driver.getWindowHandle();
        getQuestionTableContainer()
                .getQuestionComponentByQuestionText(questionText)
                .clickDeleteQuestionIcon();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new  DeleteQuestionModalWindow(driver, log);
    }
    public boolean verifyQuestionEdited(String questionText) {

        for (QuestionTableContainerComponent component : getQuestionTableContainer().getQuestionContainerComponents()) {
            if (component.getQuestionTextText().equals(questionText)) {
                return true;
            }
        }
        return false;
    }
    public boolean verifyQuestionAdded(String questionText) {

        String  question = getQuestionTableContainer()
                .getQuestionComponentByQuestionText(questionText)
                .getQuestionTextText();
        if(questionText.equals(question)){
            return true;
        }

        return false;
    }
    public boolean verifyQuestionRemoved(String questionText) {

        for (QuestionTableContainerComponent  component : getQuestionTableContainer().getQuestionContainerComponents()) {
            if (component.getQuestionTextText().equals(questionText)) {
                return false;
            }
        }
        return true;
    }


}
