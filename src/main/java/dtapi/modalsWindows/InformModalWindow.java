package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InformModalWindow extends BaseModalWindow {
    private WaitUtils wait;
    private By divText = By.xpath("//div[@class='content']");
    private By exitButton = By.xpath("//span[contains(text(),'Закрити')]/parent::button");

    public InformModalWindow(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver,10);
    }

    public boolean isTextPresent(){
        wait.prevenseOfElement(divText);
        wait.visibilityOfElement(divText);
        WebElement result = driver.findElement(divText);
        wait.scrollUntilElementVisible(result);
        return result.isDisplayed();
    }
}
