package az.semmed.domain.dao;

import az.semmed.domain.entity.FlightEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class inMemoryFlightDao extends FlightDao {

    private final List<FlightEntity> FLIGHTS = new ArrayList<>();

    @Override
    public List<FlightEntity> getAll() {
        return List.copyOf(FLIGHTS);
    }

    @Override
    public Optional<FlightEntity> getById(Long id) {
        return FLIGHTS.stream()
                .filter(a -> a.getFlightId() == id)
                .findFirst();
    }

    @Override
    public FlightEntity save(FlightEntity object) {
        FLIGHTS.add(object);
        return FLIGHTS.getLast();
    }

    @Override
    public boolean deleteById(Long id) {
        return FLIGHTS.remove(getById(id).get());
    }

    @Override
    public int getSize() {
        return FLIGHTS.size();
    }
}
