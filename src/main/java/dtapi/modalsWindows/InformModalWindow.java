package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InformModalWindow extends BaseModalWindow {
    private WaitUtils wait;
    private By divText = By.xpath("//div[@class='content']");
    private By exitButton = By.xpath("//span[contains(text(),'Закрити')]/parent::button");

    public InformModalWindow(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 10);
    }

    public boolean isTextPresent() {
        sleep(300);
        wait.presenceOfElement(divText);
        wait.visibilityOfElementByLocator(divText);
        WebElement result = driver.findElement(divText);
        return result.isDisplayed();
    }

    private void clickExitButtons() {
        wait.visibilityOfElementByLocator(exitButton);
        wait.presenceOfElement(exitButton);
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

        return new SettingsTestPage(driver);
    }
    public TestPage clickExitsButton() {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickExitButtons();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);

            }
        }

        return new TestPage(driver);
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

        return new FacultiesPage(driver);
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

        return new GroupPage(driver);
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

        return new SpecialityPage(driver);
    }
    public SubjectPage clickExitButtonAndSwitchToSubjectPage() {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickExitButtons();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);

            }
        }

        return new SubjectPage(driver);
    }

}
