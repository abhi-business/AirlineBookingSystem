// PassengerManagement.java
// Manages multiple passengers: add, view, edit, and delete.

package management;

import models.Passenger;
import java.util.ArrayList;

public class PassengerManagement {
    private ArrayList<Passenger> passengers;

    // Constructor
    public PassengerManagement() {
        passengers = new ArrayList<>();
    }

    // Add passenger
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
        System.out.println("Passenger added successfully: " + passenger.getPassengerId());
    }

    // Display all passengers
    public void displayAllPassengers() {
        System.out.println("\nRegistered Passengers:");
        System.out.println("-----------------------------------");

        if (passengers.isEmpty()) {
            System.out.println("No passengers registered.");
        } else {
            for (Passenger passenger : passengers) {
                passenger.displayPassengerDetails();
            }
        }
    }

    // Edit passenger
    public boolean editPassenger(String passengerId, Passenger updatedPassenger) {
        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).getPassengerId().equalsIgnoreCase(passengerId)) {
                passengers.set(i, updatedPassenger);
                System.out.println("Passenger updated successfully.");
                return true;
            }
        }
        System.out.println("Passenger not found.");
        return false;
    }

    // Delete passenger
    public boolean deletePassenger(String passengerId) {
        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).getPassengerId().equalsIgnoreCase(passengerId)) {
                passengers.remove(i);
                System.out.println("Passenger deleted successfully.");
                return true;
            }
        }
        System.out.println("Passenger not found.");
        return false;
    }
}
