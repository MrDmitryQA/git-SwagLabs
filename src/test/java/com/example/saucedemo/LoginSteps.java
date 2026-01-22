package com.example.saucedemo;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.*;

public class LoginSteps {

    @Step("Проверка отображения логотипа страницы (Не авторизованная зона)")
    public LoginSteps checkLogo (String logoText) {
        LoginElements.logo.shouldBe(visible);
        LoginElements.logo.shouldHave(text(logoText));
        return this;
    }

    @Step("Проверка списка 'usernames' для входа")
    public LoginSteps checkUsernames () {
        LoginElements.acceptedUsernames.shouldBe(visible);
        LoginElements.acceptedUsernames.shouldHave(text("Accepted usernames are:\nstandard_user\nlocked_out_user\nproblem_user\nperformance_glitch_user\nerror_user\nvisual_user"));
        return this;
    }

    @Step("Проверка списка 'password' для входа")
    public LoginSteps checkPassword () {
        LoginElements.acceptedPassword.shouldBe(visible);
        LoginElements.acceptedPassword.shouldHave(text("secret_sauce"));
        return this;
    }

    @Step("Проверка тектовки поля 'Username'")
    public LoginSteps checkTextUsername () {
        LoginElements.loginWindow.shouldBe(visible)
                                .shouldBe(enabled);
        LoginElements.loginWindow.shouldHave(attribute("placeholder", "Username"));
        return this;
    }

    @Step("Проверка тектовки поля 'Username'")
    public LoginSteps checkTextPassword () {
        LoginElements.passWindow.shouldBe(visible)
                                .shouldBe(enabled);
        LoginElements.passWindow.shouldHave(attribute("placeholder", "Password"));
        return this;
    }

    @Step("Проверка тектовки кнопки 'Login'")
    public LoginSteps checkButtonLogin () {
        LoginElements.loginButton.shouldBe(visible)
                                .shouldBe(enabled);
        LoginElements.loginButton.shouldHave(value("Login"));
        return this;
    }

    @Step("Авторизация на 'Swag Labs'")
    public LoginSteps avtorizationSwag (String userName, String password) {
        LoginElements.loginWindow.shouldBe(visible).shouldBe(enabled)
                .setValue(userName);
        LoginElements.passWindow.shouldBe(visible).shouldBe(enabled)
                .setValue(password);
        LoginElements.loginButton.shouldBe(visible).shouldBe(enabled)
                .click();
        return this;
    }

    @Step("Проверка сообщения об ошибке не корректных кредов")
    public LoginSteps errorTextMessageElement () {
        LoginElements.errorTextMessage.shouldBe(visible).shouldBe(enabled)
                .shouldHave(text("Epic sadface: Username and password do not match any user in this service"));
        LoginElements.errorTextMessageClose.shouldBe(visible).shouldBe(enabled)
                .click();
        LoginElements.errorTextMessage.shouldNotBe(visible);
        return this;
    }
}
