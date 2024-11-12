package az.semmed.model.dto;

import java.time.LocalDateTime;

public class FlightDto {
    private final long flightId;
    private final String from;
    private final String destination;
    private final LocalDateTime departureTime;
    private final int availableSeats;

    public FlightDto(long flightId, String from, String destination, LocalDateTime departureTime, int availableSeats) {
        this.flightId = flightId;
        this.from = from;
        this.destination = destination;
        this.departureTime = departureTime;
        this.availableSeats = availableSeats;
    }

    public long getFlightId() {
        return flightId;
    }

    public String getFrom() {
        return from;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    @Override
    public String toString() {
        return "FlightDto{flightId=%d, from='%s', destination='%s', departureTime=%s, availableSeats=%d}"
                .formatted(flightId, from, destination, departureTime, availableSeats);
    }
}
