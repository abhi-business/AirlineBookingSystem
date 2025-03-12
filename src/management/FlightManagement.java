// FlightManagement.java
// Manages multiple flights - add, view, edit, and delete functionality.

package management;

import models.Flight;
import java.util.ArrayList;

public class FlightManagement {
    private ArrayList<Flight> flights;

    public FlightManagement() {
        flights = new ArrayList<>();
    }

    // Add a flight
    public void addFlight(Flight flight) {
        flights.add(flight);
        System.out.println("Flight added successfully: " + flight.getFlightNumber());
    }

    // Display all flights
    public void displayAllFlights() {
        System.out.println("\nAvailable Flights:");
        System.out.println("------------------------------------");

        if (flights.isEmpty()) {
            System.out.println("No flights available.");
        } else {
            for (Flight flight : flights) {
                flight.displayFlightDetails();
            }
        }
    }

    // Edit a flight's details
    public boolean editFlight(String flightNumber, Flight updatedFlight) {
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getFlightNumber().equalsIgnoreCase(flightNumber)) {
                flights.set(i, updatedFlight);
                System.out.println("Flight updated successfully.");
                return true;
            }
        }
        System.out.println("Flight not found.");
        return false;
    }

    // Delete a flight by flight number
    public boolean deleteFlight(String flightNumber) {
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getFlightNumber().equalsIgnoreCase(flightNumber)) {
                flights.remove(i);
                System.out.println("Flight deleted successfully.");
                return true;
            }
        }
        System.out.println("Flight not found.");
        return false;
    }
}
