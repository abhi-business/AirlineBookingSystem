// BookingManagement.java
// Handles ticket booking operations.

package management;

import models.Flight;
import models.Passenger;
import models.Ticket;
import java.util.ArrayList;

public class BookingManagement {
    private ArrayList<Ticket> tickets;

    // Constructor
    public BookingManagement() {
        tickets = new ArrayList<>();
    }

    // Book a new ticket
    public void bookTicket(String ticketId, Passenger passenger, Flight flight) {
        Ticket ticket = new Ticket(ticketId, passenger, flight);
        tickets.add(ticket);
        System.out.println("Ticket booked successfully: " + ticketId);
    }

    // Display all booked tickets
    public void displayAllTickets() {
        System.out.println("\nBooked Tickets:");
        System.out.println("-------------------------------------");

        if (tickets.isEmpty()) {
            System.out.println("No tickets booked yet.");
        } else {
            for (Ticket ticket : tickets) {
                ticket.displayTicketDetails();
            }
        }
    }
}
