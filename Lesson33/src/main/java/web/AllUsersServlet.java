package web;

import domain.Task;
import domain.UserData;
import service.TaskService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class AllUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserService.getUserService();
        TaskService taskService = TaskService.getTaskService();

        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        UserData user = userService.getById(userId, UserData.class);
        req.setAttribute("name", user.getUserName());
        req.setAttribute("typeUser", user.getType());

        String search = req.getParameter("search");
        if (search != null) {
            List<Task> searchTasks = taskService.search(search, taskService.searchQuery);
            req.setAttribute("tasksList", searchTasks);
            List<UserData> searchUsers = userService.search(search, userService.searchQuery);
            req.setAttribute("usersList", searchUsers);
            req.getRequestDispatcher("users.jsp").forward(req, resp);
        }
        if (req.getParameter("back") != null) {
            List<Task> userTodoList = taskService.findTasks(userId);
            req.setAttribute("userTodoList", userTodoList);
            req.getRequestDispatcher("userPage.jsp").forward(req, resp);
        }
        if (req.getParameter("users") != null) {
            List<UserData> allUsersList = userService.findList(userService.queryListUsers);
            req.setAttribute("usersList", allUsersList);
            req.getRequestDispatcher("users.jsp").forward(req, resp);
        }
        if (req.getParameter("tasks") != null) {
            List<Task> allTasksList = taskService.findList(taskService.queryListTasks);
            req.setAttribute("tasksList", allTasksList);
            req.getRequestDispatcher("users.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskService taskService = TaskService.getTaskService();
        UserService userService = UserService.getUserService();

        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        UserData user = userService.getById(userId, UserData.class);
        req.setAttribute("name", user.getUserName());
        req.setAttribute("typeUser", user.getType());

        String taskIdForDelete = req.getParameter("taskIdForDelete");
        String userIdForDelete = req.getParameter("userIdForDelete");

        if (taskIdForDelete != null) {
            int taskId = Integer.parseInt(taskIdForDelete);
            taskService.delete(taskId, Task.class);
            List<Task> allTasksList = taskService.findList(taskService.queryListTasks);
            req.setAttribute("tasksList", allTasksList);
            req.getRequestDispatcher("users.jsp").forward(req, resp);
        }
        if (userIdForDelete != null) {
            int userDelete = Integer.parseInt(userIdForDelete);
            if (userDelete != userId) {
                List<Task> tasks = taskService.findTasks(userDelete);
                tasks.forEach(task -> taskService.delete(task.getId(), Task.class));
                userService.delete(userDelete, UserData.class);
            }
            List<UserData> allUsersList = userService.findList(userService.queryListUsers);
            req.setAttribute("usersList", allUsersList);
            req.getRequestDispatcher("users.jsp").forward(req, resp);
        }
    }
}
