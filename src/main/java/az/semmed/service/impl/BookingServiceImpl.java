package az.semmed.service.impl;

import az.semmed.domain.dao.BookingDao;
import az.semmed.domain.dao.FlightDao;
import az.semmed.domain.entity.BookingEntity;
import az.semmed.domain.entity.FlightEntity;
import az.semmed.exception.NotFoundException;
import az.semmed.mapper.BookingMapper;
import az.semmed.model.dto.BookingDto;
import az.semmed.model.dto.request.CreateBookingRequest;
import az.semmed.service.BookingService;

import java.util.List;

public class BookingServiceImpl implements BookingService {

    private final BookingDao bookingDao;
    private final FlightDao flightDao;
    private final BookingMapper bookingMapper;

    public BookingServiceImpl(BookingDao bookingDao, FlightDao flightDao, BookingMapper bookingMapper) {
        this.bookingDao = bookingDao;
        this.flightDao = flightDao;
        this.bookingMapper = bookingMapper;
    }


    @Override
    public BookingDto create(CreateBookingRequest request) {
        long flightId = request.getFlightId();
        FlightEntity flight = flightDao.getById(flightId).get();

        BookingEntity savedBooking = bookingDao.save(
                new BookingEntity(request.getBookerName(), request.getBookerSurname(), flight)
        );

        flight.setAvailableSeats(flight.getAvailableSeats() - 1);

        return bookingMapper.toDto(savedBooking);
    }

    @Override
    public boolean cancelBooking(long bookingId) {
        BookingEntity bookingEntity = bookingDao.getById(bookingId).get();

        FlightEntity flightEntity = flightDao.getById(bookingEntity.getFlight().getFlightId()).get();

        flightEntity.setAvailableSeats(flightEntity.getAvailableSeats() + 1);

        return bookingDao.deleteById(bookingId);
    }

    @Override
    public List<BookingDto> findAllBookingByPassenger(String fullName) {
        return bookingDao.getAll().stream()
                .filter(b -> (b.getBookerName() + " " + b.getBookerLastname()).equalsIgnoreCase(fullName))
                .map(bookingMapper::toDto)
                .toList();
    }

    @Override
    public BookingDto getBookingDetails(long bookingId) {
        return bookingDao.getById(bookingId)
                .map(bookingMapper::toDto)
                .orElseThrow(() -> new NotFoundException("couldn't be able to find booking with id " + bookingId));
    }

    @Override
    public List<BookingDto> getAllBookings() {
        return bookingDao.getAll().stream()
                .map(bookingMapper::toDto)
                .toList();
    }

    @Override
    public int getSize() {
        return bookingDao.getSize();
    }
}
