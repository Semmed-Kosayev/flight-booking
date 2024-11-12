package az.semmed.domain.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class BookingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private long bookingId;
    private String bookerName;
    private String bookerLastname;
    private FlightEntity flight;
    private AtomicLong atomicLong = new AtomicLong(0);

    public BookingEntity(String bookerName, String bookerLastname, FlightEntity flight) {
        this.bookingId = atomicLong.incrementAndGet();
        this.bookerName = bookerName;
        this.bookerLastname = bookerLastname;
        this.flight = flight;
    }

    public BookingEntity(long bookingId, String bookerName, String bookerLastname, FlightEntity flight) {
        this.bookingId = bookingId;
        this.bookerName = bookerName;
        this.bookerLastname = bookerLastname;
        this.flight = flight;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookerName() {
        return bookerName;
    }

    public void setBookerName(String bookerName) {
        this.bookerName = bookerName;
    }

    public String getBookerLastname() {
        return bookerLastname;
    }

    public void setBookerLastname(String bookerLastname) {
        this.bookerLastname = bookerLastname;
    }

    public FlightEntity getFlight() {
        return flight;
    }

    public void setFlight(FlightEntity flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "BookingEntity{bookingId='%d', bookerName='%s', bookerLastname='%s', flight=%s}"
                .formatted(bookingId, bookerName, bookerLastname, flight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingEntity that = (BookingEntity) o;
        return bookingId == that.bookingId &&
                Objects.equals(bookerName, that.bookerName) &&
                Objects.equals(bookerLastname, that.bookerLastname) &&
                Objects.equals(flight, that.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, bookerName, bookerLastname, flight);
    }
}
