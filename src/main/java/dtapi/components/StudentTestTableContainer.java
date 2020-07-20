package dtapi.components;

import dtapi.elements.Paginator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class StudentTestTableContainer extends Paginator {
    private final String studentTestTableContainerXpath = "//table/tbody/tr";
    private List<StudentTestTableContainerComponent> containerComponents;



    public StudentTestTableContainer(WebDriver driver) {
        super(driver);
        initElements();

    }

    private void initElements(){
        containerComponents = new ArrayList<>();

        for (WebElement current : driver.findElements(By.xpath(studentTestTableContainerXpath))) {
            containerComponents.add(new StudentTestTableContainerComponent(current));
        }
    }


    public List<StudentTestTableContainerComponent> getStudentTestTableContainerComponents() {
        return containerComponents;
    }


    public StudentTestTableContainerComponent getStudentTestTableContainerComponentsByTestName(String testName) {
        return getStudentTestTableContainerComponentByTestName(testName);
    }

    private StudentTestTableContainerComponent getStudentTestTableContainerComponentByTestName(String testName) {
        StudentTestTableContainerComponent  result = findStudentTestByTestName(testName);

        while (result == null ) {
            if (!isNextArrowEnabled() && result == null) {
                throw new RuntimeException(String.format("Test with testName: %s not found", testName));
            }
            clickNextButton();
            initElements();
            result = findStudentTestByTestName(testName);

        }
        return result;

    }

    private StudentTestTableContainerComponent findStudentTestByTestName(String testName) {
        for (StudentTestTableContainerComponent current : containerComponents) {

            if (current.getTestNameText().toLowerCase().contains(testName.toLowerCase())) {

                return current;
            }
        }
        return null;
    }
}
