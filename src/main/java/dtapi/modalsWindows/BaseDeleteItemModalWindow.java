package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseDeleteItemModalWindow extends BasePageObject {
    private WaitUtils wait;

    public WebElement getDeleteSubmitButton() {
        WebElement subDeleteButton = driver.findElement(By.xpath("//span[contains(text(),'Підтвердити')]/parent::button"));
        return subDeleteButton;
    }

    private By submitButton = By.xpath("//span[contains(text(),'Підтвердити')]/parent::button");
    private By cancelButton = By.xpath("//span[contains(text(),'Відмінити')]/parent::button");

    public BaseDeleteItemModalWindow(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 5);
    }

    protected void clickSubmitButton() {
        wait.visibilityOfElement(submitButton);
        wait.prevenseOfElement(submitButton);
        driver.findElement(submitButton).click();
    }

    protected void clickCancelButton() {
        click(cancelButton);

    }


}
