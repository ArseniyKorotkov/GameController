package p5servlet.logApplicationServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import p2entity.User;
import p4service.ButtonService;
import p4service.UserService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/delete_account")
public class DeleteAccountServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();
    private final ButtonService buttonService = ButtonService.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        ArrayList<String> findNamesCanDeleteUsers = userService.findNamesCanDeleteUsers(user.getName());
        for(String name : findNamesCanDeleteUsers) {
            if(req.getParameter(name + "_delete_account") != null) {
                buttonService.deleteConsoleValuesFor(userService.getIdByName(name));
                userService.deleteUserByName(name);
            }
        }

        resp.sendRedirect("delete_account_form");
    }
}
