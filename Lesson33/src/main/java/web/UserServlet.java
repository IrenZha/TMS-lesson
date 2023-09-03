package web;

import domain.TypeUser;
import domain.UserData;
import lombok.SneakyThrows;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet("/newUser")
public class UserServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String typeUser = req.getParameter("typeUser");
        TypeUser type = TypeUser.valueOf(typeUser);
        String gender = req.getParameter("gender");
        boolean isMan = Boolean.parseBoolean(gender);
        String birthday = req.getParameter("birthday");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(birthday);

        UserData user = new UserData(name, type, isMan, date);
        UserService userService =UserService.getUserService();
        userService.save(user);
        HttpSession session = req.getSession();
        session.setAttribute("userId", user.getId());
        req.setAttribute("typeUser", user.getType());
        req.getRequestDispatcher("userPage.jsp").forward(req, resp);
    }
}
