package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.SettingsTestPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DeleteSettingOfTestModalWindow extends BaseDeleteItemModalWindow{
    private WaitUtils wait;
    public DeleteSettingOfTestModalWindow(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public SettingsTestPage deleteSettings() {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickSubmitButton();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);

            }
        }

        return new SettingsTestPage(driver, log);
    }
}
