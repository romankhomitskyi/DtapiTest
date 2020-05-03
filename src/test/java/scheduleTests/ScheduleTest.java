package scheduleTests;

import dtapi.data.data_provider.DataForCreatingSchedule;
import dtapi.data.user.IUser;
import dtapi.dtapiBase.TestUtilities;
import dtapi.modalsWindows.AddNewScheduleModalWindow;
import dtapi.pages.ScheduleTestingPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static dtapi.data.schedule.NewScheduleRepository.*;

public class ScheduleTest extends TestUtilities {
    @Test(dataProvider = "addNewSchedule", dataProviderClass = DataForCreatingSchedule.class, priority = 1, groups = {"crudOnSchedulePage"})
    public void verifyCrudOnGroupPage(IUser validAdmin,
                                      String subjectName,
                                      String groupName,
                                      String startDate,
                                      String endDate,
                                      String startTime,
                                      String endTime) {
        ScheduleTestingPage scheduleTestingPage = loadSignInPage()
                .successfulAdminLogin(validAdmin)
                .clickSubjectIcon()
                .navigateToTestSchedulePage(subjectName)
                .switchToAddNewScheduleModalWindow()
                .fillAllScheduleFieldsAndSubmitForm(groupName,startDate,endDate,startTime,endTime);

        Assert.assertTrue(scheduleTestingPage.verifyScheduleAdded(groupName), "Isn't present");


    }
    @Test(dataProvider = "failCreatingSchedule", dataProviderClass = DataForCreatingSchedule.class, priority = 2, groups = {"failCreatingSchedule"})
    public void verifyValidationOnAddNewScheduleModalWindow(IUser validAdmin,
                                      String subjectName,
                                      String groupName
                                    ) {
       AddNewScheduleModalWindow scheduleTestingPage = loadSignInPage()
                .successfulAdminLogin(validAdmin)
                .clickSubjectIcon()
                .navigateToTestSchedulePage(subjectName)
                .switchToAddNewScheduleModalWindow()
                .fillInvalidScheduleData(groupName,invalidDate());
        Assert.assertFalse(scheduleTestingPage.isSubmitButtonEnabled(), "Is enabled");
        scheduleTestingPage.fillInvalidScheduleData(groupName,invalidTime());
        Assert.assertFalse(scheduleTestingPage.isSubmitButtonEnabled(), "Is enabled");


    }

}
