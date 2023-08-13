package web;

import domain.User;
import service.UserData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    UserData dataBase = new UserData();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        User user = UserData.userMap.get(login);
        HttpSession session = req.getSession();
        session.setAttribute("user",user);
        req.getRequestDispatcher("userPage.jsp").forward(req, resp);
    }

}
