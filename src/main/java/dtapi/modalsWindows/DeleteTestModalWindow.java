package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DeleteTestModalWindow extends BaseDeleteItemModalWindow{
    private WaitUtils wait;

    public DeleteTestModalWindow(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 5);
    }

    public InformModalWindow deleteTest() {
        String addSubjectPageWindow = driver.getWindowHandle();
        sleep(500);
        clickSubmitButton();
        sleep(500);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new InformModalWindow(driver, log);
    }
    protected void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
