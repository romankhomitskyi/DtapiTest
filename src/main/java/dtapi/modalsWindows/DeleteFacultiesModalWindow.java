package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.FacultiesPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DeleteFacultiesModalWindow extends BaseDeleteItemModalWindow {
    private WaitUtils wait;

    public DeleteFacultiesModalWindow(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 5);
    }

    public FacultiesPage deleteFaculties() {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickSubmitButton();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new FacultiesPage(driver, log);
    }

    public FacultiesPage cancelDeleteFaculties() {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickCancelButton();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new FacultiesPage(driver, log);
    }
}
