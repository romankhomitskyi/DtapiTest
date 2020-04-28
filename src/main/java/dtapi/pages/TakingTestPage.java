package dtapi.pages;

import dtapi.elements.AdminHeadrer;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class TakingTestPage extends AdminHeadrer {
    private String testUrl = "https://dtapi.if.ua/student/test-player?id=62";

    public String getTestUrl() {
        return testUrl;
    }

    public TakingTestPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
}
