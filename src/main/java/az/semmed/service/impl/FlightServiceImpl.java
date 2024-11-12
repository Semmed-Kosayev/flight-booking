package az.semmed.service.impl;

import az.semmed.domain.dao.FlightDao;
import az.semmed.exception.NotFoundException;
import az.semmed.mapper.FlightMapper;
import az.semmed.model.dto.FlightDto;
import az.semmed.service.FlightService;

import java.time.LocalDateTime;
import java.util.List;

public class FlightServiceImpl implements FlightService {

    private final FlightDao flightDao;
    private final FlightMapper mapper;

    public FlightServiceImpl(FlightDao flightDao, FlightMapper mapper) {
        this.flightDao = flightDao;
        this.mapper = mapper;
    }


    @Override
    public List<FlightDto> getAllFlights() {
        return flightDao.getAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public FlightDto getFlightInfo(long flightId) {
        return flightDao.getById(flightId)
                .map(mapper::toDto)
                .orElseThrow(() -> new NotFoundException("couldn't be able to find flight with id " + flightId));
    }

    @Override
    public List<FlightDto> findFlights(String destination, LocalDateTime date, int passengerCount) {
        return flightDao.getAll().stream()
                .filter(a -> a.getDestination().equals(destination) &&
                        a.getDepartureTime().equals(date) &&
                        passengerCount <= a.getAvailableSeats())
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public int getSize() {
        return flightDao.getSize();
    }
}
