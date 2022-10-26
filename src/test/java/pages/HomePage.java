package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import helpers.BaseMethods;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage extends BaseMethods {

    SelenideElement skipInstructionsButton = $$(AppiumBy.className("android.widget.TextView")).filterBy(Condition.text("ПРОПУСТИТЬ")).first();
    SelenideElement sayYesToSkipHomeInstructionsButton = $(AppiumBy.id("ru.av.vkusomania:id/buttonPositive"));
    SelenideElement deliveryAddressElement = $(AppiumBy.id("ru.av.vkusomania:id/viewBackground"));
    SelenideElement catalogTabBar = $(AppiumBy.id("ru.av.vkusomania:id/menuItemCatalog"));
    SelenideElement cartTabBar = $(AppiumBy.id("ru.av.vkusomania:id/menuItemCart"));

    public HomePage skipInstructions() {
        skipInstructionsButton.click();
        sayYesToSkipHomeInstructionsButton.shouldHave(Condition.text("ПРОПУСТИТЬ")).click();
        return this;
    }

    public HomePage goToDeliveryAddressPage() {
        deliveryAddressElement.click();
        return this;
    }

    public HomePage goToCatalog() {
        catalogTabBar.click();
        return this;
    }

    public HomePage goToCart() {
        cartTabBar.click();
        return this;
    }
}
