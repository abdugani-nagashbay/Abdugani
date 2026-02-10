package kz.aitu.airline.model;

public class Flight {

    private int id;
    private String flightNumber;
    private String destination;
    private int availableSeats;
    private double price;

    public Flight() {}

    public Flight(String flightNumber, String destination, int availableSeats, double price) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.price = price;
    }

    public int getId() { return id; }
    public String getFlightNumber() { return flightNumber; }
    public String getDestination() { return destination; }
    public int getAvailableSeats() { return availableSeats; }
    public double getPrice() { return price; }

    public void bookSeat() {
        if (availableSeats > 0) availableSeats--;
    }
}

