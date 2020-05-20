package facultiesTest;

import dtapi.data.data_provider.DataForCreatingFaculties;
import dtapi.data.user.IUser;
import dtapi.dtapiBase.TestUtilities;
import dtapi.modalsWindows.AddFacultiesModalWindow;
import dtapi.modalsWindows.InformModalWindow;
import dtapi.pages.FacultiesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static dtapi.data.faculties.NewFacultiesRepository.*;


public class FacultiesTests extends TestUtilities {
    @Test(dataProvider = "crudOperationsOnFacultyPage", dataProviderClass = DataForCreatingFaculties.class, priority = 1, groups = {"crudOperationsOnFacultypage"})
    public void verifyCrudOperationsOnFacultyPage(IUser validAdmin,
                              String facultyName,
                              String facultyDesc,
                              String newFacultyName,
                              String newFacultyDesc

    ) {
        FacultiesPage facultiesPage = loadSignInPage()
                .successfulAdminLogin(validAdmin)
                .clickFacultiesLink()
                .switchToAddNewFacultiesModalWindow()
                .fillAllFacultiesFieldsAndSubmitForm(filologiya());
        Assert.assertTrue(facultiesPage.verifyFacultyAdded(facultyName), "Isn't exist");
            facultiesPage.switchToEditFacultyModalWindow(facultyName)
                    .fillAllFacultiesFieldsAndSubmitForm(financy());
        Assert.assertTrue(facultiesPage.verifyFacultyEdited(facultyName), "Isn't edited");
            facultiesPage.switchToDeleteFacultiesModalWindow(newFacultyName)
                    .deleteFaculties();
        Assert.assertTrue(facultiesPage.verifyFacultyRemoved(newFacultyName), "Exist");


    }

    @Test(dataProvider = "failCreatingFaculty", dataProviderClass = DataForCreatingFaculties.class, priority = 2, groups = {"validation"})
    public void verifyValidationOnAddNewFacultyModalWindow(IUser validAdmin


    ) {
        AddFacultiesModalWindow facultiesModalWindow = loadSignInPage()
                .successfulAdminLogin(validAdmin)
                .clickFacultiesLink()
                .switchToAddNewFacultiesModalWindow()
                .fillInvalidFacultiesData(emptyField());
       Assert.assertFalse(facultiesModalWindow.isSubmitButtonEnabled(), "Is enabled");
        facultiesModalWindow.fillInvalidFacultiesData(englishSymbols());
        Assert.assertFalse(facultiesModalWindow.isSubmitButtonEnabled(), "Is enabled");
        facultiesModalWindow.fillInvalidFacultiesData(numbers());
        Assert.assertFalse(facultiesModalWindow.isSubmitButtonEnabled(), "Is enabled");
        InformModalWindow informModalWindow = facultiesModalWindow.fillInvalidFacultiesDataAndAndSubmitForm(existFaculty());
        Assert.assertTrue(informModalWindow.isTextPresent(), "Isn't present");




    }



}

