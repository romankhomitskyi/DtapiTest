package dtapi.tables;

import dtapi.data.enums.Pagination;
import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.Paginator;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseTable extends Paginator {
    protected By editIcon = By.xpath(".//mat-icon[@aria-label='edit']");
    protected By deleteIcon = By.xpath(".//mat-icon[@aria-label='delete']");
    private WaitUtils wait;


    public BaseTable(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 20);
    }


    protected WebElement getDeleteIcon(int rowNumber) {
        WebDriverWait waits = new WebDriverWait(driver, 10);
        wait.prevenseOfElement(By.xpath("//table"));
        wait.visibilityOfElement(By.xpath("//table"));
        WebElement tableElement = find(By.xpath("//table"));
        wait.prevenseOfElement(By.xpath(".//tr"));
        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(tableElement.findElements(By.xpath(".//tr"))));
        rows.remove(0);
        wait.visibilityOfAllElements(rows);
        wait.visibilityOfElement(deleteIcon);
        wait.prevenseOfElement(deleteIcon);
        return rows.get(rowNumber - 1).findElement(deleteIcon);
    }

    protected WebElement getEditIcon(int rowNumber) {
        WebDriverWait waits = new WebDriverWait(driver, 10);
        wait.prevenseOfElement(By.xpath("//table"));
        wait.visibilityOfElement(By.xpath("//table"));
        WebElement tableElement = find(By.xpath("//table"));
        wait.prevenseOfElement(By.xpath(".//tr"));
        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(tableElement.findElements(By.xpath(".//tr"))));
        rows.remove(0);
        wait.visibilityOfAllElements(rows);
        wait.visibilityOfElement(editIcon);
        wait.prevenseOfElement(editIcon);
        return rows.get(rowNumber - 1).findElement(editIcon);
    }

    public List<WebElement> getRows() {
        wait.visibilityOfElement(By.xpath("//table"));
        wait.prevenseOfElement(By.xpath("//table"));
        WebElement tableElement = find(By.xpath("//table"));
        wait.prevenseOfElement(By.xpath(".//tr"));
        List<WebElement> rows = tableElement.findElements(By.xpath(".//tr"));
        wait.visibilityOfAllElements(rows);
        rows.remove(0);
        return rows;
    }

    protected List<WebElement> getRowsWithCells() {
        WebDriverWait waits = new WebDriverWait(driver, 10);
        wait.prevenseOfElement(By.xpath("//table"));
        wait.visibilityOfElement2(driver.findElement(By.xpath("//table")));
        WebElement tableElement = find(By.xpath("//table"));
        wait.prevenseOfElement(By.xpath(".//tr"));
        List<WebElement> rows = waits.until(ExpectedConditions.visibilityOfAllElements(tableElement.findElements(By.xpath(".//tr//td[2]"))));
        wait.visibilityOfAllElements(rows);
        return rows;
    }

    protected WebElement findNewValueAndClickEditIcon(String name, Pagination last) {

        List<WebElement> rows = driver.findElements(By.xpath("//table//tr//td[2]"));
        wait.visibilityOfAllElements(rows);
        int count = 0;
        if (!isArrowEnabled(last)) {
            for (WebElement namesElement : rows) {
                wait.scrollUntilElementVisible(namesElement);
                count++;
                if (namesElement.getText().equals(name)) {
                    wait.visibilityOfElement2(namesElement);
                }

            }
            return getEditIcon(count);
        } else {
            clickLastButton();
            WebDriverWait waits = new WebDriverWait(driver, 10);

            wait.prevenseOfElement(By.xpath("//table"));
            wait.visibilityOfElement(By.xpath("//table"));
            wait.prevenseOfElement(By.xpath("//table//tr"));
            wait.visibilityOfElement(By.xpath("//table//tr"));
            WebElement table = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));
            wait.prevenseOfElement(By.xpath("//table//tr"));
            wait.visibilityOfElement(By.xpath("//table//tr"));

            List<WebElement> rows2 = table.findElements(By.xpath(".//tr//td[2]"));
            for (WebElement namesElement : rows2) {
                wait.scrollUntilElementVisible(namesElement);
                count++;
                if (namesElement.getText().equals(name)) {
                    wait.visibilityOfElement2(namesElement);

                }
                return getEditIcon(count);
            }
        }
        return getEditIcon(count);
    }

    protected WebElement findNewValueAndClickDeleteIcon(String name, Pagination last) {

        List<WebElement> rows2 = driver.findElements(By.xpath("//tbody//tr//td[2]"));

        int count = 0;
        if (!isArrowEnabled(last)) {
            for (WebElement namesElement : rows2) {
                wait.scrollUntilElementVisible(namesElement);
                count++;
                if (namesElement.getText().equals(name)) {
                    wait.visibilityOfElement2(namesElement);
                }

            }
            return getDeleteIcon(count);
        } else {
            clickLastButton();

            WebDriverWait waits = new WebDriverWait(driver, 10);

            wait.prevenseOfElement(By.xpath("//table"));
            wait.visibilityOfElement(By.xpath("//table"));
            wait.prevenseOfElement(By.xpath("//table//tr"));
            wait.visibilityOfElement(By.xpath("//table//tr"));
            WebElement table = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));
            wait.prevenseOfElement(By.xpath("//table//tr"));
            wait.visibilityOfElement(By.xpath("//table//tr"));

            List<WebElement> rows = table.findElements(By.xpath(".//tr//td[2]"));
            for (WebElement namesElement : rows) {
                wait.scrollUntilElementVisible(namesElement);
                count++;
                if (namesElement.getText().equals(name)) {


                }
                return getDeleteIcon(count);

            }
        }
        return getDeleteIcon(count);
    }


    protected boolean findNewValueInTable(String name, Pagination last) {
        sleep(1000);
        List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
        boolean isInList = false;
        if (!isArrowEnabled(last)) {
            for (WebElement namesElement : rows) {
                if (namesElement.getText().equals(name))

                    isInList = true;

            }

        } else {

            clickLastButton();
            sleep(1000);
            List<WebElement> rows2 = driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
            System.out.println(rows2.size());
            for (WebElement namesElements : rows2) {
                if (namesElements.getText().equals(name))
                    isInList = true;

            }
        }
        return isInList;
    }

    protected List<WebElement> getHeadings() {
        WebElement tableElement = find(By.xpath("//table"));
        WebElement headingsRow = tableElement.findElement(By.xpath(".//tr[1]"));
        List<WebElement> headingsColumns = headingsRow.findElements(By.xpath(".//th"));
        return headingsColumns;
    }

    protected List<List<WebElement>> getRowsWithColumns() {
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
        for (WebElement row : rows) {
            List<WebElement> rowWithColumns = row.findElements(By.xpath(".//td"));
            rowsWithColumns.add(rowWithColumns);

        }
        return rowsWithColumns;
    }

    protected List<Map<String, WebElement>> getRowsWithColumnsByHeadings() {


        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = new ArrayList<Map<String, WebElement>>();
        Map<String, WebElement> rowByHeadings;
        List<WebElement> headingColumns = getHeadings();

        for (List<WebElement> row : rowsWithColumns) {
            rowByHeadings = new HashMap<String, WebElement>();
            for (int i = 0; i < headingColumns.size(); i++) {
                String heading = headingColumns.get(i).getText();
                WebElement cell = row.get(i);
                rowByHeadings.put(heading, cell);


            }
            rowsWithColumnsByHeadings.add(rowByHeadings);
        }
        return rowsWithColumnsByHeadings;
    }

    protected void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
