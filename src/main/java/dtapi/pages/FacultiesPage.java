package dtapi.pages;

import dtapi.components.FacultyTableContainer;
import dtapi.components.FacultyTableContainerComponent;
import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.Paginator;
import dtapi.modalsWindows.AddFacultiesModalWindow;
import dtapi.modalsWindows.DeleteFacultiesModalWindow;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacultiesPage extends Paginator {
    private By addNewFacultiesButton = By.xpath("//span[contains(text(),'Додати факультет')]/parent::button");
    private By searchFacultiesInput = By.xpath("//div[@class='mat-form-field-infix']/input");
    private By facultiesPageTitle = By.xpath("//h3");
    private WaitUtils wait;
    private FacultyTableContainer facultyTableContainer;
    public static final String PAGE_TITLE = "Факультети";

    public FacultiesPage(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 10);
        initElements();
    }
    private void initElements() {

        facultyTableContainer = new FacultyTableContainer(driver, log);
    }
    public FacultyTableContainer getFacultyTableContainer() {
        return facultyTableContainer;
    }

    public String getFacultiesPageTitleText() {
        wait.visibilityOfElement(facultiesPageTitle);
        wait.prevenseOfElement(facultiesPageTitle);
        return find(facultiesPageTitle).getText();
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

        return new AddFacultiesModalWindow(driver, log);
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
        return new  DeleteFacultiesModalWindow(driver, log);
    }

    private void clickSearchFacultiesInput() {
        find(searchFacultiesInput).click();
    }

    private void clearSearchFacultiesInput() {
        find(searchFacultiesInput).clear();
    }

    private void setSearchFacultiesInput(String name) {
        type(name, searchFacultiesInput);
    }

    public void fillSearchFaculties(String name) {
        clickSearchFacultiesInput();
        clearSearchFacultiesInput();
        setSearchFacultiesInput(name);
    }

    public AddFacultiesModalWindow switchToAddNewFacultiesModalWindow() {
        String shoppingCartWindow = driver.getWindowHandle();
        wait.visibilityOfElement(addNewFacultiesButton);
        wait.prevenseOfElement(addNewFacultiesButton);
        click(addNewFacultiesButton);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new AddFacultiesModalWindow(driver, log);
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
