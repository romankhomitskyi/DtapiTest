package dtapi.elements;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.*;
import org.apache.logging.log4j.Logger;
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

    public AdminHeadrer(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 5);
    }

    public SubjectPage clickSubjectLink() {
        wait.prevenseOfElement(subjectsLink);
        wait.visibilityOfElement(subjectsLink);
        click(subjectsLink);
        wait.prevenseOfElement(By.xpath("//table//tr//td"));
        wait.visibilityOfElement(By.xpath("//table//tr//td"));
        wait.visibilityOfAllElements(driver.findElements(By.xpath("//table//tr//td")));
        return new SubjectPage(driver, log);
    }
    public SubjectPage clickSubjectLinks() {
        wait.prevenseOfElement(subjectsLink);
        wait.visibilityOfElement(subjectsLink);
        click(subjectsLink);


        return new SubjectPage(driver, log);
    }

    public SpecialityPage clickSpecialityLink() {
        wait.prevenseOfElement(specialtiesLink);
        wait.visibilityOfElement(specialtiesLink);
        click(specialtiesLink);
        wait.prevenseOfElement(By.xpath("//table//tr//td"));
        wait.visibilityOfElement(By.xpath("//table//tr//td"));
        wait.visibilityOfAllElements(driver.findElements(By.xpath("//table//tr//td")));
        return new SpecialityPage(driver, log);
    }

    public AdminHomePage clickHomeLink() {
        wait.prevenseOfElement(homeLink);
        wait.visibilityOfElement(homeLink);
        click(homeLink);
        return new AdminHomePage(driver, log);
    }

    public FacultiesPage clickFacultiesLink() {
        wait.prevenseOfElement(facultiesLink);
        wait.visibilityOfElement(facultiesLink);
        click(facultiesLink);
        wait.prevenseOfElement(By.xpath("//table//tr//td"));
        wait.visibilityOfElement(By.xpath("//table//tr//td"));
        wait.visibilityOfAllElements(driver.findElements(By.xpath("//table//tr//td")));
        return new FacultiesPage(driver, log);
    }

    public GroupPage clickGroupLink() {
        wait.visibilityOfElement(groupsLink);
        wait.prevenseOfElement(groupsLink);
        click(groupsLink);
        wait.prevenseOfElement(By.xpath("//table//tr//td"));
        wait.visibilityOfElement(By.xpath("//table//tr//td"));
        wait.visibilityOfAllElements(driver.findElements(By.xpath("//table//tr//td")));
        return new GroupPage(driver, log);
    }

    public ResultsPage clickResultsLink() {
        wait.prevenseOfElement(resultsLink);
        wait.visibilityOfElement(resultsLink);
        click(resultsLink);
        return new ResultsPage(driver, log);
    }

    public AdminsPage clickAdminsLink() {
        wait.prevenseOfElement(adminsLink);
        wait.visibilityOfElement(adminsLink);
        click(adminsLink);
        return new AdminsPage(driver, log);
    }

}
