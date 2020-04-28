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

public class TestScheduleTableContainer extends Paginator {
    public TestScheduleTableContainer(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver,10);
    }
    private final String testScheduleTableContainerXpath = "//table/tbody/tr";
    private WaitUtils wait;



    protected void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<TestScheduleTableContainerComponent> getTestScheduleTableContainerComponents() {
        WebDriverWait waits = new WebDriverWait(driver, 10);
        sleep(2000);
        /*waits.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath(groupTableContainerXpath))));*/
        List<TestScheduleTableContainerComponent> containerComponents = new ArrayList<>();
        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(testScheduleTableContainerXpath))));

        for (WebElement current : rows) {
            System.out.println(current.getText());
            containerComponents.add(new TestScheduleTableContainerComponent(current));
        }
        return containerComponents;
    }


    public int getTestScheduleTableContainerComponentsCount() {
        return getTestScheduleTableContainerComponents().size();
    }







    public TestScheduleTableContainerComponent getTestScheduleTableContainerComponentByGroup(String group) {
        return getTestScheduleTableContainerComponentByGroups(group);
    }


    protected TestScheduleTableContainerComponent getTestScheduleTableContainerComponentByGroups(String group) {
        TestScheduleTableContainerComponent result = null;
        WebDriverWait waits = new WebDriverWait(driver, 10);
        sleep(2000);
        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(testScheduleTableContainerXpath))));
        List<TestScheduleTableContainerComponent> containerComponents = new ArrayList<>();
        for (WebElement current : rows) {
            containerComponents.add(new TestScheduleTableContainerComponent(current));
        }
        for (TestScheduleTableContainerComponent current : containerComponents) {

            if (current.getGroupText().toLowerCase().equals(group.toLowerCase())) {
                result = current;
                break;
            }

        }
        if (result == null){

            boolean isEnabled = isNextArrowEnabled();
            while (isEnabled) {
                clickNextButton();
                waits.until(ExpectedConditions.invisibilityOfAllElements(rows));
                List<WebElement> rows2 = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(testScheduleTableContainerXpath))));
                List<TestScheduleTableContainerComponent> containerComponents2 = new ArrayList<>();
                for (WebElement current2 : rows2) {
                    containerComponents2.add(new TestScheduleTableContainerComponent(current2));

                }
                for (TestScheduleTableContainerComponent current3 : containerComponents2) {

                    if (current3.getGroupText().toLowerCase().equals(group.toLowerCase())) {
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
            throw new RuntimeException(String.format("Schedule test with group: %s not found", group));
        }

        return result;


    }
}
