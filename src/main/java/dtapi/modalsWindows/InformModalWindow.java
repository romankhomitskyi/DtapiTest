package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.*;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InformModalWindow extends BaseModalWindow {
    private WaitUtils wait;
    private By divText = By.xpath("//div[@class='content']");
    private By exitButton = By.xpath("//span[contains(text(),'Закрити')]/parent::button");

    public InformModalWindow(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 10);
    }

    public boolean isTextPresent() {
        wait.prevenseOfElement(divText);
        wait.visibilityOfElement(divText);
        WebElement result = driver.findElement(divText);
        wait.scrollUntilElementVisible(result);
        return result.isDisplayed();
    }

    private void clickExitButtons() {
        wait.visibilityOfElement(exitButton);
        wait.prevenseOfElement(exitButton);
        driver.findElement(exitButton).click();
    }

    public SettingsTestPage clickExitButton() {
        String addSubjectPageWindow = driver.getWindowHandle();
        sleep(500);
        clickExitButtons();
        sleep(500);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);

            }
        }

        return new SettingsTestPage(driver, log);
    }
    public TestPage clickExitsButton() {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickExitButtons();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);

            }
        }

        return new TestPage(driver, log);
    }
    protected void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public FacultiesPage clickExitButtonAndSwitchToFacultyPage() {
        String addSubjectPageWindow = driver.getWindowHandle();
        sleep(500);
        clickExitButtons();
        sleep(500);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);

            }
        }

        return new FacultiesPage(driver, log);
    }

    public GroupPage clickExitButtonAndSwitchToGroupPage() {
        String addSubjectPageWindow = driver.getWindowHandle();
        sleep(500);
        clickExitButtons();
     sleep(500);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);

            }
        }

        return new GroupPage(driver, log);
    }

    public SpecialityPage clickExitButtonAndSwitchToSpecialityPage() {
        String addSubjectPageWindow = driver.getWindowHandle();
        sleep(500);
        clickExitButtons();
        sleep(500);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);

            }
        }

        return new SpecialityPage(driver, log);
    }
    public SubjectPage clickExitButtonAndSwitchToSubjectPage() {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickExitButtons();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);

            }
        }

        return new SubjectPage(driver, log);
    }

}
