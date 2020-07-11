package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.FacultiesPage;
import org.openqa.selenium.WebDriver;

public class DeleteFacultiesModalWindow extends BaseDeleteItemModalWindow {
    private WaitUtils wait;

    public DeleteFacultiesModalWindow(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 5);
    }

    public FacultiesPage deleteFaculties() {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickSubmitButton();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new FacultiesPage(driver);
    }
    public InformModalWindow switchToFacultiesInformModalWindow () {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickSubmitButton();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new InformModalWindow(driver);
    }

    public FacultiesPage cancelDeleteFaculties() {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickCancelButton();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new FacultiesPage(driver);
    }
    protected void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
