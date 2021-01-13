package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.RegistrationPage;

import java.util.concurrent.TimeUnit;

public class RegisterTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private RegistrationPage registrationPage;

    @Before
    public void setup() throws InterruptedException {
        registrationPage = new RegistrationPage(driver,wait);
        driver = registrationPage.chromeDriverConnection();
        registrationPage.visit("https://www.foxnews.com/");
    }

    @Test
    public void registerTest() throws InterruptedException {
        registrationPage.RegisterUser();
    }

    @After
    public void endTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
