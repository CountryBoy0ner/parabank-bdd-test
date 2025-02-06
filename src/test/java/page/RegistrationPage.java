package page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By registrationForm = By.id("customerForm");

    public boolean isRegistrationFormDisplayed() {
        return driver.findElement(registrationForm).isDisplayed();
    }
}
