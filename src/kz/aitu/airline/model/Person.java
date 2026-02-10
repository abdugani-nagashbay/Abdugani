package kz.aitu.airline.model;

public abstract class Person {
    protected String name;
    protected int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract String getType();

    public String getName() { return name; }
    public int getAge() { return age; }
}

