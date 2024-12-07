import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:derby://localhost:1527/babynames"; // Update with your database URL
    private static final String USER = "your_username"; // Replace with your DB username
    private static final String PASSWORD = "your_password"; // Replace with your DB password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
}
