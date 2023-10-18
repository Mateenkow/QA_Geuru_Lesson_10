package page;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author mateenkov
 */

public class MainPage {

    private final SelenideElement inputSearch = $("#header-search");
    private final SelenideElement titleResultSearch = $("[data-zone-name='searchTitle']");
    private final SelenideElement buttonCatalog = $("[data-baobab-name='catalog']");
    private final SelenideElement titleCatalog = $("[data-apiary-widget-name='@MarketNode/CatalogHeader']");
    private final SelenideElement itemCatalog = $x("//div[@data-zone-name='catalog-content']");

    public MainPage searchValue(String value) {
        inputSearch.click();
        inputSearch.setValue(value).pressEnter();
        return this;
    }

    public MainPage openPage() {
        open(" ");
        return this;
    }

    public MainPage checkResult(String result) {
        titleResultSearch.shouldHave(Condition.text(result));
        return this;
    }

    public MainPage openCatalog() {
        buttonCatalog.click();
        return this;
    }

    public MainPage clickCatalogItem(String item) {
        itemCatalog.$(withText(item)).click();
        return this;
    }

    public MainPage checkCatalogTitle(String title) {
        titleCatalog.shouldHave(Condition.text(title));
        return this;
    }

}
