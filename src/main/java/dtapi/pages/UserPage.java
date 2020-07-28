package dtapi.pages;

import dtapi.components.StudentTestTableContainer;
import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.BaseHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPage extends BaseHeader {

    private String studentUrl = "https://travisdtapi.firebaseapp.com/student/home";
    private By headerTestPage = By.xpath("//section[@class='test-details']/h3");
    private By logOutButton = By.xpath("//button[contains(@class,'mat-menu-trigger')]");
    private By logOutButton2 = By.xpath("//button[contains(text(),'Вийти')]");





    public String getStudentUrl() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.urlMatches(studentUrl));
        return studentUrl;
    }

    private StudentTestTableContainer studentTestTableContainer;
    private WaitUtils wait;

    public UserPage(WebDriver driver) {
        super(driver);
        initElements();
        wait = new WaitUtils(driver,10);

    }
    private void initElements() {

        studentTestTableContainer = new StudentTestTableContainer(driver);

    }
    public StudentTestTableContainer getStudentTestTableContainer() {
        return studentTestTableContainer;
    }
    public TakingTestPage navigateToQuestionPage(String testName) {
        getStudentTestTableContainer()
                .getStudentTestTableContainerComponentsByTestName(testName)
                .clickStartTestIcon();

        return new TakingTestPage(driver);
    }

 public MainPage logOut(){
        wait.waitForElementToBeClickableByLocator(logOutButton);
        driver.findElement(logOutButton).click();
     wait.waitForElementToBeClickableByLocator(logOutButton2);
        driver.findElement(logOutButton2).click();

     return new MainPage(driver);
 }
}





