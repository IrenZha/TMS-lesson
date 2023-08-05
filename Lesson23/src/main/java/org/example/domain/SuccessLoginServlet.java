package org.example.domain;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SuccessLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var login = req.getParameter("login");
        HttpSession session = req.getSession();
        Object attrSession = session.getAttribute("attrSession");
        if (attrSession == null) {
            session.setAttribute("attrSession", "testValue");
        } else {
            resp.getWriter().println(
                    "<html>" +
                            "<body bgcolor = #F0FFFF  text=#00008B>" +
                            "<h1 align = center> Welcome back " + login + "!</h1>" +
                            "</body> " +
                            "</html>");
        }
    }
}
