package by.teachmeskills;

import by.teachmeskills.ddt.DPClass;
import by.teachmeskills.page.CalendarPage;
import by.teachmeskills.page.LoginPage;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseTest {

    @Test(enabled = true)
    public void checkWithoutParameters() {
        LoginPage loginPage = new LoginPage().openLink().loginAs("", "");
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

    @Test(dataProvider = "any-login", dataProviderClass = DPClass.class)
    public void checkWithAnyParameters(String login, String pass) {
        log.info("Run checkAnyValues with {}, {}", login, pass);
        LoginPage loginPage = new LoginPage().openLink().loginAs(login, pass);
        loginPage.loginErrMsg
                .shouldBe(Condition.visible
                        .because("no error message"))
                .shouldHave(Condition.text("Please enter a valid email address.")
                        .because("error text is invalid"));
    }

    @Test
    public void checkValidLoginNoPass() {
        LoginPage loginPage = new LoginPage().openLink().loginValidLoginNoPassword();
        loginPage.passErrMsg
                .shouldBe((Condition.visible)
                        .because("no error message"))
                .shouldHave(Condition.text("Please enter a password.")
                        .because("error text is invalid"));
    }

    @Test
    public void checkValidLoginWithWrongPass() {
        LoginPage loginPage = new LoginPage().openLink().loginValidLoginWrongPassword();
        loginPage.invalidCredErrMsg
                .shouldBe(Condition.visible
                        .because("no error message"))
                .shouldHave(Condition.text("Invalid login credentials. Please try again.")
                        .because("error text is invalid"));
    }

    @Test
    public void checkUserLock() {
        LoginPage loginPage = new LoginPage().openLink().loginWithMultipleAttempts();
        loginPage.invalidCredErrMsg
                .shouldHave(Condition.text("You have made too many login attempts and have been locked out of your account. Please try again later.")
                        .because("error text is invalid"));
    }

    @Test(enabled = true)
    public void loginValidUser() {
        CalendarPage calPage = new LoginPage().openLink().loginValidUser();
        calPage.isOpened.shouldBe(Condition.visible);
    }
}
