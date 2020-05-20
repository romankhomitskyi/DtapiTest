package subjectsTests;

import dtapi.data.data_provider.DataForCreatingSubjectAndTests;
import dtapi.data.question.NewQuestion;
import dtapi.data.testSettings.TestSettings;
import dtapi.data.user.IUser;
import dtapi.dtapiBase.TestUtilities;
import dtapi.modalsWindows.AddSubjectModalWindow;
import dtapi.modalsWindows.InformModalWindow;
import dtapi.pages.ScheduleTestingPage;
import dtapi.pages.SubjectPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static dtapi.data.question.NewQuestionRepository.getQuestion1;
import static dtapi.data.question.NewQuestionRepository.getQuestion2;
import static dtapi.data.subject.NewSubjectRepository.*;

public class SubjectTest extends TestUtilities {

    @Test(dataProvider = "addNewTest", dataProviderClass = DataForCreatingSubjectAndTests.class, priority = 1, groups = {"addNewSubjectAndTest"})
    public void verifyAddingNewTest(IUser validAdmin,
                           String oldName,
                           String oldDesc,
                           String newName,
                           String newDesc,
                           String oldTestName,
                           int oldTaskCount,
                           int oldTimeCount,
                           int oldNumberOfAttempts,
                           String newTestName,
                           int newTaskCount,
                           int newTimeCount,
                           int newNumberOfAttempts,
                           List<NewQuestion> questions,
                           List<TestSettings> settings,
                           String groupName,
                           String startDate,
                           String endDate,
                           String startTime,
                           String endTime
    )
    {
        ScheduleTestingPage scheduleTestingPage = loadSignInPage()
                .successfulAdminLogin(validAdmin)
                .clickSubjectIcon()
                .switchAddNewSubjectToModalWindow()
                .fillAllSubjectFieldsAndSubmitForm(oldName,oldDesc)
                .switchToEditSubjectModalWindow(oldName)
                .fillAllSubjectFieldsAndSubmitForm(newName,newDesc)
                .navigateToTestOfSubjectPage(newName)
                .switchToAddTestModalWindow()
                .fillAllTestFieldsAndSubmitForm(oldTestName,oldTaskCount,oldTimeCount,oldNumberOfAttempts)
                .switchToEditTestModalWindow(oldTestName)
                .fillAllTestFieldsAndSubmitForm(newTestName,newTaskCount,newTimeCount,newNumberOfAttempts)
                .navigateToQuestionPage(newTestName)
                .addQuestionWithAnswers(questions)
                .navigateToEditQuestionPage(getQuestion1())
                .editQuestion(getQuestion2())
                 .clickSubjectLink()
                 .navigateToTestOfSubjectPage(newName)
                 .navigateToSettingsTestPage(newTestName)
                 .addTestSettings(settings)
                 .clickSubjectLink()
                 .navigateToTestSchedulePage(newName)
                 .switchToAddNewScheduleModalWindow()
                 .fillAllScheduleFieldsAndSubmitForm(groupName,startDate,endDate,startTime,endTime);

        Assert.assertTrue(scheduleTestingPage.verifyScheduleAdded(groupName), "Isn't present");




        /*Assert.assertTrue(testPage.verifyTestEdited(newTestName), "Isn't exist");*/


    }
    @Test(dataProvider = "deleteNewTest", dataProviderClass = DataForCreatingSubjectAndTests.class, priority = 2, groups = {"deleteNewTest"})
    public void verifyDeletingTestAndSubject(IUser validAdmin,
                           String newName,
                           String newTestName,
                           List<NewQuestion> questions,
                           List<TestSettings> settings,
                           String groupName

    ) {
        SubjectPage subjectPage = loadSignInPage()
                .successfulAdminLogin(validAdmin)
                .clickSubjectLink()
                .navigateToTestOfSubjectPage(newName)
                .navigateToSettingsTestPage(newTestName)
                .deleteTestsSettings(settings)
                .backToTestPage()
                .navigateToQuestionPage(newTestName)
                .deleteTestsQuestions(questions)
                .backToTestPage()
                .switchToDeleteTestModalWindow(newTestName)
                .deleteTest()
                .clickExitsButton()
                .backToSubjectPage()
                .navigateToTestSchedulePage(newName)
                .switchToDeleteScheduleModalWindow(groupName)
                .deleteSchedule()
                .backToSubjectPage()
                .switchToDeleteSubjectModalWindow(newName)
                .deleteSubject();
        Assert.assertTrue(subjectPage.verifySubjectRemoved(newName), "Exist");
    }

        @Test(dataProvider = "failDeleting", dataProviderClass = DataForCreatingSubjectAndTests.class, priority = 3, groups = {"deletingItems"})
        public void verifyFailDeletingItems(IUser validAdmin,
            String facultyName,
            String specialityName,
            String groupName,
            String subjectName,
            String testName

    )
        {
           InformModalWindow informModalWindow = loadSignInPage()
                    .successfulAdminLogin(validAdmin)
                    .clickFacultiesLink()
                    .switchToDeleteFacultiesModalWindow(facultyName)
                    .switchToFacultiesInformModalWindow();
            Assert.assertTrue(informModalWindow.isTextPresent(), "Inform Window isn't present");
                    informModalWindow.clickExitButtonAndSwitchToFacultyPage()
                            .clickSpecialityLink()
                            .switchToDeleteSpecialityModalWindow(specialityName)
                            .switchToSpecialityInformWindow();
            Assert.assertTrue(informModalWindow.isTextPresent(), "Inform Window isn't present");
                            informModalWindow.clickExitButtonAndSwitchToSpecialityPage()
                                    .clickGroupLink()
                                    .switchToDeleteGroupModalWindow(groupName)
                                    .switchToGroupInformModalWindow();
            Assert.assertTrue(informModalWindow.isTextPresent(), "Inform Window isn't present");
                            informModalWindow.clickExitButtonAndSwitchToGroupPage()
                                    .clickSubjectLinks()
                                    .navigateToTestOfSubjectPage(subjectName)
                                    .switchToDeleteTestModalWindow(testName)
                                    .deleteTest();
            Assert.assertTrue(informModalWindow.isTextPresent(), "Inform Window isn't present");
                            informModalWindow.clickExitButton()
                                    .clickSubjectLink()
                                    .switchToDeleteSubjectModalWindow(subjectName)
                                    .switchToSubjectInformModalWindow();
            Assert.assertTrue(informModalWindow.isTextPresent(), "Inform Window isn't present");


    }
    @Test(dataProvider = "addNewTest", dataProviderClass = DataForCreatingSubjectAndTests.class, priority = 2, groups = {"addNewSubjectAndTest"})
    public void addNewTest2(IUser validAdmin,
                           String oldName,
                           String oldDesc,
                           String newName,
                           String newDesc,
                           String oldTestName,
                           int oldTaskCount,
                           int oldTimeCount,
                           int oldNumberOfAttempts,
                           String newTestName,
                           int newTaskCount,
                           int newTimeCount,
                           int newNumberOfAttempts,
                           List<NewQuestion> questions,
                           List<TestSettings> settings
    )
    {
        loadSignInPage()
                .successfulAdminLogin(validAdmin)
                .clickSubjectLink()
                .navigateToTestOfSubjectPage(newName)
                .navigateToSettingsTestPage(newTestName)
                .addTestSettings(settings);






    }

    @Test(dataProvider = "failCreatingSubject", dataProviderClass = DataForCreatingSubjectAndTests.class, priority = 3, groups = {"failCreatingSubject"})
    public void verifyValidationOnAddNewSubjectModalWindow(IUser validAdmin

    ) {
        AddSubjectModalWindow subjectModalWindow = loadSignInPage()
                .successfulAdminLogin(validAdmin)
                .clickSubjectIcon()
                .switchAddNewSubjectToModalWindow()
                .fillInvalidSubjectData(emptyField());
        Assert.assertFalse(subjectModalWindow.isSubmitButtonEnabled(), "Is enabled");
        subjectModalWindow.fillInvalidSubjectData(numbers());
        Assert.assertFalse(subjectModalWindow.isSubmitButtonEnabled(), "Is enabled");
        subjectModalWindow.fillInvalidSubjectData(englishSymbols());
        Assert.assertFalse(subjectModalWindow.isSubmitButtonEnabled(), "Is enabled");
        InformModalWindow informModalWindow = subjectModalWindow.fillInvalidSubjectDataAndClickSubmitButton(existSubject());
        Assert.assertTrue(informModalWindow.isTextPresent(), "Isn't present");


    }



   /* @Test(dataProvider = "results", dataProviderClass = DataForCreatingSubjectAndTests.class, priority = 4, groups = {"results"})
    public void verifyTestResults(IUser validAdmin,
                                  IStudent student,
                                  String groupId,
                                  String  testName,
                                  String result

    ) {
        ResultsPage resultsPage = loadSignInPage()
                .successfulAdminLogin(validAdmin)
                .clickResultsLink()
                .showTestResults(groupId,testName);
        Assert.assertTrue(resultsPage.verifyStudentResults(student,result), "isn't equal");



    }*/

}
