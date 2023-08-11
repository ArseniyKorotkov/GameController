package p5servlet.usageApplicatonServlet.menuContent;

import button.ButtonPusher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import p1util.JspGuide;
import p2entity.KeyboardButtonEntity;
import p2entity.User;
import p4service.ButtonService;

import java.io.IOException;
import java.util.Locale;
import java.util.Optional;

@WebServlet("/console")
public class ConsoleServlet extends HttpServlet {
    private final ButtonPusher buttonPusher = ButtonPusher.getInstance();
    private final ButtonService service = ButtonService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> buttonName = Optional.ofNullable(req.getParameter("button_name"));
        if(buttonName.isPresent()) {
            int userId = ((User) req.getSession().getAttribute("user")).getId();
            Optional<KeyboardButtonEntity> buttonValue =
                    service.getButtonValue(userId, buttonName.get().toUpperCase(Locale.ROOT));

            buttonValue.ifPresent(buttonPusher::push);
        }

        req.getRequestDispatcher(JspGuide.to("usage","console")).forward(req, resp);
    }

}
