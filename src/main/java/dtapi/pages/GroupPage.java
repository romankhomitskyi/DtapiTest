package dtapi.pages;

import dtapi.components.GroupTableContainer;
import dtapi.components.GroupTableContainerComponent;
import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.AdminHeadrer;
import dtapi.elements.Paginator;
import dtapi.modalsWindows.AddNewGroupModalWindow;
import dtapi.modalsWindows.DeleteGroupModalWindow;
import dtapi.modalsWindows.ViewGroupByFacultyWindow;
import dtapi.modalsWindows.ViewGroupBySpecialityWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupPage extends AdminHeadrer {

    private By groupsPageTitle = By.xpath("//h3");
    private By addNewGroupButton = By.xpath("//span[contains(text(),'Додати групу')]/parent::button");
    private By viewGroupBySpecialityButton = By.xpath("//span[contains(text(),'Перегляд груп за спеціальністю')]/parent::button");
    private By viewGroupByFacultyButton = By.xpath("//span[contains(text(),'Перегляд груп по інституту')]/parent::button");
    private By searchGroupInput = By.xpath("//input");
    private WaitUtils wait;
    public static final String PAGE_TITLE = "Групи";

    public GroupPage(WebDriver driver) {
        super(driver);
        initElements();
        wait = new WaitUtils(driver, 10);
    }
    public String getGroupPageTitleText() {
        wait.visibilityOfElementByLocator(groupsPageTitle);
        wait.presenceOfElement(groupsPageTitle);
        return find(groupsPageTitle).getText();
    }

    private GroupTableContainer groupTableContainer;


    private void initElements() {

        groupTableContainer = new GroupTableContainer(driver);
    }

    public GroupTableContainer getGroupTableContainer() {
        return groupTableContainer;
    }


    public AddNewGroupModalWindow switchToEditGroupModalWindow(String groupCode) {
        String shoppingCartWindow = driver.getWindowHandle();
        getGroupTableContainer().
                getContainerComponentByGroupCode(groupCode).clickEditGroupIcon();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new AddNewGroupModalWindow(driver);
    }
    public StudentPage findNewGroupAndClickStudentInGroupIcon(String groupCode) {
        String shoppingCartWindow = driver.getWindowHandle();
        getGroupTableContainer().
                getContainerComponentByGroupCode(groupCode).clickStudentInGroupIcon();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new StudentPage(driver);
    }
    public DeleteGroupModalWindow switchToDeleteGroupModalWindow(String groupCode) {
        String shoppingCartWindow = driver.getWindowHandle();
        getGroupTableContainer().
                getContainerComponentByGroupCode(groupCode).clickDeleteGroupIcon();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new  DeleteGroupModalWindow(driver);
    }
    public AddNewGroupModalWindow switchToAddNewGroupModalWindow() {
        String shoppingCartWindow = driver.getWindowHandle();
        wait.presenceOfElement(addNewGroupButton);
        wait.visibilityOfElementByLocator(addNewGroupButton);
        click(addNewGroupButton);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);

            }
        }
        return new AddNewGroupModalWindow(driver);
    }


    public boolean verifyGroupRemoved(String  groupCode) {
        for (GroupTableContainerComponent component : getGroupTableContainer().getContainerComponents()) {
            if (component.getGroupCodeText().equals(groupCode)) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyGroupEdited(String groupCode) {

        for (GroupTableContainerComponent component : getGroupTableContainer().getContainerComponents()) {
            if (component.getGroupCodeText().equals(groupCode)) {
                return true;
            }
        }
        return false;
    }
    public boolean verifyCorrectnessOfSpecialityFilter(String speciality) {

        for (GroupTableContainerComponent component : getGroupTableContainer().getContainerComponents()) {
            if (component.getGroupSpecilityText().equals(speciality)) {
                return true;
            }
        }
        return false;
    }
    public boolean verifyCorrectnessOfFacultyFilter(String faculty) {

        for (GroupTableContainerComponent component : getGroupTableContainer().getContainerComponents()) {
            if (component.getGroupFacultyText().equals(faculty)) {
                return true;
            }
        }
        return false;
    }
    public boolean verifyGroupAdded(String groupCode) {

        String  code = getGroupTableContainer().
                getContainerComponentByGroupCode(groupCode)
                .getGroupCodeText();
        if(groupCode.equals(code)){
                return true;
            }

        return false;
    }
    private void clickSearchGroupInput() {
        wait.visibilityOfElementByLocator(searchGroupInput);
        wait.presenceOfElement(searchGroupInput);
        click(searchGroupInput);
    }

    private void clearSearchGroupInput() {
        wait.visibilityOfElementByLocator(searchGroupInput);
        wait.presenceOfElement(searchGroupInput);
        find(searchGroupInput).clear();
    }

    private void setSearchGroupInput(String groupId) {
        wait.visibilityOfElementByLocator(searchGroupInput);
        wait.presenceOfElement(searchGroupInput);
        type(groupId, searchGroupInput);
    }

    public GroupPage fillSearchGroup(String groupId) {
        clickSearchGroupInput();
        clearSearchGroupInput();
        setSearchGroupInput(groupId);
        return new GroupPage(driver);
    }

    public ViewGroupBySpecialityWindow switchToViewGroupBySpecialityWindow() {
        String shoppingCartWindow = driver.getWindowHandle();
        wait.visibilityOfElementByLocator(viewGroupBySpecialityButton);
        wait.presenceOfElement(viewGroupBySpecialityButton);
        click(viewGroupBySpecialityButton);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new ViewGroupBySpecialityWindow(driver);
    }

    public ViewGroupByFacultyWindow switchToViewGroupByFacultyWindow() {
        String shoppingCartWindow = driver.getWindowHandle();
        wait.visibilityOfElementByLocator(viewGroupByFacultyButton);
        wait.presenceOfElement(viewGroupByFacultyButton);
        click(viewGroupByFacultyButton);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new ViewGroupByFacultyWindow(driver);
    }




    public GroupPage refreshPage() {
        sleep(1000);
        wait.presenceOfElement(groupsPageTitle);
        wait.visibilityOfElementByLocator(groupsPageTitle);
        driver.navigate().refresh();


        return this;
    }
    protected void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
