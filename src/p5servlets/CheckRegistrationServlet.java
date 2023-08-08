package p5servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import p4service.UserService;

import java.io.IOException;

@WebServlet("/check_regis")
public class CheckRegistrationServlet extends HttpServlet {

    private final UserService service = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userName");
        if(service.haveName(name)) {
            System.out.println("try new name"); /********/
        } else {
            System.out.println("please, wait master`s answer"); /*******/
        }
    }
}
