public class Main {

    public static void main(String[] args) {

       
        Flight flight1 = new Flight("KC101", "Atyrau", 3, 120.5);
        Flight flight2 = new Flight("KC202", "Astana", 5, 95.0);


        Passenger p1 = new Passenger("Aruzhan", 20, false);
        Passenger p2 = new Passenger("Dias", 22, false);

        Booking b1 = new Booking(p1, flight1);
        Booking b2 = new Booking(p2, flight2);


        System.out.println("=== FLIGHTS ===");
        flight1.printInfo();
        flight2.printInfo();

        System.out.println("\n=== PASSENGERS ===");
        p1.printInfo();
        p2.printInfo();


        System.out.println("\n=== BOOKING PROCESS ===");

        b1.confirmBooking();
        b2.confirmBooking();

        if (b1.isConfirmed()) {
            System.out.println("Booking 1 confirmed.");
        } else {
            System.out.println("Booking 1 failed.");
        }

        System.out.println("\n=== FLIGHT PRICE COMPARISON ===");
        if (flight1.getPrice() > flight2.getPrice()) {
            System.out.println("Flight 1 is more expensive.");
        } else {
            System.out.println("Flight 2 is cheaper.");
        }


        System.out.println("\n=== ALL BOOKINGS ===");
        Booking[] bookings = { b1, b2 };

        for (int i = 0; i < bookings.length; i++) {
            bookings[i].printInfo();
        }
    }
}
