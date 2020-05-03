package groupsTest;

import dtapi.data.data_provider.DataForCreatingGroup;
import dtapi.data.enums.Pagination;
import dtapi.data.user.IUser;
import dtapi.dtapiBase.TestUtilities;
import dtapi.modalsWindows.AddNewGroupModalWindow;
import dtapi.modalsWindows.InformModalWindow;
import dtapi.pages.GroupPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static dtapi.data.group.NewGroupRepository.*;
public class GroupsTests extends TestUtilities {
    @Test(dataProvider = "crudOnGroupPage", dataProviderClass = DataForCreatingGroup.class, priority = 1, groups = {"crudOnGroupPage"})
    public void verifyCrudOnGroupPage(IUser validAdmin,
                             String groupID,
                             String specialityName,
                             String facultyName,
                             String newGroupID,
                             String newSpecialityName,
                             String newFacultyName,
                             Pagination last) {
        GroupPage groupsPage = loadSignInPage()
                .successfulAdminLogin(validAdmin)
                .clickGroupLink()
                .switchToAddNewGroupModalWindow()
                .fillAllGroupFieldsAndSubmitForm(groupID,specialityName,facultyName);
        Assert.assertTrue(groupsPage.verifyGroupAdded(groupID), "Isn't exist");
                groupsPage.switchToEditGroupModalWindow(groupID)
                .fillAllGroupFieldsAndSubmitForm(newGroupID, newSpecialityName,newFacultyName);
        Assert.assertTrue(groupsPage.verifyGroupEdited(newGroupID), "Isn't edited");
       /* groupsPage.switchToDeleteGroupModalWindow(newGroupID)
                .deleteGroup();
        Assert.assertTrue(groupsPage.verifyGroupRemoved(newGroupID), "exist");*/

    }

    @Test(dataProvider = "addNewGroup2", dataProviderClass = DataForCreatingGroup.class, priority = 2, groups = {"verifyingGroupsFilters"})
    public void verifyGroupsFilters(IUser validAdmin,
                               String groupID,
                               String specialityName,
                               String facultyName,
                               Pagination last) {
        GroupPage groupsPage = loadSignInPage()
                .successfulAdminLogin(validAdmin)
                .clickGroupLink()
                .switchToViewGroupBySpecialityWindow()
                .setSpecialityFilterToTheTable(specialityName);

        Assert.assertTrue(groupsPage.verifyCorrectnessOfSpecialityFilter(specialityName), "Isn't present");
        groupsPage.switchToViewGroupByFacultyWindow()
                .setFacultyFilterToTheTable(facultyName);

        Assert.assertTrue(groupsPage.verifyCorrectnessOfFacultyFilter(facultyName), "Isn't present");
    }

    @Test(dataProvider = "failCreatingGroup", dataProviderClass = DataForCreatingGroup.class, priority = 3, groups = {"failCreatingGroup"})
    public void verifyValidationOnAddNewGroupModalWindow(IUser validAdmin,
                                                         String groupId,
                                                         String groupSpeciality,
                                                         String groupFaculty
                                    ) {
        AddNewGroupModalWindow groupModalWindow = loadSignInPage()
                .successfulAdminLogin(validAdmin)
                .clickGroupLink()
                .switchToAddNewGroupModalWindow()
                .fillInvalidGroupData(emptyGroupField());
        Assert.assertFalse(groupModalWindow.isSubmitButtonEnabled(), "Is enabled");
        InformModalWindow informModalWindow = groupModalWindow.fillInvalidGroupDataAndClickSubmitButton(groupId,groupSpeciality,groupFaculty);
        Assert.assertTrue(informModalWindow.isTextPresent(), "Isn't present");


    }

}
