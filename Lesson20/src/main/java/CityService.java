import lombok.Getter;
import lombok.ToString;

import java.sql.*;

@Getter
@ToString
public class CityService implements TableService<City> {

    @Override
    public void create() {
        try (Connection connection = DSUtils.getConnection()) {
            Statement statement = connection.createStatement();
            String create = "create table if not exists city(id int primary key, name varchar not null)";
            statement.execute(create);
            System.out.println("Table city created");
        } catch (Exception exception) {
            System.out.println("Error create");
        }
    }

    @Override
    public void insert(City city) {
        try (Connection connection = DSUtils.getConnection()) {
            connection.setAutoCommit(false);
            String insert = "insert into city(id, name) values (?,?) on conflict do nothing";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, city.getId());
            preparedStatement.setString(2, city.getName());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception exception) {
            System.out.println("Error insert city");
        }
    }

    @Override
    public void update(City city) {
        try (Connection connection = DSUtils.getConnection()) {
            connection.setAutoCommit(false);
            String update = "update city set name = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, city.getName());
            preparedStatement.setInt(2, city.getId());
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
            String update = "update student set city_id = null where city_id = " + id;
            PreparedStatement prSt = connection.prepareStatement(update);
            prSt.executeUpdate();
            String delete = "delete from city where  id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception exception) {
            System.out.println("Error delete city");
        }
    }

    @Override
    public void readTable() {
        try (Connection connection = DSUtils.getConnection()) {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from city");
            while (resultSet.next()) {
                var id = resultSet.getInt("id");
                var name = resultSet.getString("name");
                System.out.println(id + " " + name);
            }
            connection.commit();
        } catch (Exception exception) {
            System.out.println("Error readTable");
        }
    }
}
