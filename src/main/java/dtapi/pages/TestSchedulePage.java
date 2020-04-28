package dtapi.pages;

import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.Paginator;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestSchedulePage extends Paginator {
    private By headerTestPage = By.xpath("//h3");
    private WaitUtils wait;

    public TestSchedulePage(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver,10);
    }
    public String getTestSchedulePageHeaderText() {
        wait.prevenseOfElement(headerTestPage);
        wait.visibilityOfElement(headerTestPage);
        return find(headerTestPage).getText();
    }
    public Boolean verifyTestSchedulePageHeaderText(String subjectName) {
        return getTestSchedulePageHeaderText().contains(subjectName);
    }
}
