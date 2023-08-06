package buttons;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Field;

@WebServlet("/buttons/butA")
public class ButtonA extends HttpServlet {
    private final Robot robot = Single.ROBOT.getRobot();
    private boolean isPressedUp;
    private boolean isPressedDown;
    private boolean isPressedLeft;
    private boolean isPressedRight;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String but = "NUM_LOCK"; /******/
        try {
            Field field = KeyEvent.class.getField("VK_" + but);
            int buttonNumber = field.getInt(field);

            if(buttonNumber == KeyEvent.VK_UP) {
                if(!isPressedUp) {
                    robot.keyPress(buttonNumber);
                    isPressedUp = true;
                } else {
                    robot.keyRelease(buttonNumber);
                    isPressedUp = false;
                }
            } else {
                robot.keyPress(buttonNumber);
                robot.keyRelease(buttonNumber);
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/controller/console");
    }

}
