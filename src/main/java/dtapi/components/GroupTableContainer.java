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

public class GroupTableContainer extends Paginator {
    private final String groupTableContainerXpath = "//div[@class='table-container']/table/tbody/tr";
    private WaitUtils wait;


    /*private List<GroupTableContainerComponent> containerComponents;*/

    public GroupTableContainer(WebDriver driver, Logger log) {
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

    public List<GroupTableContainerComponent> getContainerComponents() {
        WebDriverWait waits = new WebDriverWait(driver, 10);
        sleep(2000);
        /*waits.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath(groupTableContainerXpath))));*/
        List<GroupTableContainerComponent> containerComponents = new ArrayList<>();
        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(groupTableContainerXpath))));

        for (WebElement current : rows) {
            System.out.println(current.getText());
            containerComponents.add(new GroupTableContainerComponent(current));
        }
        return containerComponents;
    }


    public int getContainerComponentsCount() {
        return getContainerComponents().size();
    }

    public List<String> getContainerComponentNames() {
        List<String> containerComponentNames = new ArrayList<>();
        for (GroupTableContainerComponent current : getContainerComponents()) {
            containerComponentNames.add(current.getGroupCodeText());
        }
        return containerComponentNames;
    }


    public String getContainerComponentSpecialityByGroupCode(String groupCode) {
        return getContainerComponentByName(groupCode).getGroupSpecilityText();
    }

    public String getContainerComponentFacultyByGroupCode(String groupCode) {
        return getContainerComponentByName(groupCode).getGroupFacultyText();
    }


    public void clickContainerComponentStudentInGroupIconByName(String groupCode) {
        getContainerComponentByName(groupCode).clickStudentInGroupIcon();
    }

    public void clickContainerComponentTestResultsIconByName(String groupCode) {
        getContainerComponentByName(groupCode).clickGroupTestResultsIcon();
    }

    public void clickContainerComponentEditGroupIconByName(String groupCode) {
        getContainerComponentByName(groupCode).clickEditGroupIcon();
    }

    public void clickContainerComponentDeleteGroupIconByName(String groupCode) {
        getContainerComponentByName(groupCode).clickDeleteGroupIcon();
    }


    public GroupTableContainerComponent getContainerComponentByGroupCode(String groupCode) {
        return getContainerComponentByName(groupCode);
    }


    protected GroupTableContainerComponent getContainerComponentByName(String groupCode) {
        GroupTableContainerComponent result = null;
        WebDriverWait waits = new WebDriverWait(driver, 10);
        sleep(2000);
        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(groupTableContainerXpath))));
        List<GroupTableContainerComponent> containerComponents = new ArrayList<>();
        for (WebElement current : rows) {
            containerComponents.add(new GroupTableContainerComponent(current));
        }
        for (GroupTableContainerComponent current : containerComponents) {

            if (current.getGroupCodeText().toLowerCase().equals(groupCode.toLowerCase())) {
                result = current;
                break;
            }

        }
        if (result == null){

            boolean isEnabled = isNextArrowEnabled();
            while (isEnabled) {
                clickNextButton();
                waits.until(ExpectedConditions.invisibilityOfAllElements(rows));
                List<WebElement> rows2 = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(groupTableContainerXpath))));
                List<GroupTableContainerComponent> containerComponents2 = new ArrayList<>();
                for (WebElement current2 : rows2) {
                    containerComponents2.add(new GroupTableContainerComponent(current2));

                }
                for (GroupTableContainerComponent current3 : containerComponents2) {

                    if (current3.getGroupCodeText().toLowerCase().equals(groupCode.toLowerCase())) {
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
                throw new RuntimeException(String.format("Group with groupCode: %s not found", groupCode));
            }

        return result;


    }
}