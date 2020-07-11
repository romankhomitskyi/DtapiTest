package dtapi.pages;

import dtapi.components.StudentTableContainer;
import dtapi.components.StudentTableContainerComponent;
import dtapi.data.student.IStudent;
import dtapi.dtapiBase.WaitUtils;
import dtapi.elements.Paginator;
import dtapi.modalsWindows.AddNewStudentModalWindow;
import dtapi.modalsWindows.StudentDataModalWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StudentPage extends Paginator {
    private By addStudentButton = By.xpath("//span[contains(text(),'Додати студента')]/parent::button");

    private StudentTableContainer studentTableContainer;
    private WaitUtils wait;
    public StudentPage(WebDriver driver) {
        super(driver);
        initElements();
        wait = new WaitUtils(driver,10);
    }

    private void initElements() {

        studentTableContainer = new  StudentTableContainer(driver);

    }
    public StudentTableContainer getStudentTableContainer() {
        return studentTableContainer;
    }


    public AddNewStudentModalWindow switchToEditStudentModalWindow(IStudent student) {
        String shoppingCartWindow = driver.getWindowHandle();
        getStudentTableContainer().
                getStudentContainerComponentByStudentNSF(student.getSurname()).clickEditStudentIcon();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new AddNewStudentModalWindow(driver);
    }
    public StudentDataModalWindow switchToInformationAboutStudentModalWindow(IStudent student) {
        String shoppingCartWindow = driver.getWindowHandle();
        getStudentTableContainer().
                getStudentContainerComponentByStudentNSF(student.getSurname()).clickStudentDataIcon();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new  StudentDataModalWindow(driver);
    }
    public boolean verifyStudentEdited(IStudent student) {

        for (StudentTableContainerComponent component : getStudentTableContainer().getStudentContainerComponents()) {
            if (component.getStudentNSFText().contains(student.getSurname())) {
                return true;
            }
        }
        return false;
    }
    public boolean verifyStudentAdded(IStudent studentNSF) {

        String  nsf = getStudentTableContainer().
                getStudentContainerComponentByStudentNSF(studentNSF.getSurname())
                .getStudentNSFText();
        if(nsf.contains(studentNSF.getSurname())){
            return true;
        }

        return false;
    }

    public AddNewStudentModalWindow switchToAddNewStudentModalWindow() {
        String shoppingCartWindow = driver.getWindowHandle();
        wait.prevenseOfElement(addStudentButton);
        wait.visibilityOfElement(addStudentButton);
        click(addStudentButton);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(shoppingCartWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
        return new AddNewStudentModalWindow(driver);
    }


}
