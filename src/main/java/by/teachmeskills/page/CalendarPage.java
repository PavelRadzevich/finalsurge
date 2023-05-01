package by.teachmeskills.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CalendarPage extends BasePage {
    public final SelenideElement isOpened = $x("//*[text()='Training Calendar']");
    public final SelenideElement settingsLnk = $(".unstyled a[href='UserProfile.cshtml']");

    public UserProfilePage goUserProfile() {
        isOpened.shouldBe(visible);
        settingsLnk.shouldHave(text("Settings"), Duration.ofSeconds(10)).click();
        return  new UserProfilePage();
    }
}