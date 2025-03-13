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

    // Book Ticket with Seat Number (clearly implemented)
    public void bookTicket(String ticketId, String passengerId, String flightNumber, int seatNumber) {
        if (!isSeatAvailable(flightNumber, seatNumber)) {
            System.out.println("❌ Seat " + seatNumber + " is already booked!");
            return;
        }

        String sql = "INSERT INTO tickets (ticket_id, passenger_id, flight_number, seat_number) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ticketId);
            stmt.setString(2, passengerId);
            stmt.setString(3, flightNumber);
            stmt.setInt(4, seatNumber);

            stmt.executeUpdate();
            System.out.println("✅ Ticket booked successfully with seat: " + seatNumber);

        } catch (SQLException e) {
            System.out.println("❌ Error booking ticket!");
            e.printStackTrace();
        }
    }

    // Method to clearly check seat availability
    private boolean isSeatAvailable(String flightNumber, int seatNumber) {
        String sql = "SELECT seat_number FROM tickets WHERE flight_number = ? AND seat_number = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, flightNumber);
            stmt.setInt(2, seatNumber);

            ResultSet rs = stmt.executeQuery();
            return !rs.next(); // If seat is found, it's unavailable clearly

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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
