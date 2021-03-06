package com.hrms.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearchStepDefinition {
    protected static WebDriver driver;
    public static ChromeOptions options;

    @Given("user navigate to google application")
    public void user_navigate_to_google_application() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--no-sandbox"); // Bypass OS security model
        driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
    }

    @When("user enters any text")
    public void user_enters_any_text() {
        driver.findElement(By.name("q")).sendKeys("Maven Repository");
    }

    @When("hits enter")
    public void hits_enter() {
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("result is displayed")
    public void result_is_displayed() {
        boolean isDisplayed = driver.findElement(By.xpath("//a[@href = 'https://mvnrepository.com/']")).isDisplayed();
        Assert.assertTrue(isDisplayed);
        driver.quit();
    }

    @When("clicks on google search button")
    public void clicks_on_google_search_button() {
        driver.findElement(By.name("btnK")).click();
    }

}
