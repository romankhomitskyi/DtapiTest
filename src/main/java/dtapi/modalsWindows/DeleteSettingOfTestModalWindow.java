package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import org.openqa.selenium.WebDriver;

public class DeleteSettingOfTestModalWindow extends BaseDeleteItemModalWindow{
    private WaitUtils wait;
    public DeleteSettingOfTestModalWindow(WebDriver driver) {
        super(driver);
    }
    public InformModalWindow deleteSettings() {
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
