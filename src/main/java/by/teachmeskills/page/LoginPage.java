package by.teachmeskills.page;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {
    public final SelenideElement loginField = $("#login_name");
    public final SelenideElement passField = $("#login_password");
    public final SelenideElement loginErrMsg = $("form#login-validate label.error[for='login_name']");
    public final SelenideElement passErrMsg = $("form#login-validate label.error[for='login_password']");
    public final SelenideElement invalidCredErrMsg = $("div[class='alert alert-error']");
    public final SelenideElement loginBtn = $x("//button[text()='Login']");
    public  final String INCORRECT_PASS = "xxx";
    public final int ATTEMPT_COUNT = 10;

    private Logger log = LogManager.getLogger(LoginPage.class);

    public LoginPage loginAs(String login, String pass) {
        loginField.clear();
        loginField.val(login);
        passField.clear();
        passField.val(pass).pressEnter();
        log.info("---TEST---");
        return page(this);
    }

    public LoginPage loginWithMultipleAttempts() {
        LoginPage loginPage = new LoginPage().openLink().loginAs(properties.getProperty("ACCOUNT_LOGIN_2"), INCORRECT_PASS);
        int attempt = ATTEMPT_COUNT;
        do {
            attempt--;
            loginPage.passField.val(INCORRECT_PASS);
            loginBtn.click();
        } while ( attempt > 0);

        return page(this);
    }

    public LoginPage loginValidLoginNoPassword() {
        LoginPage loginPage = new LoginPage().openLink().loginAs(properties.getProperty("ACCOUNT_LOGIN"), "");
        log.info("---TEST---");
        return page(this);
    }

    public LoginPage loginValidLoginWrongPassword() {
        LoginPage loginPage = new LoginPage().openLink().loginAs(properties.getProperty("ACCOUNT_LOGIN"), INCORRECT_PASS);
        log.info("---TEST---");
        return page(this);
    }

    public CalendarPage loginValidUser() {
        LoginPage loginPage = new LoginPage().openLink().loginAs(properties.getProperty("ACCOUNT_LOGIN"),
                properties.getProperty("ACCOUNT_PASSWORD"));
        log.info("---TEST---");
        return page(CalendarPage.class);
    }

    public LoginPage openLink() {
        return page(open(properties.getProperty("LOGIN_PAGE"),
                LoginPage.class));
    }

}
