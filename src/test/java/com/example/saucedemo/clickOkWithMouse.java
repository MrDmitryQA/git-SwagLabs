package com.example.saucedemo;
import java.awt.*;
import java.awt.event.InputEvent;

public class clickOkWithMouse {

    public static void clickOkButton(int x, int y) {
        try {
            Robot robot = new Robot();

            robot.delay(2000);

            robot.mouseMove(x, y);

            robot.delay(500);

            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            robot.delay(1000);

        } catch (AWTException e) {
            throw new RuntimeException("Ошибка при клике по координатам", e);
        }
    }
}
