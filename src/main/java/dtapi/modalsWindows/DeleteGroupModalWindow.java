package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.GroupPage;
import org.openqa.selenium.WebDriver;

public class DeleteGroupModalWindow extends BaseDeleteItemModalWindow {
    private WaitUtils wait;

    public DeleteGroupModalWindow(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 10);
    }

    public GroupPage deleteGroup() {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickSubmitButton();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);

            }
        }

        return new GroupPage(driver);
    }
    protected void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public InformModalWindow switchToGroupInformModalWindow() {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickSubmitButton();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);

            }
        }

        return new InformModalWindow(driver);
    }

    /*public GroupsPage cancelDeleteGroup() {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickCancelButton();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new GroupsPage(driver, log);
    }*/
}
