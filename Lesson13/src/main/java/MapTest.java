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

        Map<String, Worker> workerMap = new TreeMap<>();
        workerMap.put(director1.getFirstName(), director1);
        workerMap.put(director2.getFirstName(), director2);
        workerMap.put(director3.getFirstName(), director3);
        workerMap.put(director4.getFirstName(), director4);
        workerMap.put(engineer1.getFirstName(), engineer1);
        workerMap.put(engineer2.getFirstName(), engineer2);
        workerMap.put(engineer3.getFirstName(), engineer3);
        workerMap.put(engineer4.getFirstName(), engineer4);
        workerMap.put(engineer5.getFirstName(), engineer5);
        workerMap.put(engineer6.getFirstName(), engineer6);
        workerMap.put(engineer7.getFirstName(), engineer7);
        workerMap.put(engineer8.getFirstName(), engineer8);
        workerMap.put(engineer9.getFirstName(), engineer9);

        int countDir = 0;
        int countEng = 0;
        Collection<Worker> values = workerMap.values();
        for (Worker workers : values) {
            System.out.println(workers);
            if (workers.getTypeOfPosition().getPosition().equals(Position.DIRECTOR)) countDir++;
            if (workers.getTypeOfPosition().getPosition().equals(Position.ENGINEER)) countEng++;
        }
        System.out.println(Position.DIRECTOR.name() + " - " + countDir);
        System.out.println(Position.ENGINEER.name() + " - " + countEng);

        countDir = 0;
        countEng = 0;
        Set<String> keys = workerMap.keySet();
        for (String key : keys) {
            Worker worker = workerMap.get(key);
            if (worker.getTypeOfPosition().getPosition().equals(Position.DIRECTOR)) countDir++;
            if (worker.getTypeOfPosition().getPosition().equals(Position.ENGINEER)) countEng++;
        }
        System.out.println(Position.DIRECTOR.name() + " - " + countDir);
        System.out.println(Position.ENGINEER.name() + " - " + countEng);

        countDir = 0;
        countEng = 0;
        Set<Map.Entry<String, Worker>> entries = workerMap.entrySet();
        for (Map.Entry<String, Worker> entry : entries) {
            Worker value = entry.getValue();
            if (value.getTypeOfPosition().getPosition().equals(Position.DIRECTOR)) countDir++;
            if (value.getTypeOfPosition().getPosition().equals(Position.ENGINEER)) countEng++;
        }
        System.out.println(Position.DIRECTOR.name() + " - " + countDir);
        System.out.println(Position.ENGINEER.name() + " - " + countEng);
    }
}
