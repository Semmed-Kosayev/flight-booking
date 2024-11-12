package az.semmed.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class FlightEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private long flightId;
    private String from = "Kiev";
    private String destination;
    private LocalDateTime departureTime;
    private int availableSeats;
    private AtomicLong atomicLong = new AtomicLong(0);

    public FlightEntity(long flightId) {
        this.flightId = atomicLong.incrementAndGet();
    }

    public FlightEntity(String from, String destination, LocalDateTime departureTime, int availableSeats) {
        this.flightId = atomicLong.incrementAndGet();
        this.from = from;
        this.destination = destination;
        this.departureTime = departureTime;
        this.availableSeats = availableSeats;
    }

    public FlightEntity(long flightId, String from, String destination, LocalDateTime departureTime, int availableSeats) {
        this.flightId = flightId;
        this.from = from;
        this.destination = destination;
        this.departureTime = departureTime;
        this.availableSeats = availableSeats;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "FlightEntity{flightId='%s', from='%s', destination='%s', departureTime=%s, availableSeats=%d}"
                .formatted(flightId, from, destination, departureTime, availableSeats);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightEntity that = (FlightEntity) o;
        return flightId == that.flightId &&
                availableSeats == that.availableSeats &&
                Objects.equals(from, that.from) &&
                Objects.equals(destination, that.destination) &&
                Objects.equals(departureTime, that.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, from, destination, departureTime, availableSeats);
    }
}
