package az.semmed.model.dto.request;

public class CreateBookingRequest {
    private final long flightId;
    private final String bookerName;
    private final String bookerSurname;

    public CreateBookingRequest(long flightId, String bookerName, String bookerSurname) {
        this.flightId = flightId;
        this.bookerName = bookerName;
        this.bookerSurname = bookerSurname;
    }

    public long getFlightId() {
        return flightId;
    }

    public String getBookerName() {
        return bookerName;
    }

    public String getBookerSurname() {
        return bookerSurname;
    }

    @Override
    public String toString() {
        return "CreateBookingRequest{flightId=%d, bookerName='%s', bookerSurname='%s'}"
                .formatted(flightId, bookerName, bookerSurname);
    }
}
