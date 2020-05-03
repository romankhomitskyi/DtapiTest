package dtapi.modalsWindows;

import dtapi.data.admin.IAdmin;
import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.AdminsPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewAdminModalWindow  extends BaseModalWindow{
    private By adminLogin = By.xpath("//input[@formcontrolname='username']");
    private By adminEmail = By.xpath("//input[@placeholder='email']");
    private By adminPassword = By.xpath("//input[@placeholder='пароль']");
    private By adminСonfirmPassword = By.xpath("//input[@placeholder='підтвердіть пароль']");
    private By addAdminButton = By.xpath("//span[contains(text(),'Відмінити')]/parent::button/preceding-sibling::button");
    private WaitUtils wait;
    public AddNewAdminModalWindow(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver,10);
    }
    public boolean isAdminButtonEnabled() {

        wait.prevenseOfElement(addAdminButton);
        wait.visibilityOfElement(addAdminButton);
        WebElement result = driver.findElement(addAdminButton);
        wait.scrollUntilElementVisible(result);
        return result.isEnabled();
    }
    private void clickAdminLoginField() {
        wait.visibilityOfElement(adminLogin);
        wait.prevenseOfElement(adminLogin);
        driver.findElement(adminLogin).click();
    }

    private void clearAdminLoginField() {
        wait.visibilityOfElement(adminLogin);
        wait.prevenseOfElement(adminLogin);
        driver.findElement(adminLogin).clear();
    }

    private void setAdminLoginField(String adminLog) {
        wait.visibilityOfElement(adminLogin);
        wait.prevenseOfElement(adminLogin);
        type(adminLog, adminLogin);
    }

    private void fillAdminLoginField(String adminLog) {
        clickAdminLoginField();
        clearAdminLoginField();
        setAdminLoginField(adminLog);
    }

    private void clickAdminEmailField() {
        wait.visibilityOfElement(adminEmail);
        wait.prevenseOfElement(adminEmail);
        driver.findElement(adminEmail).click();
    }

    private void clearAdminEmailField() {
        wait.visibilityOfElement(adminEmail);
        wait.prevenseOfElement(adminEmail);
        driver.findElement(adminEmail).clear();
    }

    private void setAdminEmailField(String adminsEmail) {
        wait.visibilityOfElement(adminEmail);
        wait.prevenseOfElement(adminEmail);

        type(adminsEmail, adminEmail);
    }

    private void fillAdminEmailField(String adminsEmail) {
        clickAdminEmailField();
        clearAdminEmailField();
        setAdminEmailField(adminsEmail);
    }





    private void clickAdminСonfirmPasswordField() {
        wait.visibilityOfElement(adminСonfirmPassword);
        wait.prevenseOfElement(adminСonfirmPassword);
        driver.findElement(adminСonfirmPassword).click();
    }

    private void clearAdminСonfirmPasswordField() {
        wait.visibilityOfElement(adminСonfirmPassword);
        wait.prevenseOfElement(adminСonfirmPassword);
        driver.findElement(adminСonfirmPassword).clear();
    }

    private void setAdminСonfirmPasswordField(String adminsСonfirmPassword) {
        wait.visibilityOfElement(adminСonfirmPassword);
        wait.prevenseOfElement(adminСonfirmPassword);

        type(adminsСonfirmPassword, adminСonfirmPassword);
    }

    private void fillAdminСonfirmPasswordField(String adminsСonfirmPassword) {
        clickAdminСonfirmPasswordField();
        clearAdminСonfirmPasswordField();
        setAdminСonfirmPasswordField(adminsСonfirmPassword);
    }
    private void clickAdminPasswordField() {
        wait.visibilityOfElement(adminPassword);
        wait.prevenseOfElement(adminPassword);
        driver.findElement(adminPassword).click();
    }

    private void clearAdminPasswordField() {
        wait.visibilityOfElement(adminPassword);
        wait.prevenseOfElement(adminPassword);
        driver.findElement(adminPassword).clear();
    }

    private void setAdminPasswordField(String adminsPassword) {
        wait.visibilityOfElement(adminPassword);
        wait.prevenseOfElement(adminPassword);

        type(adminsPassword, adminPassword);
    }

    private void fillAdminPasswordField(String adminsPassword) {
        clickAdminPasswordField();
        clearAdminPasswordField();
        setAdminPasswordField(adminsPassword);
    }
    private void fillAllAdminFields(IAdmin admin) {
        fillAdminLoginField(admin.getAdminLogin());
        fillAdminEmailField(admin.getAdminEmail());
        fillAdminPasswordField(admin.getAdminPassword());
        fillAdminСonfirmPasswordField(admin.getAdminConfirmPassword());

    }
    private void clickAddAdminButton() {
        wait.visibilityOfElement(addAdminButton);
        wait.prevenseOfElement(addAdminButton);
        click(addAdminButton);
    }
    private void createAdmin(IAdmin validAdmin) {
        fillAllAdminFields(validAdmin);
        clickAddAdminButton();

    }
    public AdminsPage fillAllAdminFieldsAndSubmitForm(IAdmin admin) {
        String addSubjectPageWindow = driver.getWindowHandle();
        createAdmin(admin);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {

                driver.switchTo().window(windowHandle);
            }
        }

        return new AdminsPage(driver, log);
    }
    public AddNewAdminModalWindow fillInvalidDataInAdminFields(IAdmin invalidAdmin) {

        fillInvalidData(invalidAdmin);


        return new AddNewAdminModalWindow(driver, log);
    }
    private void fillInvalidData(IAdmin invalidAdmin) {
        fillAllAdminFields(invalidAdmin);


    }
}
