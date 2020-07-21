package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdminTableContainerComponent {
    private WebElement adminTableContainerComponent;

    private WebElement adminLogin;
    private WebElement editAdminIcon ;
    private WebElement deleteAdmin ;


    public AdminTableContainerComponent(WebElement adminTableContainerComponent) {

        this.adminTableContainerComponent = adminTableContainerComponent;
        initElements();

    }
    private void initElements(){
        adminLogin =adminTableContainerComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-username')]"));
        editAdminIcon = adminTableContainerComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'edit')]"));
        deleteAdmin =adminTableContainerComponent.findElement(By.xpath(".//td//mat-icon[contains(text(),'delete')]"));

    }


    public WebElement getAdminLogin() {
        return adminLogin;
    }

    public String getAdminLoginText() {
        return getAdminLogin().getText();
    }



    public WebElement getEditAdminIcon() {

        return  editAdminIcon;
    }

    public void clickEditAdminIcon() {
        getEditAdminIcon().click();
    }



    public WebElement getDeleteAdminIcon() {

        return deleteAdmin;
    }

    public void clickDeleteAdminIcon() {
        getDeleteAdminIcon().click();
    }
}
