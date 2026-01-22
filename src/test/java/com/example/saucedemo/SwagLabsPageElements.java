package com.example.saucedemo;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class SwagLabsPageElements {

    public static SelenideElement logo =  $x("//div[@class='app_logo']").as("Логотип");
    public static SelenideElement filter =  $x("//select[@class='product_sort_container']").as("Фильтр списка");
    public static SelenideElement firstProduct =  $x("(//div[@class='inventory_item_description'])[1]").as("Первый товар в списке");
    public static SelenideElement shoppingCart =  $x("//a[@class='shopping_cart_link']").as("Кнопка корзины");
    public static SelenideElement buttonRemoveInside =  $x("//button[@name='remove']").as("Кнопка 'Удаления' товара из корзины в карточке товара");
    public static SelenideElement buttonRemoveCart =  $x("//button[@name='remove-sauce-labs-backpack']").as("Кнопка 'Удаления' товара из корзины в корзине");
    public static SelenideElement yourCartLogo =  $x("//span[@class='title' and text()='Your Cart']").as("Название раздела корзины");
    public static SelenideElement inventorySideBar =  $x("//button[@id='react-burger-menu-btn']").as("Кнопка боковой панели (сайдбара)");
    public static SelenideElement sideBarClose =  $x("//button[@id='react-burger-cross-btn']").as("Кнопка закрытия боковой панели (сайдбара)");
    public static SelenideElement checkout =  $x("//button[@id='checkout']").as("Кнопка 'checkout'");

    public static SelenideElement summarySubtotalLabel (String summ){
        return $x("//div[@class='summary_subtotal_label' and text()='" + summ + "']").as("Сумма товара = \"" + summ + "\" ");
    }
    public static SelenideElement inputName (String name){
        return $x("//input[@name='"+ name +"']").as("Поле \"" + name + "\" в анкете");
    }
    public static SelenideElement shoppingCartPlus (String index){
        return $x("//span[@class='shopping_cart_badge' and text()='" + index + "']").as("Индекс корзины").as("Индекс корзины");
    }
    public static SelenideElement buttonCartHead (String name){
        return $x("//button[@name='"+ name +"']").as("Кнопка 'Добавления' товара в корзину c главной страницы");
    }
    public static SelenideElement filterWithParam (String filterName){
        return $x("//option[text()='" + filterName + "']").as("Низпадающий список фильтра \"" + filterName + "\"");
    }
    public static SelenideElement productName (String product){
        return $x("//div[@class='inventory_item_name ' and text()='" + product + "']").as("Название товара \"" + product + "\" в карточке (гл.страница)");
    }
    public static SelenideElement productNameCart (String product){
        return $x("//div[@class='inventory_item_name' and text()='" + product + "']").as("Название товара \"" + product + "\" в корзине");
    }
    public static SelenideElement productNamePrice (String price){
        return $x("//div[@class='inventory_item_price' and text()='" + price + "']").as("Название товара \"" + price + "\" в корзине");
    }
    public static SelenideElement productNameInside (String product){
        return $x("//div[@class='inventory_details_name large_size' and text()='" + product + "']").as("Название товара \"" + product + "\" в карточке (внутри карточки");
    }
    public static SelenideElement buttonInside (String id, String buttonName){
        return $x("//button[@id='" + id + "']").as("Название товара \"" + buttonName + "\" в карточке (внутри карточки");
    }
    public static SelenideElement sideBarButton (String buttonName){
        return $x("//a[@class='bm-item menu-item' and text()='" + buttonName + "']").as("Раздел \"" + buttonName + "\" в сайдбаре");
    }
    public static SelenideElement overviewCount (String count){
        return $x("//div[@class='cart_quantity' and text()='" + count + "']").as("Количество товара одной позиции =  \"" + count + "\"");
    }
    public static SelenideElement overviewTextInfo (String text){
        return $x("//div[@class='summary_info_label' and text()='" + text + "']").as("Текст \"" + text + "\" в карточке 'Checkout: Overview'");
    }
    public static SelenideElement overviewTextValue (String text){
        return $x("//div[@class='summary_value_label' and text()='" + text + "']").as("Текст \"" + text + "\" в карточке 'Checkout: Overview'");
    }
}
