import java.util.Objects;

public class Booking {

    private Passenger passenger;
    private Flight flight;
    private boolean confirmed;

    public Booking() {
    }

    public Booking(Passenger passenger, Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
        this.confirmed = false;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void confirmBooking() {
        if (flight.getAvailableSeats() > 0) {
            flight.bookSeat();
            passenger.setHasTicket(true);
            confirmed = true;
        }
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Booking{passenger=" + passenger.getName() +
                ", flight=" + flight.getFlightNumber() +
                ", confirmed=" + confirmed + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return passenger.equals(booking.passenger) &&
                flight.equals(booking.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passenger, flight);
    }
}


