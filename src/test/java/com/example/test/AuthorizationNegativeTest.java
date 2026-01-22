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

public class AuthorizationNegativeTest extends BaseSauceDemo  {

    String userName = "Java_is_AWESOME";
    String password = "Selenide_is_COOL";
    LoginSteps loginSteps = new LoginSteps();
    SwagLabsPageSteps swagLabsPageSteps = new SwagLabsPageSteps();

    @Tag("Test-001")
    @Link("https://www.saucedemo.com/")
    @Test(description = "Проверка ошибки авторизации")
    void testAuthNot() {
        loginSteps
                .avtorizationSwag(userName, password)
                .errorTextMessageElement();
        swagLabsPageSteps
                .clickOk();
        sleep(2000);
    }
}

