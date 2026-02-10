package kz.aitu.airline.model;

public class Passenger extends Person {

    private int id;
    private boolean hasTicket;

    public Passenger() {}

    public Passenger(String name, int age, boolean hasTicket) {
        super(name, age);
        this.hasTicket = hasTicket;
    }

    public int getId() { return id; }
    public boolean isHasTicket() { return hasTicket; }
    public void setHasTicket(boolean hasTicket) { this.hasTicket = hasTicket; }

    @Override
    public String getType() {
        return "Passenger";
    }
}


