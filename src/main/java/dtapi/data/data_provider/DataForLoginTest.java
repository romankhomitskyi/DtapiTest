package dtapi.data.data_provider;

import dtapi.data.user.UserRepository;
import dtapi.pages.MainPage;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataForLoginTest {
    @DataProvider(name = "dataLoginTests")
    public static Object[][] dataForSortLoginTests(Method method) {
        String testCase = method.getName();
        if ("login".equalsIgnoreCase(testCase)) {
            return new Object[][]{{
                    UserRepository.get().getUser(),}};
        } else if ("failLoginWithInvalidPassword".equalsIgnoreCase(testCase)) {
            return new Object[][]{
                    {UserRepository.get().getInvalidUser(), MainPage.ERROR_MESSAGE},
            };
        } else if ("failLoginWithEmptyField".equalsIgnoreCase(testCase)) {
            return new Object[][]{
                    {UserRepository.get().getInvalidUser2(), MainPage.ERROR_MESSAGE},
            };

        } else if ("failLoginWithInvalidLogin".equalsIgnoreCase(testCase)) {
            return new Object[][]{
                    {UserRepository.get().getInvalidUser3(), MainPage.ERROR_MESSAGE},
            };

        } else if ("loginAdmin".equalsIgnoreCase(testCase)) {
            return new Object[][]{
                    {UserRepository.get().getAdmin()},
            };

        } else {
            return new Object[][]{{"ERROR: Data Provider can't find method: " + testCase}};
        }
    }
}
