package p6filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({"/buttons/*", "/console", "/menu"})
public class Filter implements jakarta.servlet.Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpRequest.getSession();
        if(session.getAttribute("user") != null) {
            System.out.println("chain"); /******/
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            System.out.println("not chain"); /********/
            ((HttpServletResponse)servletResponse).sendRedirect("/controller/control");
        }


    }
}
