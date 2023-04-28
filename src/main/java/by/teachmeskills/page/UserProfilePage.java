package by.teachmeskills.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class UserProfilePage extends BasePage {

    public final SelenideElement userProfileTitle = $("");
    public final SelenideElement profileEditBtn = $(".dropdown-toggle").
            $(withText("Edit Profile"));
    public final SelenideElement profilePictureTitle = $x("//label[text()='Profile Picture']");
    public final SelenideElement profileEditCancelBtn = $("");
    public final SelenideElement firstNameFld = $("input[name='fname']");
    public final SelenideElement lastNameFld = $("input[name='lname']");
    public final SelenideElement saveChangesBtn = $("input[name='btnSubmit']");
    public final SelenideElement fixErrorsMsg = $(".alert-error");
    public final SelenideElement enterValidLNMsg = $(".alert-error").$(withText("First Name"));
    public final SelenideElement enterValidFNMsg = $(".alert-error").$(withText("Last Name"));


    private UserProfilePage clickEditProfile() {
        profileEditBtn.shouldBe(Condition.visible).click();
        return page(this);
    }

    private UserProfilePage clickSaveProfile() {
        profileEditCancelBtn.shouldBe(Condition.visible).click();
        return page(this);
    }

    private UserProfilePage editProfileFld() {
        UserProfilePage userProfile = new UserProfilePage().clickEditProfile();
        userProfile.clickEditProfile();
        profilePictureTitle.shouldBe(Condition.visible);
        return userProfile;
    }

    public UserProfilePage setUserFirstName(String firstName) {
        UserProfilePage userProfile = editProfileFld();
        profilePictureTitle.shouldBe(Condition.visible);
        firstNameFld.shouldBe(Condition.visible).clear();
        firstNameFld.shouldBe(Condition.visible).val(firstName);
        userProfile.clickSaveProfile();
        return page(this);
    }

    public UserProfilePage setUserLastName(String lastName) {
        UserProfilePage userProfile = editProfileFld();
        profilePictureTitle.shouldBe(Condition.visible);
        lastNameFld.shouldBe(Condition.visible).clear();
        lastNameFld.shouldBe(Condition.visible).val(lastName);
        userProfile.clickSaveProfile();
        return page(this);
    }
}
