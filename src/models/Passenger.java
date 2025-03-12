// Passenger.java
// Represents a passenger with personal details.
package models;

public class Passenger {
    private String passengerId;
    private String name;
    private int age;
    private String gender;

    // Constructor to initialize passenger details
    public Passenger(String passengerId, String name, int age, String gender) {
        this.passengerId = passengerId;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Getters
    public String getPassengerId() {
        return passengerId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    // Display passenger details
    public void displayPassengerDetails() {
        System.out.println("Passenger ID : " + passengerId);
        System.out.println("Name         : " + name);
        System.out.println("Age          : " + age);
        System.out.println("Gender       : " + gender);
        System.out.println("-----------------------------------");
    }
}
