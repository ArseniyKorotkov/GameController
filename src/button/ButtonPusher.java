package button;

import p2entity.KeyboardButtonEntity;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;

public final class ButtonPusher {
    private final static Robot robot = SingleRobot.ROBOT.getRobot();
    private final static ButtonPusher button = new ButtonPusher();

    private ButtonPusher() {

    }

    public void push(KeyboardButtonEntity keyboardButton) {
        try {

            Field field = KeyEvent.class.getField(keyboardButton.name());
            int buttonNumber = field.getInt(field);
            robot.keyPress(buttonNumber);
            robot.keyRelease(buttonNumber);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    public static ButtonPusher getInstance() {
        return button;
    }
}
