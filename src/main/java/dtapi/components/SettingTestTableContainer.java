package dtapi.components;

import dtapi.data.testSettings.TestSettings;
import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.Paginator;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SettingTestTableContainer  extends Paginator {


    public SettingTestTableContainer(WebDriver driver) {
        super(driver, log);
        wait = new WaitUtils(driver,10);
    }
    private final String settingsTestTableContainerXpath = "//table/tbody/tr";
    private WaitUtils wait;



    protected void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<SettingTestTableContainerComponent> getSettingsTestContainerComponents() {
        WebDriverWait waits = new WebDriverWait(driver, 10);
        sleep(2000);
        /*waits.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath(groupTableContainerXpath))));*/
        List<SettingTestTableContainerComponent> containerComponents = new ArrayList<>();
        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(settingsTestTableContainerXpath))));

        for (WebElement current : rows) {
            System.out.println(current.getText());
            containerComponents.add(new SettingTestTableContainerComponent(current));
        }
        return containerComponents;
    }


    public int getSettingsTestContainerComponentsCount() {
        return getSettingsTestContainerComponents().size();
    }

    public List<String> getSettingsTestContainerComponentsNames() {
        List<String> containerComponentNames = new ArrayList<>();
        for (SettingTestTableContainerComponent current : getSettingsTestContainerComponents()) {
            containerComponentNames.add(current.getSettingTestIdText());
        }
        return containerComponentNames;
    }


    public String getContainerComponentLvlById(String settingTestId) {
        return getSettingsTestContainerComponentById(settingTestId).getTestLvlText();
    }

    public String getContainerComponentCountTaskById(String settingTestId) {
        return getSettingsTestContainerComponentById(settingTestId).getCountTaskText();
    }

    public String getContainerComponentCountGradeById(String settingTestId) {
        return getSettingsTestContainerComponentById(settingTestId).getCountGradeText();
    }


    public void clickContainerComponentEditSettingsTestIconById(String settingTestId) {
        getSettingsTestContainerComponentById(settingTestId).clickEditSettingTestIcon();
    }

    public void clickContainerComponentDeleteSettingTestIconById(String settingTestId) {
        getSettingsTestContainerComponentById(settingTestId).clickDeleteSettingTestIcon();
    }


    public SettingTestTableContainerComponent getSettingsTestsContainerComponentById(String settingTestId) {
        return getSettingsTestContainerComponentById(settingTestId);
    }
    public SettingTestTableContainerComponent getSettingsTestsContainerComponentById(TestSettings testSettings) {
        return getSettingsTestContainerComponentById(testSettings.getRate());
    }


    protected SettingTestTableContainerComponent getSettingsTestContainerComponentById(String settingTestId) {
        SettingTestTableContainerComponent result = null;
        WebDriverWait waits = new WebDriverWait(driver, 10);
        sleep(2000);
        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(settingsTestTableContainerXpath))));
        List<SettingTestTableContainerComponent> containerComponents = new ArrayList<>();
        for (WebElement current : rows) {
            containerComponents.add(new SettingTestTableContainerComponent(current));
        }
        for (SettingTestTableContainerComponent current : containerComponents) {

            if (current.getCountGradeText().toLowerCase().equals(settingTestId.toLowerCase())) {
                result = current;
                break;
            }

        }
        if (result == null){

            boolean isEnabled = isNextArrowEnabled();
            while (isEnabled) {
                clickNextButton();
                waits.until(ExpectedConditions.invisibilityOfAllElements(rows));
                List<WebElement> rows2 = waits.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(settingsTestTableContainerXpath))));
                List<SettingTestTableContainerComponent> containerComponents2 = new ArrayList<>();
                for (WebElement current2 : rows2) {
                    containerComponents2.add(new SettingTestTableContainerComponent(current2));

                }
                for (SettingTestTableContainerComponent current3 : containerComponents2) {

                    if (current3.getCountGradeText().toLowerCase().equals(settingTestId.toLowerCase())) {
                        result = current3;
                        break;
                    }
                }

                if (result == null) {
                    if (isNextArrowEnabled()) isEnabled = true;
                    else isEnabled = false;
                } else return result;
            }
        }

        if (result == null) {
            throw new RuntimeException(String.format("Setting test with id: %s not found", settingTestId));
        }

        return result;


    }

}
