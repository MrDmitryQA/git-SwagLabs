package com.example.test;
import com.example.base.BaseSauceDemo;
import com.example.saucedemo.LoginSteps;
import com.example.saucedemo.SwagLabsPageSteps;
import io.qameta.allure.Link;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class CheckoutInventoryTest extends BaseSauceDemo {

    String productName = "Sauce Labs Backpack";
    String productPrice = "29.99";

    String userName = "standard_user";
    String password = "secret_sauce";

    String nameName = "Супер";
    String lastName = "Пупер";
    String postalCode = "Автотестер";

    String gift = "Free Pony Express Delivery!";

    LoginSteps loginSteps = new LoginSteps();
    SwagLabsPageSteps swagLabsPageSteps = new SwagLabsPageSteps();

    @Tag("Test-008")
    @Link("https://www.saucedemo.com/")
    @Test(description = "Проверка раздела 'checkout' в корзине")
    void shoppingTestOutside() {
        loginSteps
                .avtorizationSwag(userName, password);
        swagLabsPageSteps
                .clickOk()
                .shoppingCartPlusOne()
                .shoppingCheckout(nameName, lastName, postalCode)
                .checkoutOverview(productName, productPrice, gift);
        sleep(2000);
    }
}
