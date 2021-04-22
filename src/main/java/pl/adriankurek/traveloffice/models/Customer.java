package pl.adriankurek.traveloffice.models;

import java.util.Objects;

public class Customer {
    private String firstName;
    private String lastName;
    private String address;
    private Trip trip;

    public Customer(String firstName, String lastName, String address, Trip trip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.trip = trip;
    }

    public Customer(String firstName, String lastName, String address) {
        this(firstName, lastName, address, null);
    }

    public Customer() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", trip=" + trip +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(address, customer.address) && Objects.equals(trip, customer.trip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address, trip);
    }
}
