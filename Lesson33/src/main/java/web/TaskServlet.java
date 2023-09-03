package web;

import domain.Status;
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

@WebServlet("/todoList")
public class TaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserService.getUserService();
        TaskService taskService = TaskService.getTaskService();

        HttpSession session = req.getSession();
        Integer userId =(Integer)  session.getAttribute("userId");
        UserData user = userService.getById(userId, UserData.class);
        req.setAttribute("name", user.getUserName());
        req.setAttribute("typeUser", user.getType());

        String id = req.getParameter("taskId");
        Integer byId = Integer.parseInt(id);
        Task taskId = taskService.getById(byId, Task.class);

        List<Task> tasks = taskService.findTasks(userId);
        req.setAttribute("userTodoList", tasks);

        if (taskId.getStatus().equals(Status.NEW)) {
            taskId.setStatus(Status.IN_PROGRESS);
            taskService.update(taskId);
            tasks = taskService.findTasks(userId);
            req.setAttribute("userTodoList", tasks);

            req.getRequestDispatcher("userPage.jsp").forward(req, resp);
        }else
        if (taskId.getStatus().equals(Status.IN_PROGRESS)) {
            taskId.setStatus(Status.DONE);
            taskService.update(taskId);
            tasks = taskService.findTasks(userId);
            req.setAttribute("userTodoList", tasks);

            req.getRequestDispatcher("userPage.jsp").forward(req, resp);
        }else
        if (taskId.getStatus().equals(Status.DONE)) {
            req.getRequestDispatcher("userPage.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskService taskService = TaskService.getTaskService();
        UserService userService = UserService.getUserService();

        HttpSession session = req.getSession();
        Integer userId =(Integer)  session.getAttribute("userId");
        UserData user = userService.getById(userId, UserData.class);
        req.setAttribute("name", user.getUserName());
        req.setAttribute("typeUser", user.getType());

        String title = req.getParameter("title");
        String description = req.getParameter("description");

        String taskIdForDelete = req.getParameter("taskIdForDelete");
        if (taskIdForDelete != null) {
            int forDelete = Integer.parseInt(taskIdForDelete);
            taskService.delete(forDelete, Task.class);
            List<Task> tasks = taskService.findTasks(userId);
            req.setAttribute("userTodoList", tasks);
            req.getRequestDispatcher("userPage.jsp").forward(req, resp);
        } else {
            Task task = new Task(title, description);
            task.setUserData(user);

            List<Task> tasks = taskService.findTasks(userId);
            req.setAttribute("userTodoList", tasks);
            req.getRequestDispatcher("userPage.jsp").forward(req, resp);
        }
    }

}
