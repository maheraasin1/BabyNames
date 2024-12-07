import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Connected to the database!");

            // Create an instance of the queries class
            BabyNameQueries queries = new BabyNameQueries();

            // Execute each query step by step
            queries.mostCommonGirlsNameInMaryland1995(connection);
            queries.mostBoysNamedJohn(connection);
            queries.addRow(connection);
            queries.deleteRow(connection);
            queries.mostCommonBoysNameUS1991(connection);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
