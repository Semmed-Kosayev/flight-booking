package az.semmed.mapper;

import az.semmed.domain.entity.BookingEntity;
import az.semmed.model.dto.BookingDto;

public class BookingMapper implements EntityMapper<BookingEntity, BookingDto>{
    @Override
    public BookingEntity toEntity(BookingDto bookingDto) {
        return new BookingEntity(
                bookingDto.getBookingId(),
                bookingDto.getBookerName(),
                bookingDto.getBookerLastname(),
                bookingDto.getFlight()
        );
    }

    @Override
    public BookingDto toDto(BookingEntity bookingEntity) {
        return new BookingDto(
                bookingEntity.getBookingId(),
                bookingEntity.getBookerName(),
                bookingEntity.getBookerLastname(),
                bookingEntity.getFlight()
        );
    }
}
