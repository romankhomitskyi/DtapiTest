package dtapi.elements;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminHeadrer extends BaseHeader {
    protected By homeLink = By.xpath("//a[@routerlink='dashboard']");
    protected By facultiesLink = By.xpath("//a[@routerlink='faculties']");
    protected By groupsLink = By.xpath("//a[@routerlink='group']");
    protected By specialtiesLink = By.xpath("//a[@routerlink='speciality']");
    protected By subjectsLink = By.xpath("//a[@routerlink='subjects']");
    protected By resultsLink = By.xpath("//a[@routerlink='results']");
    protected By adminsLink = By.xpath("//a[@routerlink='admin-user']");
    private WaitUtils wait;

    public AdminHeadrer(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 15);
    }

    public SubjectPage clickSubjectLink() {
        wait.waitForElementToBeClickableByLocator(subjectsLink);
        wait.presenceOfElement(subjectsLink);
        wait.visibilityOfElementByLocator(subjectsLink);
        click(subjectsLink);
        wait.presenceOfElement(By.xpath("//table//tr//td"));
        wait.visibilityOfElementByLocator(By.xpath("//table//tr//td"));
        wait.visibilityOfAllElements(driver.findElements(By.xpath("//table//tr//td")));
        return new SubjectPage(driver);
    }
    public SubjectPage clickSubjectLinks() {
        wait.presenceOfElement(subjectsLink);
        wait.visibilityOfElementByLocator(subjectsLink);
        click(subjectsLink);


        return new SubjectPage(driver);
    }

    public SpecialityPage clickSpecialityLink() {
        wait.presenceOfElement(specialtiesLink);
        wait.visibilityOfElementByLocator(specialtiesLink);
        click(specialtiesLink);
        wait.presenceOfElement(By.xpath("//table//tr//td"));
        wait.visibilityOfElementByLocator(By.xpath("//table//tr//td"));
        wait.visibilityOfAllElements(driver.findElements(By.xpath("//table//tr//td")));
        return new SpecialityPage(driver);
    }

    public AdminHomePage clickHomeLink() {
        wait.presenceOfElement(homeLink);
        wait.visibilityOfElementByLocator(homeLink);
        click(homeLink);
        return new AdminHomePage(driver);
    }

    public FacultiesPage clickFacultiesLink() {
        wait.presenceOfElement(facultiesLink);
        wait.visibilityOfElementByLocator(facultiesLink);
        click(facultiesLink);
        wait.presenceOfElement(By.xpath("//table//tr//td"));
        wait.visibilityOfElementByLocator(By.xpath("//table//tr//td"));
        wait.visibilityOfAllElements(driver.findElements(By.xpath("//table//tr//td")));
        return new FacultiesPage(driver);
    }

    public GroupPage clickGroupLink() {
        wait.visibilityOfElementByLocator(groupsLink);
        wait.presenceOfElement(groupsLink);
        click(groupsLink);
        wait.presenceOfElement(By.xpath("//table//tr//td"));
        wait.visibilityOfElementByLocator(By.xpath("//table//tr//td"));
        wait.visibilityOfAllElements(driver.findElements(By.xpath("//table//tr//td")));
        return new GroupPage(driver);
    }

    public ResultsPage clickResultsLink() {
        wait.presenceOfElement(resultsLink);
        wait.visibilityOfElementByLocator(resultsLink);
        click(resultsLink);
        return new ResultsPage(driver);
    }

    public AdminsPage clickAdminsLink() {
        wait.presenceOfElement(adminsLink);
        wait.visibilityOfElementByLocator(adminsLink);
        click(adminsLink);
        return new AdminsPage(driver);
    }

}
