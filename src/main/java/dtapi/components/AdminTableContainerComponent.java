package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdminTableContainerComponent {
    private WebElement adminTableContainerComponent;

    private By adminLogin = By.xpath(".//td[contains(@class,'cdk-column-userNameColumn')]");
    private By editAdminIcon = By.xpath(".//td//mat-icon[contains(text(),'edit')]");
    private By deleteAdmin = By.xpath(".//td//mat-icon[contains(text(),'delete')]");


    public AdminTableContainerComponent(WebElement adminTableContainerComponent) {

        this.adminTableContainerComponent = adminTableContainerComponent;


    }


    public WebElement getAdminLogin() {
        WebElement adminsLogin = adminTableContainerComponent.findElement(adminLogin);
        return adminsLogin;
    }

    public String getAdminLoginText() {
        return getAdminLogin().getText();
    }



    public WebElement getEditAdminIcon() {

        WebElement editsAdminIcon = adminTableContainerComponent.findElement(editAdminIcon);
        return  editsAdminIcon;
    }

    public void clickEditAdminIcon() {
        getEditAdminIcon().click();
    }



    public WebElement getDeleteAdminIcon() {
        WebElement deletesAdmin = adminTableContainerComponent.findElement(deleteAdmin);
        return deletesAdmin;
    }

    public void clickDeleteAdminIcon() {
        getDeleteAdminIcon().click();
    }
}
