package dtapi.pages;

import dtapi.data.user.IUser;
import dtapi.dtapiBase.WaitUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BasePageObject {

    private WaitUtils wait;

    public MainPage(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 2);


    }
    public static final String ERROR_MESSAGE = "Не вірний пароль або логін";
    private By loginField = By.xpath("//input[@name='username']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By buttonLogin = By.xpath("//form//button");
    private By heading = By.xpath("//form/h3");
    private By errorMessage = By.xpath("//label[contains(text(),'Не вірний пароль або логін')]");
    private List<WebElement> languageOption;




    private void clickOnLoginField() {

        wait.prevenseOfElement(loginField);
        wait.visibilityOfElement(loginField);
        driver.findElement(loginField).click();
    }

    private void setLogin(String login) {

        wait.visibilityOfElement(loginField);
        wait.prevenseOfElement(loginField);
        type(login, loginField);
    }

    private void clearLoginField() {

        wait.visibilityOfElement(loginField);
        wait.prevenseOfElement(loginField);
        driver.findElement(loginField).clear();
    }

    private void fillLoginField(String name) {
        clickOnLoginField();
        clearLoginField();
        setLogin(name);
    }

    private void clickOnPasswordField() {

        wait.visibilityOfElement(passwordField);
        wait.prevenseOfElement(passwordField);
        driver.findElement(passwordField).click();
    }

    private void setPassword(String password) {

        wait.visibilityOfElement(passwordField);
        wait.prevenseOfElement(passwordField);
        type(password, passwordField);
    }

    private void clearPasswordField() {

        wait.visibilityOfElement(passwordField);
        wait.prevenseOfElement(passwordField);
        driver.findElement(passwordField).clear();
    }

    private void fillPasswordField(String password) {
        clickOnPasswordField();
        clearPasswordField();
        setPassword(password);
    }

    private void login(IUser user) {
        fillLoginField(user.getLogin());
        fillPasswordField(user.getPassword());
        clickLoginButton();
    }

    private void clickLoginButton() {

        wait.visibilityOfElement(buttonLogin);
        wait.prevenseOfElement(buttonLogin);
        driver.findElement(buttonLogin).click();


    }


    public UserPage successfulLogin(IUser validUser) {
        login(validUser);
        return new UserPage(driver, log);
    }

    public AdminHomePage successfulAdminLogin(IUser validAdmin) {
        login(validAdmin);
        wait.waitForPageLoad();
        return new AdminHomePage(driver, log);
    }

    public void unsuccessfulLoginPage(IUser invalidUser) {
        login(invalidUser);

    }


    public String getErrorMessageText() {
        waitForVisibilityOf(errorMessage, 5);
        return find(errorMessage).getText();
    }


    public String getHeadingText() {
        return find(heading).getText();
    }




}
