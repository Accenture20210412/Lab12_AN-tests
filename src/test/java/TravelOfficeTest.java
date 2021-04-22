
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.adriankurek.traveloffice.models.Customer;
import pl.adriankurek.traveloffice.models.TravelOffice;
import pl.adriankurek.traveloffice.models.Trip;
import pl.adriankurek.traveloffice.repositories.CustomerData;
import pl.adriankurek.traveloffice.repositories.TripData;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

public class TravelOfficeTest  {

    CustomerData customerData = new CustomerData();
    TravelOffice office = new TravelOffice(customerData, new TripData());
    Trip trip;

    @BeforeEach
    void init() throws ParseException {
        trip = new Trip(
                "Cool trip",
                new SimpleDateFormat("dd/MM/yyyy").parse("15/04/2021"),
                new SimpleDateFormat("dd/MM/yyyy").parse("20/04/2021"),
                "Washington",
                new BigDecimal("1500"));
    }

    @Test
    public void shouldAddTripToOffice() throws ParseException {
        office.addTrip(trip);
        Assertions.assertEquals(1, office.getTripAmount());
//        Assert.assertEquals(LocalDate.of(2021,04,15), trip.getStartDate());
    }

    @Test
    public void shouldAddNewCustomer() throws ParseException {
        Customer customer = new Customer("Michał", "Kowalski", "Wiśniowa 10", trip);

        office.addCustomer(customer);
        Assertions.assertEquals(1, customerData.getCustomerAmounts());
    }

    @Test
    public void shouldRemoveCustomerCorectly() throws ParseException {
        Customer customer = new Customer("Michał", "Kowalski", "Wiśniowa 10", trip);

        office.addCustomer(customer);
        boolean removed = office.removeCustomer(customer);

        Assertions.assertTrue(removed);
    }

    @Test
    public void shouldRemoveCustomerCorectlyByLastName() throws ParseException {
        Customer customer = new Customer("Michał", "Kowalski", "Wiśniowa 10", trip);

        office.addCustomer(customer);
        boolean removed = office.removeCustomerByLastName(customer.getLastName());

        Assertions.assertTrue(removed);
    }

    @Test
    public void shouldRemoveTripCorectly() throws ParseException {
        Customer customer = new Customer("Michał", "Kowalski", "Wiśniowa 10", trip);

        office.addTrip(trip);
        boolean removed = office.removeTrip(trip);
        boolean removed2 = office.removeTrip(new Trip());

        Assertions.assertTrue(removed);
        Assertions.assertFalse(removed2);
    }

    @Test
    public void shouldReturnTripWithSpecificDestination() throws ParseException {

        Trip trip2 = new Trip(
                "Cool trip",
                new SimpleDateFormat("dd/MM/yyyy").parse("15/04/2021"),
                new SimpleDateFormat("dd/MM/yyyy").parse("20/04/2021"),
                "Washington",
                new BigDecimal("1500"));
        Trip trip3 = new Trip(
                "Cool trip",
                new SimpleDateFormat("dd/MM/yyyy").parse("15/04/2021"),
                new SimpleDateFormat("dd/MM/yyyy").parse("20/04/2021"),
                "Katowice",
                new BigDecimal("1500"));

        office.addTrip(trip);
        office.addTrip(trip2);
        office.addTrip(trip3);
        List<Trip> trips = office.getTripByDestination("Washington");

        Assertions.assertEquals(2, trips.size());
    }

    @Test
    public void shouldThrowNoSuchElementException() throws ParseException {
        Customer customer = new Customer("Michał", "Kowalski", "Wiśniowa 10", trip);

        office.addCustomer(customer);
        Assertions.assertThrows(IllegalArgumentException.class, () -> office.removeCustomerByLastName("Sobczak"));
    }




}
