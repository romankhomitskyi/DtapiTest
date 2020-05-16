package dtapi.pages;

import dtapi.components.TestOfSubjectTableContainer;
import dtapi.components.TestOfSubjectTableContainerComponent;
import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.Paginator;
import dtapi.modalsWindows.AddTestModalWindow;
import dtapi.modalsWindows.DeleteTestModalWindow;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestPage extends Paginator {
    private By headerTestPage = By.xpath("//h3");
    private By addNewTestButton = By.xpath("//span[contains(text(),'Додати тест')]/parent::button");
    private By dropDown = By.xpath("//mat-select[@id='mat-select-1']");
    private String dropDownOption = "//span[@class ='mat-option-text' and text()='%s']";
    private By firstOption = By.xpath("//mat-select[@id='mat-select-1']//span//following-sibling::span");
    private WaitUtils wait;
    private TestOfSubjectTableContainer testOfSubjectTableContainer;

    public TestPage(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver,10);
        initElements();
    }
    private void initElements() {

        testOfSubjectTableContainer = new TestOfSubjectTableContainer(driver, log);

    }
    public TestOfSubjectTableContainer getTestOfSubjectTableContainer() {
        return testOfSubjectTableContainer;
    }

    public SettingsTestPage navigateToSettingsTestPage(String testName) {
        getTestOfSubjectTableContainer()
                .getTestContainerComponentByTestName(testName)
                .clickTestParamIcon();


        return new SettingsTestPage(driver, log);
    }
    public QuestionPage navigateToQuestionPage(String testName) {
        getTestOfSubjectTableContainer()
                .getTestContainerComponentByTestName(testName)
                .clickQuestionIcon();


        return new QuestionPage(driver, log);
    }
    public AddTestModalWindow switchToEditTestModalWindow(String testName) {
        String shoppingCartWindow = driver.getWindowHandle();
        getTestOfSubjectTableContainer()
                .getTestContainerComponentByTestName(testName)
                .clickEditTestIcon();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new AddTestModalWindow(driver, log);
    }
    public DeleteTestModalWindow switchToDeleteTestModalWindow(String testName) {
        String shoppingCartWindow = driver.getWindowHandle();
        getTestOfSubjectTableContainer()
                .getTestContainerComponentByTestName(testName)
                .clickDeleteTestIcon();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new DeleteTestModalWindow(driver, log);
    }

    public AddTestModalWindow switchToAddTestModalWindow() {
        String shoppingCartWindow = driver.getWindowHandle();
        wait.visibilityOfElement(addNewTestButton);
        wait.prevenseOfElement(addNewTestButton);
        click(addNewTestButton);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new AddTestModalWindow(driver, log);
    }

    public boolean verifyTestEdited(String testName) {

        for (TestOfSubjectTableContainerComponent component : getTestOfSubjectTableContainer().getTestOfSubjectContainerComponents()) {
            if (component.getTestNameText().equals(testName)) {
                return true;
            }
        }
        return false;
    }
    public boolean verifyTestAdded(String testName) {

        String  testsName = getTestOfSubjectTableContainer().
                getTestContainerComponentByTestName(testName)
                .getTestNameText();
        if(testName.equals(testsName)){
            return true;
        }

        return false;
    }




    public String getTestPageHeaderText() {
        wait.prevenseOfElement(headerTestPage);
        wait.visibilityOfElement(headerTestPage);
        return find(headerTestPage).getText();
    }
    public Boolean verifyTestPageHeaderText(String subjectName) {
        return getTestPageHeaderText().contains(subjectName);
    }
    public SubjectPage backToSubjectPage() {
        sleep(1000);
        driver.navigate().back();
        return new SubjectPage(driver,log);
    }
    protected void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* private void clickDropDownOnTestPage() {
        click(dropDown);

    }

    private void clickOptionsOnTestPage(String option) {
        click(By.xpath(String.format(dropDownOption, option)));
    }

    public void setDropDownOptionOnTestPage(String option) {
        clickDropDownOnTestPage();
        clickOptionsOnTestPage(option);
    }

    private String getFirstOptionTextOnTestPage() {
        return find(firstOption).getText();
    }

    public boolean isCorrectTestDispalayed(String option) {
        return getFirstOptionTextOnTestPage().contains(option);
    }*/
}
