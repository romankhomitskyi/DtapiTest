package dtapi.dtapiBase;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserDriverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;
    private Logger log;

    public BrowserDriverFactory(String browser, Logger Log) {
        this.browser = browser.toLowerCase();
        this.log = Log;
    }

    public WebDriver createDriver() {
        // Create driver
        log.info("Create driver: " + browser);

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "D:\\Intellij IDEA\\testgroup\\drivers\\chromedriver.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("test-type");

                options.addArguments("--disable-web-security");
                options.addArguments("--allow-running-insecure-content");
                capabilities.setCapability("chrome.binary", "./src//lib//chromedriver");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);

                driver.set(new ChromeDriver(capabilities));
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "D:\\Intellij IDEA\\testgroup\\drivers\\geckodriver.exe");
                driver.set(new FirefoxDriver());
                break;

            default:
                System.out.println("Do not know how to start: " + browser + ", starting chrome.");
                System.setProperty("webdriver.chrome.driver", "D:\\Intellij IDEA\\testgroup\\drivers\\chromedriver.exe");
                driver.set(new ChromeDriver());
                break;
        }

        return driver.get();
    }


}
