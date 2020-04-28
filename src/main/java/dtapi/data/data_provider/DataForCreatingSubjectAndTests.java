package dtapi.data.data_provider;

import dtapi.data.enums.Pagination;
import dtapi.data.question.NewQuestion;
import dtapi.data.question.NewQuestionRepository;
import dtapi.data.subject.NewSubjectRepository;
import dtapi.data.test.NewTestRepository;
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
                        questionList()
                        }
        };
    }

    private List<NewQuestion>  questionList() {
        List<NewQuestion> questions = new ArrayList<>();
        questions.add(NewQuestionRepository.getQuestion1());
        questions.add(NewQuestionRepository.getQuestion2());
        questions.add(NewQuestionRepository.getQuestion3());
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
    private List<NewQuestion>  questionList2() {
        List<NewQuestion> questions = new ArrayList<>();
        questions.add(NewQuestionRepository.getQuestion4());
        questions.add(NewQuestionRepository.getQuestion5());

        return questions;
    }
    private List<NewQuestion> getQuestionList2(){
        return questionList2();
    }
    @DataProvider(name = "questionList2")
    public Object[][] questionProvider2() {
        return getQuestionList2().stream()
                .map(student -> new Object[]{student})
                .toArray(Object[][]::new);
    }

}
