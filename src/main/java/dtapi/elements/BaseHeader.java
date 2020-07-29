package dtapi.elements;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.BasePageObject;
import dtapi.pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseHeader extends BasePageObject {
    private WebElement logOutButton;
    private WebElement logOutButtonItem;
    private WaitUtils wait;

    public BaseHeader(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver,5);
        initElements();
    }
    private void initElements(){
        wait.visibilityOfElementByLocator(By.xpath("//mat-toolbar/button"));
        logOutButton = driver.findElement(By.xpath("//mat-toolbar/button"));

        if(!driver.findElements(By.xpath("//button[contains(text(), 'Вийти')]")).isEmpty()) {
            logOutButtonItem = driver.findElement(By.xpath("//button[contains(text(), 'Вийти')]"));
        }
    }
    public MainPage logOut() {
        clickLogOutButton();
        clickLogOutButtonItem();
        return new MainPage(driver);
    }

    private void clickLogOutButton() {
        logOutButton.click();
    }
    private void clickLogOutButtonItem(){
        logOutButtonItem.click();
    }


}
