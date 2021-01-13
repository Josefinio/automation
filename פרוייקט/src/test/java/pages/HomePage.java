package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Base;

import java.util.List;

public class HomePage extends Base {
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    By searchButton = By.className("search-toggle");
    By searchFiled = By.className("resp_site_search");
    By mainNavbar = By.id("main-nav");

    public void clickSearchButtonToDisplaySearchField() {
        waitUntilElementLocated(searchButton);
        Assert.assertFalse(isDisplayed(searchFiled));
        click(searchButton);
        Assert.assertTrue(isDisplayed(searchFiled));
        type("s", searchFiled).submit();
    }

    public void testFewElementsUnderTheSameFatherElement() {
        List<WebElement> elements = findElement(mainNavbar).findElements(By.cssSelector("li"));
        for (int i = 0; i < elements.size(); i++) {
            Assert.assertTrue(elements.get(i).isDisplayed());
        }
    }

    public void returnToHomePage() {
        getDriver().navigate().back();
    }
}
