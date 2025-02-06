package page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By aboutUsLink = By.linkText("About Us");
    private By adminPageLink = By.linkText("Admin Page");
    private By logo = By.cssSelector("img[title='ParaBank']");

    public void clickAboutUs() {
        driver.findElement(aboutUsLink).click();
    }

    public void clickAdminPage() {
        driver.findElement(adminPageLink).click();
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }

    public boolean isOnHomePage() {
        return driver.getCurrentUrl().equals("https://parabank.parasoft.com/parabank/index.htm");
    }
}
