package org.example;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ClockServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        Date date = new Date();
        writer.println(
                "<html>" +
                "<body bgcolor = #F0FFFF>" +
                "<h1 align = center>" + date + "</h1>" +
                "</body> " +
                "</html>");
    }
}
