package dtapi.elements;

import dtapi.data.enums.RowsOnPage;
import dtapi.dtapiBase.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Paginator  {
    private WebDriver driver;
    private WebElement lastButton;
    private WebElement nextButton;
    private WebElement previousButton;
    private WebElement firstButton;
    private WebElement dropDown;
    private WebElement firstOption;
    private WaitUtils wait;

    public Paginator(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver, 5);
        initElements();
    }

    private void initElements() {
        if(!driver.findElements(By.xpath("//button[contains(@class, 'mat-paginator-navigation-last')]")).isEmpty()){
        lastButton = driver.findElement(By.xpath("//button[contains(@class, 'mat-paginator-navigation-last')]"));
        }
        if(!driver.findElements(By.xpath("//button[contains(@class, 'mat-paginator-navigation-next')]")).isEmpty()) {
            nextButton = driver.findElement(By.xpath("//button[contains(@class, 'mat-paginator-navigation-next')]"));
        }
        if(!driver.findElements(By.xpath("//button[contains(@class, 'mat-paginator-navigation-previous')]")).isEmpty()) {
            previousButton = driver.findElement(By.xpath("//button[contains(@class, 'mat-paginator-navigation-previous')]"));
        }
        if(!driver.findElements(By.xpath("//button[contains(@class, 'mat-paginator-navigation-previous')]")).isEmpty()) {
            firstButton = driver.findElement(By.xpath("//button[contains(@class, 'mat-paginator-navigation-previous')]"));
        }
        if(!driver.findElements(By.xpath("//mat-form-field[contains(@class, 'mat-paginator-page-size-select')]")).isEmpty()) {
            dropDown = driver.findElement(By.xpath("//mat-form-field[contains(@class, 'mat-paginator-page-size-select')]"));
        }
        if(!driver.findElements(By.xpath("//div[contains(@class,'mat-select-value')]/span/span")).isEmpty()) {
            firstOption = driver.findElement(By.xpath("//div[contains(@class,'mat-select-value')]/span/span"));
        }

    }

    public void clickLastButton() {
        wait.waitForElementToBeClickable(lastButton);
        lastButton.click();


    }

    public void clickNextButton() {
        wait.waitForElementToBeClickable(nextButton);
        nextButton.click();


    }

    public void clickPreviousButton() {
        wait.waitForElementToBeClickable(previousButton);
        previousButton.click();
    }

    public void clickFirstButton() {
        wait.waitForElementToBeClickable(firstButton);
        firstButton.click();
    }

    public boolean isPreviousArrowEnabled() {
        wait.visibilityOfWebElement(previousButton);
        return previousButton.isEnabled();
    }
    public boolean isLastArrowEnabled() {
        wait.visibilityOfWebElement(lastButton);
        return nextButton.isEnabled();
    }

    public boolean isNextArrowEnabled() {
        wait.visibilityOfWebElement(nextButton);
        return nextButton.isEnabled();
    }
    public boolean isFirstArrowEnabled() {
        wait.visibilityOfWebElement(firstButton);
        return firstButton.isEnabled();
    }



    public int getFirstOptionCount() {
        return Integer.parseInt(String.valueOf(getFirstOptionText()));
    }

    public void setDropDownOption(RowsOnPage option) {
        clickDropDown();
        clickOptions(option);

    }

    public boolean isShowCorrectQuantitySelected(RowsOnPage count) {
        return getFirstOptionText().contains(count.toString());
    }
    private void clickOptions(RowsOnPage option) {
        wait.visibilityOfAllElements(driver.findElements(By.xpath("//mat-option/span")));
        List<WebElement> dropDown = driver.findElements(By.xpath("//mat-option/span"));
        for (WebElement options : dropDown) {
            if (options.getText().equals(option.toString())) {
                options.click();
                break;
            }
        }

    }
    private String getFirstOptionText() {
        wait.visibilityOfWebElement(firstOption);
        return firstOption.getText();
    }

    private void clickDropDown() {
        wait.waitForElementToBeClickable(dropDown);
        dropDown.click();

    }

}


