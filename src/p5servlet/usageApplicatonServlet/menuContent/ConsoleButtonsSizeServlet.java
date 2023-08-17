package p5servlet.usageApplicatonServlet.menuContent;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/console_buttons_size")
public class ConsoleButtonsSizeServlet extends HttpServlet {

    private final static int SWITCH_SIZE = 10;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int size = (int) session.getAttribute("control_buttons_size");
        if (req.getParameter("small") != null && size > 100) {
            size -= SWITCH_SIZE;
        } else if (req.getParameter("big") != null && size < 600) {
            size += SWITCH_SIZE;
        }
        session.setAttribute("control_buttons_size", size);

        resp.sendRedirect("console");
    }

}
