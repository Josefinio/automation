package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Base {

    By emailFiled = By.name("email");
    By passwordFiled = By.name("password");
    By loginButton = By.className("foxid-btn-primary");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void login(String email,String password) {
        waitUntilElementLocated(emailFiled);
        type(email,emailFiled);
        type(password,passwordFiled);
        click(loginButton);

    }
}
