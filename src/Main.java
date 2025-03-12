// Main.java
// Airline Booking System with Flight & Passenger Management

import management.FlightManagement;
import management.PassengerManagement;
import models.Flight;
import models.Passenger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FlightManagement flightManager = new FlightManagement();
        PassengerManagement passengerManager = new PassengerManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Main menu
            System.out.println("\n==== Airline Booking System ====");
            System.out.println("1. Flight Management");
            System.out.println("2. Passenger Management");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Flight management submenu
                    System.out.println("\n--- Flight Management ---");
                    System.out.println("1. Add Flight");
                    System.out.println("2. View Flights");
                    System.out.println("3. Edit Flight");
                    System.out.println("4. Delete Flight");
                    System.out.print("Choose option: ");
                    int flightChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (flightChoice) {
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

                    break;

                case 2:
                    // Passenger management submenu
                    System.out.println("\n--- Passenger Management ---");
                    System.out.println("1. Add Passenger");
                    System.out.println("2. View Passengers");
                    System.out.println("3. Edit Passenger");
                    System.out.println("4. Delete Passenger");
                    System.out.print("Choose option: ");
                    int passengerChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (passengerChoice) {
                        case 1:
                            System.out.print("Passenger ID: ");
                            String pid = scanner.nextLine();
                            System.out.print("Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Age: ");
                            int age = scanner.nextInt();
                            scanner.nextLine();  // buffer clear
                            System.out.print("Gender: ");
                            String gender = scanner.nextLine();
                            passengerManager.addPassenger(new Passenger(pid, name, age, gender));
                            break;

                        case 2:
                            passengerManager.displayAllPassengers();
                            break;

                        case 3:
                            System.out.print("Enter Passenger ID to edit: ");
                            String editPid = scanner.nextLine();
                            System.out.print("New Name: ");
                            String newName = scanner.nextLine();
                            System.out.print("New Age: ");
                            int newAge = scanner.nextInt();
                            scanner.nextLine(); // buffer clear
                            System.out.print("New Gender: ");
                            String newGender = scanner.nextLine();
                            passengerManager.editPassenger(editPid, new Passenger(editPid, newName, newAge, newGender));
                            break;

                        case 4:
                            System.out.print("Enter Passenger ID to delete: ");
                            String deletePid = scanner.nextLine();
                            passengerManager.deletePassenger(deletePid);
                            break;

                        default:
                            System.out.println("Invalid passenger option.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting the system, goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select again.");
            }

        } while (choice != 3);

        scanner.close();
    }
}
