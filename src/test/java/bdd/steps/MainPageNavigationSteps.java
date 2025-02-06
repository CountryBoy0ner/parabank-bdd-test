package bdd.steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AdminPage;
import page.MainPage;
import util.WebDriverManager;


import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class MainPageNavigationSteps {
    WebDriver driver = WebDriverManager.getDriver();
    MainPage mainPage = new MainPage(driver);
    AdminPage adminPage = new AdminPage(driver);

    @Given("I am on the main page")
    public void iAmOnTheMainPage() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @When("I click on the {string} link")
    public void iClickOnTheLink(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        link.click();
    }

    @Then("I should be navigated to the about page")
    public void iShouldBeNavigatedToTheAboutPage() {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("about.htm"));
    }

    @Then("I should be navigated to the Parasoft website")
    public void iShouldBeNavigatedToTheParasoftWebsite() {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("parasoft.com"));
    }

    @When("I click the browser back button")
    public void iClickTheBrowserBackButton() {
        driver.navigate().back();
    }

    @Then("I should be navigated back to the about page")
    public void iShouldBeNavigatedBackToTheAboutPage() {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("about.htm"));
    }

    @When("I click on the logo")
    public void iClickOnTheLogo() {
        WebElement logo = driver.findElement(By.cssSelector("img[title='ParaBank']"));
        logo.click();
    }

    @Then("I should be navigated to the home page")
    public void iShouldBeNavigatedToTheHomePage() {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.equals("https://parabank.parasoft.com/parabank/index.htm"));
    }

    @Then("I should see the element with class {string}")
    public void iShouldSeeTheElementWithClass(String className) {
        WebElement element = driver.findElement(By.cssSelector("." + className));
        assertTrue(element.isDisplayed());
    }

    @Then("I should be navigated to the admin page")
    public void iShouldBeNavigatedToTheAdminPage() {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("admin.htm"));
    }

    @When("I scroll down until the submit button is visible")
    public void iScrollDownUntilTheSubmitButtonIsVisible() {
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
    }

    @When("I click on the submit button")
    public void iClickOnTheSubmitButton() {
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit'][value='Submit']"));
        submitButton.click();
    }

    @Then("I should see the message {string}")
    public void iShouldSeeTheMessage(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'Settings saved successfully.')]")));

        String actualMessage = messageElement.getText();
        System.out.println("Expected message: " + message);
        System.out.println("Actual message: " + actualMessage);
        assertTrue(actualMessage.trim().equals(message.trim()));

    }
}
