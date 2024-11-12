package az.semmed.model.dto;

import az.semmed.domain.entity.FlightEntity;

public class BookingDto {
    private final long bookingId;
    private final String bookerName;
    private final String bookerLastname;
    private final FlightEntity flight;

    public BookingDto(long bookingId, String bookerName, String bookerLastname, FlightEntity flight) {
        this.bookingId = bookingId;
        this.bookerName = bookerName;
        this.bookerLastname = bookerLastname;
        this.flight = flight;
    }

    public long getBookingId() {
        return bookingId;
    }

    public String getBookerName() {
        return bookerName;
    }

    public String getBookerLastname() {
        return bookerLastname;
    }

    public FlightEntity getFlight() {
        return flight;
    }

    @Override
    public String toString() {
        return "BookingDto{bookingId=%d, bookerName='%s', bookerLastname='%s', flight=%s}"
                .formatted(bookingId, bookerName, bookerLastname, flight);
    }
}
