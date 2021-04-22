package pl.adriankurek.traveloffice.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class DomesticTrip extends Trip {
    private BigDecimal discount;

    public DomesticTrip(String name, Date startDate, Date endDate, String destination, BigDecimal price, BigDecimal discount) {
        super(name, startDate, endDate, destination, price);
        this.discount = discount;
    }

    public DomesticTrip() {

    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().subtract(discount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DomesticTrip that = (DomesticTrip) o;
        return Objects.equals(discount, that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount);
    }
}
