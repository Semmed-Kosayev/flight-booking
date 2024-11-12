package az.semmed.controller;

import az.semmed.exception.NotFoundException;
import az.semmed.model.dto.FlightDto;
import az.semmed.service.FlightService;

import java.time.LocalDateTime;
import java.util.List;

public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    public List<FlightDto> getAllFlights() {
        return flightService.getAllFlights();
    }

    public FlightDto getFlightInfo(long flightId) throws NotFoundException{
        return flightService.getFlightInfo(flightId);
    }

    public List<FlightDto> findFlights(String destination, LocalDateTime date, int passengerCount) {
        return flightService.findFlights(destination, date, passengerCount);
    }
}
