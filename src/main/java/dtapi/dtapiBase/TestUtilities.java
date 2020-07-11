package dtapi.dtapiBase;

public class TestUtilities extends BaseTest {
    protected void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
