package by.teachmeskills;

import by.teachmeskills.util.PropertiesLoader;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {

    Properties properties = PropertiesLoader.loadProperties();

    @Parameters("browser")
    @BeforeClass
    void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }

}
