package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

public class HomePageTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;

    @Before
    public void openHomePage() {
        homePage = new HomePage(driver, wait);
        driver = homePage.chromeDriverConnection();
        homePage.visit("https://www.foxnews.com/");

    }

    //בדיקה של אלמנט שנוצר לאחר פעולה מסוימת
    @Test
    public void testSearchFiledDisplayedAfterClickingSearch(){
        homePage.clickSearchButtonToDisplaySearchField();
        homePage.returnToHomePage();
    }

    //מעבר על כמה אלמנטים תחת אותו אלמנט אב
    @Test
    public void testFewElementsUnderTheSameFatherElement() throws InterruptedException {
        homePage.testFewElementsUnderTheSameFatherElement();
    }

    @After
    public void quit() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
