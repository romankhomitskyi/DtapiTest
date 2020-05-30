package dtapi.pages;

import dtapi.components.ResultsTableContainer;
import dtapi.components.ResultsTableContainerComponent;
import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.Paginator;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ResultsPage extends Paginator {
    private By resultsPageTitle = By.xpath("//h3");
    private WaitUtils wait;
    private By groupDropDown = By.xpath("//mat-select[contains(@class,'mat-select') and contains(@placeholder,'Виберіть групу')]");
    private By testDropDown = By.xpath("//mat-select[contains(@class,'mat-select') and contains(@placeholder,'Виберіть тест')]");
    private By showResultsButton = By.xpath("//button[@type='submit']");
    public static final String PAGE_TITLE = "Результати тестувань";
    private ResultsTableContainer resultsTableContainer ;

    public ResultsPage(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 10);
        initElements();
    }
    private void initElements() {

        resultsTableContainer  = new ResultsTableContainer (driver, log);

    }

    public boolean verifyStudentResults(String result) {
        clickLastButton();
        sleep(500);

        List<Integer> id = new ArrayList<>();
            for (ResultsTableContainerComponent component : getResultsTableContainer().getResultsContainerComponents()) {
               id.add(Integer.parseInt(component.getStudentIdText()));
            }
        Collections.max(id);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String strDate = formatter.format(date);
        String  results = getResultsTableContainer()
                .getStudentResultContainerComponentByStudentId(Collections.max(id).toString())
                .getStudentResultText();
        if(results.contains(result)){
            System.out.println(" Результат мого коду" +results );
            System.out.println(" Результат тесту" +result );
            return true;
        }

        return false;
    }
    public ResultsTableContainer  getResultsTableContainer () {
        return resultsTableContainer ;
    }
    public String getResultsPageTitleText() {
        wait.visibilityOfElement(resultsPageTitle);
        wait.prevenseOfElement(resultsPageTitle);
        return find(resultsPageTitle).getText();
    }
    private void clickGroupDropDown() {
        wait.visibilityOfElement2(driver.findElement(groupDropDown));
        wait.prevenseOfElement(groupDropDown);
        wait.waitForElementClickability(groupDropDown);
        click(groupDropDown);
        wait.prevenseOfElement(By.xpath("//mat-option/span"));
    }


    private void clickGroupOptions(String groupName) {

        wait.prevenseOfElement(By.xpath("//mat-option/span"));
        List<WebElement> dropDown = driver.findElements(By.xpath("//mat-option/span"));
        for (WebElement options : dropDown) {
            if (options.getText().equals(groupName)) {
                wait.waitForElementClickability2(options);
                options.click();
                wait.invisibilityOfEmelement2(options);
                break;
            }
        }

    }

    private void setGroupDropDownOption(String groupName) {
        clickGroupDropDown();
        clickGroupOptions(groupName);

    }
    private void clickTestNameDropDown() {
        wait.visibilityOfElement2(driver.findElement(testDropDown));
        wait.prevenseOfElement(testDropDown);
        wait.waitForElementClickability(testDropDown);
        click(testDropDown);
        wait.prevenseOfElement(By.xpath("//mat-option/span"));

    }


    private void clickTestOptions(String testName) {


        List<WebElement> dropDown = driver.findElements(By.xpath("//mat-option/span"));
        for (WebElement options : dropDown) {
            if (options.getText().equals(testName)) {
                wait.waitForElementClickability2(options);
                options.click();
                wait.invisibilityOfEmelement2(options);
                break;
            }
        }

    }

    private void setTestDropDownOption(String testName) {
        clickTestNameDropDown();
        clickTestOptions(testName);

    }
    private void setGroupAndTestDropDown(String groupName, String testName) {

        setGroupDropDownOption(groupName);
        setTestDropDownOption(testName);


    }

    public ResultsPage showTestResults(String groupName, String testName) {
        setGroupAndTestDropDown(groupName, testName);
        clickSubmitButton();
        return new ResultsPage(driver,log);
    }
    private void clickSubmitButton() {
        wait.visibilityOfElement(showResultsButton);
        wait.prevenseOfElement(showResultsButton);
        click(showResultsButton);
        wait.prevenseOfElement(By.xpath("//table//tr//td"));
        wait.visibilityOfElement(By.xpath("//table//tr//td"));
        wait.visibilityOfAllElements(driver.findElements(By.xpath("//table//tr//td")));
    }
    protected void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
