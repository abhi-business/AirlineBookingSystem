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

                case 2:
                    System.out.println("\n--- Passenger Management ---");
                    System.out.println("1. Add Passenger");
                    System.out.println("2. View Passengers");
                    System.out.print("Choose option: ");
                    int passengerChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (passengerChoice) {
                        case 1:
                            // Add passenger to MySQL clearly
                            System.out.print("Passenger ID: ");
                            String pid = scanner.nextLine();
                            System.out.print("Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Age: ");
                            int age = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Gender: ");
                            String gender = scanner.nextLine();

                            Passenger newPassenger = new Passenger(pid, name, age, gender);
                            passengerManager.addPassenger(newPassenger);
                            break;

                        case 2:
                            // View passengers from MySQL clearly
                            passengerManager.displayAllPassengers();
                            break;

                        default:
                            System.out.println("Invalid passenger option.");
                    }
                    break;

                case 3:
                    // Ticket Booking Menu (Main.java)
                    System.out.println("\n--- Ticket Booking ---");
                    System.out.println("1. Book Ticket");
                    System.out.println("2. View Tickets");
                    System.out.println("3. Cancel Ticket");
                    System.out.print("Enter choice: ");
                    int bookingChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (bookingChoice) {
                        case 1:
                            // Book Ticket clearly
                            System.out.print("Enter Ticket ID: ");
                            String ticketId = scanner.nextLine();

                            System.out.print("Enter Passenger ID: ");
                            String passengerId = scanner.nextLine();

                            System.out.print("Enter Flight Number: ");
                            String flightNumber = scanner.nextLine();

                            bookingManager.bookTicket(ticketId, passengerId, flightNumber);
                            break;

                        case 2:
                            bookingManager.displayAllTickets();
                            break;

                        case 3:
                            System.out.print("Enter Ticket ID to cancel: ");
                            String cancelTicketId = scanner.nextLine();
                            bookingManager.cancelTicket(cancelTicketId);
                            break;
                        default:
                            System.out.println("Invalid booking option.");
                            break;
                    }
                    break;

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
