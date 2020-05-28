package dtapi.dtapiBase;

import dtapi.pages.MainPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Listeners({dtapi.dtapiBase.TestListener.class})
public class BaseTest {
    protected WebDriver driver;
    protected Logger log;

    protected String testSuiteName;
    protected String testName;
    protected String testMethodName;

    protected void openUrl(String url) {
        driver.get(url);
    }

    @Parameters({"browser", "url"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, @Optional("chrome") String browser, String url, ITestContext ctx) {
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);
        BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
        driver = factory.createDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        openUrl(url);
        this.testSuiteName = ctx.getSuite().getName();
        this.testName = testName;
        this.testMethodName = method.getName();


    }


    public MainPage loadSignInPage() {
        return new MainPage(driver, log);

    }

    protected void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        sleep(1300);
        driver.quit();
    }


}

