package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseModalWindow extends BasePageObject {


    protected By submitButton = By.xpath("//mat-dialog-container//button[@type='submit']");
    protected By cancelButton = By.xpath("//mat-dialog-container//button[@type='submit']/following-sibling::button");
    private WaitUtils wait;

    public BaseModalWindow(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 5);
    }
    public boolean isSubmitButtonEnabled() {

        wait.prevenseOfElement(submitButton);
        wait.visibilityOfElement(submitButton);
       wait.scrollUntilElementVisible(driver.findElement(submitButton));
        WebElement result = driver.findElement(submitButton);
        return result.isEnabled();
    }
    protected void clickSubmitButton() {
        wait.visibilityOfElement(submitButton);
        wait.prevenseOfElement(submitButton);
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
