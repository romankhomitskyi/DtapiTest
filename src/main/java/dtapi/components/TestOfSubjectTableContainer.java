package dtapi.components;

import dtapi.elements.Paginator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TestOfSubjectTableContainer {
    private WebDriver driver;
    private Paginator paginator;
    private final String testOfSubjectTableContainerXpath = "//table/tbody/tr";
    private List<TestOfSubjectTableContainerComponent> containerComponents;

    public TestOfSubjectTableContainer(WebDriver driver) {
        this.driver = driver;
        paginator = new Paginator(driver);
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
            if (!paginator.isNextArrowEnabled() && result == null) {
                throw new RuntimeException(String.format("Test with testName: %s not found", testName));
            }
            paginator.clickNextButton();
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
