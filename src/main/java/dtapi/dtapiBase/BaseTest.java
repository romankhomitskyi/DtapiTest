package dtapi.dtapiBase;

import dtapi.data.enums.Browsers;
import dtapi.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public  abstract class BaseTest {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();

    }
    @Parameters({"url"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String url) {
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
        if (driver !=null) {
            sleep(1300);
            driver.quit();
        }
    }
}

