package p5servlet.logApplicationServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import p2entity.User;
import p4service.UserService;
import p7coder.HashCoder;

import java.io.IOException;

@WebServlet("/change_pass")
public class PasswordChangerServlet extends HttpServlet {

    private final UserService service = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String oldPass = req.getParameter("old_pass");
        String newPass = req.getParameter("new_pass");
        String repeatPass = req.getParameter("repeat_pass");

        if(service.getUser(user.getName(), oldPass).isPresent()) {
            if(newPass.equals(repeatPass)) {
                service.changePass(user.getName(), HashCoder.getHash(newPass));
                req.setAttribute("answer_change", "change is OK");
            } else {
                req.setAttribute("answer_change", "wrong repeat password");
            }
        } else {
            req.setAttribute("answer_change", "wrong password");
        }
        req.getRequestDispatcher("change_pass_form").include(req,resp);
    }

}
