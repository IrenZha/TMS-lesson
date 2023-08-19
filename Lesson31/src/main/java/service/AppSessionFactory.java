package service;

import domain.Animal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

public class AppSessionFactory {
    private static AppSessionFactory factory = new AppSessionFactory();
    private static SessionFactory sessionFactory;

    private AppSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.setProperty(AvailableSettings.DRIVER, "org.postgresql.Driver");
        configuration.setProperty(AvailableSettings.URL, "jdbc:postgresql://localhost:5432/database_lesson31");
        configuration.setProperty(AvailableSettings.USER, "postgres");
        configuration.setProperty(AvailableSettings.PASS, "1111");
        configuration.setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty(AvailableSettings.HBM2DDL_AUTO, "create-drop");
        configuration.setProperty(AvailableSettings.SHOW_SQL, "true");

        configuration.addAnnotatedClass(Animal.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
