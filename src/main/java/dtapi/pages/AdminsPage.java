package dtapi.pages;

import dtapi.dtapiBase.WaitUtils;
import dtapi.tables.AdminsTable;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminsPage extends AdminsTable {
    private By adminsPageTitle = By.xpath("//h3");
    private WaitUtils wait;
    public static final String PAGE_TITLE = "Адміни";

    public AdminsPage(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 10);
    }

    public String getAdminsPageTitleText() {
        wait.visibilityOfElement(adminsPageTitle);
        wait.prevenseOfElement(adminsPageTitle);
        return find(adminsPageTitle).getText();
    }
}
