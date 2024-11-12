package az.semmed.service;

import az.semmed.model.dto.BookingDto;
import az.semmed.model.dto.request.CreateBookingRequest;

import java.util.List;

public interface BookingService {

    BookingDto create(CreateBookingRequest request);

    boolean cancelBooking(long bookingId);

    List<BookingDto> findAllBookingByPassenger(String fullName);

    BookingDto getBookingDetails(long bookingId);

    List<BookingDto> getAllBookings();

    int getSize();
}
