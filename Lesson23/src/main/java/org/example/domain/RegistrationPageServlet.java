package org.example.domain;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var login = req.getParameter("login");
        var password = req.getParameter("password");
        UserData userData = new UserData();
              userData.addUser(login, password);
            resp.getWriter().println(
                    "<html>" +
                            "<body bgcolor = #F0FFFF  text=#00008B>" +
                            "<h1 align = center> Hello new user!</h1>" +
                            "</body> " +
                            "</html>");
    }
}
