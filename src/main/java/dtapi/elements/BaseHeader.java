package dtapi.elements;

import dtapi.pages.BasePageObject;
import dtapi.pages.MainPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseHeader extends BasePageObject {
    protected By logOutButton = By.xpath("//button[contains(@class, 'mat-menu-trigger')][1]");
    protected By languageButton = By.xpath("//button[contains(@class, 'mat-menu-trigger')][2]");
    protected By logOutButtonItem = By.xpath("//button[contains(text(), 'Вийти')]");

    public BaseHeader(WebDriver driver, Logger log) {
        super(driver, log);
    }

    protected void clickLogOutButton() {
        click(logOutButton);
    }

    protected MainPage logOut() {
        clickLogOutButton();
        click(logOutButtonItem);
        return new MainPage(driver, log);
    }

}
