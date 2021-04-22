package pl.adriankurek.traveloffice.repositories;

import pl.adriankurek.traveloffice.models.Trip;

import java.util.Date;
import java.util.List;

public interface TripRepository {
    /**
     * Should add the trip to the data source.
     * @param trip the trip to add.
     * @return <code>true</code> if the operation was successful;
     *         <code>false</code> otherwise.
     */
    boolean add(Trip trip);

    /**
     * Should remove the trip from the data source.
     * @param trip the trip to remove.
     * @return <code>true</code> if the operation was successful;
     *         <code>false</code> otherwise.
     */
    boolean remove(Trip trip);

    /**
     * Should return trip with a specific name.
     * @param name name of the trip.
     * @return trip with a specific name.
     */
    Trip getByName(String name);

    /**
     * Should return trip with a specific destination.
     * @param destination destination of the trip.
     * @return trip with a specific destination.
     */
    List<Trip> getByDestination(String destination);

    /**
     * Should return list of trips that start after specific date.
     * @param date the date.
     * @return List of trips.
     */
    List<Trip> getAfterDate(Date date);

    /**
     * Should return list of trips.
     * @return list of trips.
     */
    List<Trip> getAll();

    int getTripAmounts();
}
