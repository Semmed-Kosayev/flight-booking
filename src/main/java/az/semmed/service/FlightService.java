package az.semmed.service;

import az.semmed.model.dto.FlightDto;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {

    List<FlightDto> getAllFlights();

    FlightDto getFlightInfo(long flightId);

    List<FlightDto> findFlights(String destination, LocalDateTime date, int passengerCount);

    int getSize();
}
