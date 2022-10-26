package pages;

import com.codeborne.selenide.SelenideElement;
import helpers.BaseMethods;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class CatalogPage extends BaseMethods {

    SelenideElement firstCategory = $(AppiumBy.id("ru.av.vkusomania:id/textViewCategoryTitle"));
    SelenideElement searchClickButton = $(AppiumBy.id("ru.av.vkusomania:id/action_search_stub"));
    SelenideElement searchField = $(AppiumBy.id("ru.av.vkusomania:id/search_src_text"));

    public CatalogPage chooseFirstCategory() {
        firstCategory.click();
        return this;
    }

    public CatalogPage searchClick() {
        searchClickButton.click();
        return this;
    }

    public CatalogPage sendSearchKeys(String searchKeys) {
        searchField.sendKeys(searchKeys);
        tabEnterOnKeyboard();
        return this;
    }
}
