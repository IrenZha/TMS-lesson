package web;

import service.UserData;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/signIn")
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (UserData.isContains(login, password)) {
            chain.doFilter(request, response);
        }
        if (UserData.userMap.containsKey(login)) {
            request.setAttribute("massage", "Login already exists");
        } else request.setAttribute("login", login);
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }

    @Override
    public void destroy() {

    }
}
