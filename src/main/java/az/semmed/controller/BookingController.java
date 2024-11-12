package az.semmed.controller;

import az.semmed.exception.NotFoundException;
import az.semmed.model.dto.BookingDto;
import az.semmed.model.dto.request.CreateBookingRequest;
import az.semmed.service.BookingService;
import az.semmed.service.FlightService;

import java.util.List;

public class BookingController {

    private final BookingService bookingService;
    private final FlightService flightService;

    public BookingController(BookingService bookingService, FlightService flightService) {
        this.bookingService = bookingService;
        this.flightService = flightService;
    }

    BookingDto create(CreateBookingRequest request) throws NotFoundException {
        flightService.getFlightInfo(request.getFlightId());  //checks if flight exists or not

        return bookingService.create(request);
    }

    boolean cancelBooking(long bookingId) {
        BookingDto bookingDetails = bookingService.getBookingDetails(bookingId);

        return bookingService.cancelBooking(bookingId);
    }

    List<BookingDto> findAllBookingByPassenger(String fullName) {
        return bookingService.findAllBookingByPassenger(fullName);
    }

    BookingDto getBookingDetails(long bookingId) {
        return bookingService.getBookingDetails(bookingId);
    }

    List<BookingDto> getAllBookings() {
        return bookingService.getAllBookings();
    }

    int getSize() {
        return bookingService.getSize();
    }
}
