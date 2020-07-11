package dtapi.modalsWindows;

import dtapi.pages.ScheduleTestingPage;
import org.openqa.selenium.WebDriver;

public class DeleteNewScheduleModalWindow extends BaseDeleteItemModalWindow{
    public DeleteNewScheduleModalWindow(WebDriver driver) {
        super(driver);
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
