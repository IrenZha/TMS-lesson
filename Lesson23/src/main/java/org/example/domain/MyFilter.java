package org.example.domain;

import org.example.exception.LoginIsNullException;
import org.example.exception.UserLoginFailedException;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        UserData userData = new UserData();
        var login = request.getParameter("login");
        var password = request.getParameter("password");
        try {
            if (!userData.checkExistUser(login, password)){
                request.getRequestDispatcher("/registration").forward(request, response);
            }  else {
                try {
                    if (userData.checkPassword(login, password)) {
                        chain.doFilter(request, response);
                    }
                } catch (UserLoginFailedException exception) {
                    response.getWriter().println("Invalid password");
                }
            }
        }catch (LoginIsNullException exception){
            response.getWriter().println("Login or password is null");
        }
    }

    @Override
    public void destroy() {

    }
}

