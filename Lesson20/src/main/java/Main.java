import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Driver driver = new org.postgresql.Driver();
        DriverManager.registerDriver(driver);

        CityService cityService = new CityService();
        cityService.create();
        cityService.insert(new City(1, "Minsk"));
        cityService.insert(new City(2, "Vitebsk"));
        cityService.insert(new City(3, "Grodno"));
        cityService.insert(new City(4, "Gomel"));
    /*
        System.out.println(cityService.getCities());
        cityService.readTable();
        cityService.update(new City(3, "Mogilev"));
        System.out.println(cityService.getCities());
        cityService.readTable();
*/
        StudentService studentService = new StudentService();
        studentService.create();
        studentService.insert(new Student(1, "name1", true, 1));
        studentService.insert(new Student(2, "name2", true, 1));
        studentService.insert(new Student(3, "name3", true, 2));
        studentService.insert(new Student(4, "name4", true, 3));
        studentService.insert(new Student(5, "name5", false, 4));
        studentService.insert(new Student(6, "name6", false, 1));
        studentService.insert(new Student(7, "name7", false, 2));
        studentService.insert(new Student(8, "name8", false, 3));
        System.out.println(studentService.students);
        studentService.readTable();
        studentService.update(new Student(8, "name10", false, 1));
        System.out.println(studentService.students);
        studentService.readTable();
        studentService.delete(3);
        studentService.delete(7);
        cityService.delete(1);
        System.out.println(studentService.students);
        studentService.readTable();
        System.out.println(cityService.getCities());
        cityService.readTable();

    }
}
