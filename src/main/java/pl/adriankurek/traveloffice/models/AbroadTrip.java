package pl.adriankurek.traveloffice.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class AbroadTrip extends Trip {
    private BigDecimal insurance;

    public AbroadTrip(String name, Date startDate, Date endDate, String destination, BigDecimal price, BigDecimal insurance) {
        super(name, startDate, endDate, destination, price);
        this.insurance = insurance;
    }

    public AbroadTrip() {

    }

    public BigDecimal getInsurance() {
        return insurance;
    }

    public void setInsurance(BigDecimal insurance) {
        this.insurance = insurance;
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(insurance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AbroadTrip that = (AbroadTrip) o;
        return Objects.equals(insurance, that.insurance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), insurance);
    }
}
