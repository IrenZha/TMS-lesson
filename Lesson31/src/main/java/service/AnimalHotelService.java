package service;

import domain.Animal;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AnimalHotelService {
    public void saveAnimal(Animal animal) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(animal);

        transaction.commit();
        session.close();
    }
}
