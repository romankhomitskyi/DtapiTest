package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.ScheduleTestingPage;
import org.openqa.selenium.WebDriver;

public class DeleteScheduleModalWindow extends BaseDeleteItemModalWindow {
    private WaitUtils wait;

    public DeleteScheduleModalWindow(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 5);
    }

    public ScheduleTestingPage deleteSchedule() {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickSubmitButton();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new ScheduleTestingPage(driver);
    }
}
