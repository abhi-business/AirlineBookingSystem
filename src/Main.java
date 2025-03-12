// Main.java
// Entry point of our Airline Booking System

import models.Flight;
import management.FlightManagement;

public class Main {
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("  Welcome to Airline Booking System  ");
        System.out.println("====================================");

        // Create FlightManagement object to manage flights
        FlightManagement flightManager = new FlightManagement();

        // Add multiple flights
        Flight flight1 = new Flight("AI101", "New York", "London", 250);
        Flight flight2 = new Flight("AI102", "Mumbai", "Dubai", 200);
        Flight flight3 = new Flight("AI103", "Tokyo", "Seoul", 180);

        flightManager.addFlight(flight1);
        flightManager.addFlight(flight2);
        flightManager.addFlight(flight3);

        // Display all added flights
        flightManager.displayAllFlights();
    }
}
