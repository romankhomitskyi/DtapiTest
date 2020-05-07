package dtapi.pages;

import dtapi.components.TestScheduleTableContainer;
import dtapi.components.TestScheduleTableContainerComponent;
import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.Paginator;
import dtapi.modalsWindows.AddNewScheduleModalWindow;
import dtapi.modalsWindows.DeleteSettingOfTestModalWindow;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScheduleTestingPage  extends Paginator {
    public ScheduleTestingPage(WebDriver driver, Logger log) {
        super(driver, log);
        initElements();
        wait = new WaitUtils(driver,10);
    }
    private By addNewScheduleButton = By.xpath("//span[contains(text(),'Додати розклад')]/parent::button");
    private WaitUtils wait;

    private TestScheduleTableContainer testScheduleTableContainer;


    private void initElements() {

        testScheduleTableContainer = new TestScheduleTableContainer(driver, log);
    }

    public TestScheduleTableContainer getTestScheduleTableContainer() {
        return testScheduleTableContainer;
    }

    public AddNewScheduleModalWindow switchToAddNewScheduleModalWindow() {
        String shoppingCartWindow = driver.getWindowHandle();
        wait.prevenseOfElement(addNewScheduleButton);
        wait.visibilityOfElement(addNewScheduleButton);
        click(addNewScheduleButton);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                wait.waitForPageLoad();
                driver.switchTo().window(windowHandle);
                wait.waitForPageLoad();
            }
        }
        return new  AddNewScheduleModalWindow(driver, log);
    }
    public DeleteSettingOfTestModalWindow switchToDeleteScheduleModalWindow(String group) {
        String shoppingCartWindow = driver.getWindowHandle();
        getTestScheduleTableContainer()
                .getTestScheduleTableContainerComponentByGroup(group)
                .clickDeleteScheduleTestIcon();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new  DeleteSettingOfTestModalWindow(driver, log);
    }
    public  AddNewScheduleModalWindow switchToEditScheduleModalWindow(String  group) {
        String shoppingCartWindow = driver.getWindowHandle();
        getTestScheduleTableContainer()
                .getTestScheduleTableContainerComponentByGroup(group)
                .clickEditScheduleTestIcon();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new  AddNewScheduleModalWindow(driver, log);
    }
    public boolean verifyScheduleRemoved(String  group) {
        for (TestScheduleTableContainerComponent component : getTestScheduleTableContainer().getTestScheduleTableContainerComponents()) {
            if (component.getGroupText().equals(group)) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyScheduleEdited(String group) {

        for (TestScheduleTableContainerComponent component : getTestScheduleTableContainer().getTestScheduleTableContainerComponents()) {
            if (component.getGroupText().equals(group)) {
                return true;
            }
        }
        return false;
    }
    public boolean verifyScheduleAdded(String group) {

        String groups = getTestScheduleTableContainer()
                .getTestScheduleTableContainerComponentByGroup(group)
                .getGroupText();
        if(group.equals(groups )){
            return true;
        }

        return false;
    }
}
