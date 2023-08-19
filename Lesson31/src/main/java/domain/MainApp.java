package domain;

import domain.Animal;
import domain.Person;
import service.AnimalHotelService;
import service.HotelService;

public class MainApp {
    public static void main(String[] args) {
        AnimalHotelService animalHotelService = new AnimalHotelService();
        animalHotelService.saveAnimal(new Animal("Kat", 4, true, HotelService.ACCOMMODATION, new Person("name","1111111")));
    }
}