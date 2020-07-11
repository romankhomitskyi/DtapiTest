package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.SpecialityPage;
import org.openqa.selenium.WebDriver;

public class DeleteSpecialityModalWindow extends BaseDeleteItemModalWindow {
    private WaitUtils wait;

    public DeleteSpecialityModalWindow(WebDriver driver) {
        super(driver);
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

        return new SpecialityPage(driver);
    }
    protected void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public InformModalWindow switchToSpecialityInformWindow() {
        String addSubjectPageWindow = driver.getWindowHandle();

        clickSubmitButton();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new InformModalWindow(driver);
    }

    public SpecialityPage cancelDeleteSpeciality() {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickCancelButton();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new SpecialityPage(driver);
    }
}
