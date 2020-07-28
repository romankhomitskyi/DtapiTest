package dtapi.modalsWindows;

import dtapi.data.student.IStudent;
import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.StudentPage;
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

    public AddNewStudentModalWindow(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 2);
    }

    private void clickSurnameField() {
        wait.visibilityOfElementByLocator(surnameField);
        wait.presenceOfElement(surnameField);
        driver.findElement(surnameField).click();
    }

    private void clearSurnameField() {
        wait.visibilityOfElementByLocator(surnameField);
        wait.presenceOfElement(surnameField);
        driver.findElement(surnameField).clear();
    }

    private void setSurnameField(String surname) {
        wait.visibilityOfElementByLocator(surnameField);
        wait.presenceOfElement(surnameField);
        wait.scrollUntilElementVisible(driver.findElement(surnameField));
        type(surname, surnameField);
    }

    private void fillStudentSurnameField(String surname) {
        clickSurnameField();
        clearSurnameField();
        setSurnameField(surname);
    }

    private void clickFatherNameField() {
        wait.visibilityOfElementByLocator(fatherNameField);
        wait.presenceOfElement(fatherNameField);
        driver.findElement(fatherNameField).click();
    }

    private void clearFatherNameField() {
        wait.visibilityOfElementByLocator(fatherNameField);
        wait.presenceOfElement(fatherNameField);
        driver.findElement(fatherNameField).clear();
    }

    private void setFatherNameField(String fatherName) {
        wait.visibilityOfElementByLocator(fatherNameField);
        wait.presenceOfElement(fatherNameField);
        wait.scrollUntilElementVisible(driver.findElement(fatherNameField));
        type(fatherName, fatherNameField);
    }

    private void fillStudentFatherNameField(String fatherName) {
        clickFatherNameField();
        clearFatherNameField();
        setFatherNameField(fatherName);
    }

    private void clickFirstNameField() {
        wait.visibilityOfElementByLocator(firstNameField);
        wait.presenceOfElement(firstNameField);
        driver.findElement(firstNameField).click();
    }

    private void clearFirstNameField() {
        wait.visibilityOfElementByLocator(firstNameField);
        wait.presenceOfElement(firstNameField);
        driver.findElement(firstNameField).clear();
    }

    private void setFirstNameField(String firstName) {
        wait.visibilityOfElementByLocator(firstNameField);
        wait.presenceOfElement(firstNameField);
        wait.scrollUntilElementVisible(driver.findElement(firstNameField));
        type(firstName, firstNameField);
    }

    private void fillStudentFirstNameField(String firstName) {
        clickFirstNameField();
        clearFirstNameField();
        setFirstNameField(firstName);
    }

    private void clickGradeBookIdField() {
        wait.visibilityOfElementByLocator(gradeBookId);
        wait.presenceOfElement(gradeBookId);
        driver.findElement(gradeBookId).click();
    }

    private void clearGradeBookIdField() {
        wait.visibilityOfElementByLocator(gradeBookId);
        wait.presenceOfElement(gradeBookId);
        driver.findElement(gradeBookId).clear();
    }

    private void setGradeBookIdField(String gradeBooksId) {
        wait.visibilityOfElementByLocator(gradeBookId);
        wait.presenceOfElement(gradeBookId);
        wait.scrollUntilElementVisible(driver.findElement(gradeBookId));
        type(gradeBooksId, gradeBookId);
    }

    private void fillStudentGradeBookIdField(String gradeBooksId) {
        clickGradeBookIdField();
        clearGradeBookIdField();
        setGradeBookIdField(gradeBooksId);
    }

    private void clickLoginField() {
        wait.visibilityOfElementByLocator(loginField);
        wait.presenceOfElement(loginField);
        driver.findElement(loginField).click();
    }

    private void clearLoginFieldField() {
        wait.visibilityOfElementByLocator(loginField);
        wait.presenceOfElement(loginField);
        driver.findElement(loginField).clear();
    }

    private void setLoginFieldField(String login) {
        wait.visibilityOfElementByLocator(loginField);
        wait.presenceOfElement(loginField);
        wait.scrollUntilElementVisible(driver.findElement(loginField));
        type(login, loginField);
    }

    private void fillStudentLoginField(String login) {
        clickLoginField();
        clearLoginFieldField();
        setLoginFieldField(login);
    }

    private void clickEmailField() {
        wait.visibilityOfElementByLocator(emailField);
        wait.presenceOfElement(emailField);
        driver.findElement(emailField).click();
    }

    private void clearEmailField() {
        wait.visibilityOfElementByLocator(emailField);
        wait.presenceOfElement(emailField);
        driver.findElement(emailField).clear();
    }

    private void setEmailField(String email) {
        wait.visibilityOfElementByLocator(emailField);
        wait.presenceOfElement(emailField);
        wait.scrollUntilElementVisible(driver.findElement(emailField));
        type(email, emailField);
    }

    private void fillStudentEmailField(String email) {
        clickEmailField();
        clearEmailField();
        setEmailField(email);
    }

    private void clickOnPasswordField() {
        wait.visibilityOfElementByLocator(passwordField);
        wait.presenceOfElement(passwordField);
        driver.findElement(passwordField).click();
    }

    private void clearPasswordField() {
        wait.visibilityOfElementByLocator(passwordField);
        wait.presenceOfElement(passwordField);
        driver.findElement(passwordField).clear();
    }

    private void setPassword(String password) {
        wait.visibilityOfElementByLocator(passwordField);
        wait.presenceOfElement(passwordField);
        wait.scrollUntilElementVisible(driver.findElement(passwordField));
        type(password, passwordField);
    }

    private void fillStudentPasswordField(String password) {
        clickOnPasswordField();
        clearPasswordField();
        setPassword(password);
    }

    private void clickConfirmPasswordField() {
        wait.visibilityOfElementByLocator(confirmPasswordField);
        wait.presenceOfElement(confirmPasswordField);
        driver.findElement(confirmPasswordField).click();
    }

    private void clearConfirmPasswordField() {
        wait.visibilityOfElementByLocator(confirmPasswordField);
        wait.presenceOfElement(confirmPasswordField);
        driver.findElement(confirmPasswordField).clear();
    }

    private void setConfirmPassword(String password) {
        wait.visibilityOfElementByLocator(confirmPasswordField);
        wait.presenceOfElement(confirmPasswordField);
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

        return new StudentPage(driver);
    }
    public AddNewStudentModalWindow fillInvalidDataInStudentFields(IStudent invalidStudent) {

        fillInvalidData(invalidStudent);


        return new AddNewStudentModalWindow(driver);
    }
    private void fillInvalidData(IStudent validStudent) {
        fillAllStudentFields(validStudent);


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

        return new StudentPage(driver);
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
