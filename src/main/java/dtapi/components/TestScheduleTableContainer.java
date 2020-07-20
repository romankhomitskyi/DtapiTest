package dtapi.components;

import dtapi.elements.Paginator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TestScheduleTableContainer extends Paginator {
    private final String testScheduleTableContainerXpath = "//table/tbody/tr";
    private List<TestScheduleTableContainerComponent> containerComponents;


    public TestScheduleTableContainer(WebDriver driver) {
        super(driver);
        initElements();

    }
    private void initElements(){
        containerComponents = new ArrayList<>();

        for (WebElement current : driver.findElements(By.xpath(testScheduleTableContainerXpath))) {
            containerComponents.add(new TestScheduleTableContainerComponent(current));
        }
    }

    public List<TestScheduleTableContainerComponent> getTestScheduleTableContainerComponents() {
        return containerComponents;
    }

    public TestScheduleTableContainerComponent getTestScheduleTableContainerComponentByGroup(String group) {
        return getTestScheduleTableContainerComponentByGroups(group);
    }

    private TestScheduleTableContainerComponent getTestScheduleTableContainerComponentByGroups(String group) {
        TestScheduleTableContainerComponent result  = findTestSchedule(group);

        while (result == null ) {
            if (!isNextArrowEnabled() && result == null) {
                throw new RuntimeException(String.format("Schedule test with group: %s not found", group));
            }
            clickNextButton();
            initElements();
            result = findTestSchedule(group);

        }
        return result;

    }

    private TestScheduleTableContainerComponent findTestSchedule(String group){
        for (TestScheduleTableContainerComponent current : containerComponents) {

            if (current.getGroupText().toLowerCase().equals(group.toLowerCase())) {

                return current;
            }
        }
        return null;
    }
}
