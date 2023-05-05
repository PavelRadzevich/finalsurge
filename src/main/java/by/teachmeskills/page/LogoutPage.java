package by.teachmeskills.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LogoutPage {
    public final SelenideElement accountLoginLnk = $x("//a[text()='Account Login']");

}
