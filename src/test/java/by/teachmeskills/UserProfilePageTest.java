package by.teachmeskills;

import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.UserProfilePage;
import com.codeborne.selenide.Condition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class UserProfilePageTest extends BaseTest {
    private Logger log = LogManager.getLogger(LoginPageTest.class);

    @Test(groups = {"negative"})
    public void checkFieldsFirsLastWithoutValue() {
        UserProfilePage userProfile = new LoginPage()
                .openLink()
                .loginValidUser()
                .goUserProfile();
        userProfile.clickEdit().setUserFirstName("")
                   .setUserLastName("").clickSave();
        userProfile.fixErrorsMsg.shouldBe(Condition.text(" *Please enter a value for First Name.")
                                                   .because("no error message"));
        userProfile.fixErrorsMsg.shouldBe(Condition.text(" *Please enter a value for Last Name.")
                                                   .because("no error message"));
    }

    @Test(groups = {"negative"})
    public void checkFieldFirsWithoutValue() {
        UserProfilePage userProfile = new LoginPage()
                .openLink()
                .loginValidUser()
                .goUserProfile();
        userProfile.clickEdit().setUserFirstName("").clickSave();
        userProfile.fixErrorsMsg.shouldBe(Condition.text(" *Please enter a value for First Name.")
                                                   .because("no error message"));
    }

    @Test(groups = {"negative"})
    public void checkFieldLastWithoutValue() {
        UserProfilePage userProfile = new LoginPage()
                .openLink()
                .loginValidUser()
                .goUserProfile();
        userProfile.clickEdit().setUserLastName("").clickSave();
        userProfile.fixErrorsMsg.shouldBe(Condition.text(" *Please enter a value for Last Name.")
                                                   .because("no error message"));
    }
}
