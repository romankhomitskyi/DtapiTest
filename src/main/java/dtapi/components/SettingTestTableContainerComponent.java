package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SettingTestTableContainerComponent {
    private WebElement settingTestTableComponent;

    private By settingTestId = By.xpath(".//td[contains(@class,'cdk-column-id')]");
    private By testLvl = By.xpath(".//td[contains(@class,'cdk-column-level')]");
    private By countTask = By.xpath(".//td[contains(@class,'cdk-column-tasks')]");
    private By countGrade = By.xpath(".//td[contains(@class,'cdk-column-rate')]");
    private By editSettingTestIcon = By.xpath(".//td//mat-icon[contains(text(),'edit')]");
    private By deleteSettingTestIcon = By.xpath(".//td//mat-icon[contains(text(),'delete')]");


    public SettingTestTableContainerComponent(WebElement settingTestTableComponent) {

        this.settingTestTableComponent = settingTestTableComponent;


    }


    public WebElement getSettingTestId() {
        WebElement settingsTestId = settingTestTableComponent.findElement(settingTestId);
        return settingsTestId;
    }

    public String getSettingTestIdText() {
        return getSettingTestId().getText();
    }


    public WebElement getTestLvl() {

        WebElement testsLvl = settingTestTableComponent.findElement(testLvl);
        return testsLvl;
    }

    public String getTestLvlText() {

        return getTestLvl().getText();
    }

    public WebElement getCountTask() {
        WebElement countsTask = settingTestTableComponent.findElement(countTask);

        return countsTask;
    }

    public String getCountTaskText() {
        return getCountTask().getText();
    }

    public WebElement getCountGrade() {

        WebElement countsGrade = settingTestTableComponent.findElement(countGrade);
        return countsGrade;
    }

    public String getCountGradeText() {
        return getCountGrade().getText();
    }


    public WebElement getSettingTestIcon() {

        WebElement editsSettingTestsIcon = settingTestTableComponent.findElement(editSettingTestIcon);
        return editsSettingTestsIcon;
    }

    public void clickEditSettingTestIcon() {
        getSettingTestIcon().click();
    }





    public WebElement getDeleteSettingTestIcon() {
        WebElement deleteSettingsTestIcon = settingTestTableComponent.findElement(deleteSettingTestIcon);
        return deleteSettingsTestIcon;
    }

    public void clickDeleteSettingTestIcon() {
        getDeleteSettingTestIcon().click();

    }
}
