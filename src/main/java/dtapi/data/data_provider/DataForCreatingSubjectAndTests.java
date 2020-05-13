package dtapi.data.data_provider;

import dtapi.data.enums.Pagination;
import dtapi.data.question.NewQuestion;
import dtapi.data.question.NewQuestionRepository;
import dtapi.data.schedule.NewScheduleRepository;
import dtapi.data.subject.NewSubjectRepository;
import dtapi.data.test.NewTestRepository;
import dtapi.data.testSettings.TestSettings;
import dtapi.data.testSettings.TestSettingsRepository;
import dtapi.data.user.UserRepository;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class DataForCreatingSubjectAndTests {
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
    public Object[][] failCreatingSubject(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                       }
        };
    }
    @DataProvider
    public Object[][] addNewTest(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        NewSubjectRepository.photo().getSubjectName(),
                        NewSubjectRepository.photo().getSubjectDesc(),
                        NewSubjectRepository.planet().getSubjectName(),
                        NewSubjectRepository.planet().getSubjectDesc(),
                        NewTestRepository.photos().getTestName(),
                        NewTestRepository.photos().getTaskCount(),
                        NewTestRepository.photos().getTime(),
                        NewTestRepository.photos().getNumberOfAttempts(),
                        NewTestRepository.planets().getTestName(),
                        NewTestRepository.planets().getTaskCount(),
                        NewTestRepository.planets().getTime(),
                        NewTestRepository.planets().getNumberOfAttempts(),
                        questionList(),
                        settingsList(),
                        NewScheduleRepository.schedule().getGroupName(),
                        NewScheduleRepository.schedule().getStartDate(),
                        NewScheduleRepository.schedule().getEndDate(),
                        NewScheduleRepository.schedule().getStartTime(),
                        NewScheduleRepository.schedule().getEndTime()
                        }
        };
    }

    private List<NewQuestion>  questionList() {
        List<NewQuestion> questions = new ArrayList<>();
        questions.add(NewQuestionRepository.getQuestion1());
        questions.add(NewQuestionRepository.getQuestion2());
        questions.add(NewQuestionRepository.getQuestion3());
        questions.add(NewQuestionRepository.getQuestion4());
        return questions;
    }
    private List<NewQuestion> getQuestionList(){
        return questionList();
    }

    @DataProvider(name = "questionList")
    public Object[][] questionProvider() {
        return getQuestionList().stream()
                .map(student -> new Object[]{student})
                .toArray(Object[][]::new);
    }

    private List<TestSettings>  settingsList() {
        List<TestSettings> settings = new ArrayList<>();
        settings.add(TestSettingsRepository.getSettings1());
        settings.add(TestSettingsRepository.getSetting2());
        settings.add(TestSettingsRepository.getSetting3());
        settings.add(TestSettingsRepository.getSetting4());
        settings.add(TestSettingsRepository.getSetting5());
        return settings;
    }
    private List<TestSettings> getSettingsList(){
        return settingsList();
    }

    @DataProvider(name = "settingsList")
    public Object[][] settingsProvider() {
        return getSettingsList().stream()
                .map(student -> new Object[]{student})
                .toArray(Object[][]::new);
    }
    @DataProvider
    public Object[][] results(Method method) {
        return new Object[][]{
                {UserRepository.get().getAdmin(),
                        UserRepository.get().getUser(),
                        "ІФ-105",
                        "New Test",
                        "Khomitskyi Yura igor"
                        }
        };
    }
}
