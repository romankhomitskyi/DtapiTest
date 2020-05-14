package dtapi.dtapiBase;

import dtapi.pages.MainPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.concurrent.TimeUnit;

@Listeners({dtapi.dtapiBase.TestListener.class})
public class BaseTest {
    protected RemoteWebDriver driver;
    protected Logger log;

    protected String testSuiteName;
    protected String testName;
    protected String testMethodName;

    protected void openUrl(String url) {
        driver.get(url);
    }

    @Parameters({"browser", "url"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, @Optional("chrome") String browser, String url, ITestContext ctx) throws Exception {
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("80.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");

        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        capabilities.setCapability("chrome.binary", "./src//lib//chromedriver");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new RemoteWebDriver(
                URI.create("http://192.168.99.106:4444/wd/hub").toURL(),
                capabilities
        );
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
        sleep(2000);
        driver.quit();
    }
}

