import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Director director1 = new Director("director1", "A", 10, Worker.Gender.MALE, Position.TypeOfPosition.GENERAL);
        Director director2 = new Director("director2", "B", 20, Worker.Gender.MALE, Position.TypeOfPosition.DEPARTMENT);
        Director director3 = new Director("director3", "C", 5, Worker.Gender.MALE, Position.TypeOfPosition.DEPARTMENT);
        Director director4 = new Director("director4", "D", 9, Worker.Gender.MALE, Position.TypeOfPosition.DEPARTMENT);
        Engineer engineer1 = new Engineer("engineer1", "E", 4, Worker.Gender.MALE, Position.TypeOfPosition.COMMUNICATION);
        Engineer engineer2 = new Engineer("engineer2", "F", 10, Worker.Gender.MALE, Position.TypeOfPosition.COMMUNICATION);
        Engineer engineer3 = new Engineer("engineer3", "G", 4, Worker.Gender.MALE, Position.TypeOfPosition.ROBOTICS);
        Engineer engineer4 = new Engineer("engineer4", "H", 7, Worker.Gender.FEMALE, Position.TypeOfPosition.ROBOTICS);
        Engineer engineer5 = new Engineer("engineer5", "I", 1, Worker.Gender.FEMALE, Position.TypeOfPosition.ROBOTICS);
        Engineer engineer6 = new Engineer("engineer6", "J", 6, Worker.Gender.FEMALE, Position.TypeOfPosition.AUTOMATOR);
        Engineer engineer7 = new Engineer("engineer7", "K", 11, Worker.Gender.FEMALE, Position.TypeOfPosition.AUTOMATOR);
        Engineer engineer8 = new Engineer("engineer8", "L", 3, Worker.Gender.FEMALE, Position.TypeOfPosition.AUTOMATOR);
        Engineer engineer9 = new Engineer("engineer9", "M", 15, Worker.Gender.FEMALE, Position.TypeOfPosition.COMMUNICATION);
        List<Worker> workers = new ArrayList<>();
        workers.add(director1);
        workers.add(director2);
        workers.add(director3);
        workers.add(director4);
        workers.add(engineer1);
        workers.add(engineer2);
        workers.add(engineer3);
        workers.add(engineer4);
        workers.add(engineer5);
        workers.add(engineer6);
        workers.add(engineer7);
        workers.add(engineer8);
        workers.add(engineer9);
        Map<Position, Integer> map = new HashMap<>();

        for (Worker worker : workers) {
            map.put(worker.getTypeOfPosition().getPosition(), map.getOrDefault(worker.getTypeOfPosition().getPosition(), 0) + 1);
            //   System.out.println(map.values());
            //   System.out.print(worker);
        }
        System.out.println(map.entrySet());
    }
}
