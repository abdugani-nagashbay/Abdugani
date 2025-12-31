import java.util.Objects;

public class Flight {

    private String flightNumber;
    private String destination;
    private int availableSeats;
    private double price;

    public Flight() {
    }

    public Flight(String flightNumber, String destination, int availableSeats, double price) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.price = price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getPrice() {
        return price;
    }

    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        }
    }

    public void printInfo() {
        System.out.println(this); //
    }

    @Override
    public String toString() {
        return "Flight{number='" + flightNumber +
                "', destination='" + destination +
                "', seats=" + availableSeats +
                ", price=" + price + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return flightNumber.equals(flight.flightNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber);
    }
}
