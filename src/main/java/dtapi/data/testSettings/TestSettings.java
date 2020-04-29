package dtapi.data.testSettings;

import dtapi.data.enums.QuestionLvl;

public class TestSettings {
    private QuestionLvl questionLvl;
    private String tasks;
    private String rate;


    public TestSettings(QuestionLvl questionLvl, String tasks, String rate) {
        this.questionLvl = questionLvl;
        this.tasks = tasks;
        this.rate = rate;
    }


    public QuestionLvl getQuestionLvl() {
        return questionLvl;
    }

    public void setQuestionLvl(QuestionLvl questionLvl) {
        this.questionLvl = questionLvl;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
