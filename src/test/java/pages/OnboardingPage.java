package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import helpers.BaseMethods;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class OnboardingPage extends BaseMethods {

    SelenideElement skipOnboardButton = $(AppiumBy.id("ru.av.vkusomania:id/textViewLeftAction"));
    SelenideElement sayYesToSkipOnboardButton = $(AppiumBy.id("android:id/button1"));
    SelenideElement say18plusOnOnboardPageButton = $(AppiumBy.id("ru.av.vkusomania:id/textViewRightAction"));

    public OnboardingPage skipOnboardingWith18plus() {
        skipOnboardButton.shouldHave(Condition.text("ПРОПУСТИТЬ")).click();
        sayYesToSkipOnboardButton.shouldHave(Condition.text("ДА")).click();
        say18plusOnOnboardPageButton.shouldHave(Condition.text("МНЕ ЕСТЬ 18")).click();
        return this;
    }
}
