package pl.adriankurek.traveloffice;

import pl.adriankurek.traveloffice.models.*;
import pl.adriankurek.traveloffice.repositories.CustomerData;
import pl.adriankurek.traveloffice.repositories.TripData;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException {
        TravelOffice office = new TravelOffice(new CustomerData(), new TripData());

        Trip trip = new Trip(
                "Cool trip",
                new SimpleDateFormat("dd/MM/yyyy").parse("15/04/2021"),
                new SimpleDateFormat("dd/MM/yyyy").parse("20/04/2021"),
                "Washington",
                new BigDecimal("1500")
        );

        Trip abroadTrip = new AbroadTrip(
                "Cool abroad trip",
                new SimpleDateFormat("dd/MM/yyyy").parse("16/05/2021"),
                new SimpleDateFormat("dd/MM/yyyy").parse("21/05/2021"),
                "Moscow",
                new BigDecimal("3000"),
                new BigDecimal("1000")
        );

        Trip domesticTrip = new DomesticTrip(
                "Cool domestic trip",
                new SimpleDateFormat("dd/MM/yyyy").parse("06/17/2021"),
                new SimpleDateFormat("dd/MM/yyyy").parse("06/22/2021"),
                "London",
                new BigDecimal("1000"),
                new BigDecimal("200")
        );

        Customer customer1 = new Customer("Michael", "Scofield ","Chicago", trip);
        Customer customer2 =  new Customer("Beth","Harmon", "Lexington", abroadTrip);
        Customer customer3 = new Customer("Tommy", "Shelby", "Birmingham", domesticTrip);

        office.addCustomer(customer1);
        office.addCustomer(customer2);
        office.addCustomer(customer3);

        office.addTrip(trip);
        office.addTrip(abroadTrip);
        office.addTrip(domesticTrip);

        System.out.println(office.getCustomersInfo());
        System.out.println(office.getTripsInfo());

        System.out.println(office.getTripByDestination("Mos"));
        System.out.println(office.removeCustomerByLastName("Harmon"));

        System.out.println(office.getCustomersInfo());

        List<Trip> trips = office.getTripsAfterDate(new SimpleDateFormat("dd/MM/yyyy").parse("15/04/2021"));

        for (Trip t : trips) {
            System.out.println(t);
        }

        office.removeTrip(abroadTrip);

        System.out.println(office.getTripsInfo());
    }
}
