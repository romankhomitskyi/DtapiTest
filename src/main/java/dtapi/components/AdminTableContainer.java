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

public class AdminTableContainer extends Paginator {
    public AdminTableContainer(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 10);
    }
    private final String adminTableContainerXpath = "//table/tbody/tr";
    private WaitUtils wait;





    protected void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<AdminTableContainerComponent> getAdminContainerComponents() {
        WebDriverWait waits = new WebDriverWait(driver, 10);

        sleep(2000);
        List<AdminTableContainerComponent> containerComponents = new ArrayList<>();
        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(adminTableContainerXpath))));

        for (WebElement current : rows) {
            wait.scrollUntilElementVisible(current);

            containerComponents.add(new AdminTableContainerComponent(current));
        }
        return containerComponents;
    }





    public AdminTableContainerComponent getAdminContainerComponentByLogin(String adminLog) {
        return getAdminContainerComponentsByLogin(adminLog);
    }


    protected AdminTableContainerComponent getAdminContainerComponentsByLogin(String adminLog) {
        AdminTableContainerComponent result = null;
        WebDriverWait waits = new WebDriverWait(driver, 10);
        sleep(2000);
        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(adminTableContainerXpath))));
        List<AdminTableContainerComponent> containerComponents = new ArrayList<>();
        for (WebElement current : rows) {
            containerComponents.add(new AdminTableContainerComponent(current));
        }
        for (AdminTableContainerComponent current : containerComponents) {

            if (current.getAdminLoginText().toLowerCase().equals(adminLog.toLowerCase())) {
                result = current;
                break;
            }

        }
        if (result == null){

            boolean isEnabled = isNextArrowEnabled();
            while (isEnabled) {
                clickNextButton();
                waits.until(ExpectedConditions.invisibilityOfAllElements(rows));
                List<WebElement> rows2 = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(adminTableContainerXpath))));
                List<AdminTableContainerComponent> containerComponents2 = new ArrayList<>();
                for (WebElement current2 : rows2) {
                    containerComponents2.add(new AdminTableContainerComponent(current2));

                }
                for (AdminTableContainerComponent current3 : containerComponents2) {

                    if (current3.getAdminLoginText().toLowerCase().equals(adminLog.toLowerCase())) {
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
            throw new RuntimeException(String.format("Admin with adminLog: %s not found", adminLog));
        }

        return result;


    }
}
