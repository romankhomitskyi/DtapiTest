package dtapi.pages;

import dtapi.data.user.IUser;
import dtapi.dtapiBase.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePageObject {

    private WaitUtils wait;

    public static final String ERROR_MESSAGE = "Не вірний пароль або логін";
    private WebElement loginField;
    private WebElement passwordField;
    private WebElement buttonLogin ;
    private WebElement errorMessage ;


    public MainPage(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 2);
        initElements();

    }
    private void initElements(){
        loginField = driver.findElement(By.xpath("//input[@name='username']"));
        passwordField = driver.findElement( By.xpath("//input[@name='password']"));
        buttonLogin = driver.findElement(By.xpath("//form//button"));


    }

    public UserPage successfulUserLogin(IUser validUser) {
        login(validUser);
        return new UserPage(driver);
    }

    public AdminHomePage successfulAdminLogin(IUser validAdmin) {
        login(validAdmin);
        return new AdminHomePage(driver);
    }

    public void unsuccessfulLoginPage(IUser invalidUser) {
        login(invalidUser);
    }

    private void login(IUser user) {
        fillLoginField(user.getLogin());
        fillPasswordField(user.getPassword());
        clickLoginButton();
    }
    private void clickOnLoginField() {
        wait.waitForElementToBeClickable(loginField);
        loginField.click();
    }
    private void clearLoginField() {
       loginField.clear();
    }

    private void setLogin(String login) {
       loginField.sendKeys(login);
    }


    private void fillLoginField(String name) {
        clickOnLoginField();
        clearLoginField();
        setLogin(name);
    }

    private void clickOnPasswordField() {
        wait.waitForElementToBeClickable(passwordField);
        passwordField.click();
    }

    private void clearPasswordField() {
        passwordField.clear();
    }

    private void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    private void fillPasswordField(String password) {
        clickOnPasswordField();
        clearPasswordField();
        setPassword(password);
    }

    private void clickLoginButton() {
        wait.waitForElementToBeClickable(buttonLogin);
        buttonLogin.click();
    }

    public String getErrorMessageText() {

        wait.visibilityOfAllElementsByLocator(By.xpath("//label[contains(text(),'Не вірний пароль або логін')]"));
        errorMessage = driver.findElement(By.xpath("//label[contains(text(),'Не вірний пароль або логін')]"));
        return errorMessage.getText();
    }
    
}
