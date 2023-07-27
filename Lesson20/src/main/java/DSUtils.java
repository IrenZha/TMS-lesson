import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class DSUtils {
    @SneakyThrows
    public static Connection getConnection() {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/database_ students", "postgres", "1111");
    }
}
