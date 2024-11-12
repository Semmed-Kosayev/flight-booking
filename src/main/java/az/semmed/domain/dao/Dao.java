package az.semmed.domain.dao;

import java.util.Collection;
import java.util.Optional;

public interface Dao<T, I> {
    Collection<T> getAll();

    Optional<T> getById(I id);

    T save(T object);

    boolean deleteById(I id);

    int getSize();
}
