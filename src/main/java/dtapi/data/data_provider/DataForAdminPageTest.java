package dtapi.data.data_provider;

import dtapi.data.admin.AdminRepository;
import dtapi.data.enums.Pagination;
import dtapi.data.subject.NewSubjectRepository;
import dtapi.data.test.NewTestRepository;
import dtapi.data.user.UserRepository;
import dtapi.pages.*;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataForAdminPageTest {
    @DataProvider(name = "dataAdminPageTests")
    public static Object[][] dataForSortLoginTests(Method method) {
        String testCase = method.getName();
        if ("verifyNavigationThroughTabs".equalsIgnoreCase(testCase)) {
            return new Object[][]{{
                    UserRepository.get().getAdmin(), SubjectPage.PAGE_TITLE, SpecialityPage.PAGE_TITLE, FacultiesPage.PAGE_TITLE, GroupPage.PAGE_TITLE, ResultsPage.PAGE_TITLE, AdminsPage.PAGE_TITLE, AdminHomePage.PAGE_TITLE}};
        } else {
            return new Object[][]{{"ERROR: Data Provider can't find method: " + testCase}};
        }
    }

    @DataProvider
    public Object[][] addNewBlogSubject(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewSubjectRepository.blog().getSubjectName(),
                        NewSubjectRepository.blog().getSubjectDesc(), UserRepository.get().getUser(), "Розклад Тестування", Pagination.THE_LAST_PAGE}
        };
    }

    @DataProvider
    public Object[][] addNewPhotoSubject(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewSubjectRepository.photo().getSubjectName(),
                        NewSubjectRepository.photo().getSubjectDesc(), Pagination.THE_LAST_PAGE}
        };
    }

    @DataProvider
    public Object[][] addNewTest(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewSubjectRepository.planet().getSubjectName(),
                        NewSubjectRepository.planet().getSubjectDesc(),
                        NewTestRepository.photos().getTestName(),
                        NewTestRepository.photos().getTaskCount(),
                        NewTestRepository.photos().getTime(),
                        NewTestRepository.photos().getNumberOfAttempts(),
                        NewTestRepository.planets().getTestName(),
                        NewTestRepository.planets().getTaskCount(),
                        NewTestRepository.planets().getTime(),
                        NewTestRepository.planets().getNumberOfAttempts()}
        };
    }
    @DataProvider
    public Object[][] addNewAdmin(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        AdminRepository.get().getFirstAdmin(),
                        AdminRepository.get().getSecondAdmin()

                }
        };
    }
    @DataProvider
    public Object[][] validationCreatingAdmin(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        AdminRepository.get().getAdminWithEmptyFields(),
                        AdminRepository.get().getAdminWithInvalidLogin(),
                        AdminRepository.get().getAdminWithInvalidConfirmPassword()



                }
        };
    }
}
