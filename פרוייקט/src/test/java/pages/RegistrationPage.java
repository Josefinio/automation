package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends Base {
    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    By loginButton = By.className("login");
    By createAccount = By.className("foxid-btn-primary-alt");
    By emailFiled = By.name("email");
    By passwordFiled = By.id("password");
    By firstNameFiled = By.name("firstName");
    By lastNameFiled = By.name("lastName");
    By nameToDisplayFiled = By.name("displayName");
    By dDList_month = By.name("month");
    By dDList_day = By.name("day");
    By dDList_year = By.name("year");
    By dDList_gender = By.name("gender");
    By agreeToTermsUse = By.name("tos");
    By createButton = By.className("foxid-btn");

    public void RegisterUser() throws InterruptedException {
        click(loginButton);
        waitUntilElementLocated(createAccount);
        click(createAccount);
        waitUntilElementLocated(emailFiled);
        type("BeniNaor9191@gmail.com", emailFiled);
        type("Aa123456", passwordFiled);
        type("yosef", firstNameFiled);
        type("N", lastNameFiled);
        type("josef999", nameToDisplayFiled);
        selectDropDownList(dDList_month,"02");
        selectDropDownList(dDList_day,"16");
        selectDropDownList(dDList_year,"1999");
        selectDropDownList(dDList_gender,"m");
        click(agreeToTermsUse);
        //click(createButton);
    }

}
