import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest<W> {
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
        Set<Worker> workerTreeSet = new TreeSet<>();
        workerTreeSet.add(director1);
        workerTreeSet.add(director2);
        workerTreeSet.add(director3);
        workerTreeSet.add(director4);
        workerTreeSet.add(engineer1);
        workerTreeSet.add(engineer2);
        workerTreeSet.add(engineer3);
        workerTreeSet.add(engineer4);
        workerTreeSet.add(engineer5);
        workerTreeSet.add(engineer6);
        workerTreeSet.add(engineer7);
        workerTreeSet.add(engineer8);
        workerTreeSet.add(engineer9);
        System.out.println(workerTreeSet);
    }
}
