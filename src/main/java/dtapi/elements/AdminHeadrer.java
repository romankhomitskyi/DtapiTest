package dtapi.elements;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminHeadrer extends BaseHeader {
    private WebElement homeLink;
    private WebElement  facultiesLink ;
    private WebElement  groupsLink;
    private WebElement  specialtiesLink ;
    private WebElement  subjectsLink ;
    private WebElement  resultsLink;
    private WebElement  adminsLink;
    private WaitUtils wait;

    public AdminHeadrer(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 15);
        initElements();
    }
    private void initElements(){
        homeLink = driver.findElement(By.xpath("//a[@routerlink='dashboard']"));
        facultiesLink = driver.findElement(By.xpath("//a[@routerlink='faculties']"));
        groupsLink =  driver.findElement(By.xpath("//a[@routerlink='group']"));
        specialtiesLink = driver.findElement(By.xpath("//a[@routerlink='speciality']"));
        subjectsLink = driver.findElement(By.xpath("//a[@routerlink='subjects']"));
        resultsLink = driver.findElement(By.xpath("//a[@routerlink='results']"));
        adminsLink = driver.findElement(By.xpath("//a[@routerlink='admin-user']"));

    }

    public SubjectPage clickSubjectLink() {
        wait.waitForElementToBeClickable(subjectsLink);
        subjectsLink.click();
        return new SubjectPage(driver);
    }


    public SpecialityPage clickSpecialityLink() {
        wait.waitForElementToBeClickable(specialtiesLink);
        specialtiesLink.click();

        return new SpecialityPage(driver);
    }

    public AdminHomePage clickHomeLink() {
        wait.waitForElementToBeClickable(homeLink);
        homeLink.click();
        return new AdminHomePage(driver);
    }

    public FacultiesPage clickFacultiesLink() {
        wait.waitForElementToBeClickable(facultiesLink);
        facultiesLink.click();

        return new FacultiesPage(driver);
    }

    public GroupPage clickGroupLink() {
        wait.waitForElementToBeClickable(groupsLink);
        groupsLink.click();
        return new GroupPage(driver);
    }

    public ResultsPage clickResultsLink() {
        wait.waitForElementToBeClickable(resultsLink);
        resultsLink.click();
        return new ResultsPage(driver);
    }

    public AdminsPage clickAdminsLink() {
        wait.waitForElementToBeClickable(adminsLink);
        adminsLink.click();
        return new AdminsPage(driver);
    }


     /*wait.presenceOfElement(By.xpath("//table//tr//td"));
        wait.visibilityOfElementByLocator(By.xpath("//table//tr//td"));
        wait.visibilityOfAllElements(driver.findElements(By.xpath("//table//tr//td")));*/
}
