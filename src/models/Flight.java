// Flight.java
// This class represents the basic structure of a Flight in our system.
package models;

public class Flight {
    // Properties of the flight
    private String flightNumber;
    private String origin;
    private String destination;
    private int seats;

    // Constructor to initialize flight details
    public Flight(String flightNumber, String origin, String destination, int seats) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.seats = seats;
    }

    // Getters (to access flight details)
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getSeats() {
        return seats;
    }

    // Method to display flight details clearly
    public void displayFlightDetails() {
        System.out.println("Flight Number : " + flightNumber);
        System.out.println("Origin        : " + origin);
        System.out.println("Destination   : " + destination);
        System.out.println("Seats         : " + seats);
        System.out.println("----------------------------------");
    }
}
