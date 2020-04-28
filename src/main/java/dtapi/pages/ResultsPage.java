package dtapi.pages;

import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.AdminHeadrer;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPage extends AdminHeadrer {
    private By resultsPageTitle = By.xpath("//h3");
    private WaitUtils wait;
    public static final String PAGE_TITLE = "Результати тестувань";

    public ResultsPage(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 10);
    }

    public String getResultsPageTitleText() {
        wait.visibilityOfElement(resultsPageTitle);
        wait.prevenseOfElement(resultsPageTitle);
        return find(resultsPageTitle).getText();
    }
}
