package com.example.saucedemo;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SwagLabsPageSteps {

    @Step("Проверка отображения логотипа страницы (Авторизованная зона)")
    public SwagLabsPageSteps checkLogoSwagLabs () {
        SwagLabsPageElements.logo.shouldBe(visible);
        SwagLabsPageElements.logo.shouldHave(text("Swag Labs"));
        return this;
    }

    @Step("Проверка фильтра списка 'Name (A to Z)")
    public SwagLabsPageSteps checkFilterAtoZ () {
        SwagLabsPageElements.filter
                .shouldBe(visible)
                .shouldBe(enabled).click();
        SwagLabsPageElements.filterWithParam("Name (A to Z)")
                .shouldBe(visible)
                .shouldBe(enabled).click();
        SwagLabsPageElements.firstProduct
                .shouldBe(visible)
                .shouldBe(enabled)
                .shouldHave(text("Sauce Labs Backpack"));
        return this;
    }

    @Step("Проверка фильтра списка 'Name (Z to A)'")
    public SwagLabsPageSteps checkFilterZtoA () {
        SwagLabsPageElements.filter
                .shouldBe(visible)
                .shouldBe(enabled).click();
        SwagLabsPageElements.filterWithParam("Name (Z to A)")
                .shouldBe(visible)
                .shouldBe(enabled).click();
        SwagLabsPageElements.firstProduct
                .shouldBe(visible)
                .shouldBe(enabled)
                .shouldHave(text("Test.allTheThings() T-Shirt (Red)"));
        return this;
    }

    @Step("Проверка фильтра списка 'Price (low to high)'")
    public SwagLabsPageSteps checkFilterPriceLowToHigh () {
        SwagLabsPageElements.filter
                .shouldBe(visible)
                .shouldBe(enabled).click();
        SwagLabsPageElements.filterWithParam("Price (low to high)")
                .shouldBe(visible)
                .shouldBe(enabled).click();
        SwagLabsPageElements.firstProduct
                .shouldBe(visible)
                .shouldBe(enabled)
                .shouldHave(text("Sauce Labs Onesie"));
        return this;
    }

    @Step("Проверка фильтра списка 'Price (high to low)'")
    public SwagLabsPageSteps checkFilterPriceHighToLow () {
        SwagLabsPageElements.filter
                .shouldBe(visible)
                .shouldBe(enabled).click();
        SwagLabsPageElements.filterWithParam("Price (high to low)")
                .shouldBe(visible)
                .shouldBe(enabled).click();
        SwagLabsPageElements.firstProduct
                .shouldBe(visible)
                .shouldBe(enabled)
                .shouldHave(text("Sauce Labs Fleece Jacket"));
        return this;
    }

    @Step("Добавление товара в корзину - из карточки товара")
    public SwagLabsPageSteps shoppingCartPlus (String productName ) {
        SwagLabsPageElements.productName(productName)
                .shouldBe(visible, Duration.ofSeconds(2)).shouldBe(enabled).click();
        SwagLabsPageElements.productNameInside(productName)
                .shouldBe(visible, Duration.ofSeconds(2)).shouldBe(enabled);
        SwagLabsPageElements.buttonInside("add-to-cart","Add to cart")
                .shouldBe(visible).shouldBe(enabled).click();
        SwagLabsPageElements.buttonInside("remove","Remove")
                .shouldBe(visible).shouldBe(enabled);
        SwagLabsPageElements.shoppingCart
                .shouldBe(visible).shouldBe(enabled);
        SwagLabsPageElements.shoppingCartPlus("1")
                .shouldBe(visible).shouldBe(enabled);
        SwagLabsPageElements.buttonInside("remove","Remove")
                .shouldBe(visible).shouldBe(enabled).click();
        SwagLabsPageElements.shoppingCartPlus("1")
                .shouldNot(exist);
        return this;
    }

    @Step("Добавление двух товаров в корзину - с главного экрана")
    public SwagLabsPageSteps shoppingCartPlusTwo () {
        SwagLabsPageElements.buttonCartHead("add-to-cart-sauce-labs-backpack")
                .shouldBe(visible).shouldBe(enabled).click();
        SwagLabsPageElements.buttonCartHead("add-to-cart-sauce-labs-bike-light")
                .shouldBe(visible).shouldBe(enabled).click();
        SwagLabsPageElements.shoppingCartPlus("2")
                .shouldBe(visible);
        return this;
    }

    @Step("Добавление одного (первого) товара в корзину - с главного экрана")
    public SwagLabsPageSteps shoppingCartPlusOne () {
        SwagLabsPageElements.buttonCartHead("add-to-cart-sauce-labs-backpack")
                .shouldBe(visible).shouldBe(enabled).click();
        SwagLabsPageElements.shoppingCartPlus("1")
                .shouldBe(visible);
        return this;
    }

    @Step("Проверка товара в корзине")
    public SwagLabsPageSteps shoppingCartProduct (String productName) {
        SwagLabsPageElements.shoppingCart
                .shouldBe(visible).shouldBe(enabled).click();
        SwagLabsPageElements.yourCartLogo
                .shouldBe(visible);
        SwagLabsPageElements.productNameCart(productName)
                .shouldBe(visible);
        SwagLabsPageElements.buttonRemoveCart
                .shouldBe(visible).shouldBe(enabled).click();
        SwagLabsPageElements.productNameCart(productName)
                .shouldNotBe(visible);
        return this;
    }

    @Step("Проверка раздела 'Checkout' в корзине")
    public SwagLabsPageSteps shoppingCheckout (String nameName, String lastName, String postalCode) {
        SwagLabsPageElements.shoppingCart
                .shouldBe(visible).shouldBe(enabled).click();
        SwagLabsPageElements.yourCartLogo
                .shouldBe(visible);
        SwagLabsPageElements.checkout
                .shouldBe(visible).shouldBe(enabled).click();
        SwagLabsPageElements.inputName("firstName")
                .shouldBe(visible).shouldBe(enabled).setValue(nameName);
        SwagLabsPageElements.inputName("lastName")
                .shouldBe(visible).shouldBe(enabled).setValue(lastName);
        SwagLabsPageElements.inputName("postalCode")
                .shouldBe(visible).shouldBe(enabled).setValue(postalCode);
        SwagLabsPageElements.inputName("continue")
                .shouldBe(visible).shouldBe(enabled).click();
        return this;
    }

    @Step("Проверка раздела 'Overview' в 'Checkout'")
    public SwagLabsPageSteps checkoutOverview (String productName, String productPrice, String gift) {
        SwagLabsPageElements.overviewCount("1").shouldBe(visible);
        SwagLabsPageElements.productNameCart(productName).shouldBe(visible);
        SwagLabsPageElements.productNamePrice(productPrice).shouldBe(visible);
        SwagLabsPageElements.summarySubtotalLabel(productPrice).shouldBe(visible);

        SwagLabsPageElements.overviewTextInfo("Payment Information:").shouldBe(visible);
        SwagLabsPageElements.overviewTextInfo("Shipping Information:").shouldBe(visible);
        SwagLabsPageElements.overviewTextInfo("Price Total").shouldBe(visible);

        SwagLabsPageElements.overviewTextValue(gift).shouldBe(visible);
        return this;
    }

    @Step("Нажатие 'Ок' в предупреждающем окне Chrome")
    public SwagLabsPageSteps clickOk () {
        if (SwagLabsPageElements.logo.isDisplayed()){
            clickOkWithMouse.clickOkButton(1115, 360);
        }
        return this;
    }

    @Step("Переход в сайд бар")
    public SwagLabsPageSteps inventorySideBarClick () {
        SwagLabsPageElements.inventorySideBar
                .shouldBe(visible).shouldBe(enabled)
                .click();
        return this;
    }

    @Step("Проверка элементов сайдбара")
    public SwagLabsPageSteps inventorySideBarCheck (String buttonName) {
        SwagLabsPageElements.sideBarButton(buttonName)
                .shouldBe(visible).shouldBe(enabled);
        return this;
    }

    @Step("Закрыть активный сайдбар")
    public SwagLabsPageSteps SideBarCLose () {
        SwagLabsPageElements.sideBarClose
                .shouldBe(visible).shouldBe(enabled).click();
        return this;
    }

    @Step("Проверка работы кнопки 'All Items'")
    public SwagLabsPageSteps inventorySideBarAllItems () {
        SwagLabsPageElements.shoppingCart
                .shouldBe(visible).shouldBe(enabled).click();
        SwagLabsPageElements.inventorySideBar
                .shouldBe(visible).shouldBe(enabled).click();
        sleep(3000);
        SwagLabsPageElements.sideBarButton("All Items")
                .shouldBe(visible, Duration.ofSeconds(10)).shouldBe(enabled).click();
        SwagLabsPageElements.firstProduct
                .shouldBe(visible).shouldBe(enabled);
        return this;
    }

    @Step("Проверка работы кнопки 'About'")
    public SwagLabsPageSteps inventorySideBarAbout () {
        SwagLabsPageElements.inventorySideBar
                .shouldBe(visible).shouldBe(enabled).click();
        SwagLabsPageElements.sideBarButton("About")
                .shouldBe(visible).shouldBe(enabled);
        SwagLabsPageElements.sideBarClose
                .shouldBe(visible).shouldBe(enabled).click();
        return this;
    }

    @Step("Проверка работы кнопки 'Reset App State'")
    public SwagLabsPageSteps inventorySideBarResetAppState () {
        shoppingCartPlusTwo();
        SwagLabsPageElements.inventorySideBar
                .shouldBe(visible).shouldBe(enabled).click();
        SwagLabsPageElements.sideBarButton("Reset App State")
                .shouldBe(visible).shouldBe(enabled).click();
        SwagLabsPageElements.sideBarClose
                .shouldBe(visible).shouldBe(enabled).click();
        SwagLabsPageElements.shoppingCartPlus("2")
                .shouldNot(exist);
        return this;
    }

    @Step("Проверка работы кнопки 'Logout'")
    public SwagLabsPageSteps inventorySideBarResetLogout () {
        SwagLabsPageElements.inventorySideBar
                .shouldBe(visible).shouldBe(enabled).click();
        SwagLabsPageElements.sideBarButton("Logout")
                .shouldBe(visible).shouldBe(enabled).click();
        LoginElements.loginWindow
                .shouldBe(visible).shouldBe(enabled);
        LoginElements.passWindow
                .shouldBe(visible).shouldBe(enabled);
        return this;
    }
}
