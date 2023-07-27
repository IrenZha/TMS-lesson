import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements TableService<Student> {


    @Override
    public void create() {
        try (Connection connection = DSUtils.getConnection()) {
            Statement statement = connection.createStatement();
            String create = "create table if not exists student(id int primary key, name varchar not null, is_man  boolean, city_id int constraint f_students_city references city (id))";
            statement.execute(create);
            System.out.println("Table student created");
        } catch (Exception exception) {
            System.out.println("Error create");
        }
    }

    @Override
    public void insert(Student student) {
        try (Connection connection = DSUtils.getConnection()) {
            connection.setAutoCommit(false);
            String insert = "insert into student(id, name,  is_man, city_id) values (?, ?, ?, ?) on conflict (id) do nothing";
            //String action = "update  set name = ?, city_id = ?  where id =" + student.getCity_id();
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setBoolean(3, student.is_man());
            preparedStatement.setInt(4, student.getCity_id());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception exception) {
            System.out.println("Error insert student");
        }
    }

    @Override
    public void update(Student student) {
        try (Connection connection = DSUtils.getConnection()) {
            connection.setAutoCommit(false);
            String update = "update student set name = ?, city_id = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getCity_id());
            preparedStatement.setInt(3, student.getId());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception exception) {
            System.out.println("Error update student");
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DSUtils.getConnection()) {
            connection.setAutoCommit(false);
            String delete = "delete from student where  id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
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
            String readTable = "select student.id, student.name, is_man, city.name from student left join city on student.city_id = city.id";
            ResultSet resultSet = statement.executeQuery(readTable);
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
}