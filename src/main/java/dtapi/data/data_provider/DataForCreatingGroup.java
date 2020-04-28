package dtapi.data.data_provider;

import dtapi.data.enums.Pagination;
import dtapi.data.faculties.NewFacultiesRepository;
import dtapi.data.group.NewGroupRepository;
import dtapi.data.speciality.NewSpecialityRepository;
import dtapi.data.user.UserRepository;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataForCreatingGroup {
    @DataProvider
    public Object[][] addNewGroup(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewGroupRepository.entoAndSocio().getGroupId(),
                        NewSpecialityRepository.pravo().getNameSpeciality(),
                        NewFacultiesRepository.phisoloh().getFacultiesName(), Pagination.THE_LAST_PAGE}
        };
    }

    @DataProvider
    public Object[][] crudOnGroupPage(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewGroupRepository.entoAndSocio().getGroupId(),
                        NewSpecialityRepository.pravo().getNameSpeciality(),
                        NewFacultiesRepository.phisoloh().getFacultiesName(),
                        NewGroupRepository.geoAndMed().getGroupId(),
                        NewGroupRepository.geoAndMed().getGroupSpeciality(),
                        NewGroupRepository.geoAndMed().getGroupFaculty(),
                        Pagination.THE_LAST_PAGE}
        };
    }

    @DataProvider
    public Object[][] deleteNewGroup(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewGroupRepository.geoAndMed().getGroupId(),
                        Pagination.THE_LAST_PAGE}
        };
    }

    /*@DataProvider
    public Object[][] addNewGroup2(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewGroupRepository.mathAndProg().getGroupId(),
                        NewGroupRepository.mathAndProg().getGroupSpeciality(),
                        NewGroupRepository.mathAndProg().getGroupFaculty(),Pagination.THE_LAST_PAGE}
        };
    }*/
    @DataProvider
    public Object[][] addNewGroup2(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewGroupRepository.mathAndProg().getGroupId(),
                        NewSpecialityRepository.pravo().getNameSpeciality(),
                        NewFacultiesRepository.phisoloh().getFacultiesName(), Pagination.THE_LAST_PAGE}
        };
    }
}
