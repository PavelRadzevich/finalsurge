package by.teachmeskills;

import by.teachmeskills.util.PropertiesLoader;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    Properties properties = PropertiesLoader.loadProperties();

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    void setUp(@Optional("chrome") String browser) {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        if (StringUtils.equals(browser, "firefox")) {
            Configuration.browser = "firefox";
        } else {
            Configuration.browser = "chrome";
        }
    }
    @AfterMethod
    void tearDown(){
        open(properties.getProperty("LOGOUT_PAGE"));
    }
}
