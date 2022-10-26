package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import helpers.BaseMethods;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class CartPage extends BaseMethods {
    SelenideElement firstProductAtCart = $(AppiumBy.id("ru.av.vkusomania:id/swipeLayout"));
    SelenideElement imageEmptyCart = $(AppiumBy.id("ru.av.vkusomania:id/imageViewEmpty"));

    public CartPage deleteProductViaSwipe() {
        int offsetX = -firstProductAtCart.getSize().getWidth();
        swipe(firstProductAtCart, offsetX, 0);
        return this;
    }

    public CartPage checkEmptyCart() {
        imageEmptyCart.shouldBe(Condition.visible);
        return this;
    }
}
