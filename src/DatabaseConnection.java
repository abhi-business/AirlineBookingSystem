// DatabaseConnection.java
// Test MySQL database connection clearly using JDBC

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) throws ClassNotFoundException {
        // Database URL
        String url = "jdbc:mysql://localhost:3306/airline_db";
        String username = "root";
        String password = "root";

        System.out.println("Connecting to MySQL Database...");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("✅ Database connection established successfully!");

            // Close the connection clearly
            connection.close();
        } catch (SQLException e) {
            System.out.println("❌ Failed to connect to Database!");
            e.printStackTrace();
        }
    }
}
