package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class CalcualtorPage {

    public WebDriver webDriver;
    WebDriverWait webDriverWait;

    public CalcualtorPage(WebDriver rdriver) {
        webDriver = rdriver;
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(id = "Email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(id = "Password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Log in']")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(linkText = "Logout")
    @CacheLookup
    WebElement lnkLogout;

    public CalcualtorPage one(String username) {
        txtEmail.clear();
        txtEmail.sendKeys(username);
        return this;
    }


    public CalcualtorPage two(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
        return this;
    }

    public CalcualtorPage equal(){
        btnLogin.click();
        return this;
    }

    public CalcualtorPage clickLogout(){
        lnkLogout.click();
        return this;
    }


    public String getResult(){
        return webDriver.getTitle();
    }



}
