package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.BasePageObject;
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

    public BaseDeleteItemModalWindow(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 5);
    }

    protected void clickSubmitButton() {
        wait.visibilityOfElementByLocator(submitButton);
        wait.presenceOfElement(submitButton);
        driver.findElement(submitButton).click();
    }

    protected void clickCancelButton() {
        click(cancelButton);

    }


}
