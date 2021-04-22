package pl.adriankurek.traveloffice.repositories;

import pl.adriankurek.traveloffice.models.Trip;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TripData implements TripRepository {
    private final List<Trip> trips;

    public TripData() {
        this.trips = new ArrayList<>();
    }

    @Override
    public boolean add(Trip trip) {
        return trips.add(trip);
    }

    @Override
    public boolean remove(Trip trip) {
        return trips.remove(trip);
    }

    @Override
    public Trip getByName(String name) {
        return trips.stream()
                .filter(t -> t.getName()
                        .startsWith(name))
                .findFirst()
                .get();
    }

    @Override
    public List<Trip> getByDestination(String destination) {
        return trips.stream()
                .filter(t -> t.getDestination()
                        .startsWith(destination))
                .collect(Collectors.toList());
    }

    @Override
    public List<Trip> getAfterDate(Date date) {
        return trips.stream()
                .filter(trip -> trip
                        .getStartDate()
                        .toInstant()
                        .isAfter(date.toInstant()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Trip> getAll() {
        return trips;
    }

    @Override
    public int getTripAmounts() {
        return trips.size();
    }
}
