package service;

import domain.Animal;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AnimalHotelService {
    public void saveAnimal(Animal animal) {
        Session session = AppSessionFactory.getSession();
        animal.setMoniker(animal.getMoniker());
        animal.setAge(animal.getAge());
        animal.setHealthy(animal.isHealthy());
        animal.setHotelService(animal.getHotelService());
        animal.setPerson(animal.getPerson());
        animal.getPerson().setName(animal.getPerson().getName());
        animal.getPerson().setPhoneNumber(animal.getPerson().getPhoneNumber());
        Transaction transaction = session.beginTransaction();

        session.save(animal);

        transaction.commit();
        session.close();
    }
}
