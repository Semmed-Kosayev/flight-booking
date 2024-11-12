package az.semmed.mapper;

import az.semmed.domain.entity.FlightEntity;
import az.semmed.model.dto.FlightDto;

public class FlightMapper implements EntityMapper<FlightEntity, FlightDto>{

    @Override
    public FlightEntity toEntity(FlightDto flightDto) {
        return new FlightEntity(
                flightDto.getFlightId(),
                flightDto.getFrom(),
                flightDto.getDestination(),
                flightDto.getDepartureTime(),
                flightDto.getAvailableSeats()
        );
    }

    @Override
    public FlightDto toDto(FlightEntity flightEntity) {
        return new FlightDto(
                flightEntity.getFlightId(),
                flightEntity.getFrom(),
                flightEntity.getDestination(),
                flightEntity.getDepartureTime(),
                flightEntity.getAvailableSeats()
        );
    }
}
