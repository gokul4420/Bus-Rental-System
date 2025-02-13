package pkg1;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BusRentalSystem {
    private ArrayList<Bus> buses = new ArrayList<>();
    private ArrayList<Customer> bookings = new ArrayList<>();

    public void addBus(int busId, String driverName, int capacity) {
        try {
            buses.add(new Bus(busId, driverName, capacity));
            System.out.println("Bus added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding bus: " + e.getMessage());
        }
    }

    public void viewBuses() {
        try {
            if (buses.isEmpty()) {
                System.out.println("No buses available.");
            } else {
                for (Bus bus : buses) {
                    System.out.println(bus);
                }
            }
        } catch (Exception e) {
            System.out.println("Error viewing buses: " + e.getMessage());
        }
    }

    public void bookBus(int customerId, String customerName, int busId) {
        try {
            for (Bus bus : buses) {
                if (bus.getBusId() == busId) {
                    if (bus.bookSeat()) {
                        bookings.add(new Customer(customerId, customerName, busId));
                        System.out.println("Booking successful!");
                    } else {
                        System.out.println("No seats available on this bus.");
                    }
                    return;
                }
            }
            System.out.println("Bus with ID " + busId + " not found.");
        } catch (Exception e) {
            System.out.println("Error booking bus: " + e.getMessage());
        }
    }

    public void cancelBooking(int customerId, int busId) {
        try {
            Iterator<Customer> iterator = bookings.iterator();
            while (iterator.hasNext()) {
                Customer customer = iterator.next();
                if (customer.getCustomerId() == customerId && customer.getBusId() == busId) {
                    iterator.remove();
                    for (Bus bus : buses) {
                        if (bus.getBusId() == busId) {
                            bus.cancelSeat();
                            System.out.println("Booking canceled successfully!");
                            return;
                        }
                    }
                }
            }
            System.out.println("No booking found for Customer ID " + customerId + " on Bus ID " + busId);
        } catch (Exception e) {
            System.out.println("Error canceling booking: " + e.getMessage());
        }
    }

    public void viewBookings() {
        try {
            if (bookings.isEmpty()) {
                System.out.println("No bookings made yet.");
            } else {
                for (Customer customer : bookings) {
                    System.out.println(customer);
                }
            }
        } catch (Exception e) {
            System.out.println("Error viewing bookings: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            user_login obj = new user_login();
            System.out.println("Welcome to bus Rental System");
            System.out.println();
            obj.display();
            obj.process();

            BusRentalSystem system = new BusRentalSystem();
            Scanner scanner = new Scanner(System.in);
            int choice;
            boolean exit = true;

            do {
                System.out.println("\n=== Bus Rental System ===");
                System.out.println("1. Add Bus");
                System.out.println("2. View Buses");
                System.out.println("3. Book Bus");
                System.out.println("4. Cancel Booking");
                System.out.println("5. View Bookings");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                    continue;
                }
                
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter Bus ID: ");
                        int busId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter Driver Name: ");
                        String driverName = scanner.nextLine();
                        System.out.print("Enter Capacity: ");
                        int capacity = scanner.nextInt();
                        system.addBus(busId, driverName, capacity);
                        break;
                    case 2:
                        system.viewBuses();
                        break;
                    case 3:
                        System.out.print("Enter Customer ID: ");
                        int customerId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Customer Name: ");
                        String customerName = scanner.nextLine();
                        System.out.print("Enter Bus ID: ");
                        int busIdToBook = scanner.nextInt();
                        system.bookBus(customerId, customerName, busIdToBook);
                        break;
                    case 4:
                        System.out.print("Enter Customer ID: ");
                        int customerIdToCancel = scanner.nextInt();
                        System.out.print("Enter Bus ID: ");
                        int busIdToCancel = scanner.nextInt();
                        system.cancelBooking(customerIdToCancel, busIdToCancel);
                        break;
                    case 5:
                        system.viewBookings();
                        break;
                    case 6:
                        System.out.println("Exiting the system. Goodbye!");
                        exit = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (exit);

            scanner.close();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}