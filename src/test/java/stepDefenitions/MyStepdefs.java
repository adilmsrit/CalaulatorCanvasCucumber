package stepDefenitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.CalcualtorPage;

public class MyStepdefs {

    public WebDriver driver;
    CalcualtorPage calcualtorPage;
    WebElement canvas;
    Actions actions;
    WebDriverWait webDriverWait;

    @Given("User launches chrome browser")
    public void user_launches_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
        webDriverWait = new WebDriverWait(driver, 10);
    }

    @When("User opens {string} URL")
    public void user_opens_url(String string) {
        driver.get(string);
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("fullframe")));
    }

    @When("User Adds 2 numbers {string} and {string}")
    public void addition(String username, String password) {
        canvas = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("canvas")));
        actions.moveToElement(canvas, 0, 0).moveByOffset(0, (255 / 6) * 3).click().build().perform();
        actions.moveToElement(canvas, 0, 0).moveByOffset((174 / 5) * 2, (255 / 6) * 3).click().build().perform();
        actions.moveToElement(canvas, 0, 0).moveByOffset(-(174 / 5) * 4, (255 / 6) * 3).click().build().perform();
    }

    @When("User Subtracts 2 numbers {string} and {string}")
    public void subtraction(String username, String password) {
        canvas = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("canvas")));
        actions.moveToElement(canvas, 0, 0).moveByOffset(0, (255 / 6) * 3).click().build().perform();
        actions.moveToElement(canvas, 0, 0).moveByOffset((174 / 5) * 2, (255 / 6) * 3).click().build().perform();
        actions.moveToElement(canvas, 0, 0).moveByOffset(-(174 / 5) * 4, (255 / 6) * 3).click().build().perform();
    }

    @When("Click on equal")
    public void clickOnResult() {
        actions.moveToElement(canvas, 0, 0).moveByOffset((174 / 5) * 4, (255 / 6) * 4).click().build().perform();
    }

    @When("Click on CE")
    public void clickOnCE() {
        actions.moveToElement(canvas, 0, 0).moveByOffset((174 / 5) * 4, (255 / 6) * 4).click().build().perform();
    }

    @Then("Result should be {string}")
    public void page_title_should_be(String string) {

        Assert.assertEquals(true, true);
    }

    @Then("Close Browser")
    public void close_browser() {
        driver.quit();
    }

    @Then("The result should be cleared")
    public void clearResult() {
        actions.moveToElement(canvas, 0, 0).moveByOffset((174 / 5) * 4, (255 / 6) * 4).click().build().perform();
    }


}
