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
    public final SelenideElement fixErrorsMsg = $x("//div[@class='alert alert-error']");


    public UserProfilePage clickEdit() {
        profileEditBtn.shouldBe(Condition.visible).click();
        profilePictureTitle.shouldBe(Condition.visible.because("profile edit menu not opening"));
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
        editField(firstNameFld, firstName);
        return page(this);
    }

    public String getUserFirstName() {
        return firstNameFld.val();
    }

    public UserProfilePage setUserLastName(String lastName) {
        editField(lastNameFld, lastName);
        return page(this);
    }

    public String getUserLastName() {
        return lastNameFld.val();
    }

    public UserProfilePage setUserBirthDay(String birthDay) {
        editField(birthDayFld, birthDay);
        return page(this);
    }

    public String getUserBirthDay() {
        return birthDayFld.val();
    }

    public UserProfilePage setUserWeight(String weight) {
        editField(weightFld, weight);
        return page(this);
    }

    public String getUserWeight() {
        return weightFld.val();
    }

    public UserProfilePage setUserCity(String city) {
        editField(cityFld, city);
        return page(this);
    }

    public String getUserCity() {
        return cityFld.val();
    }

    public UserProfilePage setUserZip(String zip) {
        editField(zipFld, zip);
        return page(this);
    }

    public String getUserZip() {
        return zipFld.val();
    }

    private UserProfilePage editField(SelenideElement element, String value) {
        profilePictureTitle.shouldBe(Condition.visible);
        element.shouldBe(Condition.visible).clear();
        element.shouldBe(Condition.visible).val(value);
        return page(this);
    }
}
