import config.AppSessionFactory;
import domain.Task;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.TaskService;

public class MainApp {
    public static void main(String[] args) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(new Task("T", "D"));

        transaction.commit();
        session.close();
    }
}
