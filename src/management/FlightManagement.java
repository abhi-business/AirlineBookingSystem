// FlightManagement.java
// Manages multiple flights - add, view flights functionality.

package management;

import models.Flight;
import java.util.ArrayList;

public class FlightManagement {
    // List to store multiple flight objects
    private ArrayList<Flight> flights;

    // Constructor - initializes the flights list
    public FlightManagement() {
        flights = new ArrayList<>();
    }

    // Method to add a flight to the list
    public void addFlight(Flight flight) {
        flights.add(flight);
        System.out.println("Flight added successfully: " + flight.getFlightNumber());
    }

    // Method to display all flights clearly
    public void displayAllFlights() {
        System.out.println("\nAvailable Flights:");
        System.out.println("------------------------------------");

        // Check if flights are available or not
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
        } else {
            // Iterate over each flight and display details
            for (Flight flight : flights) {
                flight.displayFlightDetails();
            }
        }
    }
}
