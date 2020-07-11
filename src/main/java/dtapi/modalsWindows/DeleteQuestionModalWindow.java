package dtapi.modalsWindows;

import dtapi.dtapiBase.WaitUtils;
import dtapi.pages.QuestionPage;
import org.openqa.selenium.WebDriver;

public class DeleteQuestionModalWindow extends BaseDeleteItemModalWindow {
    private WaitUtils wait;

    public DeleteQuestionModalWindow(WebDriver driver) {
        super(driver);
        wait = new WaitUtils(driver, 10);
    }

    public QuestionPage deleteQuestion() {
        String addSubjectPageWindow = driver.getWindowHandle();
        clickSubmitButton();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(addSubjectPageWindow)) {
                driver.switchTo().window(windowHandle);

            }
        }

        return new QuestionPage(driver);
    }
}
