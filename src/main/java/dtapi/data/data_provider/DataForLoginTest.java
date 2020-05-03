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
        } else if ("failLogin".equalsIgnoreCase(testCase)) {
            return new Object[][]{
                    {UserRepository.get().getInvalidUser(),
                            MainPage.ERROR_MESSAGE,
                            UserRepository.get().getInvalidUser2(),
                            UserRepository.get().getInvalidUser3()
                    },
            };
        } else {
            return new Object[][]{{"ERROR: Data Provider can't find method: " + testCase}};
        }
    }
}
