package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.SubjectPage;
import org.openqa.selenium.WebDriver;

public class DeleteSubjectModalWindow extends BaseDeleteItemModalWindow{
    private WaitUtils wait;

    public DeleteSubjectModalWindow(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 5);
    }

    public SubjectPage deleteSubject() {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickSubmitButton();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new SubjectPage(driver);
    }
    public InformModalWindow switchToSubjectInformModalWindow() {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickSubmitButton();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new InformModalWindow(driver);
    }
}
