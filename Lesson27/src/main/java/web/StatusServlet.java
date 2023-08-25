package web;

import domain.Status;
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
import java.util.Optional;
import java.util.UUID;

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
        String id = req.getParameter("id");
        UUID idChangeStatus = UUID.fromString(id);
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        List<Todo> userTodoList = user.getTodoList();
        Optional<Todo> first = userTodoList.stream()
                .filter(todo -> todo.getId().equals(idChangeStatus))
                .findFirst();
        Todo todoChangeStatus = first.get();
        if (todoChangeStatus.getStatus().equals(Status.CREATED)) {
            todoChangeStatus.setStatus(Status.AT_WORK);
            req.setAttribute("userTodoList", userTodoList);
            req.getRequestDispatcher("userPage.jsp").forward(req, resp);
        }
        if (todoChangeStatus.getStatus().equals(Status.AT_WORK)) {
            todoChangeStatus.setStatus(Status.COMPLETED);
            req.setAttribute("userTodoList", userTodoList);
            req.getRequestDispatcher("userPage.jsp").forward(req, resp);
        }
    }
}
