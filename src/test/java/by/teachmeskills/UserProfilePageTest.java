package by.teachmeskills;

import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.UserProfilePage;
import com.codeborne.selenide.Condition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class UserProfilePageTest {
    private Logger log = LogManager.getLogger(LoginPageTest.class);

    @Test
    public void checkFieldsFirsLastWithoutValue() {
        UserProfilePage userProfile = new LoginPage()
                .openLink()
                .loginValidUser()
                .goUserProfile();
        userProfile.setUserFirstName("")
                .setUserLastName("").clickSave()
                .enterValidFNMsg.shouldBe(Condition.text("*Please enter a value for First Name.")
                        .because("no error message"));
        userProfile.enterValidLNMsg.shouldBe(Condition.text("*Please enter a value for Last Name.")
                .because("no error message"));
    }
}
