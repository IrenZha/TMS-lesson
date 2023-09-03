package service;

import config.AppSessionFactory;
import domain.UserData;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserService extends DBService<UserData> {
    private static UserService userService;
    public String queryIsExistsUser = "select user.userName from UserData as user";
    public String queryListUsers = "from UserData";
    public String searchQuery = "from UserData  where userName like :search";
    private UserService() {
    }

    public static UserService getUserService() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public UserData findUserForName(String name) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        List<UserData> users = (List<UserData>) session.createQuery("from UserData").list();
        UserData user = users.stream().
                filter(userData -> userData.getUserName().equals(name)).
                findFirst().get();

        transaction.commit();
        session.close();
        return user;
    }

}
