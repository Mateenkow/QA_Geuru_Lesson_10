package driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static test.TestData.BASE_URL;

/**
 * @author mateenkov
 */

abstract public class BaseTest {

    @AfterEach
    public void  clearAfterTest(){
        Selenide.clearBrowserLocalStorage();
        Selenide.clearBrowserCookies();
    }

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = BASE_URL;
        Configuration.browserSize = "1920x1080";
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }

}
