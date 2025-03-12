package management;

import models.Passenger;
import java.sql.*;

public class PassengerManagement {
    // Database connection details clearly
    private final String url = "jdbc:mysql://localhost:3306/airline_db";
    private final String username = "root";
    private final String password = "root";

    // Load JDBC Driver
    public PassengerManagement() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }
    }

    // Add passenger to database clearly
    public void addPassenger(Passenger passenger) {
        String sql = "INSERT INTO passengers (passenger_id, name, age, gender) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, passenger.getPassengerId());
            stmt.setString(2, passenger.getName());
            stmt.setInt(3, passenger.getAge());
            stmt.setString(4, passenger.getGender());

            stmt.executeUpdate();
            System.out.println("✅ Passenger added to database!");

        } catch (SQLException e) {
            System.out.println("❌ Error adding passenger!");
            e.printStackTrace();
        }
    }

    // Display all passengers from database clearly
    public void displayAllPassengers() {
        String sql = "SELECT * FROM passengers";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Passengers in Database ---");
            while (rs.next()) {
                System.out.println("Passenger ID : " + rs.getString("passenger_id"));
                System.out.println("Name         : " + rs.getString("name"));
                System.out.println("Age          : " + rs.getInt("age"));
                System.out.println("Gender       : " + rs.getString("gender"));
                System.out.println("--------------------------------");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error retrieving passengers!");
            e.printStackTrace();
        }
    }
}
