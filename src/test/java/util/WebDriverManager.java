package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverManager {
    private static WebDriver driver;
    public static final String TYPE_OF_DRIVER = "webdriver.chrome.driver";
    public static final String PATH_TO_DRIVER = "C:\\chromedriver.exe";
    public static final String INDEX_PAGE_URL = "https://parabank.parasoft.com/parabank";



    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty(TYPE_OF_DRIVER, PATH_TO_DRIVER);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
