package by.teachmeskills;

import by.teachmeskills.ddt.DPClass;
import by.teachmeskills.page.CalendarPage;
import by.teachmeskills.page.LoginPage;
import com.codeborne.selenide.Condition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseTest {
    private Logger log = LogManager.getLogger(LoginPageTest.class);

    @Test(invocationCount = 1,
            groups = {"negative"})
    public void checkWithoutParameters() {
        LoginPage loginPage = new LoginPage().loginAs("", "");
        loginPage.loginErrMsg
                .shouldBe(Condition.visible
                        .because("no error message"))
                .shouldHave(Condition.text("Please enter your e-mail address.")
                        .because("error text is invalid"));
        loginPage.passErrMsg
                .shouldBe(Condition.visible
                        .because("no error message"))
                .shouldHave(Condition.text("Please enter a password."));
    }

    @Test(dataProvider = "any-login", dataProviderClass = DPClass.class,
            groups = {"negative"},
            invocationCount = 1)
    public void checkWithAnyParameters(String login, String pass) {
        log.info("Run checkAnyValues with {}, {}", login, pass);
        LoginPage loginPage = new LoginPage().loginAs(login, pass);
        loginPage.loginErrMsg
                .shouldBe(Condition.visible
                        .because("no error message"))
                .shouldHave(Condition.text("Please enter a valid email address.")
                        .because("error text is invalid"));
    }

    @Test(invocationCount = 1,
            groups = {"regression"})
    public void checkValidLoginNoPass() {
        LoginPage loginPage = new LoginPage().loginValidLoginNoPassword();
        loginPage.passErrMsg
                .shouldBe((Condition.visible)
                        .because("no error message"))
                .shouldHave(Condition.text("Please enter a password.")
                        .because("error text is invalid"));
    }

    @Test(invocationCount = 1,
            groups = {"regression"})
    public void checkValidLoginWithWrongPass() {
        LoginPage loginPage = new LoginPage().loginValidLoginWrongPassword();
        loginPage.invalidCredErrMsg
                .shouldBe(Condition.visible
                        .because("no error message"))
                .shouldHave(Condition.text("Invalid login credentials. Please try again.")
                        .because("error text is invalid"));
    }

    @Test(invocationCount = 1,
            groups = {"negative"})
    public void checkUserLock() {
        LoginPage loginPage = new LoginPage().loginWithMultipleAttempts();
        loginPage.invalidCredErrMsg
                .shouldHave(Condition.text("You have made too many login attempts and have been locked out of your account. Please try again later.")
                        .because("error text is invalid"));
    }

    @Test(invocationCount = 1,
            groups = {"smoke"})
    public void loginValidUser() {
        CalendarPage calPage = new LoginPage().loginValidUser();
        calPage.isOpened.shouldBe(Condition.visible);
    }
}
