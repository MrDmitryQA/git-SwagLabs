package com.example.test;
import com.example.base.BaseSauceDemo;
import com.example.saucedemo.LoginSteps;
import com.example.saucedemo.SwagLabsPageSteps;
import io.qameta.allure.Link;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.sleep;

public class InventorySideBarTest extends BaseSauceDemo {

    String userName = "standard_user";
    String password = "secret_sauce";
    LoginSteps loginSteps = new LoginSteps();
    SwagLabsPageSteps swagLabsPageSteps = new SwagLabsPageSteps();

    @Tag("Test-006")
    @Link("https://www.saucedemo.com/")
    @Test(description = "Проверка функционала кнопок боковой панели (сайдбара)")
    void inventorySideBar() {
        loginSteps
                .avtorizationSwag(userName, password);
        swagLabsPageSteps
                .clickOk()
                .inventorySideBarClick();
        swagLabsPageSteps
                .inventorySideBarCheck("All Items")
                .inventorySideBarCheck("About")
                .inventorySideBarCheck("Logout")
                .inventorySideBarCheck("Reset App State");
        swagLabsPageSteps
                .SideBarCLose()
                .inventorySideBarAllItems()
                .inventorySideBarAbout()
                .inventorySideBarResetAppState()
                .inventorySideBarResetLogout();
        sleep(2000);
    }
}
