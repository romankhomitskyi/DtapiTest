package dtapi.elements;

import dtapi.data.enums.Pagination;
import dtapi.data.enums.RowsOnPage;
import dtapi.dtapiBase.WaitUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Paginator extends AdminHeadrer {
    protected String arrowsButtons = "//button[contains(@class, 'mat-paginator-navigation-%s')]";
    protected By lastButton = By.xpath("//button[contains(@class, 'mat-paginator-navigation-last')]");
    protected By nextButton = By.xpath("//button[contains(@class, 'mat-paginator-navigation-next')]");
    protected By previousButton = By.xpath("//button[contains(@class, 'mat-paginator-navigation-previous')]");
    protected By firstButton = By.xpath("//button[contains(@class, 'mat-paginator-navigation-previous')]");
    protected By dropDown = (By.xpath("//mat-form-field[contains(@class, 'mat-paginator-page-size-select')]"));
    protected String dropDownOptions = "//span[@class ='mat-option-text' and text()='%s']";
    protected By firstOption = (By.xpath("//div[contains(@class,'mat-select-value')]/span/span"));
    protected By paginationLabel = (By.xpath("//div[@class='mat-paginator-range-label']"));
    private WaitUtils wait;

    public Paginator(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 5);
    }

    public void clickLastButton() {
        wait.visibilityOfElement(lastButton);
        wait.prevenseOfElement(lastButton);
        wait.waitForElementClickability(lastButton);
        click(lastButton);


    }

    public void clickNextButton() {
        wait.visibilityOfElement(nextButton);
        wait.prevenseOfElement(nextButton);
        wait.waitForElementClickability(nextButton);
        click(nextButton);
        wait.prevenseOfElement(By.xpath("//table//tr//td"));
        wait.visibilityOfElement(By.xpath("//table//tr//td"));

    }

    public void clickPreviousButton() {
        wait.visibilityOfElement(previousButton);
        wait.prevenseOfElement(previousButton);
        click(previousButton);
    }

    public void clickFirstButton() {
        wait.visibilityOfElement(firstButton);
        wait.prevenseOfElement(firstButton);
        click(firstButton);
    }

    public List<WebElement> getRows() {
        WebElement tableElement = find(By.xpath("//table"));
        List<WebElement> rows = tableElement.findElements(By.xpath(".//tr"));
        rows.remove(0);
        return rows;
    }

    public void clickNeededArrow(Pagination arrowName) {

        wait.visibilityOfElement(By.xpath(String.format(arrowsButtons, arrowName)));
        wait.prevenseOfElement(By.xpath(String.format(arrowsButtons, arrowName)));
        driver.findElement(By.xpath(String.format(arrowsButtons, arrowName))).click();

    }

    public boolean isArrowEnabled(String arrowName) {
        WebElement result = find(By.xpath(String.format(arrowsButtons, arrowName)));
        return result.isEnabled();
    }

    public boolean isArrowEnabled(Pagination arrowName) {

        wait.prevenseOfElement(lastButton);
        wait.visibilityOfElement(lastButton);
        WebElement result = driver.findElement(lastButton);
        wait.scrollUntilElementVisible(result);
        return result.isEnabled();
    }

    public boolean isNextArrowEnabled() {

        wait.prevenseOfElement(nextButton);
        wait.visibilityOfElement(nextButton);
        WebElement result = driver.findElement(nextButton);
        wait.scrollUntilElementVisible(result);
        return result.isEnabled();
    }

    protected void clickDropDown() {
        wait.visibilityOfElement(dropDown);
        wait.prevenseOfElement(dropDown);
        click(dropDown);

    }

    protected void clickOptions(RowsOnPage option) {
        wait.visibilityOfAllElements(driver.findElements(By.xpath("//mat-option/span")));
        List<WebElement> dropDown = driver.findElements(By.xpath("//mat-option/span"));
        for (WebElement options : dropDown) {
            if (options.getText().equals(option.toString())) {
                options.click(); // click the desired option
                break;
            }
        }

    }
       /* wait.visibilityOfElement(By.xpath(String.format(dropDownOptions,option.toString())));
        wait.prevenseOfElement(By.xpath(String.format(dropDownOptions,option.toString())));
        click(By.xpath(String.format(dropDownOptions,option.toString())));
        WebDriverWait waits = new WebDriverWait(driver,5);
        waits.until(ExpectedConditions.)*/


    protected String getFirstOptionText() {

        wait.visibilityOfElement(firstOption);
        wait.prevenseOfElement(firstOption);
        String textOption = driver.findElement(firstOption).getText();

        return textOption;
    }

    public int getFirstOptionCount() {
        int countRows = Integer.parseInt(String.valueOf(getFirstOptionText()));
        return countRows;
    }

    public void setDropDownOption(RowsOnPage option) {
        clickDropDown();
        clickOptions(option);

    }


    public boolean isShowCorrectQuantitySelected(RowsOnPage count) {
        return getFirstOptionText().contains(count.toString());
    }

    public boolean isShowCorrectQuantity(RowsOnPage count) {
        return isShowCorrectQuantitySelected(count);
    }

    public int getLenght() {
        String lenght = find(paginationLabel).getText().split(" ")[4];
        int result = Integer.parseInt(lenght);
        return result;
    }

    public int getEndPage() {
        String endPage = find(paginationLabel).getText().split(" ")[2];
        int result = Integer.parseInt(endPage);
        return result;

    }

    public int getPage() {
        String page = find(paginationLabel).getText().split(" ")[0];
        int result = Integer.parseInt(page);
        return result;

    }


    public boolean clickNextButton(Pagination next, Pagination first, Pagination previous) {
        int index = 0;

        if (!isArrowEnabled(first) && !isArrowEnabled(previous)) {
            clickNextButton();
            index++;
        }
        if (getPage() == (index * getFirstOptionCount()) + 1 && getEndPage() == checkEndPage(index)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean clickLastButton(Pagination last) {
        clickLastButton();


        int index = getLenght() / getFirstOptionCount();


        if (getPage() == (index * getFirstOptionCount()) + 1 && getEndPage() == checkEndPage(index)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean clickPreviousButton(Pagination previous) {
        clickPreviousButton();
        int index = getLenght() / getFirstOptionCount();
        System.out.println(((index - 1) * getFirstOptionCount()) + 1);
        System.out.println(checkEndPage(index - 1));
        if (getPage() == ((index - 1) * getFirstOptionCount()) + 1 && getEndPage() == checkEndPage(index - 1)) {
            return true;
        } else {
            return false;
        }

    }


    public int checkEndPage(int number) {


        int result = getFirstOptionCount() + (number) * (getFirstOptionCount());
        if (result > getLenght()) {
            return getLenght();
        } else return getFirstOptionCount() + (number) * (getFirstOptionCount());


    }

    public int checkEndPage() {

        int index = 0;
        int result = getFirstOptionCount() + (index) * (getFirstOptionCount());
        if (result > getLenght()) {
            return getLenght();
        } else return getFirstOptionCount() + (index) * (getFirstOptionCount());


    }
}
    /*public boolean checkWorkingPaginationWithClicking(Pagination next){
        if (checkPage() && getEndPage() == checkEndPage() && navigation(next) == getLenght()) {
            return true;
        }
        else {return false;}
    }
    public boolean checkPagination(){
        if (checkPage() && getEndPage() == checkEndPage() &&  getAllRows() == getLenght()) {
            return true;
        }
        else {return false;}
    }
    */
    /*public boolean checkPage(int number){

        if(getPage() == ((number) * (getFirstOptionCount())) + 1)
        {
            return true;
        }
        else {
            return false;
        }
    }*/
/*public int getAllRows(){
        List<Integer> countRows = new ArrayList<Integer>();

        for (WebElement row : getRows()){
            countRows.add(getRows().size());
        }
        int total = countRows.size();

        return total;
    }
    public int navigation(Pagination next){
        List<Integer> countRows = new ArrayList<Integer>();

        for (WebElement row : getRows()){
            countRows.add(getRows().size());
        }

        //if(!isArrowEnabled(first) && !isArrowEnabled(previous)){

        while (isArrowEnabled(next)){

            clickNeededArrow(next);

            for (WebElement row : getRows()) {
                countRows.add(getRows().size());

            }
            isArrowEnabled(next);

        }

        int total = countRows.size();

        return total;



    }*/


