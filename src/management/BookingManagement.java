// BookingManagement.java
// Booking Management - MySQL Integration

package management;

import models.Passenger;
import models.Flight;
import models.Ticket;
import java.sql.*;

public class BookingManagement {
    private final String url = "jdbc:mysql://localhost:3306/airline_db";
    private final String username = "root";
    private final String password = "root";
    // Constructor - Load JDBC Driver
    public BookingManagement() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver loading failed clearly.");
            e.printStackTrace();
        }
    }

    // Book Ticket - Insert clearly into MySQL
    public void bookTicket(String ticketId, String passengerId, String flightNumber) {
        String sql = "INSERT INTO tickets (ticket_id, passenger_id, flight_number) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ticketId);
            stmt.setString(2, passengerId);
            stmt.setString(3, flightNumber);

            stmt.executeUpdate();
            System.out.println("✅ Ticket booked successfully!");

        } catch (SQLException e) {
            System.out.println("❌ Error booking ticket!");
            e.printStackTrace();
        }
    }

    // Method to clearly display all booked tickets from MySQL database
    public void displayAllTickets() {
        String sql = "SELECT t.ticket_id, p.name, f.origin, f.destination FROM tickets t "
                   + "JOIN passengers p ON t.passenger_id = p.passenger_id "
                   + "JOIN flights f ON t.flight_number = f.flight_number";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Booked Tickets ---");
            while (rs.next()) {
                System.out.println("Ticket ID  : " + rs.getString("ticket_id"));
                System.out.println("Passenger   : " + rs.getString("name"));
                System.out.println("Route       : " + rs.getString("origin") + " to " + rs.getString("destination"));
                System.out.println("--------------------------------");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error retrieving tickets!");
            e.printStackTrace();
        }
    }

    // Cancel ticket clearly from MySQL database
    public boolean cancelTicket(String ticketId) {
        String sql = "DELETE FROM tickets WHERE ticket_id = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ticketId);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Ticket cancelled successfully!");
                return true;
            } else {
                System.out.println("Ticket not found!");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error cancelling ticket.");
            e.printStackTrace();
        }
        return false;
    }
}
