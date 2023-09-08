package service;

import config.AppSessionFactory;
import domain.Status;
import domain.Task;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class TaskService extends DBService<Task> {
    private static TaskService taskService;
    public String queryIsExistsTask = "select title from Task";
    public String queryListTasks = "from Task";
    public String searchQuery = "from Task  where title like :search or description like :search";

    private TaskService() {
    }

    public static TaskService getTaskService() {
        if (taskService == null) {
            taskService = new TaskService();
        }
        return taskService;
    }

    public List<Task> findTasks(Integer userId) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        List<Task> tasks = session.createQuery("from Task where userData.id = :userId")
                .setParameter("userId", userId).list();

        transaction.commit();
        session.close();
        return tasks;
    }

    public boolean isExistUserTask(Integer userId, String title) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        List<Task> tasks = findTasks(userId);
        boolean anyMatch = tasks.stream()
                .filter(task -> !task.getStatus().equals(Status.DONE))
                .anyMatch(task -> task.getTitle().equals(title));

        transaction.commit();
        session.close();
        return anyMatch;
    }

    public List<Task> unfinishedTasks(Integer userId) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        List<Task> tasks = session.createQuery("from Task where status != 'DONE' and userData.id = :userId")
                .setParameter("userId", userId).list();

        transaction.commit();
        session.close();
        return tasks;
    }

}