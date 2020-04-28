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

public class SubjectTableContainer  extends Paginator {
    private final String subjectTableContainerXpath = "//div[@class='table-container']/table/tbody/tr";
    private WaitUtils wait;



    public SubjectTableContainer(WebDriver driver, Logger log) {
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

    public List<SubjectTableContainerComponent> getSubjectContainerComponents() {
        WebDriverWait waits = new WebDriverWait(driver, 10);
        sleep(2000);
        /*waits.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath(groupTableContainerXpath))));*/
        List<SubjectTableContainerComponent> containerComponents = new ArrayList<>();
        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(subjectTableContainerXpath))));

        for (WebElement current : rows) {
            System.out.println(current.getText());
            containerComponents.add(new SubjectTableContainerComponent(current));
        }
        return containerComponents;
    }


    public int getSubjectContainerComponentsCount() {
        return getSubjectContainerComponents().size();
    }

    public List<String> getSubjectContainerComponentNames() {
        List<String> containerComponentNames = new ArrayList<>();
        for (SubjectTableContainerComponent current : getSubjectContainerComponents()) {
            containerComponentNames.add(current.getSubjectNameText());
        }
        return containerComponentNames;
    }


    public String getContainerComponentSubjectIdBySubjectName(String subjectName) {
        return getSubjectContainerComponentByName(subjectName).getSubjectIdText();
    }

    public String getContainerComponentSubjectDescBySubjectName(String subjectName) {
        return getSubjectContainerComponentByName(subjectName).getSubjectDescText();
    }


    public void clickContainerComponentSubjectTestsBySubjectName(String subjectName) {
        getSubjectContainerComponentByName(subjectName).clickSubjectTestIcon();
    }

    public void clickContainerComponentScheduleTestBySubjectName(String subjectName) {
        getSubjectContainerComponentByName(subjectName).clickScheduleIcon();
    }

    public void clickContainerComponentEditSubjectIconBySubjectName(String subjectName) {
        getSubjectContainerComponentByName(subjectName).clickEditSubjectIcon();
    }

    public void clickContainerComponentDeleteSubjectIconBySubjectName(String subjectName) {
        getSubjectContainerComponentByName(subjectName).clickDeleteSubjectIcon();
    }


    public SubjectTableContainerComponent getSubjectContainerComponentBySubjectName(String subjectName) {
        return getSubjectContainerComponentByName(subjectName);
    }


    protected SubjectTableContainerComponent getSubjectContainerComponentByName(String subjectName) {
        SubjectTableContainerComponent result = null;
        WebDriverWait waits = new WebDriverWait(driver, 10);
        sleep(2000);
        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(subjectTableContainerXpath))));
        List<SubjectTableContainerComponent> containerComponents = new ArrayList<>();
        for (WebElement current : rows) {
            containerComponents.add(new SubjectTableContainerComponent(current));
        }
        for (SubjectTableContainerComponent current : containerComponents) {

            if (current.getSubjectNameText().toLowerCase().equals(subjectName.toLowerCase())) {
                result = current;
                break;
            }

        }
        if (result == null){

            boolean isEnabled = isNextArrowEnabled();
            while (isEnabled) {
                clickNextButton();
                waits.until(ExpectedConditions.invisibilityOfAllElements(rows));
                List<WebElement> rows2 = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(subjectTableContainerXpath))));
                List<SubjectTableContainerComponent> containerComponents2 = new ArrayList<>();
                for (WebElement current2 : rows2) {
                    containerComponents2.add(new SubjectTableContainerComponent(current2));

                }
                for (SubjectTableContainerComponent current3 : containerComponents2) {

                    if (current3.getSubjectNameText().toLowerCase().equals(subjectName.toLowerCase())) {
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
            throw new RuntimeException(String.format("Subject with subjectName: %s not found", subjectName));
        }

        return result;


    }
}
