package dtapi.components;

import dtapi.data.question.NewQuestion;
import dtapi.elements.Paginator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class QuestionTableContainer  {
    private WebDriver driver;
    private Paginator paginator;
    private final String questionTableContainerXpath = "//table/tbody/tr";
    private List<QuestionTableContainerComponent> containerComponents;

    public QuestionTableContainer(WebDriver driver) {
        this.driver = driver;
        paginator = new Paginator(driver);
        initElements();
    }
    private void initElements(){
        containerComponents = new ArrayList<>();
        for (WebElement current :driver.findElements(By.xpath(questionTableContainerXpath))) {

            containerComponents.add(new QuestionTableContainerComponent(current));
        }
    }

    public List<QuestionTableContainerComponent> getQuestionContainerComponents() {
        return containerComponents;
    }


    public  QuestionTableContainerComponent getQuestionComponentByQuestionText(String questionText) {
        return getQuestionComponentByQuestionsText(questionText);
    }
    public  QuestionTableContainerComponent getQuestionComponentByQuestionText(NewQuestion questionText) {
        return getQuestionComponentByQuestionsText(questionText.getQuestionName());
    }

    private QuestionTableContainerComponent getQuestionComponentByQuestionsText(String questionText) {
        QuestionTableContainerComponent result = findQuestion(questionText);

        while (result == null ) {
            if (!paginator.isNextArrowEnabled() && result == null) {
                throw new RuntimeException(String.format("Question with questionText: %s not found", questionText));
            }
            paginator.clickNextButton();
            initElements();
            result = findQuestion(questionText);

        }
        return result;

    }

    private QuestionTableContainerComponent findQuestion( String questionText) {
        for (QuestionTableContainerComponent current : containerComponents) {

            if (current.getQuestionTextText().toLowerCase().equals(questionText.toLowerCase())) {

                return current;
            }
        }
        return null;
    }
}
