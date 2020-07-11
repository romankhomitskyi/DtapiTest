package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.AdminsPage;
import org.openqa.selenium.WebDriver;

public class DeleteAdminModalWindow extends BaseDeleteItemModalWindow {
    private WaitUtils wait;
    public DeleteAdminModalWindow(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 10);
    }
    public AdminsPage deleteAdmin() {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickSubmitButton();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new AdminsPage(driver);
    }
}
