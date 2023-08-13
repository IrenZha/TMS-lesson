package web;

import domain.Todo;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/status")
public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        List<Todo> userTodoList = user.getTodoList();
        req.setAttribute("userTodoList", userTodoList);
        req.getRequestDispatcher("completed.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        String status = req.getParameter("status");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        List<Todo> userTodoList = user.getTodoList();
        for (Todo todo : userTodoList) {
            if (text.contains(todo.getTask()) && status.equals("Created")) {
                todo.setStatus("At work");
                req.setAttribute("userTodoList", userTodoList);
                req.getRequestDispatcher("userPage.jsp").forward(req, resp);
            }
            if (text.contains(todo.getTask()) && status.equals("At work")) {
                todo.setStatus("Completed");
                req.setAttribute("userTodoList", userTodoList);
                req.getRequestDispatcher("userPage.jsp").forward(req, resp);
            }
        }
    }
}
