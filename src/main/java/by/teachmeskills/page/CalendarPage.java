package by.teachmeskills.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CalendarPage extends BasePage {
    public final SelenideElement isOpened = $x("//*[text()='Training Calendar']");
    public final SelenideElement settingsLnk = $(".unstyled a[href='UserProfile.cshtml']");
    public final SelenideElement weekUserTbl = $("table#user").find(byText("Sunday"));
    public final SelenideElement weekUserQuickTbl = $x("//table[@id='user']//div[contains(text(),'Sunday')]/parent::div//a[contains(text(),'Quick Add')]");
    public final SelenideElement weekBtn = $x("//span[@class='fc-button-content'][contains(text(),'week')]");
    public final SelenideElement workOutRunSlt = $("#QuickAdd #ActivityType");
    public final SelenideElement saveWorkOutBtn = $x("//input[@id='saveButton']");
    public final SelenideElement userWorkOutRun = $x("//table[@id='user']//span[text()='Run - Fartlek ']");
    public final SelenideElement delUserWorkOutRun = $x("//table[@id='user']//span[text()='Run - Fartlek ']/ancestor::div[@class='dropdown open']//a[contains(text(),'Delete')]");

    @Step("Go to user profile")
    public UserProfilePage goUserProfile() {
        isOpened.shouldBe(visible);
        settingsLnk.shouldHave(text("Settings"), Duration.ofSeconds(10)).click();
        return new UserProfilePage();
    }

    @Step("Add a quick workout on Monday")
    public CalendarPage checkSunday() {
        this.checkWeek();
        weekUserTbl.shouldBe(visible).click();
        weekUserQuickTbl.click();
        return this;
    }

    @Step("Switch to display weeks")
    private CalendarPage checkWeek() {
        weekBtn.shouldBe(visible).click();
        return this;
    }

    @Step("Add a workout 'Run'")
    public CalendarPage addWorkOutRun() {
        workOutRunSlt.click();
        workOutRunSlt.sendKeys(Keys.DOWN, Keys.DOWN, Keys.ENTER);
        return this;
    }

    @Step("Press the 'Save Workout' button")
    public CalendarPage saveWorkOut() {
        saveWorkOutBtn.shouldBe(visible).click();
        return this;
    }
}