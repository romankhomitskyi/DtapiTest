package dtapi.modalsWindows;

import dtapi.data.admin.IAdmin;
import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.AdminsPage;
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
    public AddNewAdminModalWindow(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver,10);
    }
    public boolean isAdminButtonEnabled() {

        wait.presenceOfElement(addAdminButton);
        wait.visibilityOfElementByLocator(addAdminButton);
        WebElement result = driver.findElement(addAdminButton);
        wait.scrollUntilElementVisible(result);
        return result.isEnabled();
    }
    private void clickAdminLoginField() {
        wait.visibilityOfElementByLocator(adminLogin);
        wait.presenceOfElement(adminLogin);
        driver.findElement(adminLogin).click();
    }

    private void clearAdminLoginField() {
        wait.visibilityOfElementByLocator(adminLogin);
        wait.presenceOfElement(adminLogin);
        driver.findElement(adminLogin).clear();
    }

    private void setAdminLoginField(String adminLog) {
        wait.visibilityOfElementByLocator(adminLogin);
        wait.presenceOfElement(adminLogin);
        type(adminLog, adminLogin);
    }

    private void fillAdminLoginField(String adminLog) {
        clickAdminLoginField();
        clearAdminLoginField();
        setAdminLoginField(adminLog);
    }

    private void clickAdminEmailField() {
        wait.visibilityOfElementByLocator(adminEmail);
        wait.presenceOfElement(adminEmail);
        driver.findElement(adminEmail).click();
    }

    private void clearAdminEmailField() {
        wait.visibilityOfElementByLocator(adminEmail);
        wait.presenceOfElement(adminEmail);
        driver.findElement(adminEmail).clear();
    }

    private void setAdminEmailField(String adminsEmail) {
        wait.visibilityOfElementByLocator(adminEmail);
        wait.presenceOfElement(adminEmail);

        type(adminsEmail, adminEmail);
    }

    private void fillAdminEmailField(String adminsEmail) {
        clickAdminEmailField();
        clearAdminEmailField();
        setAdminEmailField(adminsEmail);
    }





    private void clickAdminСonfirmPasswordField() {
        wait.visibilityOfElementByLocator(adminСonfirmPassword);
        wait.presenceOfElement(adminСonfirmPassword);
        driver.findElement(adminСonfirmPassword).click();
    }

    private void clearAdminСonfirmPasswordField() {
        wait.visibilityOfElementByLocator(adminСonfirmPassword);
        wait.presenceOfElement(adminСonfirmPassword);
        driver.findElement(adminСonfirmPassword).clear();
    }

    private void setAdminСonfirmPasswordField(String adminsСonfirmPassword) {
        wait.visibilityOfElementByLocator(adminСonfirmPassword);
        wait.presenceOfElement(adminСonfirmPassword);

        type(adminsСonfirmPassword, adminСonfirmPassword);
    }

    private void fillAdminСonfirmPasswordField(String adminsСonfirmPassword) {
        clickAdminСonfirmPasswordField();
        clearAdminСonfirmPasswordField();
        setAdminСonfirmPasswordField(adminsСonfirmPassword);
    }
    private void clickAdminPasswordField() {
        wait.visibilityOfElementByLocator(adminPassword);
        wait.presenceOfElement(adminPassword);
        driver.findElement(adminPassword).click();
    }

    private void clearAdminPasswordField() {
        wait.visibilityOfElementByLocator(adminPassword);
        wait.presenceOfElement(adminPassword);
        driver.findElement(adminPassword).clear();
    }

    private void setAdminPasswordField(String adminsPassword) {
        wait.visibilityOfElementByLocator(adminPassword);
        wait.presenceOfElement(adminPassword);

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
        wait.visibilityOfElementByLocator(addAdminButton);
        wait.presenceOfElement(addAdminButton);
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

        return new AdminsPage(driver);
    }
    public AddNewAdminModalWindow fillInvalidDataInAdminFields(IAdmin invalidAdmin) {

        fillInvalidData(invalidAdmin);


        return new AddNewAdminModalWindow(driver);
    }
    private void fillInvalidData(IAdmin invalidAdmin) {
        fillAllAdminFields(invalidAdmin);


    }
}
