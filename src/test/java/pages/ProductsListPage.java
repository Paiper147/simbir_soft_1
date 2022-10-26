package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import helpers.BaseMethods;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsListPage extends BaseMethods {
    SelenideElement firstProductAddToCartButton = $(AppiumBy.id("ru.av.vkusomania:id/cscButtonAddToCart"));
    SelenideElement sortingButton = $(AppiumBy.id("ru.av.vkusomania:id/buttonSortType"));
    SelenideElement minToMaxSortingSelector = $$(AppiumBy.className("android.widget.TextView")).filterBy(Condition.text("Сначала недорогие")).first();

    public ProductsListPage firstProductAddToCart() {
        firstProductAddToCartButton.click();
        return this;
    }

    public ProductsListPage tapToSortingButton() {
        sortingButton.click();
        return this;
    }

    public ProductsListPage sortingMinToMax() {
        minToMaxSortingSelector.click();
        return this;
    }

    public ProductsListPage checkSortingMinToMax() {
        int priceOfFirstProduct = splitPriceWithoutRubles(getProductPrice(0));
        int priceOfFourthProduct = splitPriceWithoutRubles(getProductPrice(3));
        Assertions.assertTrue(priceOfFourthProduct > priceOfFirstProduct);
        return this;
    }

    private String getProductPrice(int number) {
        String priceOfProduct = $(AppiumBy.id("ru.av.vkusomania:id/recyclerViewProducts"))
                .$$(AppiumBy.className("androidx.cardview.widget.CardView"))
                .get(number)
                .$(AppiumBy.id("ru.av.vkusomania:id/cscPriceView"))
                .$(AppiumBy.className("android.widget.TextView")).getText();
        return priceOfProduct;
    }
}
