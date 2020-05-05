package dtapi.components;

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

public class ResultsTableContainer  extends Paginator {
    private final String resultsTableContainerXpath = "//table/tbody/tr";
    private WaitUtils wait;



    public ResultsTableContainer(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 10);
    }


    protected void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<ResultsTableContainerComponent> getResultsContainerComponents() {
        WebDriverWait waits = new WebDriverWait(driver, 10);
        sleep(1500);
        /*waits.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath(groupTableContainerXpath))));*/
        List<ResultsTableContainerComponent> containerComponents = new ArrayList<>();
        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(resultsTableContainerXpath))));

        for (WebElement current : rows) {
            System.out.println(current.getText());
            containerComponents.add(new ResultsTableContainerComponent(current));
        }
        return containerComponents;
    }
    public ResultsTableContainerComponent getStudentResultContainerComponentByStudentNSF(String studentNSF) {
        return getStudentResultContainerComponentByName(studentNSF);
    }


    protected ResultsTableContainerComponent getStudentResultContainerComponentByName(String studentNSF) {
        ResultsTableContainerComponent result = null;
        WebDriverWait waits = new WebDriverWait(driver, 10);
        sleep(1500);
        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(resultsTableContainerXpath))));
        List<ResultsTableContainerComponent> containerComponents = new ArrayList<>();
        for (WebElement current : rows) {
            containerComponents.add(new ResultsTableContainerComponent(current));
        }
        for (ResultsTableContainerComponent current : containerComponents) {

            if (current.getStudentIdText().toLowerCase().contains(studentNSF.toLowerCase())) {
                result = current;
                break;
            }

        }
        if (result == null){

            boolean isEnabled = isNextArrowEnabled();
            while (isEnabled) {
                clickNextButton();
                waits.until(ExpectedConditions.invisibilityOfAllElements(rows));
                List<WebElement> rows2 = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(resultsTableContainerXpath))));
                List<ResultsTableContainerComponent> containerComponents2 = new ArrayList<>();
                for (WebElement current2 : rows2) {
                    containerComponents2.add(new ResultsTableContainerComponent(current2));

                }
                for (ResultsTableContainerComponent current3 : containerComponents2) {

                    if (current3.getStudentIdText().toLowerCase().contains(studentNSF.toLowerCase())) {
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
            throw new RuntimeException(String.format("Student with studentNSF: %s not found", studentNSF));
        }

        return result;


    }
}
