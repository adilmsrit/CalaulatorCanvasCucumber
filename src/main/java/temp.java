import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class temp {

    public static void main(String... args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.online-calculator.com/full-screen-calculator/");
        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("fullframe")));
        Thread.sleep(2000);
        WebElement canvas = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("canvas")));
                                                                        //clicking on 3
        new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(0,(255/6)*3).click().build().perform();
        Thread.sleep(1000);
                                                                        //clicking on the substract sign (-)
        new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset((174/5)*2,(255/6)*3).click().build().perform();
        Thread.sleep(1000);
                                                                        //clicking on 1
        new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(-(174/5)*4,(255/6)*3).click().build().perform();
        Thread.sleep(1000);
//clicking on equals to sign (=)
        new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset((174/5)*4,(255/6)*4).click().build().perform();
        Thread.sleep(1000);

    }

    @Test
    public void getCoordinates() throws Exception {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.online-calculator.com/full-screen-calculator/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Locate element for which you wants to retrieve x y coordinates.

        driver.switchTo().frame("fullframe");
        WebElement Image = driver.findElement(By.xpath("//*[@id='canvas']"));

        //Used points class to get x and y coordinates of element.
        Point point = Image.getLocation();
        int xcordi = point.getX();
        System.out.println("Element's Position from left side:  " + xcordi + " pixels.");
        int ycordi = point.getY();
        System.out.println("Element's Position from top:  " + ycordi + " pixels.");
    }

    @Test
    public void Login() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Creating the JavascriptExecutor interface object by Type casting
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Launching the Site.
        driver.get("http://demo.guru99.com/V4/");

        WebElement button = driver.findElement(By.name("btnLogin"));

        //Login to Guru99
        driver.findElement(By.name("uid")).sendKeys("mngr34926");
        driver.findElement(By.name("password")).sendKeys("amUpenu");

        //Perform Click on LOGIN button using JavascriptExecutor
        js.executeScript("arguments[0].click();", button);


    }
}
