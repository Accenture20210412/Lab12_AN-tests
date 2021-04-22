package pl.adriankurek.traveloffice.repositories;

import pl.adriankurek.traveloffice.models.Customer;
import pl.adriankurek.traveloffice.models.Trip;

import java.util.List;

public interface CustomerRepository {
    /**
     * Should add the customer to the data source.
     * @param customer the customer to add.
     * @return <code>true</code> if the operation was successful;
     *         <code>false</code> otherwise.
     */
    boolean add(Customer customer);

    /**
     * Should remove the specific customer from the data source.
     * @param customer the customer to remove.
     * @return <code>true</code> if the operation was successful;
     *         <code>false</code> otherwise.
     */
    boolean remove(Customer customer);

    /**
     * Should remove the customer from the data source by first name or just first letters of first name.
     * @param firstName the first name of customer.
     * @return <code>true</code> if the operation was successful;
     *         <code>false</code> otherwise.
     */
    boolean removeByFirstName(String firstName);

    /**
     * Should remove the customer from the data source by last name or just first letters of last name.
     * @param lastName the last name of customer.
     * @return <code>true</code> if the operation was successful;
     *         <code>false</code> otherwise.
     */
    boolean removeByLastName(String lastName);

    /**
     * Should assign trip to customer.
     * @param customer the customer.
     * @param trip the trip to assign.
     */
    void assignTrip(Customer customer, Trip trip);

    /**
     * Should return list of customers.
     * @return list of customers.
     */
    List<Customer> getAll();

    int getCustomerAmounts();
}
