package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Base {
    private WebDriver driver;
    private WebDriverWait wait;

    public Base(WebDriver driver,WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriver chromeDriverConnection() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,3);
        return driver;
    }


   public void waitUntilElementLocated(By locator){
       wait.until(ExpectedConditions.visibilityOfElementLocated((locator)));

   }
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public WebElement type(String inputText, By locator) {
        findElement(locator).sendKeys(inputText);
     return findElement(locator);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }


    }

    public void selectDropDownList(By locator,String  value){
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(value);
    }

    public void visit(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

}
