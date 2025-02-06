package bdd.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertFalse;
import static util.WebDriverManager.*;

public class CustomerLoginSteps {
    WebDriver driver;


    @Given("I am on the Customer Login page")
    public void iAmOnTheCustomerLoginPage() {
        System.setProperty(TYPE_OF_DRIVER, PATH_TO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(INDEX_PAGE_URL);
    }

    @When("I click on the Log In button")
    public void iClickOnTheLogInButton() {
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
    }

    @Then("the button should be clickable and responsive")
    public void theButtonShouldBeClickableAndResponsive() {
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        assertTrue(loginButton.isEnabled());
        driver.quit();
    }

    @When("I enter {string} in the Username field")
    public void iEnterInTheUsernameField(String username) {
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    @Then("the Username field should accept the text")
    public void theUsernameFieldShouldAcceptTheText() {
        WebElement usernameField = driver.findElement(By.name("username"));
        assertTrue(usernameField.getAttribute("value").length() > 0);
    }

    @When("I do not enter any data")
    public void iDoNotEnterAnyData() {
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("password")).clear();
    }

    @Then("the Log In button should be disabled")
    public void theLogInButtonShouldBeDisabled() {
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        assertFalse(loginButton.isEnabled());
        driver.quit();
    }

    @When("I enter {string} in the Username field as invalid input")
    public void iEnterInvalidInput(String invalidUsername) {
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.clear();
        usernameField.sendKeys(invalidUsername);
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        WebElement errorMsg = driver.findElement(By.className("error"));
        assertTrue(errorMsg.isDisplayed());
        driver.quit();
    }
}