import lombok.Getter;
import lombok.ToString;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class CityService implements TableService<City> {
    private List<City> cities = new ArrayList<>();

    @Override
    public void create() {
        try (Connection connection = DSUtils.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet city = metaData.getTables(null, null, "city", null);
            if (!city.next()) {
                Statement statement = connection.createStatement();
                statement.execute("create table city" +
                        "(" +
                        "    id   int primary key," +
                        "    name varchar not null" +
                        ")");
                System.out.println("Table city created");
            }
        } catch (Exception exception) {
            System.out.println("Error create");
        }
    }

    @Override
    public void insert(City city) {
        try (Connection connection = DSUtils.getConnection()) {
            connection.setAutoCommit(false);
            cities.add(city);
            if (isContains(city.getId())) {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into city(id, name) values (?,?)");
                preparedStatement.setInt(1, city.getId());
                preparedStatement.setString(2, city.getName());
                preparedStatement.executeUpdate();
            }
            connection.commit();
        } catch (Exception exception) {
            System.out.println("Error insert");
        }
    }

    @Override
    public void update(City city) {
        try (Connection connection = DSUtils.getConnection()) {
            connection.setAutoCommit(false);
            cities.set(city.getId() - 1, city);
            PreparedStatement preparedStatement = connection.prepareStatement("update city set name = ? where id = ?");
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
            cities.remove(id - 1);
            PreparedStatement prSt = connection.prepareStatement("update student set city_id = null where city_id = " + id);
            prSt.executeUpdate();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from city where  id = ?;");
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

    @Override
    public boolean isContains(int id) {
        try (Connection connection = DSUtils.getConnection()) {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from city");
            while (resultSet.next()) {
                var city_id = resultSet.getInt("id");
                if (city_id == id) return false;
            }
            connection.commit();
        } catch (Exception exception) {
            System.out.println("Error");
        }
        return true;
    }


}
