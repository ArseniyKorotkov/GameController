package buttons;

import java.awt.*;

public enum Single {
    ROBOT;


    private static Robot robot;
    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public Robot getRobot() {
        return robot;
    }
}
