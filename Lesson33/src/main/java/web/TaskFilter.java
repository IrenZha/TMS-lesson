package web;

import domain.Task;
import service.TaskService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter("/todoList")
public class TaskFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        String title = req.getParameter("title");
        String description = request.getParameter("description");

        TaskService taskService = TaskService.getTaskService();

        if (taskService.isExistUserTask(userId, title)) {
            request.setAttribute("massage", "This task already exists");
            List<Task> tasks = taskService.findTasks(userId);
            request.setAttribute("userTodoList", tasks);
            request.setAttribute("title", title);
            request.setAttribute("description", description);
            request.getRequestDispatcher("userPage.jsp").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
