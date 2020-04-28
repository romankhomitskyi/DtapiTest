package dtapi.data.data_provider;

import dtapi.data.enums.Pagination;
import dtapi.data.enums.RowsOnPage;
import dtapi.data.subject.NewSubjectRepository;
import dtapi.data.user.UserRepository;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataForPaginationTest {
    @DataProvider(name = "dataPaginationTests")
    public static Object[][] dataForSortSearchingTests(Method method) {
        String testCase = method.getName();
        if ("checkShowDropDownMenu".equalsIgnoreCase(testCase)) {
            return new Object[][]{{
                    UserRepository.get().getAdmin(),
                    RowsOnPage.FIVE,
                    RowsOnPage.TEN,
                    RowsOnPage.TWENTY}};
        } else if ("checkNavigation".equalsIgnoreCase(testCase)) {
            return new Object[][]{
                    {UserRepository.get().getAdmin(), Pagination.NEXT_PAGE, Pagination.THE_LAST_PAGE, Pagination.THE_FIRST_PAGE, Pagination.PREVIOUS_PAGE},
            };

        } else if ("checkUpdatePagination".equalsIgnoreCase(testCase)) {
            return new Object[][]{
                    {UserRepository.get().getAdmin(),
                            NewSubjectRepository.garden().getSubjectName(),
                            NewSubjectRepository.garden().getSubjectDesc(), RowsOnPage.FIVE},
            };

        } else {
            return new Object[][]{{"ERROR: Data Provider can't find method: " + testCase}};
        }
    }
}
//,Pagination.NEXT_PAGE, "next"