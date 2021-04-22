package pl.adriankurek.traveloffice.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Trip {
    private String name;
    private Date startDate;
    private Date endDate;
    private String destination;
    private BigDecimal price;

    public Trip(String name, Date startDate, Date endDate, String destination, BigDecimal price) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.destination = destination;
        this.price = price;
    }

    public Trip() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return Objects.equals(name, trip.name)
                && Objects.equals(startDate, trip.startDate)
                && Objects.equals(endDate, trip.endDate)
                && Objects.equals(destination, trip.destination)
                && Objects.equals(price, trip.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startDate, endDate, destination, price);
    }
}
