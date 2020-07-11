package dtapi.pages;

import dtapi.components.SubjectTableContainer;
import dtapi.components.SubjectTableContainerComponent;
import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.Paginator;
import dtapi.modalsWindows.AddSubjectModalWindow;
import dtapi.modalsWindows.DeleteSubjectModalWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubjectPage extends Paginator {
    private By addNewSubjectButton = By.xpath("//span[contains(text(),'Додати предмет')]/parent::button");
    private By searchSubjectInput = By.xpath("//input[@placeholder='Пошук']");
    private SubjectTableContainer subjectTableContainer;
    public static final String PAGE_TITLE = "Предмети";
    private By pageTitle = By.xpath("//h3");
    private WaitUtils wait;

    public SubjectPage(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 10);
        initElements();
    }
    private void initElements() {

        subjectTableContainer = new SubjectTableContainer(driver);

    }
    public SubjectTableContainer getSubjectTableContainer() {
        return subjectTableContainer;
    }

    public String getPageTitleText() {
        wait.visibilityOfElement(pageTitle);
        wait.prevenseOfElement(pageTitle);
        return find(pageTitle).getText();
    }

    public AddSubjectModalWindow switchAddNewSubjectToModalWindow() {
        String shoppingCartWindow = driver.getWindowHandle();
        wait.prevenseOfElement(addNewSubjectButton);
        wait.visibilityOfElement(addNewSubjectButton);
        click(addNewSubjectButton);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new AddSubjectModalWindow(driver);
    }
    public AddSubjectModalWindow switchToEditSubjectModalWindow(String subjectName) {
        String shoppingCartWindow = driver.getWindowHandle();
        getSubjectTableContainer()
                .getSubjectContainerComponentBySubjectName(subjectName)
                .clickEditSubjectIcon();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new AddSubjectModalWindow(driver);
    }
    public DeleteSubjectModalWindow switchToDeleteSubjectModalWindow(String subjectName) {
        String shoppingCartWindow = driver.getWindowHandle();
        getSubjectTableContainer()
                .getSubjectContainerComponentBySubjectName(subjectName)
                .clickDeleteSubjectIcon();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new DeleteSubjectModalWindow(driver);
    }

    private void changeUrl() {
        String mainPage = (driver.getCurrentUrl());
        mainPage = mainPage.substring(0, 19) + "/login";
        driver.navigate().to(mainPage);
    }

    public MainPage gotoMainPage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        changeUrl();
        return new MainPage(driver);
    }


    public TestPage navigateToTestOfSubjectPage(String subjectName) {

        getSubjectTableContainer()
                .getSubjectContainerComponentBySubjectName(subjectName)
                .clickSubjectTestIcon();

        return new TestPage(driver);
    }
    public ScheduleTestingPage navigateToTestSchedulePage(String subjectName) {

        getSubjectTableContainer()
                .getSubjectContainerComponentBySubjectName(subjectName)
                .clickScheduleIcon();

        return new  ScheduleTestingPage(driver);
    }
    public boolean verifySubjectEdited(String subjectName) {

        for (SubjectTableContainerComponent component : getSubjectTableContainer().getSubjectContainerComponents()) {
            if (component.getSubjectNameText().equals(subjectName)) {
                return true;
            }
        }
        return false;
    }
    public boolean verifySubjectRemoved(String subjectName) {

        for (SubjectTableContainerComponent component : getSubjectTableContainer().getSubjectContainerComponents()) {
            if (component.getSubjectNameText().equals(subjectName)) {
                return false;
            }
        }
        return true;
    }
    public boolean verifySubjectAdded(String subjectName) {

        String  subjectsName = getSubjectTableContainer().
                getSubjectContainerComponentBySubjectName(subjectName)
                .getSubjectNameText();
        if(subjectName.equals(subjectName)){
            return true;
        }

        return false;
    }
    //check whether element is present or not
   /* public boolean isElementPresent(By by) {
        return !driver.findElements(by).isEmpty();
    }*/

}
