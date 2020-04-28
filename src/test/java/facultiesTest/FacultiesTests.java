package facultiesTest;

import dtapi.data.data_provider.DataForCreatingFaculties;
import dtapi.data.user.IUser;
import dtapi.dtapiBase.TestUtilities;
import dtapi.pages.FacultiesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FacultiesTests extends TestUtilities {
    @Test(dataProvider = "crudOperationsOnFacultyPage", dataProviderClass = DataForCreatingFaculties.class, priority = 1, groups = {"crudOperationsOnFacultypage"})
    public void verifyCrudOperations(IUser validAdmin,
                              String facultyName,
                              String facultyDesc,
                              String newFacultyName,
                              String newFacultyDesc

    ) {
        FacultiesPage facultiesPage = loadSignInPage()
                .successfulAdminLogin(validAdmin)
                .clickFacultiesLink()
                .switchToAddNewFacultiesModalWindow()
                .fillAllFacultiesFieldsAndSubmitForm(facultyName, facultyDesc);
        Assert.assertTrue(facultiesPage.verifyFacultyAdded(facultyName), "Isn't exist");
            facultiesPage.switchToEditFacultyModalWindow(facultyName)
                    .fillAllFacultiesFieldsAndSubmitForm(newFacultyName,newFacultyDesc);
        Assert.assertTrue(facultiesPage.verifyFacultyEdited(facultyName), "Isn't edited");
            facultiesPage.switchToDeleteFacultiesModalWindow(newFacultyName)
                    .deleteFaculties();
        Assert.assertTrue(facultiesPage.verifyFacultyRemoved(newFacultyName), "Exist");


    }




}

