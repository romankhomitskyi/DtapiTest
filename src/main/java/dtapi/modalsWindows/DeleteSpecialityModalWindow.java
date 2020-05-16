package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.SpecialityPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DeleteSpecialityModalWindow extends BaseDeleteItemModalWindow {
    private WaitUtils wait;

    public DeleteSpecialityModalWindow(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 5);
    }

    public SpecialityPage deleteSpeciality() {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickSubmitButton();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new SpecialityPage(driver, log);
    }
    public InformModalWindow switchToSpecialityInformWindow() {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickSubmitButton();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new InformModalWindow(driver, log);
    }

    public SpecialityPage cancelDeleteSpeciality() {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickCancelButton();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new SpecialityPage(driver, log);
    }
}
