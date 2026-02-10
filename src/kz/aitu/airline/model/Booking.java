package kz.aitu.airline.model;

public class Booking {

    private int id;
    private int passengerId;
    private int flightId;
    private boolean confirmed;

    public Booking() {}

    public Booking(int passengerId, int flightId) {
        this.passengerId = passengerId;
        this.flightId = flightId;
        this.confirmed = true;
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}
