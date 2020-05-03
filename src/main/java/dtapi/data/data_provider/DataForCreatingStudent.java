package dtapi.data.data_provider;

import dtapi.data.group.NewGroupRepository;
import dtapi.data.student.StudentRepository;
import dtapi.data.user.UserRepository;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataForCreatingStudent {
    @DataProvider
    public Object[][] addNewStudent(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewGroupRepository.geoAndMed().getGroupId(),
                        StudentRepository.get().getFirstStudent(),
                        StudentRepository.get().getSecondStudent(),

                        NewGroupRepository.geoAndMed().getGroupSpeciality(),
                        NewGroupRepository.geoAndMed().getGroupFaculty(),

                        }
        };
    }
    @DataProvider
    public Object[][] validationCreatingStudents(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewGroupRepository.geoAndMed().getGroupId(),
                        StudentRepository.get().getStudentWithEmptyFields(),
                        StudentRepository.get().getStudentInvalidGradeBookId(),
                        StudentRepository.get().getStudentInvalidLogin(),
                        StudentRepository.get().getStudentInvalidConfirmPassword()



                }
        };
    }
}
