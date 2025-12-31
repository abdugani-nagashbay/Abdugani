import java.util.Objects;

public class Passenger extends Person {

    private boolean hasTicket;

    public Passenger() {
        super("", 0);
    }

    public Passenger(String name, int age, boolean hasTicket) {
        super(name, age);
        this.hasTicket = hasTicket;
    }

    public boolean hasTicket() {
        return hasTicket;
    }

    public void setHasTicket(boolean hasTicket) {
        this.hasTicket = hasTicket;
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String getType() {
        return "Passenger";
    }

    @Override
    public String toString() {
        return "Passenger{name='" + name +
                "', age=" + age +
                ", hasTicket=" + hasTicket + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        Passenger that = (Passenger) o;
        return age == that.age && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
