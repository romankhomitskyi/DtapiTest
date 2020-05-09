package dtapi.pages;

import dtapi.components.AdminTableContainer;
import dtapi.components.AdminTableContainerComponent;
import dtapi.data.admin.IAdmin;
import dtapi.dtapiBase.WaitUtils;
import dtapi.modalsWindows.AddNewAdminModalWindow;
import dtapi.modalsWindows.DeleteAdminModalWindow;
import dtapi.tables.BaseTable;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminsPage extends BaseTable {
    private By adminsPageTitle = By.xpath("//h3");
    private By addAdminButton = By.xpath("//span[contains(text(),'Додати адміна')]/parent::button");
    private WaitUtils wait;
    private AdminTableContainer adminTableContainer;
    public static final String PAGE_TITLE = "Адміни";

    public AdminsPage(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 10);
        initElements();
    }
    private void initElements() {

        adminTableContainer = new AdminTableContainer(driver, log);

    }
    public AdminTableContainer getAdminTableContainer() {
        return adminTableContainer;
    }

    public String getAdminsPageTitleText() {
        wait.visibilityOfElement(adminsPageTitle);
        wait.prevenseOfElement(adminsPageTitle);
        return find(adminsPageTitle).getText();
    }
    public AddNewAdminModalWindow switchToEditAdminModalWindow(IAdmin admin) {
        String shoppingCartWindow = driver.getWindowHandle();
        getAdminTableContainer()
                .getAdminContainerComponentByLogin(admin.getAdminLogin())
                .clickEditAdminIcon();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new AddNewAdminModalWindow(driver, log);
    }
    public boolean verifyAdminEdited(IAdmin admin) {

        for (AdminTableContainerComponent component : getAdminTableContainer().getAdminContainerComponents()) {
            if (component.getAdminLoginText().equals(admin.getAdminLogin())) {
                return true;
            }
        }
        return false;
    }
    public boolean verifyAdminRemoved(IAdmin  admin) {

        for (AdminTableContainerComponent component : getAdminTableContainer().getAdminContainerComponents()) {
            if (component.getAdminLoginText().equals(admin.getAdminLogin())) {
                return false;
            }
        }
        return true;
    }
    public boolean verifyAdminAdded(IAdmin admin) {

        String  admLog = getAdminTableContainer()
                .getAdminContainerComponentByLogin(admin.getAdminLogin())
                .getAdminLoginText();
        if(admLog.equals(admin.getAdminLogin())){
            return true;
        }

        return false;
    }

    public AddNewAdminModalWindow switchToAddNewAdminModalWindow() {
        String shoppingCartWindow = driver.getWindowHandle();
        wait.prevenseOfElement(addAdminButton);
        wait.visibilityOfElement(addAdminButton);
        click(addAdminButton);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new AddNewAdminModalWindow(driver, log);
    }
    public DeleteAdminModalWindow switchToDeleteAdminModalWindow(IAdmin admin) {
        String shoppingCartWindow = driver.getWindowHandle();
        getAdminTableContainer()
                .getAdminContainerComponentByLogin(admin.getAdminLogin())
                .clickDeleteAdminIcon();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new  DeleteAdminModalWindow(driver, log);
    }
    public AdminsPage refreshPage() {
        sleep(1000);
        wait.prevenseOfElement(adminsPageTitle);
        wait.visibilityOfElement(adminsPageTitle);
        driver.navigate().refresh();


        return this;
    }
}
