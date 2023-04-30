package by.teachmeskills.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class UserProfilePage extends BasePage {

    public final SelenideElement userProfileTitle = $("");
    public final SelenideElement profileEditBtn = $x("//span[normalize-space()='Edit Profile']");
    public final SelenideElement profilePictureTitle = $x("//label[text()='Profile Picture']");
    public final SelenideElement profileEditCancelBtn = $("span.dropdown-toggle").$(withText("Cancel"));
    public final SelenideElement firstNameFld = $("input[name='fname']");
    public final SelenideElement lastNameFld = $("input[name='lname']");
    public final SelenideElement birthDayFld = $("input[name='BDay']");
    public final SelenideElement weightFld = $("input[name='Weight']");
    public final SelenideElement cityFld = $("input[name='City']");
    public final SelenideElement zipFld = $("input[name='Zip']");
    public final SelenideElement saveChangesBtn = $("input[name='btnSubmit']");
    public final SelenideElement fixErrorsMsg = $(".alert-error");
    public final SelenideElement enterValidFNMsg = $(".alert-error").$(withText("First Name"));
    public final SelenideElement enterValidLNMsg = $(".alert-error").$(withText("Last Name"));


    public UserProfilePage clickEdit() {
        profileEditBtn.shouldBe(Condition.visible).click();
        return page(this);
    }

    public UserProfilePage clickSave() {
        saveChangesBtn.shouldBe(Condition.visible).click();
        return page(this);
    }

    public UserProfilePage clickCancel() {
        profileEditCancelBtn.shouldBe(Condition.visible).click();
        return page(this);
    }

    public UserProfilePage setUserFirstName(String firstName) {
        UserProfilePage userProfile = edite();
        editField(firstNameFld, firstName);
        return page(this);
    }

    public String getUserFirstName() {
        return firstNameFld.val();
    }

    public UserProfilePage setUserLastName(String lastName) {
        UserProfilePage userProfile = edite();
        editField(lastNameFld, lastName);
        return page(this);
    }

    public String getUserLastName() {
        return lastNameFld.val();
    }

    public UserProfilePage setUserBirthDay(String birthDay) {
        UserProfilePage userProfile = edite();
        editField(birthDayFld, birthDay);
        return page(this);
    }

    public String getUserBirthDay() {
        return birthDayFld.val();
    }

    public UserProfilePage setUserWeight(String weight) {
        UserProfilePage userProfile = edite();
        editField(weightFld, weight);
        return page(this);
    }

    public String getUserWeight() {
        return weightFld.val();
    }

    public UserProfilePage setUserCity(String city) {
        UserProfilePage userProfile = edite();
        editField(cityFld, city);
        return page(this);
    }

    public String getUserCity() {
        return cityFld.val();
    }

    public UserProfilePage setUserZip(String zip) {
        UserProfilePage userProfile = edite();
        editField(zipFld, zip);
        return page(this);
    }

    public String getUserZip() {
        return zipFld.val();
    }

    private UserProfilePage edite() {
        UserProfilePage userProfile = new UserProfilePage().clickEdit();
        userProfile.clickEdit();
        profilePictureTitle.shouldBe(Condition.visible);
        return userProfile;
    }

    private void editField(SelenideElement element, String value) {
        UserProfilePage userProfile = edite();
        profilePictureTitle.shouldBe(Condition.visible);
        element.shouldBe(Condition.visible).clear();
        element.shouldBe(Condition.visible).val(value);
        userProfile.clickSave();
    }
}
