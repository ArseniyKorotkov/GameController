package p5servlet.usageApplicatonServlet.menuContent;

import button.ButtonPusher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import p1util.JspGuide;
import p2entity.ControlButton;
import p2entity.KeyboardButtonEntity;
import p2entity.User;

import java.io.IOException;
import java.util.*;

@WebServlet("/console")
public class ConsoleServlet extends HttpServlet {
    private final ButtonPusher buttonPusher = ButtonPusher.getInstance();
    private static final HashMap<Integer, HashSet<String>> PRESSED_BUTTONS = new HashMap<>();
    private static HashMap<Integer, HashMap<String, Optional<KeyboardButtonEntity>>> buttonsValues;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int userId = ((User) session.getAttribute("user")).getId();


        buttonsValues = (HashMap<Integer, HashMap<String, Optional<KeyboardButtonEntity>>>)
                session.getAttribute("buttons_values");

        fillingCheckBoxes(req);

        pressButton(req, session, userId);

        req.getRequestDispatcher(JspGuide.to("usage", "console")).forward(req, resp);
    }

    private void fillingCheckBoxes(HttpServletRequest req) {
        Arrays.stream(ControlButton.values())
                .map(ControlButton::name)
                .map(this::getCheckName)
                .filter(buttonName -> req.getParameter(buttonName) != null)
                .forEach(buttonName -> req.setAttribute(buttonName, "checked"));
    }

    private void pressButton(HttpServletRequest req, HttpSession session, int userId) {
        Optional<String> optionalButtonName = Optional.ofNullable(req.getParameter("button_name"));

        if (optionalButtonName.isPresent()) {
            String buttonName = optionalButtonName.get();
            String buttonCheckName = getCheckName(buttonName);
            String buttonColorName = getColorName(buttonName);
            Optional<String> buttonCheck = Optional.ofNullable(req.getParameter(buttonCheckName));

            if (!PRESSED_BUTTONS.containsKey(userId)) {
                PRESSED_BUTTONS.put(userId, new HashSet<>());
            }

            if (buttonsValues.get(userId).containsKey(buttonName.toUpperCase(Locale.ROOT))) {

                if (buttonCheck.isPresent()) {

                    if (PRESSED_BUTTONS.get(userId).add(buttonName)) {

                        buttonsValues.get(userId).get(buttonName.toUpperCase(Locale.ROOT)).ifPresent(buttonPusher::press);
                        session.setAttribute(buttonColorName, "blue");
                    } else {
                        buttonsValues.get(userId).get(buttonName.toUpperCase(Locale.ROOT)).ifPresent(buttonPusher::release);
                        PRESSED_BUTTONS.get(userId).remove(buttonName);
                        session.setAttribute(buttonColorName, "");
                    }
                } else {
                    PRESSED_BUTTONS.get(userId).remove(buttonName);
                    session.setAttribute(buttonColorName, "");
                    buttonsValues.get(userId).get(buttonName.toUpperCase(Locale.ROOT)).ifPresent(buttonPusher::push);
                }
            }
        }
    }

    private String getCheckName(String buttonName) {
        return "check_" + buttonName.split("_")[1].toLowerCase(Locale.ROOT);
    }

    private String getColorName(String buttonName) {
        return "color_" + buttonName.split("_")[1].toLowerCase(Locale.ROOT);
    }

}
