package management;

import models.Flight;
import java.sql.*;
import java.util.ArrayList;

public class FlightManagement {
    // Database credentials clearly
    private final String url = "jdbc:mysql://localhost:3306/airline_db";
    private final String username = "root";
    private final String password = "root";

    // Constructor: Load JDBC Driver
    public FlightManagement() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }
    }

    // Add a flight to database clearly
    public void addFlight(Flight flight) {
        String sql = "INSERT INTO flights (flight_number, origin, destination, seats) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, flight.getFlightNumber());
            stmt.setString(2, flight.getOrigin());
            stmt.setString(3, flight.getDestination());
            stmt.setInt(4, flight.getSeats());

            stmt.executeUpdate();
            System.out.println("✅ Flight added to database!");

        } catch (SQLException e) {
            System.out.println("❌ Error adding flight!");
            e.printStackTrace();
        }
    }

    // Display all flights from database clearly
    public void displayAllFlights() {
        String sql = "SELECT * FROM flights";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Flights in Database ---");
            while (rs.next()) {
                System.out.println("Flight Number : " + rs.getString("flight_number"));
                System.out.println("Origin        : " + rs.getString("origin"));
                System.out.println("Destination   : " + rs.getString("destination"));
                System.out.println("Seats         : " + rs.getInt("seats"));
                System.out.println("------------------------------");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error retrieving flights!");
            e.printStackTrace();
        }
    }
}
