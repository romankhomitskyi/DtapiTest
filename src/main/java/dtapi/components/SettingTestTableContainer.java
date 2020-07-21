package dtapi.components;

import dtapi.data.testSettings.TestSettings;
import dtapi.elements.Paginator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SettingTestTableContainer  extends Paginator {

    private final String settingsTestTableContainerXpath = "//table/tbody/tr";
    private  List<SettingTestTableContainerComponent> containerComponents;

    public SettingTestTableContainer(WebDriver driver) {
        super(driver);
       initElements();
    }

        private void initElements(){
            containerComponents = new ArrayList<>();
            for (WebElement current : driver.findElements(By.xpath(settingsTestTableContainerXpath))) {
                containerComponents.add(new SettingTestTableContainerComponent(current));
            }
        }


    public List<SettingTestTableContainerComponent> getSettingsTestContainerComponents() {
        return containerComponents;
    }


    public SettingTestTableContainerComponent getSettingsTestsContainerComponentById(String settingTestId) {
        return getSettingsTestContainerComponentById(settingTestId);
    }
    public SettingTestTableContainerComponent getSettingsTestsContainerComponentById(TestSettings testSettings) {
        return getSettingsTestContainerComponentById(testSettings.getRate());
    }
    private SettingTestTableContainerComponent getSettingsTestContainerComponentById(String settingTestId) {
        SettingTestTableContainerComponent result = findTestSettings(settingTestId);

        while (result == null ) {
            if (!isNextArrowEnabled() && result == null) {
                throw new RuntimeException(String.format("Setting test with id: %s not found", settingTestId));
            }
            clickNextButton();
            initElements();
            result = findTestSettings(settingTestId);

        }
        return result;

    }

    private SettingTestTableContainerComponent findTestSettings( String settingTestId) {
        for (SettingTestTableContainerComponent current : containerComponents) {

            if (current.getCountGradeText().toLowerCase().equals(settingTestId.toLowerCase())) {

                return current;
            }
        }
        return null;
    }

}
