package p5servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import p2entity.ControlButton;
import p2entity.KeyboardButtonEntity;
import p2entity.User;
import p4service.ButtonService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

@WebServlet("/save_button_settings")
public class SaveButtonSettingsServlet extends HttpServlet {

    private static User user;
    private final ButtonService service = ButtonService.getInstance();
    private static final HashSet<KeyboardButtonEntity> CONTROL_RATIO = new HashSet<>();
    private static final ArrayList<String[]> responseArray = new ArrayList<>();
    private static final String BUTTON_PREFIX = "VK_";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        clearResults(req);

        Arrays.stream(ControlButton.values())
                .forEach(button -> putIntoSet(button, req.getParameter(button.name().toLowerCase(Locale.ROOT))));

//        String buttonUp = req.getParameter("button_up");
//        String buttonDown = req.getParameter("button_down");
//        String buttonLeft = req.getParameter("button_left");
//        String buttonRight = req.getParameter("button_right");
//        String buttonA = req.getParameter("button_a");
//        String buttonB = req.getParameter("button_b");
//        String buttonC = req.getParameter("button_c");
//        String buttonD = req.getParameter("button_d");
//        String buttonE = req.getParameter("button_e");
//        String buttonF = req.getParameter("button_f");
//
//        putIntoSet(ControlButton.BUTTON_UP, buttonUp);
//        putIntoSet(ControlButton.BUTTON_DOWN, buttonDown);
//        putIntoSet(ControlButton.BUTTON_LEFT, buttonLeft);
//        putIntoSet(ControlButton.BUTTON_RIGHT, buttonRight);
//        putIntoSet(ControlButton.BUTTON_A, buttonA);
//        putIntoSet(ControlButton.BUTTON_B, buttonB);
//        putIntoSet(ControlButton.BUTTON_C, buttonC);
//        putIntoSet(ControlButton.BUTTON_D, buttonD);
//        putIntoSet(ControlButton.BUTTON_E, buttonE);
//        putIntoSet(ControlButton.BUTTON_F, buttonF);

        checkBeforeSend();

        req.getSession().setAttribute("answers_message", responseArray);
        resp.sendRedirect("console_settings");
    }

    private void clearResults(HttpServletRequest req) {
        responseArray.clear();
        CONTROL_RATIO.clear();
        user = (User) req.getSession().getAttribute("user");
    }

    private void putIntoSet(ControlButton controlButton, String buttonName) {
        KeyboardButtonEntity keyboardButton = KeyboardButtonEntity.build(
                BUTTON_PREFIX + buttonName.split(" ")[0],
                user.getId(),
                controlButton
        );
        CONTROL_RATIO.add(keyboardButton);
    }

    private void checkBeforeSend() {
        if (CONTROL_RATIO.size() == ControlButton.values().length) {
            responseArray.addAll(service.saveConsoleButtonsValues(CONTROL_RATIO));
        } else {
            responseArray.add(new String[]{"Not save.", " Have double of buttons"});
        }
    }
}
