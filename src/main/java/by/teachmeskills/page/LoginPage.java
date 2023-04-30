package by.teachmeskills.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.auth.login.LoginContext;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class LoginPage extends BasePage {
    public final SelenideElement loginField = $("#login_name");
    public final SelenideElement passField = $("#login_password");
    public final SelenideElement loginErrMsg = $("form#login-validate label.error[for='login_name']");
    public final SelenideElement passErrMsg = $("form#login-validate label.error[for='login_password']");
    public final SelenideElement invalidCredErrMsg = $("div[class='alert alert-error']");
    public final SelenideElement loginBtn = $x("//button[text()='Login']");
    public final String INCORRECT_PASS = "xxx";
    public final int ATTEMPT_COUNT = 10;

    private Logger log = LogManager.getLogger(LoginPage.class);

    public LoginPage(){
        log.info("Open page {}", properties.getProperty("LOGIN_PAGE"));
        open(properties.getProperty("LOGIN_PAGE"));
    }
    public LoginPage loginAs(String login, String pass) {
        loginField.clear();
        loginField.val(login);
        passField.clear();
        passField.val(pass).pressEnter();
        log.info("Login as LOGIN: {},  PASS: {} ", login, pass);
        return this;
    }

    public LoginPage loginWithMultipleAttempts() {
        LoginPage loginPage = new LoginPage().openLink().loginAs(properties.getProperty("ACCOUNT_LOGIN_2"), INCORRECT_PASS);
        int attempt = ATTEMPT_COUNT;
        do {
            attempt--;
            loginPage.passField.val(INCORRECT_PASS);
            loginBtn.click();
        } while (attempt > 0);
        log.info("URL : {}", url().toString());
        return this;
    }

    public LoginPage loginValidLoginNoPassword() {
        LoginPage loginPage = new LoginPage().openLink().loginAs(properties.getProperty("ACCOUNT_LOGIN"), "");
        log.info("URL : {}", url().toString());
        return this;
    }

    public LoginPage loginValidLoginWrongPassword() {
        LoginPage loginPage = new LoginPage().openLink().loginAs(properties.getProperty("ACCOUNT_LOGIN"), INCORRECT_PASS);
        log.info("URL : {}", url().toString());
        return this;
    }

    public CalendarPage loginValidUser() {
        LoginPage loginPage = new LoginPage().openLink().loginAs(properties.getProperty("ACCOUNT_LOGIN"),
                properties.getProperty("ACCOUNT_PASSWORD"));
        log.info("URL : {}", url().toString());
        return new CalendarPage();
    }

    public LoginPage openLink() {
        log.info("URL Open : {}", url().toString());
        return this;
    }
}
