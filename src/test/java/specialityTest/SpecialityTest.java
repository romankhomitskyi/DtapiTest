package specialityTest;

import dtapi.data.data_provider.DataForCreatingSpeciality;
import dtapi.data.user.IUser;
import dtapi.dtapiBase.TestUtilities;
import dtapi.pages.SpecialityPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpecialityTest extends TestUtilities {


    @Test(dataProvider = "crudOnSpecialityPage", dataProviderClass = DataForCreatingSpeciality.class, priority = 2, groups = {"crudOnSpecialityPage"})
    public void verifyCrudOnSpecialityPage(IUser validAdmin,
                                  int oldSpecialityCode,
                                  String oldSpecialityName,
                                  int newSpecialityCode,
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




}
