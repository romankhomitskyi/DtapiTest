package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SpecialityTableContainerComponent {
    private WebElement specialityTableComponent;

    private By specialityId = By.xpath(".//td[contains(@class,'cdk-column-code')]");
    private By specialityName = By.xpath(".//td[contains(@class,'cdk-column-name')]");
    private By editSpecialityIcon = By.xpath(".//td//i[contains(text(),'edit')]/parent::a");
    private By deleteSpecialityIcon = By.xpath(".//td//i[contains(text(),'delete')]/parent::a");


    public SpecialityTableContainerComponent(WebElement specialityTableComponent) {

        this.specialityTableComponent = specialityTableComponent;


    }


    public WebElement getSpecialityId() {
        WebElement specialitysId = specialityTableComponent.findElement(specialityId);
        return specialitysId;
    }

    public String getSpecialityIdText() {
        return getSpecialityId().getText();
    }


    public WebElement getSpecialityName() {
        WebElement specialitysName = specialityTableComponent.findElement(specialityName);
        return specialitysName;
    }

    public String getSpecialityNameText() {

        return getSpecialityName().getText();
    }


    public WebElement getEditSpecialityIcon() {
        WebElement editSpecialitiesIcon = specialityTableComponent.findElement(editSpecialityIcon);
        return editSpecialitiesIcon;
    }

    public void clickSpecialityEditIcon() {
        getEditSpecialityIcon().click();
    }



    public WebElement getDeleteSpecialityIcon() {
        WebElement deleteSpecialitiesIcon = specialityTableComponent.findElement(deleteSpecialityIcon);
        return  deleteSpecialitiesIcon;
    }

    public void clickDeleteSpecialityIcon() {
        getDeleteSpecialityIcon().click();
    }
}
