package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SpecialityTableContainerComponent {
    private WebElement specialityTableComponent;

    private WebElement specialityId;
    private WebElement specialityName ;
    private WebElement editSpecialityIcon;
    private WebElement deleteSpecialityIcon ;


    public SpecialityTableContainerComponent(WebElement specialityTableComponent) {

        this.specialityTableComponent = specialityTableComponent;
        initElements();

    }
    private void initElements(){
        specialityId = specialityTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-code')]"));
        specialityName = specialityTableComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-name')]"));
        editSpecialityIcon = specialityTableComponent.findElement(By.xpath(".//td//i[contains(text(),'edit')]/parent::a"));
        deleteSpecialityIcon = specialityTableComponent.findElement(By.xpath(".//td//i[contains(text(),'delete')]/parent::a"));


    }

    public WebElement getSpecialityId() {
        return specialityId;
    }

    public String getSpecialityIdText() {
        return getSpecialityId().getText();
    }


    public WebElement getSpecialityName() {
        return specialityName;
    }

    public String getSpecialityNameText() {

        return getSpecialityName().getText();
    }


    public WebElement getEditSpecialityIcon() {
        return editSpecialityIcon;
    }

    public void clickSpecialityEditIcon() {
        getEditSpecialityIcon().click();
    }



    public WebElement getDeleteSpecialityIcon() {
        return  deleteSpecialityIcon;
    }

    public void clickDeleteSpecialityIcon() {
        getDeleteSpecialityIcon().click();
    }
}
