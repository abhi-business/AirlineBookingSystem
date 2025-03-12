// Main.java
// Entry point of our Airline Booking System

// Import Flight class from the models package
import models.Flight;

public class Main {
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("  Welcome to Airline Booking System  ");
        System.out.println("====================================");

        // Creating our first flight object
        Flight flight1 = new Flight("AI101", "New York", "London", 250);

        // Display the details of flight1
        System.out.println("\nFlight Details:");
        System.out.println("----------------------------------");
        flight1.displayFlightDetails();
    }
}
