// Main.java
// Airline Booking System with Flight & Passenger Management

import management.FlightManagement;
import management.PassengerManagement;
import management.BookingManagement;
import models.Flight;
import models.Passenger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FlightManagement flightManager = new FlightManagement();
        PassengerManagement passengerManager = new PassengerManagement();
        BookingManagement bookingManager = new BookingManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Main menu
            System.out.println("\n==== Airline Booking System ====");
            System.out.println("1. Flight Management");
            System.out.println("2. Passenger Management");
            System.out.println("3. Ticket Booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Flight management submenu
                    System.out.println("\n--- Flight Management ---");
                    System.out.println("1. Add Flight");
                    System.out.println("2. View Flights");
                    System.out.print("Choose option: ");
                    int flightChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (flightChoice) {
                        case 1:
                            // Adding Flight to MySQL clearly
                            System.out.print("Flight Number: ");
                            String flightNo = scanner.nextLine();
                            System.out.print("Origin: ");
                            String origin = scanner.nextLine();
                            System.out.print("Destination: ");
                            String dest = scanner.nextLine();
                            System.out.print("Seats: ");
                            int seats = scanner.nextInt();
                            scanner.nextLine();
                
                            Flight newFlight = new Flight(flightNo, origin, dest, seats);
                            flightManager.addFlight(newFlight);
                            break;
                
                        case 2:
                            // Viewing Flights from MySQL clearly
                            flightManager.displayAllFlights();
                            break;
                
                        default:
                            System.out.println("Invalid flight option.");
                    }
                    break;

                // case 2:
                //     // Passenger management submenu
                //     System.out.println("\n--- Passenger Management ---");
                //     System.out.println("1. Add Passenger");
                //     System.out.println("2. View Passengers");
                //     System.out.println("3. Edit Passenger");
                //     System.out.println("4. Delete Passenger");
                //     System.out.print("Choose option: ");
                //     int passengerChoice = scanner.nextInt();
                //     scanner.nextLine();

                //     switch (passengerChoice) {
                //         case 1:
                //             System.out.print("Passenger ID: ");
                //             String pid = scanner.nextLine();
                //             System.out.print("Name: ");
                //             String name = scanner.nextLine();
                //             System.out.print("Age: ");
                //             int age = scanner.nextInt();
                //             scanner.nextLine();  // buffer clear
                //             System.out.print("Gender: ");
                //             String gender = scanner.nextLine();
                //             passengerManager.addPassenger(new Passenger(pid, name, age, gender));
                //             break;

                //         case 2:
                //             passengerManager.displayAllPassengers();
                //             break;

                //         case 3:
                //             System.out.print("Enter Passenger ID to edit: ");
                //             String editPid = scanner.nextLine();
                //             System.out.print("New Name: ");
                //             String newName = scanner.nextLine();
                //             System.out.print("New Age: ");
                //             int newAge = scanner.nextInt();
                //             scanner.nextLine(); // buffer clear
                //             System.out.print("New Gender: ");
                //             String newGender = scanner.nextLine();
                //             passengerManager.editPassenger(editPid, new Passenger(editPid, newName, newAge, newGender));
                //             break;

                //         case 4:
                //             System.out.print("Enter Passenger ID to delete: ");
                //             String deletePid = scanner.nextLine();
                //             passengerManager.deletePassenger(deletePid);
                //             break;

                //         default:
                //             System.out.println("Invalid passenger option.");
                //     }
                //     break;

                //     case 3:
                //     // Ticket booking submenu
                //     System.out.println("\n--- Ticket Booking ---");
                //     System.out.println("1. Book Ticket");
                //     System.out.println("2. View Booked Tickets");
                //     System.out.println("3. Cancel Ticket");
                //     System.out.print("Choose option: ");
                //     int bookingChoice = scanner.nextInt();
                //     scanner.nextLine();
                
                //     switch (bookingChoice) {
                //         case 1:
                //             System.out.print("Ticket ID: ");
                //             String ticketId = scanner.nextLine();
                
                //             System.out.print("Enter Passenger ID: ");
                //             String passengerId = scanner.nextLine();
                //             Passenger passenger = null;
                //             for (Passenger p : passengerManager.getPassengers()) {
                //                 if (p.getPassengerId().equalsIgnoreCase(passengerId)) {
                //                     passenger = p;
                //                     break;
                //                 }
                //             }
                
                //             if (passenger == null) {
                //                 System.out.println("Passenger not found.");
                //                 break;
                //             }
                
                //             System.out.print("Enter Flight Number: ");
                //             String flightNo = scanner.nextLine();
                //             Flight flight = null;
                //             for (Flight f : flightManager.getFlights()) {
                //                 if (f.getFlightNumber().equalsIgnoreCase(flightNo)) {
                //                     flight = f;
                //                     break;
                //                 }
                //             }
                
                //             if (flight == null) {
                //                 System.out.println("Flight not found.");
                //                 break;
                //             }
                
                //             bookingManager.bookTicket(ticketId, passenger, flight);
                //             break;
                
                //         case 2:
                //             bookingManager.displayAllTickets();
                //             break;
                        
                //         case 3:
                //             System.out.print("Enter Ticket ID to cancel: ");
                //             String cancelTicketId = scanner.nextLine();
                //             bookingManager.cancelTicket(cancelTicketId);
                //             break;
                
                //         default:
                //             System.out.println("Invalid booking option.");
                //     }
                //     break;
                

                case 4:
                    System.out.println("Exiting the system, goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
