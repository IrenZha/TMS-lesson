package web;

import domain.Task;
import domain.UserData;
import lombok.SneakyThrows;
import service.TaskService;
import service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebFilter(urlPatterns = {"/checkUser", "/newUser"})
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        UserService userService = UserService.getUserService();
        TaskService taskService = TaskService.getTaskService();

        String name = request.getParameter("name");
        request.setAttribute("name", name);
        String birthday = request.getParameter("birthday");

        if (userService.isExists(name, userService.queryIsExistsUser)) {
            UserData userForName = userService.findUserForName(name);
            List<Task> tasks = taskService.findTasks(userForName.getId());
            request.setAttribute("userTodoList", tasks);

            HttpServletRequest req = (HttpServletRequest) request;
            HttpSession session = req.getSession();
            session.setAttribute("userId", userForName.getId());
            request.setAttribute("typeUser", userForName.getType());

            if (request.getParameter("allTasks") != null) {
                request.setAttribute("isVisible", true);
                request.getRequestDispatcher("checkUser.jsp").forward(request, response);
            }
            if (request.getParameter("unfinishedTasks") != null) {
                List<Task> list = taskService.unfinishedTasks(userForName.getId());
                request.setAttribute("userTodoList", list);
                request.setAttribute("isVisible", true);
                request.getRequestDispatcher("checkUser.jsp").forward(request, response);
            }
            if (request.getParameter("edit") != null) {
                request.getRequestDispatcher("userPage.jsp").forward(request, response);
            }
            if (request.getParameter("save") != null) {
                request.getRequestDispatcher("userPage.jsp").forward(request, response);
            }
        } else {
            if (birthday != null) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(birthday);
                Date now = new Date();

                if (date.after(now)) {
                    request.setAttribute("massage", "Invalid Date");
                    request.getRequestDispatcher("checkUser.jsp").forward(request, response);
                } else {
                    chain.doFilter(request, response);
                }
            } else {
                request.setAttribute("massage1", "This user doesn't exist");
                request.getRequestDispatcher("checkUser.jsp").forward(request, response);
            }

        }

    }

    @Override
    public void destroy() {

    }
}
