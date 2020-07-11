package dtapi.pages;

import dtapi.components.SpecialityTableContainer;
import dtapi.components.SpecialityTableContainerComponent;
import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.Paginator;
import dtapi.modalsWindows.AddNewSpecialityModalWindow;
import dtapi.modalsWindows.DeleteSpecialityModalWindow;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpecialityPage extends Paginator {


    private By pageTitle = By.xpath("//h3");
    private WaitUtils wait;
    public static final String PAGE_TITLE = "Спеціальності";
    private By addNewSpecialityButton = By.xpath("//span[contains(text(),'Додати спеціальність')]/parent::button");
    private SpecialityTableContainer specialityTableContainer;
    public SpecialityPage(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 10);
        initElements();
    }
    private void initElements() {

        specialityTableContainer = new SpecialityTableContainer(driver);
    }
    public SpecialityTableContainer getSpecialityTableContainer() {
        return specialityTableContainer;
    }
    public String getPageTitleText() {
        wait.visibilityOfElement(pageTitle);
        wait.prevenseOfElement(pageTitle);
        return find(pageTitle).getText();
    }
    public AddNewSpecialityModalWindow switchToEditFacultyModalWindow(String specialityName) {
        String shoppingCartWindow = driver.getWindowHandle();
        getSpecialityTableContainer()
                .getContainerComponentBySpecialitiesName(specialityName)
                .clickSpecialityEditIcon();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new AddNewSpecialityModalWindow(driver);
    }
    public DeleteSpecialityModalWindow switchToDeleteSpecialityModalWindow(String specialityName) {
        String shoppingCartWindow = driver.getWindowHandle();
        getSpecialityTableContainer()
                .getContainerComponentBySpecialitiesName(specialityName)
                .clickDeleteSpecialityIcon();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new  DeleteSpecialityModalWindow(driver);
    }

    public AddNewSpecialityModalWindow switchToAddNewSpecialityModalWindow() {
        String shoppingCartWindow = driver.getWindowHandle();
        wait.visibilityOfElement(addNewSpecialityButton);
        wait.prevenseOfElement(addNewSpecialityButton);
        click(addNewSpecialityButton);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new AddNewSpecialityModalWindow(driver);
    }
    public boolean verifySpecialityRemoved(String specialityName) {

        for (SpecialityTableContainerComponent component : getSpecialityTableContainer().getSpecialityContainerComponents()) {
            if (component.getSpecialityNameText().equals(specialityName)) {
                return false;
            }
        }
        return true;
    }

    public boolean verifySpecialityEdited(String specialityName) {

        for (SpecialityTableContainerComponent component : getSpecialityTableContainer().getSpecialityContainerComponents()) {
            System.out.println(component.getSpecialityNameText());
            if (component.getSpecialityNameText().equals(specialityName)) {
                return true;
            }
        }
        return false;
    }
    public boolean verifySpecialityAdded(String specialityName) {

        String speciality = getSpecialityTableContainer().
                getContainerComponentBySpecialitiesName(specialityName)
                .getSpecialityNameText();
        if(specialityName.equals(speciality)){
            return true;
        }

        return false;
    }




}
