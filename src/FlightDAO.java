import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO {

    // INSERT
    public static void saveFlight(Flight flight) {
        String sql = """
                INSERT INTO flight (flight_number, destination, available_seats, price)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, flight.getFlightNumber());
            ps.setString(2, flight.getDestination());
            ps.setInt(3, flight.getAvailableSeats());
            ps.setDouble(4, flight.getPrice());

            ps.executeUpdate();
            System.out.println("Flight saved to DB");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SELECT
    public static List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM flight";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                flights.add(new Flight(
                        rs.getString("flight_number"),
                        rs.getString("destination"),
                        rs.getInt("available_seats"),
                        rs.getDouble("price")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flights;

    }
}

