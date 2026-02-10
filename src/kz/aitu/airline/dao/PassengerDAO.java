package kz.aitu.airline.dao;

import kz.aitu.airline.model.Passenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerDAO {

    // ➕ INSERT passenger
    public static void save(Passenger passenger) {
        String sql = """
            INSERT INTO passenger (name, age, has_ticket)
            VALUES (?, ?, ?)
        """;

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, passenger.getName());
            ps.setInt(2, passenger.getAge());
            ps.setBoolean(3, passenger.isHasTicket());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 📥 SELECT all passengers
    public static List<Passenger> findAll() {
        List<Passenger> list = new ArrayList<>();
        String sql = "SELECT * FROM passenger";

        try (Connection c = DatabaseConnection.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Passenger p = new Passenger(
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getBoolean("has_ticket")
                );
                list.add(p);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    // 🔄 UPDATE has_ticket = true
    public static void updateHasTicket(int passengerId) {
        String sql = """
            UPDATE passenger
            SET has_ticket = true
            WHERE id = ?
        """;

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, passengerId);
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

