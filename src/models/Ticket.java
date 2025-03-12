// Ticket.java
// Represents a booked ticket linking a passenger and flight.

package models;

public class Ticket {
    private String ticketId;
    private Passenger passenger;
    private Flight flight;

    // Constructor
    public Ticket(String ticketId, Passenger passenger, Flight flight) {
        this.ticketId = ticketId;
        this.passenger = passenger;
        this.flight = flight;
    }

    // Display ticket details clearly
    public void displayTicketDetails() {
        System.out.println("\nTicket ID : " + ticketId);
        System.out.println("Passenger : " + passenger.getName() + " (ID: " + passenger.getPassengerId() + ")");
        System.out.println("Flight    : " + flight.getFlightNumber() + " [" + flight.getOrigin() + " to " + flight.getDestination() + "]");
        System.out.println("-------------------------------------");
    }
}
