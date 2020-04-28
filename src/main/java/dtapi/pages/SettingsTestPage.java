package dtapi.pages;

import dtapi.components.SettingTestTableContainer;
import dtapi.components.SettingTestTableContainerComponent;
import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.Paginator;
import dtapi.modalsWindows.AddNewSettingOfTestModalWindow;
import dtapi.modalsWindows.DeleteSettingOfTestModalWindow;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsTestPage extends Paginator {
    private By addNewSettingsButton = By.xpath("//span[contains(text(),'Додати налаштування')]/parent::button");
    private WaitUtils wait;
    public SettingsTestPage(WebDriver driver, Logger log) {
        super(driver, log);
        initElements();
        wait = new WaitUtils(driver,10);
    }
    private SettingTestTableContainer settingTestTableContainer;


    private void initElements() {

        settingTestTableContainer = new SettingTestTableContainer(driver, log);
    }

    public SettingTestTableContainer getSettingTestTableContainer() {
        return settingTestTableContainer;
    }

    public AddNewSettingOfTestModalWindow switchToAddAddNewSettingOfTestModalWindow() {
        String shoppingCartWindow = driver.getWindowHandle();
        wait.prevenseOfElement(addNewSettingsButton);
        wait.visibilityOfElement(addNewSettingsButton);
        click(addNewSettingsButton);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                wait.waitForPageLoad();
                driver.switchTo().window(windowHandle);
                wait.waitForPageLoad();
            }
        }
        return new AddNewSettingOfTestModalWindow(driver, log);
    }
    public DeleteSettingOfTestModalWindow switchToDeleteSettingsModalWindow(String settingId) {
        String shoppingCartWindow = driver.getWindowHandle();
        getSettingTestTableContainer()
                .getSettingsTestsContainerComponentById(settingId)
                .clickDeleteSettingTestIcon();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new  DeleteSettingOfTestModalWindow(driver, log);
    }
    public AddNewSettingOfTestModalWindow switchToEditSettingsModalWindow(String settingId) {
        String shoppingCartWindow = driver.getWindowHandle();
        getSettingTestTableContainer()
                .getSettingsTestsContainerComponentById(settingId)
                .clickEditSettingTestIcon();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new AddNewSettingOfTestModalWindow(driver, log);
    }
    public boolean verifySettingsRemoved(String  settingId) {
        for (SettingTestTableContainerComponent component : getSettingTestTableContainer().getSettingsTestContainerComponents()) {
            if (component.getSettingTestIdText().equals(settingId)) {
                return false;
            }
        }
        return true;
    }

    public boolean verifySettingsEdited(String settingId) {

        for (SettingTestTableContainerComponent component : getSettingTestTableContainer().getSettingsTestContainerComponents()) {
            if (component.getSettingTestIdText().equals(settingId)) {
                return true;
            }
        }
        return false;
    }
    public boolean verifySettingsAdded(String settingId) {

        String setId = getSettingTestTableContainer()
                .getSettingsTestsContainerComponentById(settingId)
                .getSettingTestIdText();
        if(settingId.equals(setId)){
            return true;
        }

        return false;
    }
}
