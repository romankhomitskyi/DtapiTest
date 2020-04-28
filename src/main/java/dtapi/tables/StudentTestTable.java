package dtapi.tables;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class StudentTestTable extends BaseTable {
    protected By startTestIcon = (By.xpath(".//mat-icon[@aria-label='start']"));
    protected String iconXpath = ".//mat-icon[@aria-label='start']";

    public StudentTestTable(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /*public String getValueFromCell(int rowNumber, String columnName){
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = getRowsWithColumnsByHeadings();
        return rowsWithColumnsByHeadings.get(rowNumber - 1).get(columnName).getText();

    }*/

    /*public TakingTestPage getValueFromCell(int rowNumber, String columnName,String iconValue){
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = getRowsWithColumnsByHeadings();
        rowsWithColumnsByHeadings.get(rowNumber - 1).get(columnName);
        click(By.xpath(String.format(iconXpath,iconValue)));
        return new TakingTestPage(driver,log);
    }*/
    public WebElement getValueFromCell(int rowNumber, String columnName) {
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = getRowsWithColumnsByHeadings();
        return rowsWithColumnsByHeadings.get(rowNumber - 1).get(columnName).findElement(startTestIcon);


    }
   /* public String getValueFromCell(int rowNumber, String columnName){
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = getRowsWithColumnsByHeadings();
        List<WebElement> elements = driver.findElements(startTestIcon);
        elements.get(rowNumber);
        return rowsWithColumnsByHeadings.get(rowNumber - 1).get(columnName).getText();
    }*/


}
