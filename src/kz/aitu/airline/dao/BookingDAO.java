package kz.aitu.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookingDAO {

    public static void book(int passengerId, int flightId) {

        String checkSeats = """
            SELECT available_seats
            FROM flight
            WHERE id = ?
        """;

        String updateSeats = """
            UPDATE flight
            SET available_seats = available_seats - 1
            WHERE id = ? AND available_seats > 0
        """;

        String insertBooking = """
            INSERT INTO booking (passenger_id, flight_id, confirmed)
            VALUES (?, ?, true)
        """;

        try (Connection c = DatabaseConnection.getConnection()) {

            // 🔍 check seats
            try (PreparedStatement ps = c.prepareStatement(checkSeats)) {
                ps.setInt(1, flightId);
                ResultSet rs = ps.executeQuery();

                if (!rs.next() || rs.getInt("available_seats") <= 0) {
                    throw new RuntimeException("No available seats");
                }
            }

            // ➖ update seats
            try (PreparedStatement ps = c.prepareStatement(updateSeats)) {
                ps.setInt(1, flightId);
                ps.executeUpdate();
            }

            // ➕ insert booking
            try (PreparedStatement ps = c.prepareStatement(insertBooking)) {
                ps.setInt(1, passengerId);
                ps.setInt(2, flightId);
                ps.executeUpdate();
            }

            // 🎟 passenger gets ticket
            PassengerDAO.updateHasTicket(passengerId);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
