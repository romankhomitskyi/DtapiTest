package dtapi.components;

import dtapi.elements.Paginator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TestOfSubjectTableContainer extends Paginator {
    private final String testOfSubjectTableContainerXpath = "//table/tbody/tr";
    private List<TestOfSubjectTableContainerComponent> containerComponents;

    public TestOfSubjectTableContainer(WebDriver driver) {
        super(driver);
        initElements();

    }
    private void initElements(){
        containerComponents = new ArrayList<>();

        for (WebElement current : driver.findElements(By.xpath(testOfSubjectTableContainerXpath))) {
            containerComponents.add(new TestOfSubjectTableContainerComponent(current));
        }
    }


    public List<TestOfSubjectTableContainerComponent> getTestOfSubjectContainerComponents() {
        return containerComponents;
    }



    public TestOfSubjectTableContainerComponent getTestContainerComponentByTestName(String testName) {
        return getTestOfSubjectContainerComponentByName(testName);
    }
    private TestOfSubjectTableContainerComponent getTestOfSubjectContainerComponentByName(String testName){
        TestOfSubjectTableContainerComponent result = findTest(testName);

        while (result == null ) {
            if (!isNextArrowEnabled() && result == null) {
                throw new RuntimeException(String.format("Test with testName: %s not found", testName));
            }
            clickNextButton();
            initElements();
            result = findTest(testName);

        }
        return result;

    }


    private TestOfSubjectTableContainerComponent findTest(String testName) {

        for (TestOfSubjectTableContainerComponent current : containerComponents) {

            if (current.getTestNameText().toLowerCase().equals(testName.toLowerCase())) {

                return current;
            }
        }
        return null;
    }
}
