package dtapi.data.testSettings;

public class TestSettings {
    private String testLvls;
    private String tasks;
    private String rate;


    public TestSettings(String testLvls, String tasks, String rate) {
        this.testLvls = testLvls;
        this.tasks = tasks;
        this.rate = rate;
    }



    public String getTestLvls() {
        return testLvls;
    }

    public void setTestLvls(String testLvls) {
        this.testLvls = testLvls;
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
