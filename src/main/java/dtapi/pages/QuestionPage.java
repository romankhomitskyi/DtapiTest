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
    public QuestionPage(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver,10);
        initElements();
    }
    private WaitUtils wait;
    private QuestionTableContainer questionTableContainer;
    private By addQuestion = By.xpath("//span[contains(text(),'Додати питання')]/parent::a");

    private void initElements() {

        questionTableContainer = new QuestionTableContainer(driver);
    }
    public QuestionTableContainer getQuestionTableContainer() {
        return questionTableContainer;
    }


    public AddQuestionPage clickAddQuesButton() {
        wait.prevenseOfElement(addQuestion);
        wait.visibilityOfElement(addQuestion);
        driver.findElement(addQuestion).click();
        return new AddQuestionPage(driver);
    }

    public QuestionPage addQuestionWithAnswers(List<NewQuestion> questions) {

        int i = 1;
        QuestionPage questionPage = getQuestionWithAnswers(questions.get(0));

        while (i != questions.size()) {
            questionPage = questionPage. getQuestionWithAnswers(questions.get(i));
            i++;
        }

        return new QuestionPage(driver);
    }

    public QuestionPage getQuestionWithAnswers(NewQuestion question) {
        clickAddQuesButton()
                .fillAllQuestion(question);
        return new QuestionPage(driver);
    }

    public AddQuestionPage navigateToEditQuestionPage(NewQuestion question) {
        getQuestionTableContainer()
                .getQuestionComponentByQuestionText(question.getQuestionName())
                .clickEditQuestionIcon();


        return new AddQuestionPage(driver);
    }
    public SettingsTestPage deleteTestsQuestions(List<NewQuestion> questions) {

        int i = 1;
        QuestionPage questionPage = deleteAllQuestions(questions.get(0));

        while (i != questions.size()) {
            questionPage = questionPage.deleteAllQuestions(questions.get(i));
            i++;
        }

        return new SettingsTestPage(driver);
    }
    private QuestionPage deleteAllQuestions(NewQuestion question) {
        switchToDeleteQuestionModalWindow(question)
                .deleteQuestion();
        return new QuestionPage(driver);
    }
    public DeleteQuestionModalWindow switchToDeleteQuestionModalWindow(NewQuestion question) {
        String shoppingCartWindow = driver.getWindowHandle();
        getQuestionTableContainer()
                .getQuestionComponentByQuestionText(question)
                .clickDeleteQuestionIcon();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new  DeleteQuestionModalWindow(driver);
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
    public TestPage backToTestPage() {
        sleep(1000);
        driver.navigate().back();
        return new TestPage(driver);
    }
    protected void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
