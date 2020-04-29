package subjectsTests;

import dtapi.data.data_provider.DataForCreatingSubjectAndTests;
import dtapi.data.question.NewQuestion;
import dtapi.data.testSettings.TestSettings;
import dtapi.data.user.IUser;
import dtapi.dtapiBase.TestUtilities;
import org.testng.annotations.Test;

import java.util.List;

public class SubjectTest extends TestUtilities {
    /**
     * loading application, logging in, click subject icon, switching to new subject modal window
     * filling all fields, finding created subject, clicking on test of suject icon, switching to
     * new test modal window and filling all fields and then finding new test
     * <p>
     * param  validAdmin from UserRepository
     * param name from NewSubjectRepository
     * param desc from NewSubjectRepository
     * param Pagination from Enum class
     * param taskCount from NewTestRepository
     * param timeCount from NewTestRepository
     * param numberOfAttempts from NewTestRepository
     */
    /*@Test(dataProvider = "addNewTest", dataProviderClass = DataForCreatingSubjectAndTests.class, priority = 2, groups = {"addNewSubjectAndTest"})
    public void addNewTest(IUser validAdmin,
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
                           List<NewQuestion> questions
    )
    {
         loadSignInPage()
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
                .addQuestionWithAnswers(questions);


       *//* Assert.assertTrue(testPage.verifyTestEdited(newTestName), "Isn't exist");*//*


    }*/
    @Test(dataProvider = "addNewTest", dataProviderClass = DataForCreatingSubjectAndTests.class, priority = 2, groups = {"addNewSubjectAndTest"})
    public void addNewTest(IUser validAdmin,
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
                .clickSubjectIcon()
               /* .navigateToTestOfSubjectPage(newName)
                .navigateToQuestionPage(newTestName)
                .addQuestionWithAnswers(questions)
                .navigateToEditQuestionPage(getQuestion1())
                .editQuestion(getQuestion2())
                .clickSubjectLink()*/
                .navigateToTestOfSubjectPage(newName)
                .navigateToSettingsTestPage(newTestName)
                .addTestSettings(settings);



        /* Assert.assertTrue(testPage.verifyTestEdited(newTestName), "Isn't exist");*/


    }






}
