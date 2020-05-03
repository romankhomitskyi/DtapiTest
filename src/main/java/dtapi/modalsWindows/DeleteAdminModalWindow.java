package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.AdminsPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAdminModalWindow extends BaseDeleteItemModalWindow {
    private WaitUtils wait;
    public DeleteAdminModalWindow(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 10);
    }
    public AdminsPage deleteAdmin() {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickSubmitButton();
        wait.prevenseOfElement(By.xpath("//table//tr"));
        wait.visibilityOfAllElements2(By.xpath("//table//tr"));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new AdminsPage(driver, log);
    }
}
