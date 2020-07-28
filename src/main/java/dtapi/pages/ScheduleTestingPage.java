package dtapi.pages;

import dtapi.components.TestScheduleTableContainer;
import dtapi.components.TestScheduleTableContainerComponent;
import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.AdminHeadrer;
import dtapi.modalsWindows.AddNewScheduleModalWindow;
import dtapi.modalsWindows.DeleteScheduleModalWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScheduleTestingPage  extends AdminHeadrer {

    public ScheduleTestingPage(WebDriver driver) {
        super(driver);
        initElements();
        wait = new WaitUtils(driver,10);
    }
    private By addNewScheduleButton = By.xpath("//span[contains(text(),'Додати розклад')]/parent::button");
    private WaitUtils wait;

    private TestScheduleTableContainer testScheduleTableContainer;


    private void initElements() {

        testScheduleTableContainer = new TestScheduleTableContainer(driver);
    }

    public TestScheduleTableContainer getTestScheduleTableContainer() {
        return testScheduleTableContainer;
    }

    public AddNewScheduleModalWindow switchToAddNewScheduleModalWindow() {
        String shoppingCartWindow = driver.getWindowHandle();
        wait.presenceOfElement(addNewScheduleButton);
        wait.visibilityOfElementByLocator(addNewScheduleButton);
        click(addNewScheduleButton);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);

            }
        }
        return new  AddNewScheduleModalWindow(driver);
    }
    public DeleteScheduleModalWindow switchToDeleteScheduleModalWindow(String group) {
        String shoppingCartWindow = driver.getWindowHandle();
        getTestScheduleTableContainer()
                .getTestScheduleTableContainerComponentByGroup(group)
                .clickDeleteScheduleTestIcon();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new  DeleteScheduleModalWindow(driver);
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
        return new  AddNewScheduleModalWindow(driver);
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
    public SubjectPage backToSubjectPage() {

        driver.navigate().back();
        return new SubjectPage(driver);
    }
    protected void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
