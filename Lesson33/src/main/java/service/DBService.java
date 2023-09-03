package service;

import config.AppSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DBService<T> {
    public void save(T entity) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
    }

    public void update(T entity) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();
    }

    public void delete(Integer id, Class<T> tClass) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        T entityById = session.find(tClass, id);
        session.delete(entityById);

        transaction.commit();
        session.close();
    }

    public T getById(Integer id, Class<T> tClass) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        T entityById = session.find(tClass, id);

        transaction.commit();
        session.close();
        return entityById;
    }

    public boolean isExists(String name, String queryIsExists) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        var list = session.createQuery(queryIsExists).list();
        boolean isExists = list.contains(name);

        transaction.commit();
        session.close();
        return isExists;
    }

    public List<T> findList(String queryList) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        var list = session.createQuery(queryList).list();

        transaction.commit();
        session.close();
        return list;
    }

    public List<T> search(String text, String searchQuery){
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        List<T> list =(List<T>) session.createQuery(searchQuery)
        .setParameter("search", "%"+text+"%");


        transaction.commit();
        session.close();
        return list;
    }
}
