package p5servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import p1util.JspGuide;
import p4service.ButtonService;
import p4service.UserService;

import java.io.IOException;

@WebServlet("/console_settings")
public class ConsoleSettingsServlet extends HttpServlet {

    private final ButtonService buttonService = ButtonService.getInstance();
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("keyboard_buttons", buttonService.getKeyboardButtonsArray());
        req.setAttribute("connect_users", userService.getConnectUsers());

        req.getRequestDispatcher(JspGuide.to("console_settings")).forward(req, resp);
    }
}
