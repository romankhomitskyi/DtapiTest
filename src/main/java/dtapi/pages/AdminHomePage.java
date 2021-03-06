package dtapi.pages;

import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.AdminHeadrer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminHomePage extends AdminHeadrer {
    private String adminUrl = "https://travisdtapi.firebaseapp.com/admin/dashboard";
    private By facultiesIcon = By.xpath("//mat-icon[contains(text(),'school')]");
    private By groupIcon = By.xpath("//mat-icon[contains(text(),'group')]");
    private By specialityIcon = By.xpath("//mat-icon[contains(text(),'library_books')]");
    private By subjectIcon = By.xpath("//mat-icon[contains(text(),'local_library')]");
    private By studentIcon = By.xpath("//mat-icon[contains(text(),'assignment_ind')]");
    private By adminIcon = By.xpath("//mat-icon[contains(text(),'person')]");
    private By resultsIcon = By.xpath("//mat-icon[contains(text(),'assessment')]");
    private By homePageTitle = By.xpath("//h3");
    public static final String PAGE_TITLE = "Головна";
    private WaitUtils wait;


    public AdminHomePage(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 10);
    }

    public String getAdminPageTitleText() {
        wait.visibilityOfElementByLocator(homePageTitle);
        wait.presenceOfElement(homePageTitle);
        return find(homePageTitle).getText();
    }

    public String getAdminUrl() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.urlMatches(adminUrl));
        return adminUrl;
    }

    public SubjectPage clickSubjectIcon() {

        wait.visibilityOfElementByLocator(subjectIcon);
        wait.presenceOfElement(subjectIcon);
        click(subjectIcon);
        wait.presenceOfElement(By.xpath("//table//tr//td"));
        wait.visibilityOfElementByLocator(By.xpath("//table//tr//td"));
        wait.visibilityOfAllElements(driver.findElements(By.xpath("//table//tr//td")));
        return new SubjectPage(driver);
    }
}
