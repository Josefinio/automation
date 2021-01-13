package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Base;
import pages.LoginPage;

public class LoginTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;
    private Base base;
    @Before
    public void setUp() {
        loginPage = new LoginPage(driver, wait);
        driver = loginPage.chromeDriverConnection();
        loginPage.visit("https://my.foxnews.com/");
    }

    @Test
    public void login() {
        loginPage.login("beninaor9191@gmail.com","Aa123456");
    }

    @After
    public void verifyTheUserLoggedIn() throws InterruptedException {
       Thread.sleep(4000);
       driver.quit();
    }
}
