package dtapi.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResultsTableContainerComponent {
    private WebElement resultsTableContainerComponent;

    private WebElement studentNSF;
    private WebElement studentId ;
    private WebElement studentResult ;
    private WebElement studentScore ;
    private WebElement sessionDate ;




    public ResultsTableContainerComponent(WebElement resultsTableContainerComponent) {

        this.resultsTableContainerComponent = resultsTableContainerComponent;
        initElements();

    }

    private void initElements(){
        studentNSF = resultsTableContainerComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-student')]"));
        studentId = resultsTableContainerComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-id')]"));
        studentResult = resultsTableContainerComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-twenty')]"));
        studentScore = resultsTableContainerComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-score')]"));
        sessionDate = resultsTableContainerComponent.findElement(By.xpath(".//td[contains(@class,'cdk-column-session_date')]"));

    }

    public WebElement getSessionDate() {
        return sessionDate;
    }

    public String getSessionDateText() {
        return getSessionDate().getText();
    }

    public WebElement getStudentId() {
        return studentId;
    }

    public String getStudentIdText() {
        return getStudentId().getText();
    }

    public WebElement getStudentScore() {
        return studentScore;
    }

    public String getStudentScoreText() {
        return getStudentScore().getText();
    }


    public WebElement getStudentResult() {

        return studentResult;
    }

    public String getStudentResultText() {

        return getStudentResult().getText();
    }

    public WebElement getStudentNSF() {

        return studentNSF;
    }

    public String getStudentNSFText() {
        return getStudentNSF().getText();
    }


}
