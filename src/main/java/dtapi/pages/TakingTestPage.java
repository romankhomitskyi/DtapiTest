package dtapi.pages;

import dtapi.dtapiBase.WaitUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TakingTestPage extends BasePageObject {
        private By markAnswerButton = By.xpath("//button[contains(text(),'Позначити питання')]");
        private By firstAnswer = By.xpath("//p[contains(text(),'50')]/ancestor::mat-radio-button//input");

        private By secondAnswer = By.xpath("//p[contains(text(),'Перша правильна відповідь')]/ancestor::mat-checkbox");
        private By thirdAnswer = By.xpath("//p[contains(text(),'Друга правильна відповідь')]/ancestor::mat-checkbox");
        private By fourAnswer = By.xpath("//input[@type='text']");
        private By numberAnswer = By.xpath("//input[@type='number']");
        private By firstQuestion = By.xpath("//div[contains(text(),'1')]");
        private By secondQuestion = By.xpath("//div[contains(text(),'2')]");
        private By thirdQuestion = By.xpath("//div[contains(text(),'3')]");
        private By fourtQuestion = By.xpath("//div[contains(text(),'4')]");
        private By fiveQuestion = By.xpath("//div[contains(text(),'5')]");
        private By sixQuestion = By.xpath("//div[contains(text(),'6')]");
        private By finishTestButton = By.xpath("//span[contains(text(),'Завершити тест')]/parent::button");
        private By mark = By.xpath("//p[contains(text(),'Ваша оцінка')]");
        private By exitButton = By.xpath("//button[contains(text(),'Вийти')]");
        private WaitUtils wait;



    public TakingTestPage(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver,10);
    }

    private void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void passTest(){
        sleep(2000);
        Actions actions = new Actions(driver);


        wait.visibilityOfElement(firstAnswer);
        wait.waitForElementClickability(firstAnswer);
        /*wait.scrollUntilElementVisible(driver.findElement(firstAnswer));*/
        driver.findElement(firstAnswer).sendKeys(Keys.SPACE);
        sleep(1000);
        wait.visibilityOfElement(secondQuestion);
        wait.waitForElementClickability(secondQuestion);
        wait.javaClick(driver.findElement(secondQuestion));
        sleep(1000);
        wait.prevenseOfElement(secondAnswer);
        wait.visibilityOfElement(secondAnswer);
        wait.waitForElementClickability(secondAnswer);
        wait.scrollUntilElementVisible(driver.findElement(secondAnswer));
        driver.findElement(secondAnswer).click();
        wait.prevenseOfElement(thirdAnswer);
        wait.visibilityOfElement(thirdAnswer);
        wait.waitForElementClickability(thirdAnswer);
        wait.scrollUntilElementVisible(driver.findElement(thirdAnswer));
        driver.findElement(thirdAnswer).click();
        wait.visibilityOfElement(thirdQuestion);
        wait.waitForElementClickability(thirdQuestion);
        /*wait.scrollUntilElementVisible(driver.findElement(thirdQuestion));*/
        driver.findElement(thirdQuestion).click();
        sleep(1000);
        driver.findElement(fourAnswer).sendKeys("Київ");
        wait.visibilityOfElement(fourtQuestion);
        wait.waitForElementClickability(fourtQuestion);
        /*wait.scrollUntilElementVisible(driver.findElement(fourtQuestion));*/
        driver.findElement(fourtQuestion).click();
        sleep(1000);
        driver.findElement(numberAnswer).sendKeys("5");
        wait.visibilityOfElement(fiveQuestion);
        wait.waitForElementClickability(fiveQuestion);
       /* wait.scrollUntilElementVisible(driver.findElement(fiveQuestion));*/
        driver.findElement(fiveQuestion).click();
        sleep(1000);
        wait.visibilityOfElement(firstAnswer);
        wait.waitForElementClickability(firstAnswer);
        wait.scrollUntilElementVisible(driver.findElement(firstAnswer));
        driver.findElement(firstAnswer).sendKeys(Keys.SPACE);
        wait.visibilityOfElement(sixQuestion);
        wait.waitForElementClickability(sixQuestion);
       /* wait.scrollUntilElementVisible(driver.findElement(sixQuestion));*/
        driver.findElement(sixQuestion).click();
        sleep(1000);
        driver.findElement(fourAnswer).sendKeys("Київ");
        sleep(1000);
        driver.findElement(finishTestButton).click();

    }
    public String getMark(){
        String page = find(mark).getText().split(" ")[2];
        return page;
    }
    public UserPage clickExitButton(){
        driver.findElement(exitButton).click();
        return  new UserPage(driver,log);
    }
}
