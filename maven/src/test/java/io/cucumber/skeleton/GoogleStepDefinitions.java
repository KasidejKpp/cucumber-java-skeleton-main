package io.cucumber.skeleton;

import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;


public class GoogleStepDefinitions {
    private final WebDriver driver = new ChromeDriver();

    @Given("Open Google.com")
    public void open_google_com() {
        driver.get("https://www.google.com");
    }

    @When("Search with {string}")
    public void search_with(String query) {
        WebElement element = driver.findElement(By.id("APjFqb"));
        // Enter something to search for
        element.sendKeys(query);
        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
    }

    @Then("The page title should start with {string}")
    public void checkTitle(String titleStartsWith) {
        // Google's search is rendered dynamically with JavaScript
        // Wait for the page to load timeout after ten seconds
        Duration duration = Duration.ofSeconds(10);
        new WebDriverWait(driver,duration).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                d.findElement(By.id("APjFqb")).getText();
                return d.getTitle().toLowerCase().startsWith(titleStartsWith.toLowerCase());
            }

        });
    }

    @Then("Search box contain {string}")
    public void search_box(String input) {
        // Google's search is rendered dynamically with JavaScript
        // Wait for the page to load timeout after ten seconds
        Duration duration = Duration.ofSeconds(10);
        new WebDriverWait(driver,duration).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("APjFqb")).getText().equalsIgnoreCase(input);
            }

        });
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }

}
