package adminPageTest;

import dtapi.data.admin.IAdmin;
import dtapi.data.data_provider.DataForAdminPageTest;
import dtapi.data.user.IUser;
import dtapi.dtapiBase.TestUtilities;
import dtapi.modalsWindows.AddNewAdminModalWindow;
import dtapi.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

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

        String subjectTitleActual = subjectPage.getPageTitleText();
        Assert.assertTrue(subjectTitleActual.contains(subjectTitle), "Does not contain. \nActual" + subjectTitleActual + "\n Expected" + subjectTitle);
        SpecialityPage specialityPage =subjectPage.clickSpecialityLink();

        String specialityTitleActual = specialityPage.getPageTitleText();
        Assert.assertTrue(specialityTitleActual.contains(specialityTitle), "Does not contain. \nActual" + specialityTitleActual + "\n Expected" + specialityTitle);
         FacultiesPage facultiesPage = specialityPage.clickFacultiesLink();

         String faculityTitle = facultiesPage.getFacultiesPageTitleText();
        Assert.assertTrue(faculityTitle.contains(facultyTitle), "Does not contain. \nActual" + specialityTitleActual + "\n Expected" + specialityTitle);
        GroupPage groupsPage = facultiesPage.clickGroupLink();

        String groupsTitle = groupsPage.getGroupPageTitleText();
        Assert.assertTrue(groupsTitle.contains(groupTitle), "Does not contain. \nActual" + groupsTitle + "\n Expected" + groupTitle);
        ResultsPage resultsPage = groupsPage.clickResultsLink();

        String resultPageTitle = resultsPage.getResultsPageTitleText();
        Assert.assertTrue(resultPageTitle.contains(resultTitle), "Does not contain. \nActual" + specialityTitleActual + "\n Expected" + specialityTitle);
        AdminsPage adminsPage = resultsPage.clickAdminsLink();

        String adminsPageTitle = adminsPage.getAdminsPageTitleText();
        Assert.assertTrue(adminsPageTitle.contains(adminTitle), "Does not contain. \nActual" + specialityTitleActual + "\n Expected" + specialityTitle);
        AdminHomePage adminHomePage = adminsPage.clickHomeLink();

        String homePageTitle = adminHomePage.getAdminPageTitleText();
        Assert.assertTrue(homePageTitle.contains( homeTitle), "Does not contain. \nActual" + specialityTitleActual + "\n Expected" + specialityTitle);

    }

    @Test(dataProvider = "addNewAdmin", dataProviderClass = DataForAdminPageTest.class, priority = 2, groups = {"a addNewAdmin"})
    public void addNewAdmin(IUser validAdmin,
                              IAdmin fistAdmin,
                              IAdmin secondAdmin

    ) {
        AdminsPage adminsPage = loadSignInPage()
                .successfulAdminLogin(validAdmin)
                .clickAdminsLink()
                .switchToAddNewAdminModalWindow()
                .fillAllAdminFieldsAndSubmitForm(fistAdmin)
                .refreshPage();
        Assert.assertTrue(adminsPage.verifyAdminAdded(fistAdmin), "Isn't exist");
        adminsPage.switchToEditAdminModalWindow(fistAdmin)
                .fillAllAdminFieldsAndSubmitForm(secondAdmin)
                .refreshPage();
        Assert.assertTrue(adminsPage.verifyAdminEdited(secondAdmin), "Isn't edited");
        adminsPage.switchToDeleteAdminModalWindow(secondAdmin)
                .deleteAdmin()
                .refreshPage();
        Assert.assertTrue(adminsPage.verifyAdminRemoved(secondAdmin), "Isn't deleted");



    }
    @Test(dataProvider = "validationCreatingAdmin", dataProviderClass = DataForAdminPageTest.class, priority = 3, groups = {"validationCreatingStudents"})
    public void verifyValidationOnAddNewAdminModalWindow(IUser validAdmin,
                                                           IAdmin admin1,
                                                           IAdmin admin2,
                                                           IAdmin admin3



    ) {
        AddNewAdminModalWindow addNewAdminModalWindow = loadSignInPage()
                .successfulAdminLogin(validAdmin)
                .clickAdminsLink()
                .switchToAddNewAdminModalWindow()
                .fillInvalidDataInAdminFields(admin1);
        Assert.assertFalse(addNewAdminModalWindow.isAdminButtonEnabled(), "Is enabled");
        addNewAdminModalWindow.fillInvalidDataInAdminFields(admin2);
        Assert.assertFalse(addNewAdminModalWindow.isAdminButtonEnabled(), "Is enabled");
        addNewAdminModalWindow.fillInvalidDataInAdminFields(admin3);
        Assert.assertFalse(addNewAdminModalWindow.isAdminButtonEnabled(), "Is enabled");



    }





    //takeScreenshot("login");
}

