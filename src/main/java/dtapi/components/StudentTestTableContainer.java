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

public class StudentTestTableContainer extends Paginator {
    private final String studentTestTableContainerXpath = "//table/tbody/tr";
    private WaitUtils wait;



    public StudentTestTableContainer(WebDriver driver, Logger log) {
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

    public List<StudentTestTableContainerComponent> getStudentTestTableContainerComponents() {
        WebDriverWait waits = new WebDriverWait(driver, 10);
        sleep(1500);
        /*waits.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath(groupTableContainerXpath))));*/
        List<StudentTestTableContainerComponent> containerComponents = new ArrayList<>();
        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(studentTestTableContainerXpath))));

        for (WebElement current : rows) {
            System.out.println(current.getText());
            containerComponents.add(new StudentTestTableContainerComponent(current));
        }
        return containerComponents;
    }



    public StudentTestTableContainerComponent getStudentTestTableContainerComponentsByTestName(String testName) {
        return getStudentTestTableContainerComponentByTestName(testName);
    }


    protected StudentTestTableContainerComponent getStudentTestTableContainerComponentByTestName(String testName) {
        StudentTestTableContainerComponent result = null;
        WebDriverWait waits = new WebDriverWait(driver, 10);
        sleep(2000);
        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(studentTestTableContainerXpath))));
        List<StudentTestTableContainerComponent> containerComponents = new ArrayList<>();
        for (WebElement current : rows) {
            containerComponents.add(new StudentTestTableContainerComponent(current));
        }
        for (StudentTestTableContainerComponent current : containerComponents) {

            if (current.getTestNameText().toLowerCase().contains(testName.toLowerCase())) {
                result = current;
                break;
            }

        }
        if (result == null){

            boolean isEnabled = isNextArrowEnabled();
            while (isEnabled) {
                clickNextButton();
                waits.until(ExpectedConditions.invisibilityOfAllElements(rows));
                List<WebElement> rows2 = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(studentTestTableContainerXpath))));
                List<StudentTestTableContainerComponent> containerComponents2 = new ArrayList<>();
                for (WebElement current2 : rows2) {
                    containerComponents2.add(new StudentTestTableContainerComponent(current2));

                }
                for (StudentTestTableContainerComponent current3 : containerComponents2) {

                    if (current3.getTestNameText().toLowerCase().contains(testName.toLowerCase())) {
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
            throw new RuntimeException(String.format("Test with testName: %s not found", testName));
        }

        return result;


    }
}
