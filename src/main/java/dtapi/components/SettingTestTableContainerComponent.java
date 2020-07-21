package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SettingTestTableContainerComponent {
    private WebElement settingTestTableComponent;

    private WebElement settingTestId;
    private WebElement testLvl;
    private WebElement countTask ;
    private WebElement countGrade;
    private WebElement editSettingTestIcon ;
    private WebElement deleteSettingTestIcon ;


    public SettingTestTableContainerComponent(WebElement settingTestTableComponent) {

        this.settingTestTableComponent = settingTestTableComponent;
        initElements();

    }
    private void initElements(){
        settingTestId = settingTestTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-id')]"));
        testLvl = settingTestTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-level')]"));
        countTask = settingTestTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-tasks')]"));
        countGrade = settingTestTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-rate')]"));
        editSettingTestIcon = settingTestTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'edit')]"));
        deleteSettingTestIcon = settingTestTableComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'delete')]"));

    }


    public WebElement getSettingTestId() {
        return settingTestId;
    }

    public String getSettingTestIdText() {
        return getSettingTestId().getText();
    }


    public WebElement getTestLvl() {
        return testLvl;
    }

    public String getTestLvlText() {

        return getTestLvl().getText();
    }

    public WebElement getCountTask() {
        return countTask;
    }

    public String getCountTaskText() {
        return getCountTask().getText();
    }

    public WebElement getCountGrade() {
        return countGrade;
    }

    public String getCountGradeText() {
        return getCountGrade().getText();
    }


    public WebElement getSettingTestIcon() {
        return editSettingTestIcon;
    }

    public void clickEditSettingTestIcon() {
        getSettingTestIcon().click();
    }


    public WebElement getDeleteSettingTestIcon() {
        return deleteSettingTestIcon;
    }

    public void clickDeleteSettingTestIcon() {
        getDeleteSettingTestIcon().click();

    }
}
