package dtapi.modalsWindows;

import dtapi.data.student.IStudent;
import dtapi.dtapiBase.WaitUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StudentDataModalWindow {
    private WebDriver driver;
    private WaitUtils wait;
    private Logger log;
    private By title = By.xpath("//h3[text()='Інформація про студента']");
    private By studentSNF = By.xpath("//div[contains(text(),'ПІБ')]/following-sibling::div");
    private By studentFaculty = By.xpath("//div[contains(text(),'Факультет/Інститут')]/following-sibling::div");
    private By studentSpeciality = By.xpath("//div[contains(text(),'Спеціальність')]/following-sibling::div");
    private By studentGroup = By.xpath("//div[contains(text(),'Група')]/following-sibling::div");
    private By studentGradeBookId = By.xpath("//div[contains(text(),'Номер заліковки')]/following-sibling::div");
    private By studentEmail = By.xpath("//div[contains(text(),'Електронна пошта')]/following-sibling::div");
    private By studentLogin = By.xpath("//div[contains(text(),'Унікальне')]/following-sibling::div");
    private By closeWindow = By.xpath("//mat-icon[contains(text(),'close')]");

    public StudentDataModalWindow(WebDriver driver) {
            this.driver = driver;

            wait = new WaitUtils(driver,10);

    }
    private void clickCloseWindowIcon(){
        wait.visibilityOfElementByLocator(closeWindow);
        wait.presenceOfElement(closeWindow);
        driver.findElement(closeWindow).click();
    }
    public WebElement getStudentSNF() {
        wait.visibilityOfElementByLocator(studentSNF);
        wait.presenceOfElement(studentSNF);
        WebElement studentsSNF = driver.findElement(studentSNF);
        return studentsSNF;
    }

    public String getStudentSNFText() {
        return getStudentSNF().getText();
    }

    public WebElement getStudentFaculty() {
        wait.visibilityOfElementByLocator(studentFaculty);
        wait.presenceOfElement(studentFaculty);
        WebElement studentsFaculty = driver.findElement(studentFaculty);
        return studentsFaculty;
    }

    public String getStudentFacultyText() {
        return getStudentFaculty().getText();
    }

    public WebElement getStudentSpeciality() {
        wait.visibilityOfElementByLocator(studentSpeciality);
        wait.presenceOfElement(studentSpeciality);
        WebElement studentsSpeciality = driver.findElement(studentSpeciality);
        return studentsSpeciality;
    }

    public String getStudentSpecialityText() {
        return getStudentSpeciality().getText();
    }
    public WebElement getStudentGroup() {
        wait.visibilityOfElementByLocator(studentGroup);
        wait.presenceOfElement(studentGroup);
        WebElement studentsGroup = driver.findElement(studentGroup);
        return studentsGroup;
    }

    public String getStudentGroupText() {
        return getStudentGroup().getText();
    }

    public WebElement getStudentGradeBookId() {
        wait.visibilityOfElementByLocator(studentGradeBookId);
        wait.presenceOfElement(studentGradeBookId);
        WebElement studentsGradeBookId = driver.findElement(studentGradeBookId);
        return studentsGradeBookId;
    }

    public String getStudentGradeBookIdText() {
        return getStudentGradeBookId().getText();
    }

    public WebElement getStudentEmail() {
        wait.visibilityOfElementByLocator(studentEmail);
        wait.presenceOfElement(studentEmail);
        WebElement studentsEmail = driver.findElement(studentEmail);
        return studentsEmail;
    }

    public String getStudentEmailText() {
        return getStudentEmail().getText();
    }
    public WebElement getStudentLogin() {
        wait.visibilityOfElementByLocator(studentLogin);
        wait.presenceOfElement(studentLogin);
        WebElement studentsLog = driver.findElement(studentLogin);
        return studentsLog;
    }

    public String getStudentLogText() {
        return getStudentLogin().getText();
    }
    private String getStudentModalWindowTitleText() {
        wait.visibilityOfElementByLocator(title);
        wait.presenceOfElement(title);
        return driver.findElement(title).getText();
    }
    private boolean verifyInformation(IStudent student,IStudent student2,String speciality,String faculty,String group) {
        if (getStudentSNFText().contains(student2.getSurname())
                && getStudentFacultyText().equals(faculty)
                && getStudentSpecialityText().equals(speciality)
                && getStudentGroupText().equals(group)
                && getStudentGradeBookIdText().equals(student.getGradeBookId())
                && getStudentEmailText().equals(student.getStudentEmail())
                && getStudentLogText().equals(student.getStudentLogin()))
        {
            clickCloseWindowIcon();
            return true;

        }
       return false;

    }

    public boolean verifyInformationAboutStudentAndCloseWindow(IStudent validStudent,IStudent validStudent2,String speciality,String faculty,String group) {
        return verifyInformation(validStudent, validStudent2, speciality, faculty, group);

    }

}
