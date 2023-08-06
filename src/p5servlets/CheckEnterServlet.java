package p5servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import p2entity.User;
import p4service.UserService;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/check_enter")
public class CheckEnterServlet extends HttpServlet {

    private final UserService service = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userName");
        String password = req.getParameter("userPass");
        Optional<User> user = service.haveUser(name, password);
        if(user.isEmpty()) {
            if(service.haveName(name)) {
                System.out.println("wrong pass"); /******/
            } else {
                System.out.println("no such account"); /*******/
            }
            resp.sendRedirect("control");
        } else if(!service.getConnectUsers().contains(user.get())) {
            System.out.println("this account already use"); /********/
            resp.sendRedirect("control");
        } else {
            req.getSession().setAttribute("user", user.get());
            resp.sendRedirect("menu");
        }
    }
}
