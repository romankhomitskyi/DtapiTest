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

public class FacultyTableContainer extends Paginator {
    private final String facultyTableContainerXpath = "//div[@class='table-container']/table/tbody/tr";
    private WaitUtils wait;

    public FacultyTableContainer(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 10);
    }

    public List<FacultyTableContainerComponent> getFacultyContainerComponents() {
        WebDriverWait waits = new WebDriverWait(driver, 10);

       sleep(2000);
        /*wait.visibilityOfAllElements2(By.xpath(facultyTableContainerXpath));*/
        List<FacultyTableContainerComponent> containerComponents = new ArrayList<>();
        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(facultyTableContainerXpath))));

        for (WebElement current : rows) {
            System.out.println(current.getText());
            containerComponents.add(new FacultyTableContainerComponent(current));
        }
        return containerComponents;
    }
    public int getFacultyContainerComponentsCount() {
        return getFacultyContainerComponents().size();
    }
    public List<String> getFacultyContainerComponentNames() {
        List<String> containerComponentNames = new ArrayList<>();
        for (FacultyTableContainerComponent current : getFacultyContainerComponents()) {
            containerComponentNames.add(current.getFacultyNameText());
        }
        return containerComponentNames;
    }
    public String getContainerComponentFacultyIdByFacultyName(String facultyName) {
        return getContainerComponentByFacultyName(facultyName).getFacultyIdText();
    }

    public String getContainerComponentFacultyDescByFacultyName(String facultyName) {
        return getContainerComponentByFacultyName(facultyName).getFacultyDescText();
    }
    public void clickContainerComponentEditFacultyIconByFacultyName(String facultyName) {
        getContainerComponentByFacultyName(facultyName).clickFacultyEditIcon();
    }

    public void clickContainerComponentDeleteFacultyIconByFacultyName(String facultyName) {
        getContainerComponentByFacultyName(facultyName).clickDeleteFacultyIcon();
    }
    public FacultyTableContainerComponent getContainerComponentByFacultiesName(String facultyName) {
        return getContainerComponentByFacultyName(facultyName);
    }
    protected FacultyTableContainerComponent getContainerComponentByFacultyName(String facultyName) {
        FacultyTableContainerComponent result = null;
        WebDriverWait waits = new WebDriverWait(driver, 10);

        sleep(2000);

        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(facultyTableContainerXpath))));
        List<FacultyTableContainerComponent> containerComponents = new ArrayList<>();
        for (WebElement current : rows) {

            containerComponents.add(new FacultyTableContainerComponent(current));
        }
        for (FacultyTableContainerComponent current : containerComponents) {

            if (current.getFacultyNameText().toLowerCase().equals(facultyName.toLowerCase())) {
                result = current;
                break;
            }

        }
        if (result == null){

            boolean isEnabled = isNextArrowEnabled();
            while (isEnabled) {
                clickNextButton();
                waits.until(ExpectedConditions.invisibilityOfAllElements(rows));
                List<WebElement> rows2 = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(facultyTableContainerXpath))));
                List<FacultyTableContainerComponent> containerComponents2 = new ArrayList<>();
                for (WebElement current2 : rows2) {
                    containerComponents2.add(new FacultyTableContainerComponent(current2));

                }
                for (FacultyTableContainerComponent current3 : containerComponents2) {

                    if (current3.getFacultyNameText().toLowerCase().equals(facultyName.toLowerCase())) {
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
            throw new RuntimeException(String.format("Faculty with facultyName: %s not found", facultyName));
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
