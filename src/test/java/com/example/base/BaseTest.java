package com.example.base;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    @BeforeSuite
    public void setUpSuite() {
        // Автоматическая установка драйвера
        WebDriverManager.chromedriver().setup();

        // Настройки Selenide
        Configuration.browser = "chrome";
        Configuration.headless = false; // false - видим браузер
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        Configuration.screenshots = true;
        Configuration.savePageSource = false;
    }

    @BeforeMethod
    public void setUp() {
        // Открываем браузер перед каждым тестом
        open("https://ya.ru/");
    }

    @AfterMethod
    public void tearDown() {
        // Закрываем браузер после каждого теста
        closeWebDriver();
    }
}