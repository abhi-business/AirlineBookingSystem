// Ticket.java (clearly updated for Seat Management)

package models;

public class Ticket {
    private String ticketId;
    private Passenger passenger;
    private Flight flight;
    private int seatNumber; // New attribute clearly added

    // Constructor clearly updated
    public Ticket(String ticketId, Passenger passenger, Flight flight, int seatNumber) {
        this.ticketId = ticketId;
        this.passenger = passenger;
        this.flight = flight;
        this.seatNumber = seatNumber;
    }

    // Getter for seat number
    public int getSeatNumber() {
        return seatNumber;
    }

    // Display ticket details clearly updated
    public void displayTicketDetails() {
        System.out.println("\nTicket ID   : " + ticketId);
        System.out.println("Passenger   : " + passenger.getName());
        System.out.println("Flight      : " + flight.getFlightNumber());
        System.out.println("Route       : " + flight.getOrigin() + " to " + flight.getDestination());
        System.out.println("Seat Number : " + seatNumber);
        System.out.println("-------------------------------------");
    }
}
