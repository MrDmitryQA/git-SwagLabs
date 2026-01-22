package com.example.test;
import com.example.base.BaseSauceDemo;
import com.example.saucedemo.LoginSteps;
import com.example.saucedemo.SwagLabsPageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

@Feature("Swag Labs")
@Owner("Барченко Д.О.")

public class PageFiltersTest extends BaseSauceDemo {

    String userName = "standard_user";
    String password = "secret_sauce";
    LoginSteps loginSteps = new LoginSteps();
    SwagLabsPageSteps swagLabsPageSteps = new SwagLabsPageSteps();

    @Tag("Test-004")
    @Link("https://www.saucedemo.com/")
    @Test(description = "Проверка работы фильтров")
    void filtersCheck() {
        loginSteps
                .avtorizationSwag(userName, password);
        swagLabsPageSteps
                .clickOk()
                .checkFilterAtoZ()
                .checkFilterZtoA()
                .checkFilterPriceLowToHigh()
                .checkFilterPriceHighToLow();
        sleep(2000);
    }
}
