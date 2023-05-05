package by.teachmeskills.page;

import by.teachmeskills.util.PropertiesLoader;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class BasePage {
    Properties properties = PropertiesLoader.loadProperties();

    public LogoutPage logout() {
        return page(open(properties.getProperty("LOGOUT_PAGE"),
                LogoutPage.class));
    }
}
