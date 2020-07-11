package dtapi.dtapiBase;

import dtapi.data.enums.Browsers;
import dtapi.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;


public class BaseTest {
    public WebDriver driver;

    @Parameters({"browser", "url"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, @Optional("chrome") String browser, String url, ITestContext ctx) {
        driver = Browsers.CHROME.create();
        driver.manage().window().maximize();
        openUrl(url);

    }


    public MainPage loadSignInPage() {
        return new MainPage(driver);

    }

    private void sleep(long n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void openUrl(String url) {
        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        sleep(1300);
        driver.quit();
    }
}

