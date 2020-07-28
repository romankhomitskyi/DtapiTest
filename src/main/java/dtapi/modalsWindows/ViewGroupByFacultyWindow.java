package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.GroupPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ViewGroupByFacultyWindow extends BaseModalWindow {
    private By facultyDropDown = By.xpath("//mat-select[contains(@class,'mat-select') and contains(@placeholder,'Виберіть факультет/інститут')]");
    private By facultyDropDown2 = By.xpath("//mat-select[contains(@class,'mat-select') and contains(@placeholder,'Виберіть факультет/інститут')]/parent::*/parent::*/parent::*/parent::*");
    private By listBox = By.xpath("//div[contains(@class,'mat-primary')]");
    private String facultyDropDownOption = "//mat-option//span[contains(text(),'%s')]";
    private WaitUtils wait;

    public ViewGroupByFacultyWindow(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 5);
    }

    private void clickFacultyDropDown() {
        wait.presenceOfElement(facultyDropDown);
        wait.visibilityOfElementByLocator(facultyDropDown);
        click(facultyDropDown);
        wait.visibilityOfWebElement(driver.findElement(listBox));
        wait.presenceOfElement(listBox);

    }

    private void clickFacultyOptions(String facultyName) {
        wait.visibilityOfWebElement(driver.findElement(By.xpath("//mat-option/span")));
        wait.waitForElementToBeClickable(driver.findElement(By.xpath("//mat-option/span")));
        List<WebElement> dropDown = driver.findElements(By.xpath("//mat-option/span"));
        for (WebElement options : dropDown) {
            if (options.getText().equals(facultyName)) {
                options.click(); // click the desired option
                break;
            }
        }

    }

    private void setFacultyDropDownOption(String facultyName) {
        clickFacultyDropDown();
        clickFacultyOptions(facultyName);

    }

    private void setFacultyAndClickShowButton(String facultyName) {
        setFacultyDropDownOption(facultyName);
        clickSubmitButton();
    }

    public GroupPage setFacultyFilterToTheTable(String facultyName) {
        String addSubjectPageWindow = driver.getWindowHandle();
        setFacultyAndClickShowButton(facultyName);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new GroupPage(driver);
    }
}
