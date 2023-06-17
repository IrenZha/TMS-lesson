public class Main {
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
        director1.assignSubordinates(director2);
        director1.assignSubordinates(director3);
        director1.assignSubordinates(engineer1);
        director1.assignSubordinates(engineer2);
        director2.assignSubordinates(engineer3);
        director2.assignSubordinates(engineer4);
        director3.assignSubordinates(director4);
        director3.assignSubordinates(engineer5);
        director3.assignSubordinates(engineer6);
        director4.assignSubordinates(engineer7);
        director4.assignSubordinates(engineer8);
        director4.assignSubordinates(engineer9);

        System.out.println(director2.countSalary());
        System.out.println(engineer1.countSalary());
        System.out.println(engineer3.countSalary());
        System.out.println(engineer8.countSalary());

        System.out.println(director1);
        Director.toStringAll(director1);
        System.out.println(Director.isSubordinates(director1, engineer1));
        System.out.println(Director.isSubordinatesAll(director1, engineer9));

    }
}
