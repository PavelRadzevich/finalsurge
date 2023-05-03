package by.teachmeskills.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class UserProfilePage extends BasePage {

    public final SelenideElement userProfileTitle = $("");
    public final SelenideElement profileEditBtn = $x("//span[normalize-space()='Edit Profile']");
    public final SelenideElement profilePictureTitle = $x("//label[text()='Profile Picture']");
    public final SelenideElement profileEditCancelBtn = $("span.dropdown-toggle").$(withText("Cancel"));
    public final SelenideElement firstNameEditFld = $("input[name='fname']");
    public final SelenideElement lastNameEditFld = $("input[name='lname']");
    public final SelenideElement birthDayEditFld = $("input[name='BDay']");
    public final SelenideElement weightEditFld = $("input[name='Weight']");
    public final SelenideElement cityEditFld = $("input[name='City']");
    public final SelenideElement zipEditFld = $("input[name='Zip']");
    public final SelenideElement saveChangesBtn = $("input[name='btnSubmit']");
    public final SelenideElement fixErrorsMsg = $x("//div[@class='alert alert-error']");

    public final SelenideElement profileNameFld = $x("//small[@class='muted'][normalize-space()='Name:']/parent::p");
    public final SelenideElement profileBirthdayFld = $x("//small[@class='muted'][normalize-space()='Birthday:']/parent::p");
    public final SelenideElement profileWeightFld = $x("//small[@class='muted'][normalize-space()='Weight:']/parent::p");
    public final SelenideElement profileCityFld = $x("//small[@class='muted'][normalize-space()='City:']/parent::p");
    public final SelenideElement profileZipFld = $x("//small[@class='muted'][normalize-space()='Zip/Postal Code:']/parent::p");

    private Logger log = LogManager.getLogger(UserProfilePage.class);

    @Step("Select the menu item Edit profile")
    public UserProfilePage clickEdit() {
        profileEditBtn.shouldBe(visible).click();
        profilePictureTitle.shouldBe(visible.because("profile edit menu not opening"));
        return this;
    }
    @Step("Select the menu item Save profile")
    public UserProfilePage clickSave() {
        saveChangesBtn.shouldBe(visible).click();
        return this;
    }

    public UserProfilePage clickCancel() {
        profileEditCancelBtn.shouldBe(visible).click();
        return this;
    }
    @Step("Paste a value into the First Name field")
    public UserProfilePage setUserFirstName(String firstName) {
        editField(firstNameEditFld, firstName);
        return this;
    }

    public String getUserFirstName() {
        return firstNameEditFld.val();
    }

    @Step("Paste a value into the Last Name field")
    public UserProfilePage setUserLastName(String lastName) {
        editField(lastNameEditFld, lastName);
        return this;
    }

    public String getUserLastName() {
        return lastNameEditFld.val();
    }

    @Step("Paste a value into the Birth Day field")
    public UserProfilePage setUserBirthDay(String birthDay) {
        editField(birthDayEditFld, birthDay);
        return this;
    }

    public String getUserBirthDay() {
        return birthDayEditFld.val();
    }

    @Step("Paste a value into the Weight field")
    public UserProfilePage setUserWeight(String weight) {
        editField(weightEditFld, weight);
        return this;
    }

    public String getUserWeight() {
        return weightEditFld.val();
    }

    public UserProfilePage setUserCity(String city) {
        editField(cityEditFld, city);
        return this;
    }

    public String getUserCity() {
        return cityEditFld.val();
    }

    public UserProfilePage setUserZip(String zip) {
        editField(zipEditFld, zip);
        return this;
    }

    public String getUserZip() {
        return zipEditFld.val();
    }

    @Step("Edit field")
    private void editField(SelenideElement element, String value) {
        profilePictureTitle.shouldBe(visible);
        element.shouldBe(visible).clear();
        element.shouldBe(visible).val(value);
        log.info("Edit element {}, value {}",element, value);
    }
}
