import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("KC101", "Atyrau", 3, 120.5));
        flights.add(new Flight("KC202", "Astana", 5, 95.0));
        flights.add(new Flight("KC303", "Almaty", 2, 150.0));

        Passenger p1 = new Passenger("Aruzhan", 20, false);
        Passenger p2 = new Passenger("Dias", 22, false);

        Booking b1 = new Booking(p1, flights.get(0));
        Booking b2 = new Booking(p2, flights.get(1));

        b1.confirmBooking();
        b2.confirmBooking();

        System.out.println("=== ALL FLIGHTS ===");
        flights.forEach(System.out::println);

        System.out.println("\n=== FILTER: price < 120 ===");
        flights.stream()
                .filter(f -> f.getPrice() < 120)
                .forEach(System.out::println);

        System.out.println("\n=== SORT BY PRICE ===");
        flights.stream()
                .sorted(Comparator.comparingDouble(Flight::getPrice))
                .forEach(System.out::println);

        System.out.println("\n=== SEARCH: Astana ===");
        flights.stream()
                .filter(f -> f.getDestination().equalsIgnoreCase("Astana"))
                .forEach(System.out::println);

        System.out.println("\n=== BOOKINGS ===");
        System.out.println(b1);
        System.out.println(b2);
    }
}

