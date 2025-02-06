package bdd.steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import page.MainPage;
import page.RegistrationPage;
import util.WebDriverManager;

import static org.testng.AssertJUnit.assertTrue;

public class NavigationSteps {
    WebDriver driver = WebDriverManager.getDriver();
    MainPage mainPage = new MainPage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);

    @Given("the user is on the Login page")
    public void theUserIsOnTheLoginPage() {
        driver.get("https://parabank.parasoft.com");
    }

    @When("the user clicks on the {string} link")
    public void theUserClicksOnTheLink(String linkText) {
        if (linkText.equals("Register")) {
            driver.findElement(org.openqa.selenium.By.linkText("Register")).click();
        }
    }

    @Then("the user should be redirected to the Registration page")
    public void theUserShouldBeRedirectedToTheRegistrationPage() {
        assertTrue(driver.getCurrentUrl().contains("register.htm"));
    }

    @Then("the registration form should be displayed")
    public void theRegistrationFormShouldBeDisplayed() {
        assertTrue(registrationPage.isRegistrationFormDisplayed());
    }
}
