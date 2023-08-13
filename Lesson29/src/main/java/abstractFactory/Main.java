package abstractFactory;

public class Main {
    public static void main(String[] args) {
        MuseumService museumService = new MuseumService();
        museumService.makeSchedule(new SculptureFactory());
    }
}
