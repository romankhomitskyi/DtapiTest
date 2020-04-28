package dtapi.pages;

import dtapi.components.GroupTableContainer;
import dtapi.components.GroupTableContainerComponent;
import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.Paginator;
import dtapi.modalsWindows.AddNewGroupModalWindow;
import dtapi.modalsWindows.DeleteGroupModalWindow;
import dtapi.modalsWindows.ViewGroupByFacultyWindow;
import dtapi.modalsWindows.ViewGroupBySpecialityWindow;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupPage extends Paginator {
    private By groupsPageTitle = By.xpath("//h3");
    private By addNewGroupButton = By.xpath("//span[contains(text(),'Додати групу')]/parent::button");
    private By viewGroupBySpecialityButton = By.xpath("//span[contains(text(),'Перегляд груп за спеціальністю')]/parent::button");
    private By viewGroupByFacultyButton = By.xpath("//span[contains(text(),'Перегляд груп по інституту')]/parent::button");
    private By searchGroupInput = By.xpath("//input");
    private WaitUtils wait;
    public static final String PAGE_TITLE = "Групи і студенти";
    public GroupPage(WebDriver driver, Logger log) {
        super(driver, log);
        initElements();
        wait = new WaitUtils(driver, 10);
    }
    public String getGroupPageTitleText() {
        wait.visibilityOfElement(groupsPageTitle);
        wait.prevenseOfElement(groupsPageTitle);
        return find(groupsPageTitle).getText();
    }

    private GroupTableContainer groupTableContainer;


    private void initElements() {

        groupTableContainer = new GroupTableContainer(driver, log);
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
        return new AddNewGroupModalWindow(driver, log);
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
        return new StudentPage(driver, log);
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
        return new  DeleteGroupModalWindow(driver, log);
    }
    public AddNewGroupModalWindow switchToAddNewGroupModalWindow() {
        String shoppingCartWindow = driver.getWindowHandle();
        wait.prevenseOfElement(addNewGroupButton);
        wait.visibilityOfElement(addNewGroupButton);
        click(addNewGroupButton);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                wait.waitForPageLoad();
                driver.switchTo().window(windowHandle);
                wait.waitForPageLoad();
            }
        }
        return new AddNewGroupModalWindow(driver, log);
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
        wait.visibilityOfElement(searchGroupInput);
        wait.prevenseOfElement(searchGroupInput);
        click(searchGroupInput);
    }

    private void clearSearchGroupInput() {
        wait.visibilityOfElement(searchGroupInput);
        wait.prevenseOfElement(searchGroupInput);
        find(searchGroupInput).clear();
    }

    private void setSearchGroupInput(String groupId) {
        wait.visibilityOfElement(searchGroupInput);
        wait.prevenseOfElement(searchGroupInput);
        type(groupId, searchGroupInput);
    }

    public GroupPage fillSearchGroup(String groupId) {
        clickSearchGroupInput();
        clearSearchGroupInput();
        setSearchGroupInput(groupId);
        return new GroupPage(driver, log);
    }

    public ViewGroupBySpecialityWindow switchToViewGroupBySpecialityWindow() {
        String shoppingCartWindow = driver.getWindowHandle();
        wait.visibilityOfElement(viewGroupBySpecialityButton);
        wait.prevenseOfElement(viewGroupBySpecialityButton);
        click(viewGroupBySpecialityButton);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new ViewGroupBySpecialityWindow(driver, log);
    }

    public ViewGroupByFacultyWindow switchToViewGroupByFacultyWindow() {
        String shoppingCartWindow = driver.getWindowHandle();
        wait.visibilityOfElement(viewGroupByFacultyButton);
        wait.prevenseOfElement(viewGroupByFacultyButton);
        click(viewGroupByFacultyButton);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new ViewGroupByFacultyWindow(driver, log);
    }




    public GroupPage refreshPage() {
        sleep(1000);
        wait.prevenseOfElement(groupsPageTitle);
        wait.visibilityOfElement(groupsPageTitle);
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
    /*
     *//**
     * finds container component by product from param and clicks remove button
     *
     * @param product
     * @return new ShoppingCartPage after removing a component
     *//*
    public ShoppingCartPage removeComponentByProduct(Product product) {
        this.getShoppingCartProductsContainer()
                .getContainerComponentByProduct(product)
                .clickRemoveButton();
        waitUtils.setImplicitWait(0);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.stalenessOf(this.getShoppingCartProductsContainer()
                        .getContainerComponentByProduct(product).getProductName()));
        waitUtils.setImplicitWait(10);
        return new ShoppingCartPage(driver);
    }



    *//**
     * goes through container components list and checks if product form param is not present in it
     *
     * @param expectedRemovedItem product expected to be removed
     * @return false if product is present in list, true if not present
     *//*
    public boolean verifyProductRemoved(Product expectedRemovedItem) {
        for (ShoppingCartContainerComponent component : getShoppingCartProductsContainer().getContainerComponents()) {
            if (component.getProductNameText().equals(expectedRemovedItem.getName())) {
                return false;
            }
        }
        return true;
    }*/

}
