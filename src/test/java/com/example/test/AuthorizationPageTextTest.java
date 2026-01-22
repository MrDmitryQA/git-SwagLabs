package com.example.test;
import com.example.base.BaseSauceDemo;
import com.example.saucedemo.LoginSteps;
import com.example.saucedemo.SwagLabsPageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;


@Feature("Swag Labs")
@Owner("Барченко Д.О.")

public class AuthorizationPageTextTest extends BaseSauceDemo {

    String logoText = "Swag Labs";
    LoginSteps loginSteps = new LoginSteps();
    SwagLabsPageSteps swagLabsPageSteps = new SwagLabsPageSteps();


    @Tag("Test-002")
    @Link("https://www.saucedemo.com/")
    @Test(description = "Проверка отображения элементов на странице")
    void testAuthText() {
        loginSteps
                .checkLogo(logoText)
                .checkUsernames()
                .checkPassword()
                .checkTextUsername()
                .checkTextPassword()
                .checkButtonLogin();
        swagLabsPageSteps
                .clickOk();
    }
}
