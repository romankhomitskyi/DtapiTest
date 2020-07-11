package dtapi.components;

import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.Paginator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TestOfSubjectTableContainer extends Paginator {
    private final String testOfSubjectTableContainerXpath = "//table/tbody/tr";
    private WaitUtils wait;

    public TestOfSubjectTableContainer(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 10);
    }

    protected void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<TestOfSubjectTableContainerComponent> getTestOfSubjectContainerComponents() {
        WebDriverWait waits = new WebDriverWait(driver, 10);
        sleep(2000);
        /*waits.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath(groupTableContainerXpath))));*/
        List<TestOfSubjectTableContainerComponent> containerComponents = new ArrayList<>();
        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(testOfSubjectTableContainerXpath))));

        for (WebElement current : rows) {
            System.out.println(current.getText());
            containerComponents.add(new TestOfSubjectTableContainerComponent(current));
        }
        return containerComponents;
    }


    public int getTestOfSubjectContainerComponentsCount() {
        return getTestOfSubjectContainerComponents().size();
    }

    public List<String> getTestOfSubjectContainerComponentNames() {
        List<String> containerComponentNames = new ArrayList<>();
        for (TestOfSubjectTableContainerComponent current : getTestOfSubjectContainerComponents()) {
            containerComponentNames.add(current.getTestNameText());
        }
        return containerComponentNames;
    }


    public String getContainerComponentTestIdByTestName(String testName) {
        return getTestOfSubjectContainerComponentByName(testName).getTestIdText();
    }

    public String getContainerComponentSubjectNameByTestName(String testName) {
        return getTestOfSubjectContainerComponentByName(testName).getTestOfSubjectNameText();
    }
    public String getContainerComponentCountTaskByTestName(String testName) {
        return getTestOfSubjectContainerComponentByName(testName).getCountTaskText();
    }


    public void clickContainerComponentTestParamByTestName(String testName) {
        getTestOfSubjectContainerComponentByName(testName).clickTestParamIcon();
    }

    public void clickContainerComponentQuestionByTestName(String testName) {
        getTestOfSubjectContainerComponentByName(testName).clickQuestionIcon();
    }

    public void clickContainerComponentEditTestIconByTestName(String testName) {
        getTestOfSubjectContainerComponentByName(testName).clickEditTestIcon();
    }

    public void clickContainerComponentDeleteTestIconByTestName(String testName) {
        getTestOfSubjectContainerComponentByName(testName).clickDeleteTestIcon();
    }


    public TestOfSubjectTableContainerComponent getTestContainerComponentByTestName(String testName) {
        return getTestOfSubjectContainerComponentByName(testName);
    }


    protected TestOfSubjectTableContainerComponent getTestOfSubjectContainerComponentByName(String testName) {
        TestOfSubjectTableContainerComponent result = null;
        WebDriverWait waits = new WebDriverWait(driver, 10);
        sleep(2000);
        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(testOfSubjectTableContainerXpath))));
        List<TestOfSubjectTableContainerComponent> containerComponents = new ArrayList<>();
        for (WebElement current : rows) {
            containerComponents.add(new TestOfSubjectTableContainerComponent(current));
        }
        for (TestOfSubjectTableContainerComponent current : containerComponents) {

            if (current.getTestNameText().toLowerCase().equals(testName.toLowerCase())) {
                result = current;
                break;
            }

        }
        if (result == null){

            boolean isEnabled = isNextArrowEnabled();
            while (isEnabled) {
                clickNextButton();
                waits.until(ExpectedConditions.invisibilityOfAllElements(rows));
                List<WebElement> rows2 = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(testOfSubjectTableContainerXpath))));
                List<TestOfSubjectTableContainerComponent> containerComponents2 = new ArrayList<>();
                for (WebElement current2 : rows2) {
                    containerComponents2.add(new TestOfSubjectTableContainerComponent(current2));

                }
                for (TestOfSubjectTableContainerComponent current3 : containerComponents2) {

                    if (current3.getTestNameText().toLowerCase().equals(testName.toLowerCase())) {
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
