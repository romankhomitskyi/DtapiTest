package dtapi.components;

import dtapi.elements.Paginator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResultsTableContainer  extends Paginator {
    private final String resultsTableContainerXpath = "//table/tbody/tr";
    private List<ResultsTableContainerComponent> containerComponents;



    public ResultsTableContainer(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){
        containerComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.xpath(resultsTableContainerXpath))) {

            containerComponents.add(new ResultsTableContainerComponent(current));
        }
    }


    public List<ResultsTableContainerComponent> getResultsContainerComponents() {
        return containerComponents;
    }
    public ResultsTableContainerComponent getStudentResultContainerComponentByStudentId(String studentId) {
        return getStudentResultContainerComponentStudentId(studentId);
    }
    private ResultsTableContainerComponent getStudentResultContainerComponentStudentId(String studentId) {
        ResultsTableContainerComponent result = findTestResult(studentId);

        while (result == null ) {
            if (!isNextArrowEnabled() && result == null) {
                throw new RuntimeException(String.format("Results with studentId: %s not found", studentId));
            }
            clickNextButton();
            initElements();
            result = findTestResult(studentId);

        }
        return result;

    }

    private ResultsTableContainerComponent findTestResult( String studentId) {
        for (ResultsTableContainerComponent current : containerComponents) {

            if (current.getStudentIdText().toLowerCase().contains(studentId.toLowerCase())) {

                return current;
            }
        }
        return null;
    }
}
