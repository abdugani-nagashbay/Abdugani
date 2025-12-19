public class Passenger {

    private String name;
    private int age;
    private boolean hasTicket;

    public Passenger() {
    }

    public Passenger(String name, int age, boolean hasTicket) {
        this.name = name;
        this.age = age;
        this.hasTicket = hasTicket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean hasTicket() {
        return hasTicket;
    }

    public void setHasTicket(boolean hasTicket) {
        this.hasTicket = hasTicket;
    }

    public void printInfo() {
        System.out.println("Passenger → Name: " + name +
                ", Age: " + age +
                ", Has ticket: " + hasTicket);
    }
}
