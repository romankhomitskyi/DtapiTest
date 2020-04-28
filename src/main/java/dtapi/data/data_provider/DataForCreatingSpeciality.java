package dtapi.data.data_provider;

import dtapi.data.enums.Pagination;
import dtapi.data.speciality.NewSpecialityRepository;
import dtapi.data.user.UserRepository;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataForCreatingSpeciality {
    @DataProvider
    public Object[][] addNewSpeciality(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewSpecialityRepository.ciberSecurity().getCodeSpeciality(),
                        NewSpecialityRepository.ciberSecurity().getNameSpeciality(), Pagination.THE_LAST_PAGE}
        };
    }

    @DataProvider
    public Object[][] crudOnSpecialityPage(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewSpecialityRepository.ciberSecurity().getCodeSpeciality(),
                        NewSpecialityRepository.ciberSecurity().getNameSpeciality(),
                        NewSpecialityRepository.metalurgia().getCodeSpeciality(),
                        NewSpecialityRepository.metalurgia().getNameSpeciality(),
                       }
        };
    }

    @DataProvider
    public Object[][] deleteNewSpeciality(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewSpecialityRepository.metalurgia().getNameSpeciality(),
                        Pagination.THE_LAST_PAGE}
        };
    }

    @DataProvider
    public Object[][] addNewSpeciality2(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewSpecialityRepository.pravo().getCodeSpeciality(),
                        NewSpecialityRepository.pravo().getNameSpeciality(), Pagination.THE_LAST_PAGE}
        };
    }
}
