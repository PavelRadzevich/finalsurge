package by.teachmeskills;

import by.teachmeskills.page.LoginPage;
import by.teachmeskills.page.UserProfilePage;
import com.codeborne.selenide.Condition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.url;

public class UserProfilePageTest extends BaseTest {
    private Logger log = LogManager.getLogger(LoginPageTest.class);

    @Test(groups = {"negative"})
    public void checkFieldsFirsLastWithoutValue() {
        UserProfilePage userProfile = new LoginPage()
                .loginValidUser()
                .goUserProfile();
        log.info("URL : {}", url().toString());
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
                .loginValidUser()
                .goUserProfile();
        log.info("URL : {}", url().toString());
        userProfile.clickEdit().setUserFirstName("").clickSave();
        userProfile.fixErrorsMsg.shouldBe(Condition.text(" *Please enter a value for First Name.")
                                                   .because("no error message"));
    }

    @Test(groups = {"negative"})
    public void checkFieldLastWithoutValue() {
        UserProfilePage userProfile = new LoginPage()
                .loginValidUser()
                .goUserProfile();
        log.info("URL : {}", url().toString());
        userProfile.clickEdit().setUserLastName("").clickSave();
        userProfile.fixErrorsMsg.shouldBe(Condition.text(" *Please enter a value for Last Name.")
                                                   .because("no error message"));
    }

    @Test(groups = {"smoke"})
    public void checkFieldFirstWithValidValue() {
        UserProfilePage userProfile = new LoginPage()
                .loginValidUser()
                .goUserProfile();
        log.info("URL : {}", url().toString());
        userProfile.clickEdit().setUserFirstName("First").clickSave();
        userProfile.profileNameFld
                .shouldHave(Condition.innerText("First")
                                     .because("The 'Name' field doesn't contain the expected value."));
    }

    @Test(groups = {"smoke"})
    public void checkFieldLastWithValidValue() {
        UserProfilePage userProfile = new LoginPage()
                .loginValidUser()
                .goUserProfile();
        log.info("URL : {}", url().toString());
        userProfile.clickEdit().setUserLastName("777").clickSave();
        userProfile.profileNameFld
                .shouldHave(Condition.innerText("777")
                                     .because("The 'Name' field doesn't contain the expected value."));
    }

    @Test(groups = {"smoke"})
    public void checkFieldBirthdayWithValidValue() {
        UserProfilePage userProfile = new LoginPage()
                .loginValidUser()
                .goUserProfile();
        log.info("URL : {}", url().toString());
        userProfile.clickEdit().setUserBirthDay("12/20/2001").clickSave();
        userProfile.profileBirthdayFld
                .shouldHave(Condition.innerText("12/20/2001")
                                     .because("The 'Birthday' field doesn't contain the expected value."));
    }

    @Test(groups = {"negative"})
    public void checkFieldBirthdayWithNotValidValue() {
        UserProfilePage userProfile = new LoginPage()
                .loginValidUser()
                .goUserProfile();
        log.info("URL : {}", url().toString());
        userProfile.clickEdit().setUserBirthDay("99/99/0003").clickSave();
        userProfile.fixErrorsMsg.shouldBe(Condition.text(" *Please enter a valid Birthday.")
                                                   .because("no error message"));
    }

    @Test(groups = {"smoke"})
    public void checkFieldWeightWithValidValue() {
        UserProfilePage userProfile = new LoginPage()
                .loginValidUser()
                .goUserProfile();
        log.info("URL : {}", url().toString());
        userProfile.clickEdit().setUserWeight("80").clickSave();
        userProfile.profileWeightFld
                .shouldHave(Condition.innerText("80")
                                     .because("The 'Weight' field doesn't contain the expected value."));
    }

    @Test(groups = {"negative"})
    public void checkFieldWeightWithNotValidValue() {
        UserProfilePage userProfile = new LoginPage()
                .loginValidUser()
                .goUserProfile();
        log.info("URL : {}", url().toString());
        userProfile.clickEdit().setUserWeight("0").clickSave();
        userProfile.fixErrorsMsg.shouldBe(Condition.text(" *Weight cannot be less than 1.00.")
                                                   .because("no error message"));
    }
}
