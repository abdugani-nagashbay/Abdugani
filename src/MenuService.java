import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuService {

    private final Connection conn;
    private final Scanner scanner = new Scanner(System.in);

    public MenuService(Connection conn) {
        this.conn = conn;
    }

    // === MAIN MENU ===
    public void start() {
        while (true) {
            System.out.println("\n=== AIRLINE MENU ===");
            System.out.println("1. Add Passenger");
            System.out.println("2. Add Flight");
            System.out.println("3. Book Flight");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // buffer clear

            switch (choice) {
                case 1 -> addPassenger();
                case 2 -> addFlight();
                case 3 -> bookFlight();
                case 0 -> {
                    System.out.println("Program finished.");
                    return;
                }
                default -> System.out.println("Wrong option!");
            }
        }
    }

    // === ADD PASSENGER ===
    private void addPassenger() {
        System.out.print("Passenger name: ");
        String name = scanner.nextLine();

        System.out.print("Passenger age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        String sql =
                "INSERT INTO passenger (name, age, has_ticket) VALUES (?, ?, false)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.executeUpdate();
            System.out.println("Passenger added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // === ADD FLIGHT ===
    private void addFlight() {
        System.out.print("Flight number: ");
        String number = scanner.nextLine();

        System.out.print("Destination: ");
        String destination = scanner.nextLine();

        System.out.print("Available seats: ");
        int seats = scanner.nextInt();

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        String sql =
                "INSERT INTO flight (flight_number, destination, available_seats, price) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, number);
            stmt.setString(2, destination);
            stmt.setInt(3, seats);
            stmt.setDouble(4, price);
            stmt.executeUpdate();
            System.out.println("Flight added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // === BOOK FLIGHT ===
    private void bookFlight() {
        System.out.print("Passenger ID: ");
        int passengerId = scanner.nextInt();

        System.out.print("Flight ID: ");
        int flightId = scanner.nextInt();
        scanner.nextLine();

        String updateSeats =
                "UPDATE flight SET available_seats = available_seats - 1 WHERE id = ? AND available_seats > 0";

        String bookingSql =
                "INSERT INTO booking (passenger_id, flight_id, confirmed) VALUES (?, ?, true)";

        try (
                PreparedStatement seatStmt = conn.prepareStatement(updateSeats);
                PreparedStatement bookStmt = conn.prepareStatement(bookingSql)
        ) {
            seatStmt.setInt(1, flightId);
            int updated = seatStmt.executeUpdate();

            if (updated == 0) {
                System.out.println("No available seats!");
                return;
            }

            bookStmt.setInt(1, passengerId);
            bookStmt.setInt(2, flightId);
            bookStmt.executeUpdate();

            System.out.println("Booking successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
