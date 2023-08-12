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
import p4service.ButtonService;

import java.io.IOException;
import java.util.*;

@WebServlet("/console")
public class ConsoleServlet extends HttpServlet {
    private final ButtonPusher buttonPusher = ButtonPusher.getInstance();
    private final ButtonService service = ButtonService.getInstance();
    private static final HashSet<String> PRESSED_BUTTONS = new HashSet<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        fillingCheckBoxes(req);
        Optional<String> optionalButtonName = Optional.ofNullable(req.getParameter("button_name"));
        HttpSession session = req.getSession();

        if (optionalButtonName.isPresent()) {
            String buttonName = optionalButtonName.get();
            String buttonCheckName = getCheckName(buttonName);
            String buttonColorName = getColorName(buttonName);
            Optional<String> buttonCheck = Optional.ofNullable(req.getParameter(buttonCheckName));
            int userId = ((User) session.getAttribute("user")).getId();
            Optional<KeyboardButtonEntity> buttonValue =
                    service.getButtonValue(userId, buttonName.toUpperCase(Locale.ROOT));

            if (buttonCheck.isPresent()) {
                if (PRESSED_BUTTONS.add(buttonName)) {
                    System.out.println("press " + buttonName);
                    buttonValue.ifPresent(buttonPusher::press);
                    session.setAttribute(buttonColorName, "blue");
                } else {
                    buttonValue.ifPresent(buttonPusher::release);
                    System.out.println("remove " + buttonName);
                    PRESSED_BUTTONS.remove(buttonName);
                    session.setAttribute(buttonColorName, "");
                }
            } else {
                PRESSED_BUTTONS.remove(buttonName);
                System.out.println("push " + buttonName);
                session.setAttribute(buttonColorName, "");
                buttonValue.ifPresent(buttonPusher::push);
            }
        }
        req.getRequestDispatcher(JspGuide.to("usage", "console")).forward(req, resp);
    }

    private void fillingCheckBoxes(HttpServletRequest req) {
        Arrays.stream(ControlButton.values())
                .map(ControlButton::name)
                .map(this::getCheckName)
                .peek(b -> req.getSession().setAttribute(b, ""))
                .filter(b -> req.getParameter(b) != null)
                .forEach(b -> req.getSession().setAttribute(b, "checked"));
    }

    private String getCheckName(String buttonName) {
        return "check_" + buttonName.split("_")[1].toLowerCase(Locale.ROOT);
    }

    private String getColorName(String buttonName) {
        return "color_" + buttonName.split("_")[1].toLowerCase(Locale.ROOT);
    }

}
