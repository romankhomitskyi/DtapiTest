package takingTestTest;

import dtapi.data.data_provider.DataForCreatingSubjectAndTests;
import dtapi.data.user.IUser;
import dtapi.dtapiBase.TestUtilities;
import dtapi.pages.ResultsPage;
import dtapi.pages.TakingTestPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TakingTestPageTest extends TestUtilities {
     @Test(dataProvider = "results", dataProviderClass = DataForCreatingSubjectAndTests.class, priority = 4, groups = {"results"})
    public void verifyTestResults(IUser validAdmin,
                                  IUser validUser,
                                  String groupId,
                                  String  testName,
                                  String student


    ) {
        TakingTestPage testPage = loadSignInPage()
                .successfulLogin(validUser)
                .navigateToQuestionPage(testName);
         testPage.passTest();
                String result = testPage.getMark();
         ResultsPage resultsPage = testPage.clickExitButton()
                        .logOut()
                        .successfulAdminLogin(validAdmin)
                        .clickResultsLink()
                .showTestResults(groupId,testName);

        Assert.assertTrue(resultsPage.verifyStudentResults(result), "isn't equal");



    }

}
