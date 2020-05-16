package dtapi.components;

import dtapi.data.question.NewQuestion;
import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.Paginator;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class QuestionTableContainer extends Paginator {
    private final String questionTableContainerXpath = "//table/tbody/tr";
    private WaitUtils wait;

    public QuestionTableContainer(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 10);
    }

    public List<QuestionTableContainerComponent> getQuestionContainerComponents() {
        WebDriverWait waits = new WebDriverWait(driver, 10);

        sleep(2000);

        List<QuestionTableContainerComponent> containerComponents = new ArrayList<>();
        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(questionTableContainerXpath))));

        for (WebElement current : rows) {
            System.out.println(current.getText());
            containerComponents.add(new QuestionTableContainerComponent(current));
        }
        return containerComponents;
    }
    public int getQuestionContainerComponentsCount() {
        return getQuestionContainerComponents().size();
    }

    public List<String> getQuestionContainerComponentNames() {
        List<String> containerComponentNames = new ArrayList<>();
        for (QuestionTableContainerComponent current : getQuestionContainerComponents()) {
            containerComponentNames.add(current.getQuestionTextText());
        }
        return containerComponentNames;
    }
    public String getContainerComponentQuestionIdByQuestionText(String questionText) {
        return getQuestionComponentByQuestionsText(questionText).getQuestionIdText();
    }

    public String getContainerComponentQuestionTypeByQuestionText(String questionText) {
        return getQuestionComponentByQuestionsText(questionText).getQuestionTypeText();
    }
    public String getContainerComponentQuestionLvlByQuestionText(String questionText) {
        return getQuestionComponentByQuestionsText(questionText).getQuestionLvlText();
    }
    public void clickContainerComponentEditQuestionIconByQuestionText(String questionText) {
        getQuestionComponentByQuestionsText(questionText).clickEditQuestionIcon();
    }

    public void clickContainerComponentDeleteQuestionIconByQuestionText(String questionText) {
        getQuestionComponentByQuestionsText(questionText).clickDeleteQuestionIcon();
    }
    public  QuestionTableContainerComponent getQuestionComponentByQuestionText(String questionText) {
        return getQuestionComponentByQuestionsText(questionText);
    }
    public  QuestionTableContainerComponent getQuestionComponentByQuestionText(NewQuestion questionText) {
        return getQuestionComponentByQuestionsText(questionText.getQuestionName());
    }
    protected QuestionTableContainerComponent getQuestionComponentByQuestionsText(String questionText) {
        QuestionTableContainerComponent result = null;
        WebDriverWait waits = new WebDriverWait(driver, 10);

        sleep(2000);

        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(questionTableContainerXpath))));
        List<QuestionTableContainerComponent> containerComponents = new ArrayList<>();
        for (WebElement current : rows) {

            containerComponents.add(new QuestionTableContainerComponent(current));
        }
        for (QuestionTableContainerComponent current : containerComponents) {

            if (current.getQuestionTextText().toLowerCase().equals(questionText.toLowerCase())) {
                result = current;
                break;
            }

        }
        if (result == null){

            boolean isEnabled = isNextArrowEnabled();
            while (isEnabled) {
                clickNextButton();
                waits.until(ExpectedConditions.invisibilityOfAllElements(rows));
                List<WebElement> rows2 = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(questionTableContainerXpath))));
                List<QuestionTableContainerComponent> containerComponents2 = new ArrayList<>();
                for (WebElement current2 : rows2) {
                    containerComponents2.add(new QuestionTableContainerComponent(current2));

                }
                for (QuestionTableContainerComponent current3 : containerComponents2) {

                    if (current3.getQuestionTextText().toLowerCase().equals(questionText.toLowerCase())) {
                        result = current3;
                        break;
                    }
                }

                if (result == null) {
                    if (isNextArrowEnabled()) isEnabled = true;
                    else isEnabled = false;
                } else return result;
            }
        }

        if (result == null) {
            throw new RuntimeException(String.format("Question with questionText: %s not found", questionText));
        }

        return result;


    }
    protected void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
