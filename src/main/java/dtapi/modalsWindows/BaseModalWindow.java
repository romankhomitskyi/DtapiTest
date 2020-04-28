package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseModalWindow extends BasePageObject {


    protected By submitButton = By.xpath("//mat-dialog-container//button[@type='submit']");
    protected By cancelButton = By.xpath("//mat-dialog-container//button[@type='submit']/following-sibling::button");
    private WaitUtils waitUtils;

    public BaseModalWindow(WebDriver driver, Logger log) {
        super(driver, log);
        waitUtils = new WaitUtils(driver, 5);
    }

    protected void clickSubmitButton() {
        waitUtils.visibilityOfElement(submitButton);
        waitUtils.prevenseOfElement(submitButton);
        click(submitButton);
    }

    public WebElement getSubmitButton() {
        WebElement subButton = driver.findElement(By.xpath("//mat-dialog-container//button[@type='submit']"));
        return subButton;
    }

    protected void clickCancelButton() {
        click(cancelButton);

    }


}
