package com.example.saucedemo;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class LoginElements {

   public static SelenideElement logo =  $x("//div[@class='login_logo']").as("Логотип");
   public static SelenideElement loginWindow =  $x("//input[@placeholder='Username']").as("Окно ввода логина");
   public static SelenideElement passWindow =  $x("//input[@placeholder='Password']").as("Окно ввода пароля");
   public static SelenideElement loginButton =  $x("//input[@class='submit-button btn_action']").as("Кнопка 'Логин'");
   public static SelenideElement acceptedUsernames =  $x("//div[@class='login_credentials']").as("Accepted usernames");
   public static SelenideElement acceptedPassword =  $x("//div[@class='login_password']").as("Accepted password");
   public static SelenideElement errorTextMessage =  $x("//h3[@data-test='error']").as("Сообщение об ошибке не корректных кредов");
   public static SelenideElement errorTextMessageClose =  $x("//button[@class='error-button']").as("Кнопка закрытия 'Сообщения об ошибке не корректных кредов'");
}
