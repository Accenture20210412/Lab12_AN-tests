import org.junit.Assert;
import org.junit.Test;
import pl.adriankurek.traveloffice.models.Customer;
import pl.adriankurek.traveloffice.models.TravelOffice;
import pl.adriankurek.traveloffice.models.Trip;
import pl.adriankurek.traveloffice.repositories.CustomerData;
import pl.adriankurek.traveloffice.repositories.TripData;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TravelOfficeTest  {

    TravelOffice office = new TravelOffice(new CustomerData(), new TripData());

    @Test
    public void shouldAddTripToOffice() throws ParseException {
        Trip trip = new Trip(
                "Cool trip",
                new SimpleDateFormat("dd/MM/yyyy").parse("15/04/2021"),
                new SimpleDateFormat("dd/MM/yyyy").parse("20/04/2021"),
                "Washington",
                new BigDecimal("1500"));
        office.addTrip(trip);
        Assert.assertEquals(1, office.getTripAmount());
    }

    @Test
    public void shouldAddNewCustomer() throws ParseException {
        Trip trip = new Trip(
                "Cool trip",
                new SimpleDateFormat("dd/MM/yyyy").parse("15/04/2021"),
                new SimpleDateFormat("dd/MM/yyyy").parse("20/04/2021"),
                "Washington",
                new BigDecimal("1500"));
        Customer customer = new Customer("Michał", "Kowalski", "Wiśniowa 10", trip);

        office.addCustomer(customer);
        Assert.assertEquals(1, office.getCustomerAmount());
    }

    @Test
    public void shouldRemoveCustomerCorectly() throws ParseException {
        Trip trip = new Trip(
                "Cool trip",
                new SimpleDateFormat("dd/MM/yyyy").parse("15/04/2021"),
                new SimpleDateFormat("dd/MM/yyyy").parse("20/04/2021"),
                "Washington",
                new BigDecimal("1500"));
        Customer customer = new Customer("Michał", "Kowalski", "Wiśniowa 10", trip);

        office.addCustomer(customer);
        boolean removed = office.removeCustomer(customer);

        Assert.assertTrue(removed);
    }

    @Test
    public void shouldRemoveCustomerCorectlyByLastName() throws ParseException {
        Trip trip = new Trip(
                "Cool trip",
                new SimpleDateFormat("dd/MM/yyyy").parse("15/04/2021"),
                new SimpleDateFormat("dd/MM/yyyy").parse("20/04/2021"),
                "Washington",
                new BigDecimal("1500"));
        Customer customer = new Customer("Michał", "Kowalski", "Wiśniowa 10", trip);

        office.addCustomer(customer);
        boolean removed = office.removeCustomerByLastName(customer.getLastName());

        Assert.assertTrue(removed);
    }

    @Test
    public void shouldRemoveTripCorectly() throws ParseException {
        Trip trip = new Trip(
                "Cool trip",
                new SimpleDateFormat("dd/MM/yyyy").parse("15/04/2021"),
                new SimpleDateFormat("dd/MM/yyyy").parse("20/04/2021"),
                "Washington",
                new BigDecimal("1500"));
        Customer customer = new Customer("Michał", "Kowalski", "Wiśniowa 10", trip);

        office.addTrip(trip);
        boolean removed = office.removeTrip(trip);

        Assert.assertTrue(removed);
    }



}
