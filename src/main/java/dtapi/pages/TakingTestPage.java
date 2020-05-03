package dtapi.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TakingTestPage extends BasePageObject {
        private By markAnswerButton = By.xpath("//button[contains(text(),'Позначити питання')]");
        private By listOfQuestions = By.xpath("//div//app-question-menu-item");

    public TakingTestPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
}
