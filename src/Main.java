import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Connected to the database!");

            BabyNameQueries queries = new BabyNameQueries();

            // Execute queries step by step
            queries.mostCommonGirlsNameInMaryland1995(connection);
            queries.mostBoysNamedJohn(connection);
            queries.addRow(connection);
            queries.deleteRow(connection);

            // Add calls to remaining query methods here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
