package by.teachmeskills.ddt;

import org.testng.annotations.DataProvider;

public class DPClass {
    @DataProvider(name = "any-login", parallel = true)
    public static Object[][] dataProvFunc() {
        return new Object[][]{
                {"/././.","/./././"},
                {"a@","@"},
                {"1111111111111111111111111111111","1111111111111111111111111"},
                {"     898998989898989898   -------   ","*8N¡"}
        };
    }
}