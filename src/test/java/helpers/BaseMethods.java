package helpers;

import com.codeborne.selenide.SelenideElement;
import com.google.common.collect.ImmutableMap;

import static com.codeborne.selenide.Selenide.webdriver;

public class BaseMethods {
    public void swipe(SelenideElement element, int offsetX, int offsetY) {
        webdriver().driver().actions().clickAndHold(element).moveByOffset(offsetX, offsetY).release().perform();
    }

    public void tabEnterOnKeyboard() {
        webdriver().driver().executeJavaScript("mobile: performEditorAction", ImmutableMap.of("action", "done"));
    }

    public int splitPriceWithoutRubles(String price) {
        return Integer.parseInt(price.split(" ₽")[0]);
    }
}
