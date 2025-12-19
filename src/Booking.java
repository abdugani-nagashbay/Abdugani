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

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }


    public void confirmBooking() {
        if (flight.getAvailableSeats() > 0) {
            flight.bookSeat();
            passenger.setHasTicket(true);
            confirmed = true;
        }
    }

    public void printInfo() {
        System.out.println("Booking → Passenger: " + passenger.getName() +
                ", Flight: " + flight.getFlightNumber() +
                ", Confirmed: " + confirmed);
    }
}

