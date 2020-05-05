package dtapi.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TakingTestPage extends BasePageObject {
        private By markAnswerButton = By.xpath("//button[contains(text(),'Позначити питання')]");
        private By firstAnswer = By.xpath("//span[contains(text(),'50')]/preceding-sibling::input");
        private By secondAnswer = By.xpath("//span[contains(text(),'Перша правильна відповідь')]/preceding-sibling::input");
        private By thirdAnswer = By.xpath("//span[contains(text(),'Друга правильна відповідь')]/preceding-sibling::input");
        private By fourAnswer = By.xpath("//input[@placeholder='введіть відповідь']");
        private By firstQuestion = By.xpath("//div[contains(text(),'1')]");
        private By secondQuestion = By.xpath("//div[contains(text(),'2')]");
        private By thirdQuestion = By.xpath("//div[contains(text(),'3')]");
        private By fourtQuestion = By.xpath("//div[contains(text(),'4')]");
        private By fiveQuestion = By.xpath("//div[contains(text(),'5')]");
        private By sixQuestion = By.xpath("//div[contains(text(),'6')]");
        private By finishTestButton = By.xpath("//button[contains(text(),'Завершити тест')]");
        private By mark = By.xpath("//p[contains(text(),'Ваша оцінка')]");
        private By exitButton = By.xpath("//button[contains(text(),'Вийти')]");



    public TakingTestPage(WebDriver driver, Logger log) {
        super(driver, log);
    }


    public void passTest(){
        driver.findElement(firstAnswer).click();
        driver.findElement(markAnswerButton).click();
        driver.findElement(secondQuestion).click();
        driver.findElement(secondAnswer).click();
        driver.findElement(thirdAnswer).click();
        driver.findElement(markAnswerButton).click();
        driver.findElement(thirdQuestion).click();
        driver.findElement(fourAnswer).sendKeys("Київ");
        driver.findElement(markAnswerButton).click();
        driver.findElement(fourtQuestion).click();
        driver.findElement(fourAnswer).sendKeys("5");
        driver.findElement(markAnswerButton).click();
        driver.findElement(fiveQuestion).click();
        driver.findElement(firstAnswer).click();
        driver.findElement(markAnswerButton).click();
        driver.findElement(sixQuestion).click();
        driver.findElement(fourAnswer).sendKeys("Київ");
        driver.findElement(markAnswerButton).click();
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
