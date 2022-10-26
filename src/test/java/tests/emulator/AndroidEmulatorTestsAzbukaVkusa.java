package tests.emulator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

@Tag("androidEmulatorTestsAzbukaVkusa")
public class AndroidEmulatorTestsAzbukaVkusa extends TestBaseEmulatorAzbukaVkusa {

    @BeforeEach
    void preconditions() {
        step("Skip onboarding", () -> {
            onboardingPage.skipOnboardingWith18plus();
        });

        step("Skip instructions", () -> {
            homePage.skipInstructions();
        });
    }

    @Test
    void deleteProductAtCartViaSwipe() {
        step("Setting the address and delivery date", () -> {
            homePage.goToDeliveryAddressPage();
            deliveryAddressPage.notAllowLocationData()
                    .selectBigDelivery()
                    .selectDeliveryTime();
        });

        step("Go to catalog and add some product to cart", () -> {
            homePage.goToCatalog();
            catalogPage.chooseFirstCategory();
            productsListPage.firstProductAddToCart();
        });

        step("Go to cart", () -> {
            homePage.goToCart();
            sleep(2000);
        });

        step("Delete product via swipe", () -> {
            cartPage.deleteProductViaSwipe();
        });

        step("Check empty card", () -> {
            cartPage.checkEmptyCart();
        });
    }

    @Test
    void sortingTest() {
        step("Setting the address and delivery date", () -> {
            homePage.goToDeliveryAddressPage();
            deliveryAddressPage.notAllowLocationData()
                    .selectBigDelivery()
                    .selectDeliveryTime();
        });

        step("Go to catalog and search some product", () -> {
            homePage.goToCatalog();
            catalogPage.searchClick()
                    .sendSearchKeys("мука");
        });

        step("Sorting: min to max price", () -> {
            productsListPage.tapToSortingButton()
                    .sortingMinToMax();
            sleep(2000);
        });

        step("Check sorting", () -> {
            productsListPage.checkSortingMinToMax();
        });
    }
}
