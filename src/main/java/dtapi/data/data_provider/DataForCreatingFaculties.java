package dtapi.data.data_provider;

import dtapi.data.enums.Pagination;
import dtapi.data.faculties.NewFaculties;
import dtapi.data.faculties.NewFacultiesRepository;
import dtapi.data.user.UserRepository;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class DataForCreatingFaculties {
    @DataProvider
    public Object[][] crudOperationsOnFacultyPage(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewFacultiesRepository.filologiya().getFacultiesName(),
                        NewFacultiesRepository.filologiya().getFacultiesDesc(),
                        NewFacultiesRepository.financy().getFacultiesName(),
                        NewFacultiesRepository.financy().getFacultiesDesc()}
        };

    }


    @DataProvider
    public Object[][] editNewFaculty(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewFacultiesRepository.filologiya().getFacultiesName(),
                        NewFacultiesRepository.financy().getFacultiesName(),
                        NewFacultiesRepository.financy().getFacultiesDesc(),
                        Pagination.THE_LAST_PAGE}
        };
    }

    @DataProvider
    public Object[][] deleteNewFaculty(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewFacultiesRepository.financy().getFacultiesName(),
                        Pagination.THE_LAST_PAGE}
        };
    }

    @DataProvider
    public Object[][] addNewFaculty2(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewFacultiesRepository.phisoloh().getFacultiesName(),
                        NewFacultiesRepository.phisoloh().getFacultiesDesc(), Pagination.THE_LAST_PAGE}
        };
    }
    @DataProvider
    public Object[][] failCreatingFaculty(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        }
        };
    }


    private List<NewFaculties> invalidDataList() {
        List<NewFaculties> invalidData = new ArrayList<>();
        invalidData.add(NewFacultiesRepository.emptyField());
        invalidData.add(NewFacultiesRepository.numbers());
        invalidData.add(NewFacultiesRepository.lowerCase());
        invalidData.add(NewFacultiesRepository.englishSymbols());
        return invalidData;
    }
    private List<NewFaculties> getInvalidDataList(){
        return invalidDataList();
    }

    @DataProvider(name = "invalidDataList")
    public Object[][] invalidDataForCreatingFacultyProvider() {
        return getInvalidDataList().stream()
                .map(student -> new Object[]{student})
                .toArray(Object[][]::new);
    }
}
