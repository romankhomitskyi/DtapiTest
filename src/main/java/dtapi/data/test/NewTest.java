package dtapi.data.test;

public class NewTest {
    private String testName;
    private int taskCount;
    private int time;
    private int numberOfAttempts;


    public NewTest(String testName, int taskCount, int time, int numberOfAttempts) {
        this.testName = testName;
        this.taskCount = taskCount;
        this.time = time;
        this.numberOfAttempts = numberOfAttempts;

    }


    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(int taskCount) {
        this.taskCount = taskCount;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void setNumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }
}
