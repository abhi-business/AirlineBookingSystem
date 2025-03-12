// Main.java
// Entry point of Airline Booking System with Console Menu.

import management.FlightManagement;
import models.Flight;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FlightManagement flightManager = new FlightManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Displaying the main menu
            System.out.println("\n==== Airline Booking System ====");
            System.out.println("1. Add Flight");
            System.out.println("2. View Flights");
            System.out.println("3. Edit Flight");
            System.out.println("4. Delete Flight");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    // Add Flight
                    System.out.print("Flight Number: ");
                    String flightNo = scanner.nextLine();
                    System.out.print("Origin: ");
                    String origin = scanner.nextLine();
                    System.out.print("Destination: ");
                    String dest = scanner.nextLine();
                    System.out.print("Seats: ");
                    int seats = scanner.nextInt();
                    scanner.nextLine(); // clear buffer
                    Flight newFlight = new Flight(flightNo, origin, dest, seats);
                    flightManager.addFlight(newFlight);
                    break;

                case 2:
                    // View Flights
                    flightManager.displayAllFlights();
                    break;

                case 3:
                    // Edit Flight
                    System.out.print("Enter Flight Number to edit: ");
                    String editFlightNo = scanner.nextLine();
                    System.out.print("New Origin: ");
                    String newOrigin = scanner.nextLine();
                    System.out.print("New Destination: ");
                    String newDest = scanner.nextLine();
                    System.out.print("New Seats: ");
                    int newSeats = Integer.parseInt(scanner.nextLine());
                    Flight updatedFlight = new Flight(editFlightNo, newOrigin, newDest, newSeats);
                    flightManager.editFlight(editFlightNo, updatedFlight);
                    break;

                case 4:
                    // Delete Flight
                    System.out.print("Enter Flight Number to delete: ");
                    String deleteFlightNo = scanner.nextLine();
                    flightManager.deleteFlight(deleteFlightNo);
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }

        } while (choice != 5);

        scanner.close();
    }
}
