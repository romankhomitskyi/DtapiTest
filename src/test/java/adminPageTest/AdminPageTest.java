package adminPageTest;

import dtapi.data.data_provider.DataForAdminPageTest;
import dtapi.data.user.IUser;
import dtapi.dtapiBase.TestUtilities;
import dtapi.pages.*;
import org.testng.Assert;

public class AdminPageTest extends TestUtilities {

    /**
     * loading application, logging in, click subject Icon, going to subject Page,
     * getting title text and verifying, click speciality tab going to speciality page
     * getting title text and verifying
     *
     * param  validAdmin from UserRepository
     * param subjectTitle from SubjectPage
     * param specialityTitle product from SpecialityPage
     */
    @org.testng.annotations.Test(dataProvider = "dataAdminPageTests", dataProviderClass = DataForAdminPageTest.class, priority = 1, groups = {"smokeTest"})
    public void verifyNavigationThroughTabs(IUser validAdmin, String subjectTitle, String specialityTitle,String facultyTitle, String groupTitle,String resultTitle,String adminTitle,String homeTitle) {
        SubjectPage subjectPage = loadSignInPage()
                .successfulAdminLogin(validAdmin)
                .clickSubjectIcon();
        sleep(1000);
        String subjectTitleActual = subjectPage.getPageTitleText();
        Assert.assertTrue(subjectTitleActual.contains(subjectTitle), "Does not contain. \nActual" + subjectTitleActual + "\n Expected" + subjectTitle);
        SpecialityPage specialityPage =subjectPage.clickSpecialityLink();
        sleep(1000);
        String specialityTitleActual = specialityPage.getPageTitleText();
        Assert.assertTrue(specialityTitleActual.contains(specialityTitle), "Does not contain. \nActual" + specialityTitleActual + "\n Expected" + specialityTitle);
         FacultiesPage facultiesPage = specialityPage.clickFacultiesLink();
         sleep(1000);
         String faculityTitle = facultiesPage.getFacultiesPageTitleText();
        Assert.assertTrue(faculityTitle.contains(facultyTitle), "Does not contain. \nActual" + specialityTitleActual + "\n Expected" + specialityTitle);
        GroupPage groupsPage = facultiesPage.clickGroupLink();
        sleep(1000);
        String groupsTitle = groupsPage.getGroupPageTitleText();
        Assert.assertTrue(groupsTitle.contains(groupTitle), "Does not contain. \nActual" + specialityTitleActual + "\n Expected" + specialityTitle);
        ResultsPage resultsPage = groupsPage.clickResultsLink();
        sleep(1000);
        String resultPageTitle = resultsPage.getResultsPageTitleText();
        Assert.assertTrue(resultPageTitle.contains(resultTitle), "Does not contain. \nActual" + specialityTitleActual + "\n Expected" + specialityTitle);
        AdminsPage adminsPage = resultsPage.clickAdminsLink();
        sleep(1000);
        String adminsPageTitle = adminsPage.getAdminsPageTitleText();
        Assert.assertTrue(adminsPageTitle.contains(adminTitle), "Does not contain. \nActual" + specialityTitleActual + "\n Expected" + specialityTitle);
        AdminHomePage adminHomePage = adminsPage.clickHomeLink();
        sleep(1000);
        String homePageTitle = adminHomePage.getAdminPageTitleText();
        Assert.assertTrue(homePageTitle.contains( homeTitle), "Does not contain. \nActual" + specialityTitleActual + "\n Expected" + specialityTitle);

    }







    //takeScreenshot("login");
}

