import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements TableService<Student> {
    List<Student> students = new ArrayList<>();

    @Override
    public void create() {
        try (Connection connection = DSUtils.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet studentTable = metaData.getTables(null, null, "student", null);
            if (!studentTable.next()) {
                Statement statement = connection.createStatement();
                statement.execute("create table student " +
                        "(" +
                        "id int primary key," +
                        " name varchar not null," +
                        " is_man  boolean," +
                        " city_id int" +
                        " constraint f_students_city references city (id)" +
                        ")");
                System.out.println("Table student created");
            }
        } catch (Exception exception) {
            System.out.println("Error create");
        }
    }

    @Override
    public void insert(Student student) {
        try (Connection connection = DSUtils.getConnection()) {
            connection.setAutoCommit(false);
            students.add(student);
            if (isContains(student.getId())) {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into student(id, name,  is_man, city_id) values (?, ?, ?, ?)");
                preparedStatement.setInt(1, student.getId());
                preparedStatement.setString(2, student.getName());
                preparedStatement.setBoolean(3, student.is_man());
                preparedStatement.setInt(4, student.getCity_id());
                preparedStatement.executeUpdate();
            }
            connection.commit();
        } catch (Exception exception) {
            System.out.println("Error insert student");
        }
    }

    @Override
    public void update(Student student) {
        try (Connection connection = DSUtils.getConnection()) {
            connection.setAutoCommit(false);
            students.set(student.getId() - 1, student);
            PreparedStatement preparedStatement = connection.prepareStatement("update student set name = ?, city_id = ? where id = ?");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getCity_id());
            preparedStatement.setInt(3, student.getId());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception exception) {
            System.out.println("Error update");
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DSUtils.getConnection()) {
            connection.setAutoCommit(false);
            students.remove(id - 1);
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student where  id = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception exception) {
            System.out.println("Error delete student");
        }
    }

    @Override
    public void readTable() {
        try (Connection connection = DSUtils.getConnection()) {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select student.id, student.name, is_man, city.name from student left join city on student.city_id = city.id");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "  " +
                        resultSet.getString(2) + "  " +
                        resultSet.getBoolean(3) + "  " +
                        resultSet.getString(4));
            }
            connection.commit();
        } catch (Exception exception) {
            System.out.println("Error readTable");
        }
    }

    @Override
    public boolean isContains(int id) {
        try (Connection connection = DSUtils.getConnection()) {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()) {
                var student_id = resultSet.getInt("id");
                if (student_id == id) return false;
            }
            connection.commit();
        } catch (Exception exception) {
            System.out.println("Error");
        }
        return true;
    }


}