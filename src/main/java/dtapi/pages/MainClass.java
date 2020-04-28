package dtapi.pages;

import org.openqa.selenium.WebDriver;

public class MainClass {
    static WebDriver driver;

    public static void main(String[] args) {
        /*System.setProperty("webdriver.chrome.driver", "D:\\Intellij IDEA\\testgroup\\drivers\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://dtapi.if.ua/login");
        //dtapi.pages.MainPage mainPage = new dtapi.pages.MainPage(driver);
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickLanguageButton("Eng");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(mainPage.getLanguageButtonText());
        System.out.println(mainPage.getLoginButtonText());
        System.out.println(mainPage.getPasswordFieldText());
        System.out.println(mainPage.getLoginFieldText());
        mainPage.login("yurik","qwerty123");
        System.out.println(driver.getCurrentUrl());*/


    }
}
