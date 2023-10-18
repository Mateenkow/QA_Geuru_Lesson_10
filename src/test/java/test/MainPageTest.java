package test;

import driver.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import page.MainPage;

import java.util.stream.Stream;


/**
 * @author mateenkov
 */

public class MainPageTest extends BaseTest {

    private final MainPage mainPage = new MainPage();

    @ParameterizedTest(name = "При успешном поиске  {0} на странице поиска отображается заголовок {1}")
    @Tags({@Tag("UI"), @Tag("Smoke"), @Tag("Search")})
    @CsvSource(value = {
            "iphone, Iphone",
            "redmi, Redmi",
            "samsung, Samsung"
    })
    void searchTest(String value, String titleResult) {
        mainPage.openPage()
                .searchValue(value)
                .checkResult(titleResult);
    }

    static Stream<Arguments> checkTitlesCatalog() {
        return Stream.of(Arguments.of("Дача и сад", "Дача и сад"),
                Arguments.of("Ноутбуки и компьютеры", "Ноутбуки и компьютеры"),
                Arguments.of("Книги", "Книги")
        );
    }

    @MethodSource("checkTitlesCatalog")
    @ParameterizedTest(name = "После клика на пункт каталога {0} отображается заголовок каталога {1}")
    @Tags({@Tag("UI"), @Tag("Smoke"), @Tag("Catalog")})
    void checkTitlesCatalog(String itemCatalog, String titleCatalog) {
        mainPage.openPage()
                .openCatalog()
                .clickCatalogItem(itemCatalog)
                .checkCatalogTitle(titleCatalog);
    }

    @ParameterizedTest
    @DisplayName("")
    @Tags({@Tag("UI"), @Tag("Smoke")})
    @ValueSource(strings = {"iphone", "redmi", "samsung"})
    void checkValueSearch(String valueSearch){
        mainPage.openPage()
                .searchValue(valueSearch)
                .checkResult(valueSearch);
    }
}
