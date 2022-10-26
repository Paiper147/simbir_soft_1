package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DeliveryAddressPage {

    SelenideElement notAllowLocationDataButton = $(AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button"));
    SelenideElement chooseBigDeliveryButton = $$(AppiumBy.id("ru.av.vkusomania:id/deliveryTimeTypeTitle")).filterBy(Condition.text("Широкий ассортимент")).first();
    SelenideElement setDeliveryTypeButton = $(AppiumBy.id("ru.av.vkusomania:id/deliveryTypesButtonNext"));
    SelenideElement setTimeslotDate = $(AppiumBy.id("ru.av.vkusomania:id/recyclerViewTimeslotsDeliveryDate"));
    SelenideElement setTimeslotTime = $(AppiumBy.id("ru.av.vkusomania:id/timeslotItemTagView"));
    SelenideElement setTimeslotButton = $(AppiumBy.id("ru.av.vkusomania:id/progressButtonTimeslotsAction"));

    public DeliveryAddressPage notAllowLocationData() {
        notAllowLocationDataButton.click();
        return this;
    }

    public DeliveryAddressPage selectBigDelivery() {
        chooseBigDeliveryButton.click();
        setDeliveryTypeButton.shouldBe(Condition.enabled).click();
        return this;
    }

    public DeliveryAddressPage selectDeliveryTime() {
        setTimeslotDate.click();
        setTimeslotTime.click();
        setTimeslotButton.click();
        return this;
    }
}
