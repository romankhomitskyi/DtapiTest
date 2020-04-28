package dtapi.modalsWindows;

import dtapi.data.student.IStudent;
import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.StudentPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewStudentModalWindow extends BaseModalWindow {
    private By surnameField = By.xpath("//input[@placeholder='Прізвище']");
    private By firstNameField = By.xpath("//input[@formcontrolname='firstname']");
    private By fatherNameField = By.xpath("//input[@formcontrolname='fathername']");
    private By gradeBookId = By.xpath("//input[@formcontrolname='gradebookID']");
    private By loginField = By.xpath("//input[@formcontrolname='login']");
    private By emailField = By.xpath("//input[@formcontrolname='email']");
    private By passwordField = By.xpath("//input[@formcontrolname='password']");
    private By confirmPasswordField = By.xpath("//input[@formcontrolname='password_confirm']");
    private By choosePhotoButton = By.xpath("//input[@type='file']");
    private WaitUtils wait;

    public AddNewStudentModalWindow(WebDriver driver, Logger log) {
        super(driver, log);
        wait = new WaitUtils(driver, 2);
    }

    private void clickSurnameField() {
        wait.visibilityOfElement(surnameField);
        wait.prevenseOfElement(surnameField);
        driver.findElement(surnameField).click();
    }

    private void clearSurnameField() {
        wait.visibilityOfElement(surnameField);
        wait.prevenseOfElement(surnameField);
        driver.findElement(surnameField).clear();
    }

    private void setSurnameField(String surname) {
        wait.visibilityOfElement(surnameField);
        wait.prevenseOfElement(surnameField);
        wait.scrollUntilElementVisible(driver.findElement(surnameField));
        type(surname, surnameField);
    }

    private void fillStudentSurnameField(String surname) {
        clickSurnameField();
        clearSurnameField();
        setSurnameField(surname);
    }

    private void clickFatherNameField() {
        wait.visibilityOfElement(fatherNameField);
        wait.prevenseOfElement(fatherNameField);
        driver.findElement(fatherNameField).click();
    }

    private void clearFatherNameField() {
        wait.visibilityOfElement(fatherNameField);
        wait.prevenseOfElement(fatherNameField);
        driver.findElement(fatherNameField).clear();
    }

    private void setFatherNameField(String fatherName) {
        wait.visibilityOfElement(fatherNameField);
        wait.prevenseOfElement(fatherNameField);
        wait.scrollUntilElementVisible(driver.findElement(fatherNameField));
        type(fatherName, fatherNameField);
    }

    private void fillStudentFatherNameField(String fatherName) {
        clickFatherNameField();
        clearFatherNameField();
        setFatherNameField(fatherName);
    }

    private void clickFirstNameField() {
        wait.visibilityOfElement(firstNameField);
        wait.prevenseOfElement(firstNameField);
        driver.findElement(firstNameField).click();
    }

    private void clearFirstNameField() {
        wait.visibilityOfElement(firstNameField);
        wait.prevenseOfElement(firstNameField);
        driver.findElement(firstNameField).clear();
    }

    private void setFirstNameField(String firstName) {
        wait.visibilityOfElement(firstNameField);
        wait.prevenseOfElement(firstNameField);
        wait.scrollUntilElementVisible(driver.findElement(firstNameField));
        type(firstName, firstNameField);
    }

    private void fillStudentFirstNameField(String firstName) {
        clickFirstNameField();
        clearFirstNameField();
        setFirstNameField(firstName);
    }

    private void clickGradeBookIdField() {
        wait.visibilityOfElement(gradeBookId);
        wait.prevenseOfElement(gradeBookId);
        driver.findElement(gradeBookId).click();
    }

    private void clearGradeBookIdField() {
        wait.visibilityOfElement(gradeBookId);
        wait.prevenseOfElement(gradeBookId);
        driver.findElement(gradeBookId).clear();
    }

    private void setGradeBookIdField(String gradeBooksId) {
        wait.visibilityOfElement(gradeBookId);
        wait.prevenseOfElement(gradeBookId);
        wait.scrollUntilElementVisible(driver.findElement(gradeBookId));
        type(gradeBooksId, gradeBookId);
    }

    private void fillStudentGradeBookIdField(String gradeBooksId) {
        clickGradeBookIdField();
        clearGradeBookIdField();
        setGradeBookIdField(gradeBooksId);
    }

    private void clickLoginField() {
        wait.visibilityOfElement(loginField);
        wait.prevenseOfElement(loginField);
        driver.findElement(loginField).click();
    }

    private void clearLoginFieldField() {
        wait.visibilityOfElement(loginField);
        wait.prevenseOfElement(loginField);
        driver.findElement(loginField).clear();
    }

    private void setLoginFieldField(String login) {
        wait.visibilityOfElement(loginField);
        wait.prevenseOfElement(loginField);
        wait.scrollUntilElementVisible(driver.findElement(loginField));
        type(login, loginField);
    }

    private void fillStudentLoginField(String login) {
        clickLoginField();
        clearLoginFieldField();
        setLoginFieldField(login);
    }

    private void clickEmailField() {
        wait.visibilityOfElement(emailField);
        wait.prevenseOfElement(emailField);
        driver.findElement(emailField).click();
    }

    private void clearEmailField() {
        wait.visibilityOfElement(emailField);
        wait.prevenseOfElement(emailField);
        driver.findElement(emailField).clear();
    }

    private void setEmailField(String email) {
        wait.visibilityOfElement(emailField);
        wait.prevenseOfElement(emailField);
        wait.scrollUntilElementVisible(driver.findElement(emailField));
        type(email, emailField);
    }

    private void fillStudentEmailField(String email) {
        clickEmailField();
        clearEmailField();
        setEmailField(email);
    }

    private void clickOnPasswordField() {
        wait.visibilityOfElement(passwordField);
        wait.prevenseOfElement(passwordField);
        driver.findElement(passwordField).click();
    }

    private void clearPasswordField() {
        wait.visibilityOfElement(passwordField);
        wait.prevenseOfElement(passwordField);
        driver.findElement(passwordField).clear();
    }

    private void setPassword(String password) {
        wait.visibilityOfElement(passwordField);
        wait.prevenseOfElement(passwordField);
        wait.scrollUntilElementVisible(driver.findElement(passwordField));
        type(password, passwordField);
    }

    private void fillStudentPasswordField(String password) {
        clickOnPasswordField();
        clearPasswordField();
        setPassword(password);
    }

    private void clickConfirmPasswordField() {
        wait.visibilityOfElement(confirmPasswordField);
        wait.prevenseOfElement(confirmPasswordField);
        driver.findElement(confirmPasswordField).click();
    }

    private void clearConfirmPasswordField() {
        wait.visibilityOfElement(confirmPasswordField);
        wait.prevenseOfElement(confirmPasswordField);
        driver.findElement(confirmPasswordField).clear();
    }

    private void setConfirmPassword(String password) {
        wait.visibilityOfElement(confirmPasswordField);
        wait.prevenseOfElement(confirmPasswordField);
        wait.scrollUntilElementVisible(driver.findElement(confirmPasswordField));
        type(password, confirmPasswordField);
    }

    private void fillStudentConfirmPasswordField(String password) {
        clickConfirmPasswordField();
        clearConfirmPasswordField();
        setConfirmPassword(password);
    }


    private void fillAllStudentFields(IStudent student) {
        fillStudentSurnameField(student.getSurname());
        fillStudentFirstNameField(student.getFirstName());
        fillStudentFatherNameField(student.getFatherName());
        fillStudentGradeBookIdField(student.getGradeBookId());
        fillStudentLoginField(student.getStudentLogin());
        fillStudentEmailField(student.getStudentEmail());
        fillStudentPasswordField(student.getStudentPassword());
        fillStudentConfirmPasswordField(student.getStudentConfirmPassword());

    }


    public StudentPage fillAllStudentFieldsAndSubmitForm(IStudent validStudent) {
        String addSubjectPageWindow = driver.getWindowHandle();
        createStudent(validStudent);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {

                driver.switchTo().window(windowHandle);
            }
        }

        return new StudentPage(driver, log);
    }

    private void createStudent(IStudent validStudent) {
        fillAllStudentFields(validStudent);
        clickSubmitButton();

    }
    public StudentPage fillStudentNSFFieldsAndSubmitForm(IStudent validStudent) {
        String addSubjectPageWindow = driver.getWindowHandle();
        editStudent(validStudent);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {

                driver.switchTo().window(windowHandle);
            }
        }

        return new StudentPage(driver, log);
    }
    private void editStudent(IStudent validStudent) {
        fillStudentNSF(validStudent);
        clickSubmitButton();

    }
    private void fillStudentNSF(IStudent student) {
        fillStudentSurnameField(student.getSurname());
        fillStudentFirstNameField(student.getFirstName());
        fillStudentFatherNameField(student.getFatherName());
}
}
