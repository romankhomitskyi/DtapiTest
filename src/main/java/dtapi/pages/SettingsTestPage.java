package dtapi.pages;

import dtapi.components.SettingTestTableContainer;
import dtapi.components.SettingTestTableContainerComponent;
import dtapi.data.testSettings.TestSettings;
import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.AdminHeadrer;
import dtapi.elements.Paginator;
import dtapi.modalsWindows.AddNewSettingOfTestModalWindow;
import dtapi.modalsWindows.DeleteSettingOfTestModalWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class SettingsTestPage extends AdminHeadrer {

    private By addNewSettingsButton = By.xpath("//span[contains(text(),'Додати налаштування')]/parent::button");
    private WaitUtils wait;
    private By deleteSettingTestIcon = By.xpath(".//td//mat-icon[contains(text(),'delete')]");
    public SettingsTestPage(WebDriver driver) {
        super(driver);
        initElements();
        wait = new WaitUtils(driver,10);
    }
    private SettingTestTableContainer settingTestTableContainer;


    private void initElements() {

        settingTestTableContainer = new SettingTestTableContainer(driver);

    }

    public SettingTestTableContainer getSettingTestTableContainer() {
        return settingTestTableContainer;
    }
    public SettingsTestPage addTestSettings(List<TestSettings> settings) {

        int i = 1;
        SettingsTestPage settingsTestPage = getTestSetting(settings.get(0));

        while (i != settings.size()) {
            settingsTestPage = settingsTestPage.getTestSetting(settings.get(i));
            i++;
        }

        return new SettingsTestPage(driver);
    }
    public SettingsTestPage deleteTestsSettings(List<TestSettings> settings) {

        int i = 1;
        SettingsTestPage settingsTestPage = deleteAllTestSetting(settings.get(0));

        while (i != settings.size()) {
            settingsTestPage = settingsTestPage.deleteAllTestSetting(settings.get(i));
            i++;
        }

        return new SettingsTestPage(driver);
    }

    public SettingsTestPage getTestSetting(TestSettings testSettings) {
        switchToAddAddNewSettingOfTestModalWindow()
                .fillAllSettingsAndSubmitForm(testSettings);
        return new SettingsTestPage(driver);
    }
    public AddNewSettingOfTestModalWindow switchToAddAddNewSettingOfTestModalWindow() {
        String shoppingCartWindow = driver.getWindowHandle();
        wait.presenceOfElement(addNewSettingsButton);
        wait.visibilityOfElementByLocator(addNewSettingsButton);
        click(addNewSettingsButton);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {

                driver.switchTo().window(windowHandle);

            }
        }
        return new AddNewSettingOfTestModalWindow(driver);
    }
    public SettingsTestPage deleteAllTestSetting(TestSettings testSettings) {
        switchToDeleteSettingsModalWindow(testSettings)
                .deleteSettings()
                .clickExitButton();
        return new SettingsTestPage(driver);
    }

    public DeleteSettingOfTestModalWindow switchToDeleteSettingsModalWindow(TestSettings settingId) {
        String shoppingCartWindow = driver.getWindowHandle();
        getSettingTestTableContainer()
                .getSettingsTestsContainerComponentById(settingId)
                .clickDeleteSettingTestIcon();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new  DeleteSettingOfTestModalWindow(driver);
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
        return new AddNewSettingOfTestModalWindow(driver);
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
    public TestPage backToTestPage() {

        driver.navigate().back();
        return new TestPage(driver);
    }
    protected void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
