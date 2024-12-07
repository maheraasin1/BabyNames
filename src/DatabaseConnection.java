//Mahera Asin 
//December 07 2024 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Update with your database URL and credentials
    private static final String DB_URL = "jdbc:derby://localhost:1527/babynames;create=true";
    private static final String USER = "your_username"; // Replace with your DB username
    private static final String PASSWORD = "your_password"; // Replace with your DB password

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        // Explicitly load the driver
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
}
