package kz.aitu.airline.dao;

import kz.aitu.airline.model.Flight;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO {

    public static void save(Flight flight) {
        String sql = """
            INSERT INTO flight (flight_number, destination, available_seats, price)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, flight.getFlightNumber());
            ps.setString(2, flight.getDestination());
            ps.setInt(3, flight.getAvailableSeats());
            ps.setDouble(4, flight.getPrice());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Flight> findAll() {
        List<Flight> list = new ArrayList<>();
        String sql = "SELECT * FROM flight";

        try (Connection c = DatabaseConnection.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Flight(
                        rs.getString("flight_number"),
                        rs.getString("destination"),
                        rs.getInt("available_seats"),
                        rs.getDouble("price")
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
