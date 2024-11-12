package az.semmed.domain.dao;

import az.semmed.domain.entity.BookingEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class inMemoryBookingDao extends BookingDao {

    private final List<BookingEntity> BOOKINGS = new ArrayList<>();

    @Override
    public Collection<BookingEntity> getAll() {
        return List.copyOf(BOOKINGS);
    }

    @Override
    public Optional<BookingEntity> getById(Long id) {
        return BOOKINGS.stream()
                .filter(a -> a.getBookingId() == id)
                .findFirst();
    }

    @Override
    public BookingEntity save(BookingEntity object) {
        BOOKINGS.add(object);
        return BOOKINGS.getLast();
    }

    @Override
    public boolean deleteById(Long id) {
        return BOOKINGS.remove(getById(id).get());
    }

    @Override
    public int getSize() {
        return BOOKINGS.size();
    }
}
