import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BabyNameQueries {

    public void mostCommonGirlsNameInMaryland1995(Connection connection) throws SQLException {
        String query = "SELECT NAME, MAX(NUM_BABIES) AS MaxBabies " +
                       "FROM babynames WHERE GENDER = 'F' AND US_STATE = 'MD' AND DATE_YEAR = 1995 " +
                       "GROUP BY NAME ORDER BY MaxBabies DESC FETCH FIRST 1 ROW ONLY";

        try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(query)) {
            if (rs.next()) {
                System.out.println("Most common girl's name in Maryland in 1995: " + rs.getString("NAME"));
            }
        }
    }

    public void mostBoysNamedJohn(Connection connection) throws SQLException {
        String query = "SELECT DATE_YEAR, SUM(NUM_BABIES) AS TotalJohnBabies " +
                       "FROM babynames WHERE NAME = 'John' AND GENDER = 'M' " +
                       "GROUP BY DATE_YEAR ORDER BY TotalJohnBabies DESC FETCH FIRST 1 ROW ONLY";

        try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(query)) {
            if (rs.next()) {
                System.out.println("Year with most boys named John: " + rs.getInt("DATE_YEAR"));
            }
        }
    }

    public void addRow(Connection connection) throws SQLException {
        String query = "INSERT INTO babynames (ID, NAME, DATE_YEAR, GENDER, US_STATE, NUM_BABIES) " +
                       "VALUES (10000000, 'Joseph', 2016, 'M', 'PA', 476)";
        try (Statement statement = connection.createStatement()) {
            int rowsInserted = statement.executeUpdate(query);
            System.out.println("Row added. Rows affected: " + rowsInserted);
        }
    }

    public void deleteRow(Connection connection) throws SQLException {
        String query = "DELETE FROM babynames WHERE ID = 10000000";
        try (Statement statement = connection.createStatement()) {
            int rowsDeleted = statement.executeUpdate(query);
            System.out.println("Row deleted. Rows affected: " + rowsDeleted);
        }
    }

    public void mostCommonBoysNameUS1991(Connection connection) throws SQLException {
        String query = "SELECT NAME, SUM(NUM_BABIES) AS TotalBabies " +
                       "FROM babynames WHERE GENDER = 'M' AND DATE_YEAR = 1991 " +
                       "GROUP BY NAME ORDER BY TotalBabies DESC FETCH FIRST 1 ROW ONLY";

        try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(query)) {
            if (rs.next()) {
                System.out.println("Most common boy's name in the US in 1991: " + rs.getString("NAME"));
            }
        }
    }
}
