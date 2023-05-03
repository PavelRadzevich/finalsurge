package by.teachmeskills;

import by.teachmeskills.page.CalendarPage;
import by.teachmeskills.page.LoginPage;
import io.qameta.allure.Step;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CalendarPageTest extends BaseTest {

    @Test(groups = {"smoke", "workOutRun"})
    public void test() {
        CalendarPage calPage = new LoginPage().loginValidUser();
        calPage.checkSunday();
        calPage.addWorkOutRun().saveWorkOut();
        calPage.userWorkOutRun.shouldBe(visible.because("Workout not added"));
    }

    @AfterTest(groups = {"workOutRun"})
    @Step("Delete running workout")
    public void clearWorkOut() {
        CalendarPage calPage = new LoginPage().loginValidUser();
        calPage.checkSunday();
        calPage.userWorkOutRun.shouldBe(visible).click();
        calPage.delUserWorkOutRun.click();
        $x("//a[@class='btn btn-primary']").click();
    }
}
