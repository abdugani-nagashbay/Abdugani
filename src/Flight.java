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

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        }
    }

    public void printInfo() {
        System.out.println("Flight → " + flightNumber +
                ", Destination: " + destination +
                ", Seats: " + availableSeats +
                ", Price: $" + price);
    }
}
