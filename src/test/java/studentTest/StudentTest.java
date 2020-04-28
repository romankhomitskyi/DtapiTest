package studentTest;

import dtapi.data.data_provider.DataForCreatingStudent;
import dtapi.data.student.IStudent;
import dtapi.data.user.IUser;
import dtapi.dtapiBase.TestUtilities;
import dtapi.modalsWindows.StudentDataModalWindow;
import dtapi.pages.StudentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StudentTest extends TestUtilities {
    @Test(dataProvider = "addNewStudent", dataProviderClass = DataForCreatingStudent.class, priority = 1, groups = {"addNewStudent"})
    public void addNewStudent(IUser validAdmin,
                              String groupID,
                              IStudent validStudent,
                              IStudent secondStudent,
                              String newSpecialityName,
                              String newFacultyName
    ) {
        StudentPage studentPage = loadSignInPage()
                .successfulAdminLogin(validAdmin)
                .clickGroupLink()
                .findNewGroupAndClickStudentInGroupIcon(groupID)
                .switchToAddNewStudentModalWindow()
                .fillAllStudentFieldsAndSubmitForm(validStudent);
        Assert.assertTrue(studentPage.verifyStudentAdded(validStudent), "Isn't exist");
                studentPage.switchToEditStudentModalWindow(validStudent)
                        .fillStudentNSFFieldsAndSubmitForm(secondStudent);
        Assert.assertTrue(studentPage.verifyStudentEdited(secondStudent), "Isn't edited");
             StudentDataModalWindow studModal = studentPage.switchToInformationAboutStudentModalWindow(secondStudent);
        Assert.assertTrue(studModal.verifyInformationAboutStudentAndCloseWindow(validStudent,secondStudent,newSpecialityName,newFacultyName,groupID), "Data are not equal");


    }
}
