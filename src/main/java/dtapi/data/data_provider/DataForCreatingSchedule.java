package dtapi.data.data_provider;

import dtapi.data.schedule.NewScheduleRepository;
import dtapi.data.subject.NewSubjectRepository;
import dtapi.data.user.UserRepository;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataForCreatingSchedule {
    @DataProvider
    public Object[][] addNewSchedule(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewSubjectRepository.planet().getSubjectName(),
                        NewScheduleRepository.schedule().getGroupName(),
                        NewScheduleRepository.schedule().getStartDate(),
                        NewScheduleRepository.schedule().getEndDate(),
                        NewScheduleRepository.schedule().getStartTime(),
                        NewScheduleRepository.schedule().getEndTime()}
        };
    }
    @DataProvider
    public Object[][] failCreatingSchedule(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewSubjectRepository.highMath().getSubjectName(),
                        NewScheduleRepository.invalidDate().getGroupName(),
                   }
        };
    }
}
