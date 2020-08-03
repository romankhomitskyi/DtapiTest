package dtapi.pages;

import dtapi.components.FacultyTableContainer;
import dtapi.components.FacultyTableContainerComponent;
import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.AdminHeadrer;
import dtapi.modalsWindows.AddFacultiesModalWindow;
import dtapi.modalsWindows.DeleteFacultiesModalWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacultiesPage extends AdminHeadrer {

    private WebElement addNewFacultiesButton;
    private WebElement facultiesPageTitle;
    private WaitUtils wait;
    private FacultyTableContainer facultyTableContainer;
    public static final String PAGE_TITLE = "Факультети";

    public FacultiesPage(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 10);
        initElements();
    }

    private void initElements() {
        facultyTableContainer = new FacultyTableContainer(driver);
        addNewFacultiesButton = driver.findElement(By.xpath("//span[contains(text(),'Додати факультет')]/parent::button"));
        facultiesPageTitle = driver.findElement(By.xpath("//h3"));
    }

    private FacultyTableContainer getFacultyTableContainer() {
        return facultyTableContainer;
    }

    public String getFacultiesPageTitleText() {
        wait.visibilityOfWebElement(facultiesPageTitle);
        return facultiesPageTitle.getText();
    }
    public AddFacultiesModalWindow switchToEditFacultyModalWindow(String facultyName) {
        String shoppingCartWindow = driver.getWindowHandle();
        getFacultyTableContainer()
                .getContainerComponentByFacultiesName(facultyName)
                .clickFacultyEditIcon();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        return new AddFacultiesModalWindow(driver);
    }
    public DeleteFacultiesModalWindow switchToDeleteFacultiesModalWindow(String facultyName) {
        String shoppingCartWindow = driver.getWindowHandle();
        getFacultyTableContainer()
                .getContainerComponentByFacultiesName(facultyName)
                .clickDeleteFacultyIcon();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new  DeleteFacultiesModalWindow(driver);
    }



    public AddFacultiesModalWindow switchToAddNewFacultiesModalWindow() {
        String shoppingCartWindow = driver.getWindowHandle();

        wait.waitForElementToBeClickable(addNewFacultiesButton);
        addNewFacultiesButton.click();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new AddFacultiesModalWindow(driver);
    }


    public boolean verifyFacultyRemoved(String  facultyName) {

        for (FacultyTableContainerComponent component : getFacultyTableContainer().getFacultyContainerComponents()) {
            if (component.getFacultyNameText().equals(facultyName)) {
                return false;

            }
        }
        return true;
    }
    public boolean verifyFacultyEdited(String facultyName) {

        for (FacultyTableContainerComponent component : getFacultyTableContainer().getFacultyContainerComponents()) {
            if (component.getFacultyNameText().equals(facultyName)) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyFacultyAdded(String facultyName) {

        String faculty = getFacultyTableContainer().
                getContainerComponentByFacultiesName(facultyName)
                .getFacultyNameText();
        if(facultyName.equals(faculty)){
            return true;
        }

        return false;
    }
}
