package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.GroupPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ViewGroupBySpecialityWindow extends BaseModalWindow {
    private By specialityDropDown = By.xpath("//mat-select[contains(@class,'mat-select') and contains(@placeholder,'Виберіть спеціальність')]");
    private By specialityDropDown2 = By.xpath("//mat-select[contains(@class,'mat-select') and contains(@placeholder,'Виберіть спеціальність')]/parent::*/parent::*/parent::*/parent::*");
    private By listBox = By.xpath("//div[contains(@class,'mat-primary')]");
    private String specialityDropDownOption = "//mat-option//span[contains(text(),'%s')]";
    private WaitUtils wait;

    public ViewGroupBySpecialityWindow(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 10);
    }

    private void clickSpecialityDropDown() {
        wait.visibilityOfElement(specialityDropDown);
        wait.prevenseOfElement(specialityDropDown);
        click(specialityDropDown);
        wait.visibilityOfElement2(driver.findElement(listBox));
        wait.prevenseOfElement(listBox);

    }

    private void clickSpecialityOptions(String specialityName) {
        wait.visibilityOfElement2(driver.findElement(By.xpath("//mat-option/span")));
        wait.waitForElementClickability2(driver.findElement(By.xpath("//mat-option/span")));
        List<WebElement> dropDown = driver.findElements(By.xpath("//mat-option/span"));
        for (WebElement options : dropDown) {
            if (options.getText().equals(specialityName)) {
                options.click(); // click the desired option
                break;
            }
        }

    }

    private void setSpecialityDropDownOption(String specialityName) {
        clickSpecialityDropDown();
        clickSpecialityOptions(specialityName);

    }

    private void setSpecialityAndClickShowButton(String specialityName) {
        setSpecialityDropDownOption(specialityName);
        clickSubmitButton();
    }

    public GroupPage setSpecialityFilterToTheTable(String specialityName) {
        String addSubjectPageWindow = driver.getWindowHandle();
        setSpecialityAndClickShowButton(specialityName);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new GroupPage(driver);
    }
}
