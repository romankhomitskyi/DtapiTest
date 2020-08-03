package dtapi.data.enums;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

    public enum Browsers {
        CHROME {
            public WebDriver create(){
                /*System.setProperty("webdriver.chrome.driver", "D:\\Intellij IDEA\\testgroup\\drivers\\chromedriver.exe");*/

                ChromeOptions options = new ChromeOptions();
                options.addArguments("test-type");

                options.addArguments("--disable-web-security");
                options.addArguments("--allow-running-insecure-content");
                options.setCapability("chrome.binary", "./src//lib//chromedriver");
                options.setCapability(ChromeOptions.CAPABILITY, options);


                return new ChromeDriver(options);
            }
        },
        IE {
            public WebDriver create(){
                return new InternetExplorerDriver();
            }
        },
        FIREFOX {
            public WebDriver create() {
                System.setProperty("webdriver.gecko.driver", "D:\\Intellij IDEA\\testgroup\\drivers\\geckodriver.exe");
                return new FirefoxDriver();
            }
        };

        public WebDriver create(){
            return null;
        }
    }

