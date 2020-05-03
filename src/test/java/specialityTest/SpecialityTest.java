package specialityTest;

import dtapi.data.data_provider.DataForCreatingSpeciality;
import dtapi.data.user.IUser;
import dtapi.dtapiBase.TestUtilities;
import dtapi.modalsWindows.AddNewSpecialityModalWindow;
import dtapi.pages.SpecialityPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static dtapi.data.speciality.NewSpecialityRepository.*;

public class SpecialityTest extends TestUtilities {


    @Test(dataProvider = "crudOnSpecialityPage", dataProviderClass = DataForCreatingSpeciality.class, priority = 1, groups = {"crudOnSpecialityPage"})
    public void verifyCrudOnSpecialityPage(IUser validAdmin,
                                  String oldSpecialityCode,
                                  String oldSpecialityName,
                                           String newSpecialityCode,
                                  String newSpecialityName

    ) {
        SpecialityPage specialityPage = loadSignInPage()
                .successfulAdminLogin(validAdmin)
                .clickSpecialityLink()
                .switchToAddNewSpecialityModalWindow()
                .fillAllSpecialityFieldsAndSubmitForm(oldSpecialityCode, oldSpecialityName);
        Assert.assertTrue(specialityPage.verifySpecialityAdded(oldSpecialityName), "Isn't exist");
                specialityPage.switchToEditFacultyModalWindow(oldSpecialityName)
                        .fillAllSpecialityFieldsAndSubmitForm(newSpecialityCode,newSpecialityName);
        Assert.assertTrue(specialityPage.verifySpecialityEdited(newSpecialityName), "Isn't edited");
                specialityPage.switchToDeleteSpecialityModalWindow(newSpecialityName)
                        .deleteSpeciality();
        Assert.assertTrue(specialityPage.verifySpecialityRemoved(newSpecialityName), "Exist");
    }
    @Test(dataProvider = "failCreatingSpeciality", dataProviderClass = DataForCreatingSpeciality.class, priority = 2, groups = {"failCreatingSpeciality"})
    public void verifyValidationOnAddNewSpecialityModalWindow(IUser validAdmin

    ) {
        AddNewSpecialityModalWindow specialityPage = loadSignInPage()
                .successfulAdminLogin(validAdmin)
                .clickSpecialityLink()
                .switchToAddNewSpecialityModalWindow()
                .fillInvalidSpecialityData(emptyField());
        Assert.assertTrue(specialityPage.isErrorDisplayed(), "Is enabled");
        specialityPage.fillInvalidSpecialityData(englishSymbols());
        Assert.assertTrue(specialityPage.isErrorDisplayed(), "Is enabled");
        specialityPage.fillInvalidSpecialityData(numbers());
        Assert.assertTrue(specialityPage.isErrorDisplayed(), "Is enabled");



    }





}
