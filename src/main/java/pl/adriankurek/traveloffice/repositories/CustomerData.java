package pl.adriankurek.traveloffice.repositories;

import pl.adriankurek.traveloffice.models.Customer;
import pl.adriankurek.traveloffice.models.Trip;

import java.util.ArrayList;
import java.util.List;

public class CustomerData implements CustomerRepository {
    private final List<Customer> customers;

    public CustomerData() {
        this.customers = new ArrayList<>();
    }

    @Override
    public boolean add(Customer customer) {
        return customers.add(customer);
    }

    @Override
    public boolean remove(Customer customer) {
        return customers.remove(customer);
    }

    @Override
    public boolean removeByFirstName(String firstName) {
        return customers.removeIf(c -> c.getFirstName().startsWith(firstName));
    }

    @Override
    public boolean removeByLastName(String lastName) {
        return customers.removeIf(c -> c.getLastName().startsWith(lastName));
    }

    @Override
    public void assignTrip(Customer customer, Trip trip) {
        customers.stream()
                .filter(c -> c.equals(customer))
                .findFirst()
                .orElse(null)
                .setTrip(trip);
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }

    public int getCustomerAmounts() {
        return customers.size();
    }
}
