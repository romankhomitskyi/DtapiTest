package dtapi.pages;

import dtapi.components.ResultsTableContainer;
import dtapi.components.ResultsTableContainerComponent;
import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.AdminHeadrer;
import dtapi.elements.Paginator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ResultsPage extends AdminHeadrer {
    private By resultsPageTitle = By.xpath("//h3");
    private Paginator paginator;//FIXME
    private WaitUtils wait;
    private By groupDropDown = By.xpath("//mat-select[contains(@class,'mat-select') and contains(@placeholder,'Виберіть групу')]");
    private By testDropDown = By.xpath("//mat-select[contains(@class,'mat-select') and contains(@placeholder,'Виберіть тест')]");
    private By showResultsButton = By.xpath("//button[@type='submit']");
    public static final String PAGE_TITLE = "Результати тестувань";
    private ResultsTableContainer resultsTableContainer ;

    public ResultsPage(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 10);
        initElements();
    }
    private void initElements() {
        paginator = new Paginator(driver);
        resultsTableContainer  = new ResultsTableContainer (driver);

    }

    public boolean verifyStudentResults(String result) {
        paginator.clickLastButton();//FIXME
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

            return true;
        }

        return false;
    }
    public ResultsTableContainer  getResultsTableContainer () {
        return resultsTableContainer ;
    }
    public String getResultsPageTitleText() {
        wait.visibilityOfElementByLocator(resultsPageTitle);
        wait.presenceOfElement(resultsPageTitle);
        return find(resultsPageTitle).getText();
    }
    private void clickGroupDropDown() {
        wait.visibilityOfWebElement(driver.findElement(groupDropDown));
        wait.presenceOfElement(groupDropDown);
        wait.waitForElementToBeClickableByLocator(groupDropDown);
        click(groupDropDown);
        wait.presenceOfElement(By.xpath("//mat-option/span"));
    }


    private void clickGroupOptions(String groupName) {

        wait.presenceOfElement(By.xpath("//mat-option/span"));
        List<WebElement> dropDown = driver.findElements(By.xpath("//mat-option/span"));
        for (WebElement options : dropDown) {
            if (options.getText().equals(groupName)) {
                wait.waitForElementToBeClickable(options);
                options.click();
                wait.invisibilityOfElement(options);
                break;
            }
        }

    }

    private void setGroupDropDownOption(String groupName) {
        clickGroupDropDown();
        clickGroupOptions(groupName);

    }
    private void clickTestNameDropDown() {
        wait.visibilityOfWebElement(driver.findElement(testDropDown));
        wait.presenceOfElement(testDropDown);
        wait.waitForElementToBeClickableByLocator(testDropDown);
        click(testDropDown);
        wait.presenceOfElement(By.xpath("//mat-option/span"));

    }


    private void clickTestOptions(String testName) {


        List<WebElement> dropDown = driver.findElements(By.xpath("//mat-option/span"));
        for (WebElement options : dropDown) {
            if (options.getText().equals(testName)) {
                wait.waitForElementToBeClickable(options);
                options.click();
                wait.invisibilityOfElement(options);
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
        return new ResultsPage(driver);
    }
    private void clickSubmitButton() {
        wait.visibilityOfElementByLocator(showResultsButton);
        wait.presenceOfElement(showResultsButton);
        click(showResultsButton);
        wait.presenceOfElement(By.xpath("//table//tr//td"));
        wait.visibilityOfElementByLocator(By.xpath("//table//tr//td"));
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
