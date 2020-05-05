package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResultsTableContainerComponent {
    private WebElement resultsTableContainerComponent;

    private By studentNSF = By.xpath(".//td[contains(@class,'cdk-column-student')]");
    private By studentResult = By.xpath(".//td[contains(@class,'cdk-column-result')]");
    private By studentScore = By.xpath(".//td[contains(@class,'cdk-column-score')]");




    public ResultsTableContainerComponent(WebElement resultsTableContainerComponent) {

        this.resultsTableContainerComponent = resultsTableContainerComponent;


    }


    public WebElement getStudentScore() {
        WebElement studentsScore = resultsTableContainerComponent.findElement(studentScore);
        return studentsScore;
    }

    public String getStudentScoreText() {
        return getStudentScore().getText();
    }


    public WebElement getStudentResult() {


        WebElement studentsResult = resultsTableContainerComponent.findElement(studentResult);
        return studentsResult;
    }

    public String getStudentResultText() {

        return getStudentResult().getText();
    }

    public WebElement getStudentNSF() {
        WebElement studentsNSF = resultsTableContainerComponent.findElement(studentNSF);

        return studentsNSF;
    }

    public String getStudentNSFText() {
        return getStudentNSF().getText();
    }


}