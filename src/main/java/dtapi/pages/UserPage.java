package dtapi.pages;

import dtapi.tables.StudentTestTable;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPage extends StudentTestTable {

    private String studentUrl = "https://travisdtapi.firebaseapp.com/student/home";
    private By headerTestPage = By.xpath("//section[@class='test-details']/h3");


    public UserPage(WebDriver driver, Logger log) {
        super(driver, log);

    }

    public String getStudentUrl() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.urlMatches(studentUrl));
        return studentUrl;
    }

    public TakingTestPage startTakingTest(int rowNumber, String columnName) {
        getValueFromCell(rowNumber, columnName).click();
        return new TakingTestPage(driver, log);
    }

    public String getHeaderText() {

        return find(headerTestPage).getText();
    }


}





