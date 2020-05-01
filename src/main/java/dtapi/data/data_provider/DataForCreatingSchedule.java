package dtapi.data.data_provider;

import dtapi.data.group.NewGroupRepository;
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
                        NewGroupRepository.geoAndMed().getGroupId(),
                        NewScheduleRepository.schedule().getStartDate(),
                        NewScheduleRepository.schedule().getEndDate(),
                        NewScheduleRepository.schedule().getStartTime(),
                        NewScheduleRepository.schedule().getEndTime()}
        };
    }
}
