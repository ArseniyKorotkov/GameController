package p5servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import p1util.JspGuide;
import p4service.ButtonService;

import java.io.IOException;

@WebServlet("/console_settings")
public class ConsoleSettingsServlet extends HttpServlet {

    ButtonService service = ButtonService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("keyboard_buttons", service.getKeyboardButtons());
        String substring = service.getKeyboardButtons().get(0).name().substring(3);
        req.getRequestDispatcher(JspGuide.to("console_settings")).forward(req, resp);
    }
}
